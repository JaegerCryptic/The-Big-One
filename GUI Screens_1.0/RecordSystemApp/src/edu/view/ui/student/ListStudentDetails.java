/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.view.ui.student;

/**
 *
 * @author Aeron
 */
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ListStudentDetails extends JFrame {

    String tableHeader[] = new String[]{"ID", "First Name", "Gender",
        "Phone", "DoB", "Status"};

    public ListStudentDetails() {

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

        initDataTable();
        loadTableData(null);
        pack();
    }

    public static void main(String arg[]) {
        ListStudentDetails ex2 = new ListStudentDetails();
        ex2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ex2.setVisible(true);
    }

    private javax.swing.JPanel header;
    private javax.swing.JLabel lableHeader;
    final JTable table = new JTable();

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
                    JOptionPane.showMessageDialog(null, "TEst");
                }
            }
        });

    }

    private void loadTableData(List<Object> tableRows) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        for (int count = 1; count <= 30; count++) {
            defaultTableModel.addRow(new Object[]{"001", "First", "Female",
                "3453453535", "12-12-2000", "Enrolled"});
        }
  
    }

}
