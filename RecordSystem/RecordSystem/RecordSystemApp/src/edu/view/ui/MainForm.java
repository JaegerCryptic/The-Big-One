/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.view.ui;

import edu.curd.dto.StudentDTO;
import edu.view.ui.classes.ClassAttendence;
import edu.view.ui.classes.ClassManagment;
import edu.view.ui.classes.ClassRegistration;
import edu.view.ui.excercises.ClassExcersises;
import edu.view.ui.excercises.ClassGrades;
import edu.view.ui.student.ListStudentDetails;
import edu.view.ui.student.StudentDetails;
import edu.view.ui.teacher.TeacherDetails;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Kyle
 */
public class MainForm extends javax.swing.JFrame {

    Dimension desktopSize;
    JDialog classRegistrationForm = new ClassRegistration(this);
    JDialog classManagmentForm = new ClassManagment(this);
    JDialog ListStudentDetailsForm = new ListStudentDetails(this);
    JDialog changeTeacherDetailsForm = new TeacherDetails(this);
    StudentDetails studentDetailsForm = new StudentDetails(this);
    JDialog classAttendenceForm = new ClassAttendence(this);
    JDialog classExcersisesForm = new ClassExcersises(this);
    JDialog classGradesForm = new ClassGrades(this);

    public static String USER_ID="";
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        changePasswordMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        studentMenu = new javax.swing.JMenu();
        registerMenu = new javax.swing.JMenuItem();
        modifyStudentMenu = new javax.swing.JMenuItem();
        viewStudentsMenu = new javax.swing.JMenuItem();
        classMenu = new javax.swing.JMenu();
        addClassesMenu = new javax.swing.JMenuItem();
        enrollMenu = new javax.swing.JMenuItem();
        markAttendenceMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        assingmentMenu = new javax.swing.JMenu();
        addExMenu = new javax.swing.JMenuItem();
        gradeMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        changePasswordMenu.setMnemonic('p');
        changePasswordMenu.setText("Change Teacher Password");
        changePasswordMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordMenuActionPerformed(evt);
            }
        });
        fileMenu.add(changePasswordMenu);

        exitMenu.setMnemonic('x');
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        menuBar.add(fileMenu);

        studentMenu.setMnemonic('e');
        studentMenu.setText("Students");

        registerMenu.setMnemonic('n');
        registerMenu.setText("Register New Student");
        registerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerMenuActionPerformed(evt);
            }
        });
        studentMenu.add(registerMenu);

        modifyStudentMenu.setMnemonic('m');
        modifyStudentMenu.setText("Modify Student Details");
        modifyStudentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyStudentMenuActionPerformed(evt);
            }
        });
        studentMenu.add(modifyStudentMenu);

        viewStudentsMenu.setMnemonic('v');
        viewStudentsMenu.setText("View All Students");
        viewStudentsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentsMenuActionPerformed(evt);
            }
        });
        studentMenu.add(viewStudentsMenu);

        menuBar.add(studentMenu);

        classMenu.setMnemonic('c');
        classMenu.setText("Classes");

        addClassesMenu.setMnemonic('a');
        addClassesMenu.setText("Add Classes");
        addClassesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassesMenuActionPerformed(evt);
            }
        });
        classMenu.add(addClassesMenu);

        enrollMenu.setMnemonic('a');
        enrollMenu.setText("Enroll to Classes");
        enrollMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollMenuActionPerformed(evt);
            }
        });
        classMenu.add(enrollMenu);

        markAttendenceMenu.setMnemonic('a');
        markAttendenceMenu.setText("Mark Atendance");
        markAttendenceMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAttendenceMenuActionPerformed(evt);
            }
        });
        classMenu.add(markAttendenceMenu);
        classMenu.add(jSeparator1);

        menuBar.add(classMenu);

        assingmentMenu.setText("Assessment");

        addExMenu.setMnemonic('e');
        addExMenu.setText("Add Exercises");
        addExMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExMenuActionPerformed(evt);
            }
        });
        assingmentMenu.add(addExMenu);

        gradeMenu.setText("Manage Grades");
        gradeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeMenuActionPerformed(evt);
            }
        });
        assingmentMenu.add(gradeMenu);

        menuBar.add(assingmentMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuActionPerformed

    private void displayChildForm(JDialog childWindow) {
        if (!childWindow.isVisible()) {
            desktopSize = desktopPane.getSize();
            Dimension internalFrameSize = childWindow.getSize();
            childWindow.setLocation((desktopSize.width - internalFrameSize.width) / 2,
                    (desktopSize.height - internalFrameSize.height) / 2);
            childWindow.setVisible(true);
        }
    }

    private void changePasswordMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordMenuActionPerformed
        displayChildForm(changeTeacherDetailsForm);
    }//GEN-LAST:event_changePasswordMenuActionPerformed

    private void registerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerMenuActionPerformed
        displayChildForm(studentDetailsForm);
    }//GEN-LAST:event_registerMenuActionPerformed

    private void modifyStudentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyStudentMenuActionPerformed
        JOptionPane.showMessageDialog(this, "Please select the student to be modified!.");
        displayChildForm(ListStudentDetailsForm);
    }//GEN-LAST:event_modifyStudentMenuActionPerformed

    private void viewStudentsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentsMenuActionPerformed
        displayChildForm(ListStudentDetailsForm);
    }//GEN-LAST:event_viewStudentsMenuActionPerformed

    private void enrollMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollMenuActionPerformed
        displayChildForm(classRegistrationForm);
    }//GEN-LAST:event_enrollMenuActionPerformed

    private void addClassesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassesMenuActionPerformed
        displayChildForm(classManagmentForm);
    }//GEN-LAST:event_addClassesMenuActionPerformed

    private void markAttendenceMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAttendenceMenuActionPerformed
        displayChildForm(classAttendenceForm);
    }//GEN-LAST:event_markAttendenceMenuActionPerformed

    private void addExMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExMenuActionPerformed
        displayChildForm(classExcersisesForm);
    }//GEN-LAST:event_addExMenuActionPerformed

    private void gradeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeMenuActionPerformed
        displayChildForm(classGradesForm);
    }//GEN-LAST:event_gradeMenuActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addClassesMenu;
    private javax.swing.JMenuItem addExMenu;
    private javax.swing.JMenu assingmentMenu;
    private javax.swing.JMenuItem changePasswordMenu;
    private javax.swing.JMenu classMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem enrollMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem gradeMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem markAttendenceMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem modifyStudentMenu;
    private javax.swing.JMenuItem registerMenu;
    private javax.swing.JMenu studentMenu;
    private javax.swing.JMenuItem viewStudentsMenu;
    // End of variables declaration//GEN-END:variables

    
    
    public void callStudentEditWindow(int studentId){
       
        
        StudentDTO student = studentDetailsForm.manageStudentService.getStudentDetails(studentId);
        
        if(student!=null){
            displayChildForm(studentDetailsForm);
            studentDetailsForm.loadStudentDetails(student);
        }
    }
}
