
package edu.view.ui.teacher;

import edu.data.service.ManageTeacherService;
import edu.data.service.impl.ManageTeacherServiceImpl;
import edu.view.ui.MainForm;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


public class TeacherDetails extends javax.swing.JDialog {


    public TeacherDetails(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUserDetails();
    }

    public TeacherDetails(java.awt.Frame parent) {
        super(parent);
        initComponents();
        initUserDetails();
    }

    // Load user details
    private void initUserDetails() {

        password_1.setText("");
        password_2.setText("");

        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                txtUserLogin.setText(MainForm.USER_ID);
                password_1.requestFocus();
            }
        });

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
        txtUserLogin = new javax.swing.JTextField();
        password_1 = new javax.swing.JPasswordField();
        updatePassword = new javax.swing.JButton();
        password_2 = new javax.swing.JPasswordField();
        uPass_label1 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setBackground(new java.awt.Color(30, 130, 76));
        header.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setText("Teacher Details");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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
        uName_label.setText("Username:");

        uPass_label.setBackground(new java.awt.Color(0, 0, 0));
        uPass_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uPass_label.setForeground(new java.awt.Color(204, 204, 204));
        uPass_label.setText("New Password");

        txtUserLogin.setBackground(new java.awt.Color(51, 51, 51));
        txtUserLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUserLogin.setForeground(new java.awt.Color(255, 255, 255));
        txtUserLogin.setEnabled(false);
        txtUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserLoginActionPerformed(evt);
            }
        });
        txtUserLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserLoginKeyPressed(evt);
            }
        });

        password_1.setBackground(new java.awt.Color(51, 51, 51));
        password_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password_1.setForeground(new java.awt.Color(255, 255, 255));
        password_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_1ActionPerformed(evt);
            }
        });
        password_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_1KeyPressed(evt);
            }
        });

        updatePassword.setBackground(new java.awt.Color(108, 122, 137));
        updatePassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updatePassword.setText("Update");
        updatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordActionPerformed(evt);
            }
        });

        password_2.setBackground(new java.awt.Color(51, 51, 51));
        password_2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password_2.setForeground(new java.awt.Color(255, 255, 255));
        password_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_2ActionPerformed(evt);
            }
        });
        password_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_2KeyPressed(evt);
            }
        });

        uPass_label1.setBackground(new java.awt.Color(0, 0, 0));
        uPass_label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uPass_label1.setForeground(new java.awt.Color(204, 204, 204));
        uPass_label1.setText("Confirm Password:");

        cancel.setBackground(new java.awt.Color(108, 122, 137));
        cancel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(uPass_label1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uName_label, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uPass_label, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updatePassword))
                    .addComponent(password_1)
                    .addComponent(txtUserLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(password_2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uName_label)
                    .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uPass_label)
                    .addComponent(password_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uPass_label1)
                    .addComponent(password_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatePassword)
                    .addComponent(cancel))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserLoginActionPerformed

    private void txtUserLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserLoginKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //     Login();
        }
    }//GEN-LAST:event_txtUserLoginKeyPressed

    private void password_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_1ActionPerformed
    }//GEN-LAST:event_password_1ActionPerformed

    private void password_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_1KeyPressed

    }//GEN-LAST:event_password_1KeyPressed
    private static ManageTeacherService teacherService = new ManageTeacherServiceImpl();

    private void updatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePasswordActionPerformed
        if (!String.valueOf(password_1.getPassword()).equals(String.valueOf(password_2.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Confirmed password is not matching! Plesae try again!.");
        } else if (teacherService.updateUserPassword(Integer.parseInt(txtUserLogin.getText()), String.valueOf(password_1.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Password Successfully changed!.");
        }
    }//GEN-LAST:event_updatePasswordActionPerformed

    private void password_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_2ActionPerformed

    private void password_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_2KeyPressed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField password_1;
    private javax.swing.JPasswordField password_2;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JLabel uName_label;
    private javax.swing.JLabel uPass_label;
    private javax.swing.JLabel uPass_label1;
    private javax.swing.JButton updatePassword;
    // End of variables declaration//GEN-END:variables
}
