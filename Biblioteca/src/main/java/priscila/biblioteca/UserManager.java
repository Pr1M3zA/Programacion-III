package priscila.biblioteca;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UserManager extends javax.swing.JPanel {
    final private Connection connectDB;
    private MainFrame mainFrame;
    final private ImagesDB image;
    User user;
    String[] roles =  {"Undefined", "Administrator", "Operator"};
    
    public UserManager(MainFrame mainFrame, Connection connectDB) {
        this.connectDB = connectDB;
        this.image = new ImagesDB(connectDB);
        this.mainFrame = mainFrame;
        ImagesDB images = new ImagesDB(connectDB);
        initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        final Color GREEN_RECTANGLE = new Color(141,129,45);
        
        g2d.setColor(GREEN_RECTANGLE);
        g2d.fillRect(360, 0, 660, 80);
       
        g2d.drawImage(image.GetImage("logoOasisLib").getScaledInstance(292, 100, Image.SCALE_SMOOTH), 40, 2, null);
        g2d.drawImage(image.GetImage("userManagerIcon").getScaledInstance(55,55, Image.SCALE_SMOOTH), 640, 10, null);
    }    
    
    public void showData(){
        user = new User(UserNameField.getText(), connectDB);
        if(user.isExists()){
            FirstNameField.setText(user.getFirstName());
            LastNameField.setText(user.getLastName());
            PasswordField.setText(user.getPassword());
            ConfirmPasswordField.setText(user.getPassword());
            RoleComboBox.setSelectedIndex(user.getRole());
            NewUserButton.setText("Apply changes");
        }
        else
             NewUserButton.setText("New user");
    }
    
    private ComboBoxModel getComboBoxModel(){
        return new DefaultComboBoxModel(roles);
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserNameField = new javax.swing.JTextField();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        RoleLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        RoleComboBox = new javax.swing.JComboBox<>();
        UserNameLabel = new javax.swing.JLabel();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        ConfirmPasswordField = new javax.swing.JPasswordField();
        PasswordField = new javax.swing.JPasswordField();
        NewUserButton = new javax.swing.JButton();
        BookInventoryManager = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserNameField.setBackground(new java.awt.Color(223, 220, 196));
        UserNameField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        UserNameField.setForeground(new java.awt.Color(91, 52, 33));
        UserNameField.setPreferredSize(new java.awt.Dimension(334, 31));
        UserNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UserNameFieldFocusLost(evt);
            }
        });
        UserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameFieldActionPerformed(evt);
            }
        });
        add(UserNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        FirstNameField.setBackground(new java.awt.Color(223, 220, 196));
        FirstNameField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        FirstNameField.setForeground(new java.awt.Color(91, 52, 33));
        FirstNameField.setPreferredSize(new java.awt.Dimension(334, 31));
        FirstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FirstNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                FirstNameFieldFocusLost(evt);
            }
        });
        FirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameFieldActionPerformed(evt);
            }
        });
        add(FirstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        LastNameField.setBackground(new java.awt.Color(223, 220, 196));
        LastNameField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        LastNameField.setForeground(new java.awt.Color(91, 52, 33));
        LastNameField.setPreferredSize(new java.awt.Dimension(334, 31));
        LastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LastNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                LastNameFieldFocusLost(evt);
            }
        });
        LastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameFieldActionPerformed(evt);
            }
        });
        add(LastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        RoleLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        RoleLabel.setForeground(new java.awt.Color(91, 52, 33));
        RoleLabel.setText("Role");
        add(RoleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        PasswordLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(91, 52, 33));
        PasswordLabel.setText("Password");
        add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        RoleComboBox.setBackground(new java.awt.Color(223, 220, 196));
        RoleComboBox.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        RoleComboBox.setForeground(new java.awt.Color(91, 52, 33));
        RoleComboBox.setModel(getComboBoxModel());
        RoleComboBox.setPreferredSize(new java.awt.Dimension(334, 31));
        RoleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleComboBoxActionPerformed(evt);
            }
        });
        add(RoleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, 31));

        UserNameLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(91, 52, 33));
        UserNameLabel.setText("User name");
        add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        ConfirmPasswordLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        ConfirmPasswordLabel.setForeground(new java.awt.Color(91, 52, 33));
        ConfirmPasswordLabel.setText("Confirm Password");
        add(ConfirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        FirstNameLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        FirstNameLabel.setForeground(new java.awt.Color(91, 52, 33));
        FirstNameLabel.setText("First name");
        add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        LastNameLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        LastNameLabel.setForeground(new java.awt.Color(91, 52, 33));
        LastNameLabel.setText("Last name");
        add(LastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        ConfirmPasswordField.setBackground(new java.awt.Color(223, 220, 196));
        ConfirmPasswordField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        ConfirmPasswordField.setForeground(new java.awt.Color(91, 52, 33));
        ConfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordFieldActionPerformed(evt);
            }
        });
        add(ConfirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 334, 31));

        PasswordField.setBackground(new java.awt.Color(223, 220, 196));
        PasswordField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(91, 52, 33));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 334, 31));

        NewUserButton.setBackground(new java.awt.Color(100, 96, 46));
        NewUserButton.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        NewUserButton.setForeground(new java.awt.Color(255, 255, 255));
        NewUserButton.setText("New user");
        NewUserButton.setActionCommand("");
        NewUserButton.setPreferredSize(new java.awt.Dimension(154, 32));
        NewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserButtonActionPerformed(evt);
            }
        });
        add(NewUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 210, -1));

        BookInventoryManager.setBackground(new java.awt.Color(255, 255, 255));
        BookInventoryManager.setFont(new java.awt.Font("Arimo", 1, 36)); // NOI18N
        BookInventoryManager.setForeground(new java.awt.Color(255, 255, 255));
        BookInventoryManager.setText("User manager");
        add(BookInventoryManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserNameFieldFocusGained
        UserNameField.setText("");
        FirstNameField.setText("");
        LastNameField.setText("");
        PasswordField.setText("");
        ConfirmPasswordField.setText("");
        RoleComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_UserNameFieldFocusGained

    private void UserNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserNameFieldFocusLost
        if(UserNameField.getText().length() != 0){
            showData();
        }
    }//GEN-LAST:event_UserNameFieldFocusLost

    private void UserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameFieldActionPerformed

    private void FirstNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FirstNameFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldFocusGained

    private void FirstNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FirstNameFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldFocusLost

    private void FirstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldActionPerformed

    private void LastNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LastNameFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldFocusGained

    private void LastNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LastNameFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldFocusLost

    private void LastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldActionPerformed

    private void RoleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleComboBoxActionPerformed

    private void ConfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void NewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUserButtonActionPerformed
        user.setFirstName(FirstNameField.getText());
        user.setLastName(LastNameField.getText());
        user.setRole(RoleComboBox.getSelectedIndex());
        if(PasswordField.getText().compareTo(ConfirmPasswordField.getText()) == 0)
            user.setPassword(PasswordField.getText());
        user.ApplyChanges();
        JOptionPane.showMessageDialog(null, "The user was saved succesfully!", null, JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_NewUserButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookInventoryManager;
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton NewUserButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JComboBox<String> RoleComboBox;
    private javax.swing.JLabel RoleLabel;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JLabel UserNameLabel;
    // End of variables declaration//GEN-END:variables
}
