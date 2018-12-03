
package edu.view.ui.student;

import edu.curd.dto.ClassDTO;
import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.data.service.ManageAttendenceService;
import edu.data.service.ManageClassService;
import edu.data.service.ManageStudentService;
import edu.data.service.impl.ManageAttendenceServiceImpl;
import edu.data.service.impl.ManageClassImpl;
import edu.data.service.impl.ManageStudentServiceImpl;
import edu.view.ui.MainForm;
import edu.view.ui.WelcomeFrame;
import edu.view.ui.classes.attendence.MarkAttendence;
import edu.view.ui.util.GenericComboItem;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ManageStudentAttendance extends JDialog {

    ManageStudentService manageStudentService = new ManageStudentServiceImpl();
    ManageClassService manageClassService = new ManageClassImpl();
    ManageAttendenceService manageAttendenceService = new ManageAttendenceServiceImpl();

   private static String DATE_PATTERN = "dd-MM-yyyy h:m";
   private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ManageStudentAttendance.DATE_PATTERN);

    public ManageStudentAttendance(MainForm parent) {
        super(parent);
        initComponent();
    }
    private void initComponent() {

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

        lblDatetTime.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDatetTime.setForeground(new java.awt.Color(204, 204, 204));
        lblDatetTime.setText("XXXX-XX-XX");

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
                                                                        .addComponent(lblDatetTime, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                initDataTable();
                loadClassDetails();
                lblDatetTime.setText(simpleDateFormat.format(new Date()));
            }
        });

    }

    public static void main(String arg[]) {
 
    }

    private void cmbClassesActionPerformed(ActionEvent evt) {
        List<StudentDTO> studentsList = manageClassService.viewEnrolledStuents(getSelectedClassId());

        if (studentsList == null || studentsList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Students are enrolled for this subject!");
            
             tableModel.setRowCount(0);
            return;
        }

        tableModel.setRowCount(0);
        for (int index = 0; index < studentsList.size(); index++) {
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(false, index, 0);
            tableModel.setValueAt(studentsList.get(index).getStudentId(), index, 1);
            tableModel.setValueAt(studentsList.get(index).getFirstName() + " " + studentsList.get(index).getLastName(), index, 2);
            tableModel.setValueAt(studentsList.get(index).getEnrollmentId(), index, 3);
        }

    }

    private int getSelectedClassId() {
        try {
            String selectedClass = (String) cmbClasses.getSelectedItem();
            int selectedClassId = Integer.valueOf(selectedClass.split(" - ")[0]);
            return selectedClassId;
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(this, "No Classes were selected!");
        }
        return 0;
    }
    private javax.swing.JPanel header;

    private DefaultTableModel tableModel = new DefaultTableModel() {
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return Boolean.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                default:
                    return String.class;
            }
        }
    };

    private void initDataTable() {
        studentTable.setModel(tableModel);
        tableModel.addColumn("Student Present");
        tableModel.addColumn("Student ID");
        tableModel.addColumn("Student Name");
        tableModel.addColumn("Enrollment ID");
    }

    private void loadClassDetails() {
        tableModel.setRowCount(0);
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

    private void saveActionPerformed(ActionEvent evt) {

        Map<String, String> markedStuendts = obtainAttendence();
        if (markedStuendts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Students were marked, please select the students!");
        } else {
            if (manageAttendenceService.saveAttendence(getSelectedClassId(), markedStuendts)) {
                JOptionPane.showMessageDialog(this, "Students : " + markedStuendts.toString() + " \n marked present.");
            } else {
                JOptionPane.showMessageDialog(this, "Error while saving attendence.");
            }

        }

    }

    private Map<String, String> obtainAttendence() {

        Map<String, String> studentIds = new HashMap<>();

        for (int index = 0; index < studentTable.getRowCount(); index++) {
            Boolean checked = Boolean.valueOf(studentTable.getValueAt(index, 0).toString());
            String studentId = studentTable.getValueAt(index, 1).toString();
            String enrollId = studentTable.getValueAt(index, 3).toString();
            if (checked) {
                studentIds.put(studentId, enrollId);
            }
        }
        return studentIds;
    }

    private void cancleActionPerformed(ActionEvent evt) {
        this.setVisible(false);
    }

    private javax.swing.JButton cancle;
    private javax.swing.JComboBox<String> cmbClasses;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatetTime;
    private javax.swing.JButton save;
    private javax.swing.JTable studentTable;
    private javax.swing.JLabel uName_label;
    private javax.swing.JLabel uName_label1;
    private javax.swing.JLabel uName_label2;
}
