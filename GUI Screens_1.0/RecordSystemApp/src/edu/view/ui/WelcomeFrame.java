/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package edu.view.ui;
//Create a new JFrame  

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

        // JWindow window = new JWindow();
        //  window.getContentPane().add(
        //           new JLabel("", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
        //   window.setBounds(500, 150, 300, 200);
        //  window.setVisible(true);
        WelcomeFrame frame = new WelcomeFrame(PropertyLoader.getInstance().getProperty("APP_NAME"), PropertyLoader.getInstance().getProperty("APP_VERSION"));
        frame.setSize(680, 400);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
//Calculate the frame location  
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

//Set the new frame location  
//        frame.setUndecorated(true);
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
       // framex.setSize(300, 100);
        frame.dispose();

    }
}
