package priscila.biblioteca;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends javax.swing.JPanel {
    final private Connection connectDB;
    final private ImagesDB image;
    final private MainFrame mainFrame;
    /**
     * Creates new form Login
     * @param connectDB
     */
    
    public Login(MainFrame mainFrame, Connection connectDB) {
        initComponents();
        this.connectDB = connectDB;
        this.image = new ImagesDB(connectDB, "corner2");
        this.mainFrame = mainFrame;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
       // BufferedImage corner2 = image.GetImage("corner2");
       
        g2d.drawImage(image.Rotate(90).getScaledInstance(200, 200, Image.SCALE_SMOOTH), 300, 400, null);
        g2d.drawImage(image.Rotate(180).getScaledInstance(200, 200, Image.SCALE_SMOOTH), -50, 400, null);
        g2d.drawImage(image.GetImage("libraryExample").getScaledInstance(513, 600, Image.SCALE_SMOOTH), 490, 0, null);
        g2d.drawImage(image.GetImage("logoOasisLib").getScaledInstance(292, 100, Image.SCALE_SMOOTH), 176, 3, null);
        g2d.drawImage(image.GetImage("userIcon").getScaledInstance(30, 30, Image.SCALE_SMOOTH), 30, 194, null);
        g2d.drawImage(image.GetImage("passwordIcon").getScaledInstance(30, 30, Image.SCALE_SMOOTH), 30, 304, null);
        g2d.drawImage(image.GetImage("logo").getScaledInstance(150, 120, Image.SCALE_SMOOTH), 10, 0, null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserTextField = new javax.swing.JTextField();
        MessageLabel = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        PasswordLabel = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserTextField.setBackground(new java.awt.Color(227, 207, 179));
        UserTextField.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        UserTextField.setForeground(new java.awt.Color(0, 0, 0));
        UserTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserTextFieldFocusGained(evt);
            }
        });
        UserTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTextFieldActionPerformed(evt);
            }
        });
        add(UserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 370, 30));

        MessageLabel.setFont(new java.awt.Font("Arimo", 1, 14)); // NOI18N
        MessageLabel.setForeground(new java.awt.Color(102, 0, 0));
        add(MessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        UserLabel.setFont(new java.awt.Font("Arimo", 1, 25)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(22, 10, 2));
        UserLabel.setText("User");
        add(UserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        LoginButton.setBackground(new java.awt.Color(211, 153, 64));
        LoginButton.setFont(new java.awt.Font("Arimo", 1, 25)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setPreferredSize(new java.awt.Dimension(345, 457));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 210, 40));

        PasswordLabel.setFont(new java.awt.Font("Arimo", 1, 25)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(22, 10, 2));
        PasswordLabel.setText("Password");
        add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        PasswordTextField.setBackground(new java.awt.Color(227, 207, 179));
        PasswordTextField.setPreferredSize(new java.awt.Dimension(68, 32));
        add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 370, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void UserTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTextFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        User user = new User(UserTextField.getText(), connectDB);
        if(user.isExists()){
            if(user.getPassword().compareTo(PasswordTextField.getText()) != 0)
                MessageLabel.setText("Incorrect Password");
            else{
               mainFrame.setUser(user);
               mainFrame.GoHome();
            }
        }
        else
            MessageLabel.setText("User doesn't exist");
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void UserTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserTextFieldFocusGained
        MessageLabel.setText("");
    }//GEN-LAST:event_UserTextFieldFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel MessageLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JTextField UserTextField;
    // End of variables declaration//GEN-END:variables
}
