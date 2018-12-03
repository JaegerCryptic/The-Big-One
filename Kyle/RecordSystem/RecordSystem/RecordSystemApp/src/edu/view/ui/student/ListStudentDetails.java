
package edu.view.ui.student;


import edu.curd.dto.StudentDTO;
import edu.curd.operation.JDBCDataObject;
import edu.data.service.ManageStudentService;
import edu.data.service.impl.ManageStudentServiceImpl;
import edu.view.ui.MainForm;
import edu.view.ui.WelcomeFrame;
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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ListStudentDetails extends JDialog {

    private String tableHeader[] = new String[]{"ID", "Name", "Gender",
        "Phone", "DoB", "Status"};

    ManageStudentService manageStudentService = new ManageStudentServiceImpl();

    private MainForm parentFrame;

    private void initComponent() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        header = new javax.swing.JPanel();
        lableHeader = new javax.swing.JLabel();

        header.setBackground(new java.awt.Color(30, 130, 76));
        header.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        lableHeader.setBackground(new java.awt.Color(102, 102, 102));
        lableHeader.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lableHeader.setText("Student Details");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(310, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(lableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                initDataTable();
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                loadTableData(manageStudentService.viewAllStudents());
            }
        });

    }

    public static void main(String arg[]) {
        ListStudentDetails sampleDialog = new ListStudentDetails(null);

        sampleDialog.initDataTable();
        sampleDialog.loadTableData(sampleDialog.manageStudentService.viewAllStudents());

        sampleDialog.setVisible(true);
    }

    private javax.swing.JPanel header;
    private javax.swing.JLabel lableHeader;
    final JTable table = new JTable();

    public ListStudentDetails(MainForm parent) {

        super(parent);
        initComponent();
        this.parentFrame = parent;
    }

    public ListStudentDetails() {
        super();
        initComponent();
    }

    private void initDataTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);
        defaultTableModel.setColumnIdentifiers(tableHeader);
        table.setModel(defaultTableModel);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                javax.swing.JTable table = (javax.swing.JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

                    int studentId = (Integer) table.getValueAt(table.getSelectedRow(), 0);
                    loadEditWindow(studentId);
                }
            }
        });

    }

    private void loadEditWindow(int studentId) {

        this.setVisible(false);

        parentFrame.callStudentEditWindow(studentId);
    }

    private void loadTableData(List<JDBCDataObject> studentList) {

        if (studentList == null || studentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Students to display!");
            return;
        }

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        defaultTableModel.setRowCount(0);

        studentList.forEach((jdbcStudent) -> {

            StudentDTO student = (StudentDTO) jdbcStudent;
            defaultTableModel.addRow(new Object[]{student.getStudentId(), student.getFirstName() + " " + student.getLastName(), student.getGender(),
                student.getPhone(), student.getDob(), "Enrolled"});
        });
    }

}
