package edu.view.ui;

import edu.config.PropertyLoader;
import edu.view.ui.teacher.TeacheLogin;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class WelcomeFrame extends JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JLabel titleText;
    private javax.swing.JLabel lblVersion;
    // End of variables declaration    

    /**
     * Creates new form NewJFrame
     */
    public WelcomeFrame(String applicationTitle, String applicationVersion) {
        initComponents(applicationTitle, applicationVersion);
    }

    private void initComponents(String applicationTitle, String applicationVersion) {

        titleText = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleText.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        titleText.setText(applicationTitle);

        lblVersion.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblVersion.setText(applicationVersion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(titleText)
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblVersion)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(titleText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(lblVersion)
                                .addGap(57, 57, 57))
        );
        this.setUndecorated(true);
        pack();
    }// </editor-fold>                        

    public static void main(String arg[]) throws MalformedURLException {

        WelcomeFrame frame = new WelcomeFrame(PropertyLoader.getInstance().getProperty("APP_NAME"), PropertyLoader.getInstance().getProperty("APP_VERSION"));
        frame.setSize(680, 400);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y);
        frame.setVisible(true);

        System.err.println(PropertyLoader.getInstance().getProperty("APP_NAME"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.setVisible(false);

        TeacheLogin teacherLogin = new TeacheLogin(new javax.swing.JFrame(), true);

        teacherLogin.setVisible(true);
        teacherLogin.setLocation(x, y);
        frame.dispose();

    }

}
