
package edu.view.ui.classes;

import edu.view.ui.util.ListTransferHandler;
import edu.curd.dto.ClassDTO;
import edu.curd.dto.EnrollmentDTO;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.data.service.ManageClassService;
import edu.data.service.ManageStudentService;
import edu.data.service.impl.ManageClassImpl;
import edu.data.service.impl.ManageStudentServiceImpl;
import edu.view.ui.MainForm;
import edu.view.ui.teacher.*;
import edu.view.ui.util.GenericComboItem;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ClassRegistration extends javax.swing.JDialog {

    /**
     * Creates new form TeacheLogin
     */
    ManageClassService manageClassService = new ManageClassImpl();
    ManageStudentService manageStudentService = new ManageStudentServiceImpl();

    public ClassRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initDataSettings();
    }

    public ClassRegistration(java.awt.Frame parent) {
        super(parent);
        initComponents();
        initDataSettings();
    }

    public ClassRegistration() {

        initComponents();
        initDataSettings();
    }

    private void initDataSettings() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                loadClassDetails();
                loadStudentDetails();
            }

        });

        studnetList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        studnetList.setDragEnabled(true);
        studnetList.setTransferHandler(new ListTransferHandler(this));

    }

    private void loadClassDetails() {
        List<JDBCDataObject> classObjLis = manageClassService.viewAllClasses();
        if (classObjLis != null && !classObjLis.isEmpty()) {

            classObjLis.forEach((classRow) -> {
                ClassDTO classObject = (ClassDTO) classRow;
                cmbClasses.addItem(new GenericComboItem(classObject.getClassId(), classObject.getTopic()).toString());
            });
        } else {
            JOptionPane.showMessageDialog(this, "No Classes to display!");
        }
    }

    private void loadStudentDetails() {

        List<JDBCDataObject> studentList = manageStudentService.viewAllStudents();

        if (studentList == null || studentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Students to display!");
            return;
        }

        Vector<String> finalList = new Vector<>();
        studentList.forEach((jdbcStudent) -> {

            StudentDTO student = (StudentDTO) jdbcStudent;
            finalList.add(student.getStudentId() + " - " + student.getFirstName() + " " + student.getLastName());
        });

        studnetList.setListData(finalList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        uName_label = new javax.swing.JLabel();
        uPass_label = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentIdTxt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        studnetList = new javax.swing.JList<>();
        cmbClasses = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setBackground(new java.awt.Color(30, 130, 76));
        header.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setText("Class Enrollment");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(51, 51, 51));

        uName_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uName_label.setForeground(new java.awt.Color(204, 204, 204));
        uName_label.setText("Student ID:");

        uPass_label.setBackground(new java.awt.Color(0, 0, 0));
        uPass_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uPass_label.setForeground(new java.awt.Color(204, 204, 204));
        uPass_label.setText("Class");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancle.setText("Cancel");
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });

        studentIdTxt.setColumns(20);
        studentIdTxt.setRows(5);
        jScrollPane1.setViewportView(studentIdTxt);

        jScrollPane2.setViewportView(studnetList);

        cmbClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(cancle)
                        .addGap(130, 130, 130)
                        .addComponent(save))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(uPass_label)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(uName_label)))
                        .addGap(18, 18, 18)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                            .addComponent(cmbClasses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uPass_label)
                    .addComponent(cmbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(uName_label)
                        .addGap(63, 63, 63)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancle))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        if (studentIdTxt.getText().replaceAll(";", "").trim().length() > 0) {

            boolean enrrolmentStatus = manageClassService.saveEnrollment( getSelectedClassId(), getStudentIdList());

            if (enrrolmentStatus) {
                JOptionPane.showMessageDialog(this, "Student Enrollment was saved!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "No Students were selected!");

        }

    }//GEN-LAST:event_saveActionPerformed

    private int getSelectedClassId() {
        try {
            String selectedClass = (String) cmbClasses.getSelectedItem();
            int selectedClassId = Integer.valueOf(selectedClass.split(" - ")[0]);
            return selectedClassId;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Classes were selected!");
        }
        return 0;
    }
    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancleActionPerformed

    private void cmbClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassesActionPerformed

            List<EnrollmentDTO> enrollments = manageClassService.viewEnrolledStuentIDs(getSelectedClassId());
            
            if(enrollments==null || enrollments.isEmpty())
                studentIdTxt.setText("");
            
            StringBuffer studentIdText= new StringBuffer();
            
            for(EnrollmentDTO student : enrollments)
                studentIdText.append(student.getStudentId()).append(" ; ");
            
            studentIdTxt.setText(studentIdText.toString());
    }//GEN-LAST:event_cmbClassesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ClassRegistration newClassRegistration = new ClassRegistration();
        newClassRegistration.setVisible(true);
    }

    public Set<String> getStudentIdList() {
        return new HashSet<String>(Arrays.asList(studentIdTxt.getText().split(" ; ")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    private javax.swing.JComboBox<String> cmbClasses;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton save;
    private javax.swing.JTextArea studentIdTxt;
    private javax.swing.JList<String> studnetList;
    private javax.swing.JLabel uName_label;
    private javax.swing.JLabel uPass_label;
    // End of variables declaration//GEN-END:variables
}