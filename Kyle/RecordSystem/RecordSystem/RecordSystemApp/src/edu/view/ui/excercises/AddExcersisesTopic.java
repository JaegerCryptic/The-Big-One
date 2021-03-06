package edu.view.ui.excercises;

import edu.curd.dto.ClassDTO;
import edu.curd.dto.ClassExercisesDTO;
import edu.curd.dto.EnrollmentDTO;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.curd.operation.excercises.ManageClassExercises;
import edu.data.service.ClassExcercisesService;
import edu.data.service.ManageClassService;
import edu.data.service.ManageGradesService;
import edu.data.service.impl.ClassExcercisesServiceImpl;
import edu.data.service.impl.ManageClassImpl;
import edu.data.service.impl.ManageGradesServiceImpl;
import edu.view.ui.MainForm;
import edu.view.ui.classes.*;
import edu.view.ui.teacher.*;
import edu.view.ui.util.GenericComboItem;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddExcersisesTopic extends javax.swing.JDialog {

    ClassExcercisesService manageClassExercises = new ClassExcercisesServiceImpl();
    ManageClassService manageClassService = new ManageClassImpl();

    public AddExcersisesTopic(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initGui();
    }

    public AddExcersisesTopic(java.awt.Frame parent) {
        super(parent);
        initComponents();
        initGui();
    }

    public AddExcersisesTopic() {
        super();
        initComponents();
        initGui();
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
        cmbExcersise = new javax.swing.JComboBox<>();
        cmbClasses = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        excersise_topics = new javax.swing.JTable();
        uPass_label1 = new javax.swing.JLabel();
        txtTopic = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setBackground(new java.awt.Color(30, 130, 76));
        header.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("New Topic");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        content.setBackground(new java.awt.Color(51, 51, 51));

        uName_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uName_label.setForeground(new java.awt.Color(204, 204, 204));
        uName_label.setText("Class ID:");

        uPass_label.setBackground(new java.awt.Color(0, 0, 0));
        uPass_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uPass_label.setForeground(new java.awt.Color(204, 204, 204));
        uPass_label.setText("Topic:");

        cmbExcersise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExcersiseActionPerformed(evt);
            }
        });

        cmbClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassesActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        excersise_topics.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        excersise_topics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Class ID", "Excersise Type", "Topic"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(excersise_topics);

        uPass_label1.setBackground(new java.awt.Color(0, 0, 0));
        uPass_label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uPass_label1.setForeground(new java.awt.Color(204, 204, 204));
        uPass_label1.setText("Excercise Type:");

        txtTopic.setEditable(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uName_label)
                            .addComponent(uPass_label1)
                            .addComponent(uPass_label))
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbClasses, 0, 283, Short.MAX_VALUE)
                                    .addComponent(cmbExcersise, 0, 283, Short.MAX_VALUE)
                                    .addComponent(txtTopic)))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(save))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(cancel)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uName_label)
                    .addComponent(cmbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExcersise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uPass_label1))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uPass_label))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel))
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

        if (getSelectedExcercisesId() == 0) {
            JOptionPane.showMessageDialog(this, "Please select an excercise!");
            return;
        } else if (txtTopic.isEditable() && txtTopic.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Excercise Topic Cant be empty!");
            return;
        } else if (txtTopic.isEditable()) {

            if (manageClassExercises.saveTopic(this.getSelectedClassId(), this.getSelectedExcercisesId(), this.txtTopic.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Topic saved successfuly!");
                txtTopic.setEditable(false);
                txtTopic.setText("");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Error while saving the Topic");
            }
        }


    }//GEN-LAST:event_saveActionPerformed

    private String getSelectedExcercisesText() {
        try {
            String selectedClass = (String) cmbExcersise.getSelectedItem();
            return selectedClass.split(" - ")[1];
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Classes were selected!");
        }
        return "";
    }

    private int getSelectedExcercisesId() {
        try {
            String selectedClass = (String) cmbExcersise.getSelectedItem();
            int selectedClassId = Integer.valueOf(selectedClass.split(" - ")[0]);
            return selectedClassId;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Classes were selected!");
        }
        return 0;
    }

    private int getSelectedClassId() {
        try {
            String selectedClass = (String) cmbClasses.getSelectedItem();
            return Integer.valueOf(selectedClass.split(" - ")[0]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Classes were selected!");
        }
        return 0;
    }

    private String getSelectedClassText() {
        try {
            String selectedClass = (String) cmbClasses.getSelectedItem();
            return selectedClass.split(" - ")[1];
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Classes were selected!");
        }
        return "";
    }

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        cleanForm();
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void cleanForm() {
        txtTopic.setEditable(false);
        cmbExcersise.removeAllItems();
        DefaultTableModel defaultTableModel = (DefaultTableModel) excersise_topics.getModel();
        defaultTableModel.setRowCount(0);
    }
    private void cmbClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassesActionPerformed

        List<ClassExercisesDTO> excercises = manageClassExercises.viewAllExcercisesForClass(getSelectedClassId());

        if (excercises == null || excercises.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "No Excersise were Added to the class!");
            cleanForm();
            return;
        }

        txtTopic.setEditable(true);
        DefaultComboBoxModel dataModel = new javax.swing.DefaultComboBoxModel<>();
        dataModel.addElement("----- SELECT -------");

        for (ClassExercisesDTO exc : excercises) {
            dataModel.addElement(String.valueOf(exc.getExcerciseId()) + " - " + exc.getExcerciseType());
        }

        cmbExcersise.setModel(dataModel);

    }//GEN-LAST:event_cmbClassesActionPerformed

    private void cmbExcersiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbExcersiseActionPerformed

        if (cmbExcersise.getSelectedIndex() > 0) {
            loadTableData();
        } else {
            DefaultTableModel defaultTableModel = (DefaultTableModel) excersise_topics.getModel();
            defaultTableModel.setRowCount(0);
        }
    }//GEN-LAST:event_cmbExcersiseActionPerformed

    private void loadTableData() {

        Map<Integer, String> topics = manageClassExercises.viewAllTopicsForExcercises(getSelectedExcercisesId());

        DefaultTableModel defaultTableModel = (DefaultTableModel) excersise_topics.getModel();
        defaultTableModel.setRowCount(0);

        if (topics == null || topics.isEmpty()) {
            return;
        }

        String classId = String.valueOf(this.getSelectedClassId());
        String excersise = getSelectedExcercisesText();
        topics.keySet().forEach((topicId) -> {

            defaultTableModel.addRow(new Object[]{classId, excersise, topics.get(topicId).toString()});
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        AddExcersisesTopic clss = new AddExcersisesTopic();
        clss.setVisible(true);
    }

    private void loadClassDetails() {
        List<JDBCDataObject> classObjLis = manageClassService.viewAllClasses();
        if (classObjLis != null && !classObjLis.isEmpty()) {

            classObjLis.forEach((classRow) -> {
                ClassDTO classObject = (ClassDTO) classRow;
                cmbClasses.addItem(new GenericComboItem(classObject.getClassId(), classObject.getTopic()).toString());
            });
        } else {
            //JOptionPane.showMessageDialog(this, "No Classes to display!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> cmbClasses;
    private javax.swing.JComboBox<String> cmbExcersise;
    private javax.swing.JPanel content;
    private javax.swing.JTable excersise_topics;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtTopic;
    private javax.swing.JLabel uName_label;
    private javax.swing.JLabel uPass_label;
    private javax.swing.JLabel uPass_label1;
    // End of variables declaration//GEN-END:variables

    private void initGui() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadClassDetails();
            }
        });
    }

}
