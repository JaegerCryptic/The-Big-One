
package edu.view.ui.classes.attendence;

import edu.curd.dto.ClassDTO;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.data.service.ManageClassService;
import edu.data.service.ManageStudentService;
import edu.data.service.impl.ManageClassImpl;
import edu.data.service.impl.ManageStudentServiceImpl;
import edu.view.ui.MainForm;
import edu.view.ui.excercises.*;
import edu.view.ui.classes.*;
import edu.view.ui.teacher.*;
import edu.view.ui.util.GenericComboItem;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class MarkAttendence extends javax.swing.JDialog {

    ManageClassService manageClassService = new ManageClassImpl();
    ManageStudentService manageStudentService = new ManageStudentServiceImpl();

    private static String DATE_PATTERN = "dd-MM-yyyy h:m";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MarkAttendence.DATE_PATTERN);

    public MarkAttendence(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initDataSettings();
    }

    public MarkAttendence(java.awt.Frame parent) {
        super(parent);
        initComponents();
        initDataSettings();
    }

    private MarkAttendence() {
        super();
        initComponents();
        initDataSettings();
    }

    private void initDataSettings() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                loadClassDetails();
                 loadStudentDetails();
               // lblDatetTime.setText(simpleDateFormat.format(new Date()));
            }

        });

//        studnetList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        studnetList.setDragEnabled(true);
//        studnetList.setTransferHandler(new ListTransferHandler(this));
//jScrollPane1.remove(0);

       
 DefaultTableModel model=new DefaultTableModel()
    {
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return Boolean.class;
        case 1:
          return String.class;
        case 2:
          return String.class;

          default:
            return String.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    studentTable.setModel(model);

    model.addColumn("Select");
    model.addColumn("Position");
    model.addColumn("Team");

    //THE ROW
    for(int i=0;i<=7;i++)
    {
      model.addRow(new Object[0]);
      model.setValueAt(false,i,0);
      model.setValueAt("Our Row"+(i+1), i, 1);
      model.setValueAt("Our Column 2", i, 2);

    }
    
    studentTable.revalidate();
    jScrollPane1.add(studentTable);
//    
//Object[][] data = {{false, "IBM", "XZD"}};
//        DefaultTableModel defaultTableModel = new DefaultTableModel(data, new String[]{"Attendence", "Student ID", "Name"});
//        studentTable.setModel(defaultTableModel);
//
//        studentTable = new JTable(defaultTableModel) {
//
//            private static final long serialVersionUID = 1L;
//
//            /*@Override
//            public Class getColumnClass(int column) {
//            return getValueAt(0, column).getClass();
//            }*/
//            @Override
//            public Class getColumnClass(int column) {
//                switch (column) {
//                    case 0:
//                        return Boolean.class;
//                    case 1:
//                        return String.class;
//                    case 2:
//                        return String.class;
//                    default:
//                        return String.class;
//                }
//            }
//        };
    }

    private void loadClassDetails() {
        List<JDBCDataObject> classObjLis = manageClassService.viewAllClasses();
        if (classObjLis != null && !classObjLis.isEmpty()) {

            classObjLis.forEach((classRow) -> {
                ClassDTO classObject = (ClassDTO) classRow;
                cmbClasses.addItem(new GenericComboItem(classObject.getClassId(), classObject.getTopic()).toString());
            });
        } else {
           // JOptionPane.showMessageDialog(this, "No Classes to display!");
        }
    }

    private void loadStudentDetails() {

        List<JDBCDataObject> studentList = manageStudentService.viewAllStudents();

        if (studentList == null || studentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Students to display!");
            return;
        }

        DefaultTableModel defaultTableModel = (DefaultTableModel) studentTable.getModel();
        // defaultTableModel.setRowCount(0);

        studentList.forEach((jdbcStudent) -> {

            StudentDTO student = (StudentDTO) jdbcStudent;
            defaultTableModel.addRow(new Object[]{false, student.getStudentId(), student.getFirstName() + " " + student.getLastName()});
        });

        //        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);
        // studentTable.setModel(defaultTableModel);
//        List<JDBCDataObject> studentList = manageStudentService.viewAllStudents();
//
//        if (studentList == null || studentList.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "No Students to display!");
//            return;
//        }
//
//        Vector<String> finalList = new Vector<>();
//        studentList.forEach((jdbcStudent) -> {
//
//            StudentDTO student = (StudentDTO) jdbcStudent;
//            finalList.add(student.getStudentId() + " - " + student.getFirstName() + " " + student.getLastName());
//        });
//
//        studnetList.setListData(finalList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uName_label1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        uName_label = new javax.swing.JLabel();
        cmbClasses = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        uName_label2 = new javax.swing.JLabel();
        lblDatetTime = new javax.swing.JLabel();
        cancle = new javax.swing.JButton();
        save = new javax.swing.JButton();

        uName_label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uName_label1.setForeground(new java.awt.Color(204, 204, 204));
        uName_label1.setText("Class ID:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setBackground(new java.awt.Color(30, 130, 76));
        header.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setText("Class Attendance");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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
        uName_label.setText("Class ID:");

        cmbClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassesActionPerformed(evt);
            }
        });

        studentTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(studentTable);

        uName_label2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uName_label2.setForeground(new java.awt.Color(204, 204, 204));
        uName_label2.setText("Date:");

        lblDatetTime.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDatetTime.setForeground(new java.awt.Color(204, 204, 204));
        lblDatetTime.setText("XXXXXXXXX");

        cancle.setText("Cancel");
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uName_label)
                                    .addComponent(uName_label2))
                                .addGap(122, 122, 122)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDatetTime, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(cancle)
                        .addGap(79, 79, 79)
                        .addComponent(save)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uName_label)
                    .addComponent(cmbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uName_label2)
                    .addComponent(lblDatetTime))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClassesActionPerformed

    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        /*
        if (classTopic.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter Class Topic!");
            return;
        }
        if (classDescription.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter Class Topic!");
            return;
        }

        if (manageClassService.addClass(classTopic.getText().trim(), classDescription.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Details are saved!", "Class Details", JOptionPane.INFORMATION_MESSAGE);
        }
         */
    }//GEN-LAST:event_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MarkAttendence classAttendence = new MarkAttendence();
        classAttendence.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    private javax.swing.JComboBox<String> cmbClasses;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatetTime;
    private javax.swing.JButton save;
    private javax.swing.JTable studentTable;
    private javax.swing.JLabel uName_label;
    private javax.swing.JLabel uName_label1;
    private javax.swing.JLabel uName_label2;
    // End of variables declaration//GEN-END:variables
}
