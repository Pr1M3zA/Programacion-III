/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package priscila.biblioteca;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Connection;



public class MenuBar extends javax.swing.JPanel {
    final private MainFrame mainFrame;
    private Connection connectDB;  
    private ImagesDB imgDB;
            
    public MenuBar(MainFrame mainFrame, Connection connectDB) {
        initComponents();
        this.mainFrame = mainFrame;
        this.connectDB = connectDB;
        imgDB = new ImagesDB(connectDB);
    }
    
      @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        final Color DARK_ORANGE = new Color(143, 73, 0);
        final Color DARK_GREEN = new Color(100,96,46);
        final Color DARK_YELLOW = new Color(132,96,0);
        g2d.setColor(DARK_ORANGE);
        g2d.fillRoundRect(15, 10, 170, 50, 50, 50);
        g2d.drawImage(imgDB.GetImage("bookInventoryIcon").getScaledInstance(60, 60, Image.SCALE_SMOOTH), 125, 7, null);
        g2d.setColor(DARK_GREEN);
        g2d.fillRoundRect(205, 10, 170, 50, 50, 50);
        g2d.drawImage(imgDB.GetImage("ManageUsersIcon").getScaledInstance(50, 50, Image.SCALE_SMOOTH), 315, 10, null);
        g2d.setColor(DARK_YELLOW);
        g2d.fillRoundRect(395, 10, 170, 50, 50, 50); 
        g2d.drawImage(imgDB.GetImage("BorrowingIcon").getScaledInstance(50, 50, Image.SCALE_SMOOTH), 515, 10, null);
        
    }
    
    public void setTextLogOut(){
        logOutButton.setText("Log out");
    }
    
    public void setUser(User user){
        UserNameLabel.setText(user.getLastName() + " " + user.getFirstName());
        RoleLabel.setText(user.getRole() == 1 ? "ADMINISTRATOR" : "OPERATOR");
        if(user.getRole() == 1){
            bookInventoryButton.setEnabled(true);
            manageUsersButton.setEnabled(true);
        }
        LendingButton.setEnabled(true);
        logOutButton.setEnabled(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookInventoryButton = new javax.swing.JButton();
        manageUsersButton = new javax.swing.JButton();
        LendingButton = new javax.swing.JButton();
        UserNameLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        RoleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(82, 43, 29));
        setPreferredSize(new java.awt.Dimension(1024, 70));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookInventoryButton.setBackground(new java.awt.Color(143, 73, 0));
        bookInventoryButton.setFont(new java.awt.Font("Arimo", 1, 17)); // NOI18N
        bookInventoryButton.setForeground(new java.awt.Color(255, 255, 255));
        bookInventoryButton.setText("<html>  Book <p>Inventory<html>");
        bookInventoryButton.setToolTipText("");
        bookInventoryButton.setBorder(null);
        bookInventoryButton.setBorderPainted(false);
        bookInventoryButton.setContentAreaFilled(false);
        bookInventoryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookInventoryButton.setEnabled(false);
        bookInventoryButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookInventoryButton.setMaximumSize(new java.awt.Dimension(79, 27));
        bookInventoryButton.setMinimumSize(new java.awt.Dimension(79, 27));
        bookInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookInventoryButtonActionPerformed(evt);
            }
        });
        add(bookInventoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 50));

        manageUsersButton.setBackground(new java.awt.Color(100, 96, 46));
        manageUsersButton.setFont(new java.awt.Font("Arimo", 1, 17)); // NOI18N
        manageUsersButton.setForeground(new java.awt.Color(255, 255, 255));
        manageUsersButton.setText("<html>Manage <p>Users<html>");
        manageUsersButton.setToolTipText("");
        manageUsersButton.setBorder(null);
        manageUsersButton.setBorderPainted(false);
        manageUsersButton.setContentAreaFilled(false);
        manageUsersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageUsersButton.setEnabled(false);
        manageUsersButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        manageUsersButton.setMaximumSize(new java.awt.Dimension(79, 27));
        manageUsersButton.setMinimumSize(new java.awt.Dimension(79, 27));
        manageUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUsersButtonActionPerformed(evt);
            }
        });
        add(manageUsersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 140, 50));

        LendingButton.setBackground(new java.awt.Color(132, 96, 0));
        LendingButton.setFont(new java.awt.Font("Arimo", 1, 17)); // NOI18N
        LendingButton.setForeground(new java.awt.Color(255, 255, 255));
        LendingButton.setText("<html>Lending <p>Managment<html>");
        LendingButton.setToolTipText("");
        LendingButton.setBorder(null);
        LendingButton.setBorderPainted(false);
        LendingButton.setContentAreaFilled(false);
        LendingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LendingButton.setEnabled(false);
        LendingButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LendingButton.setMaximumSize(new java.awt.Dimension(79, 27));
        LendingButton.setMinimumSize(new java.awt.Dimension(79, 27));
        LendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LendingButtonActionPerformed(evt);
            }
        });
        add(LendingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 140, 50));

        UserNameLabel.setFont(new java.awt.Font("Arimo", 3, 18)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 250, 20));

        logOutButton.setBackground(new java.awt.Color(45, 38, 33));
        logOutButton.setFont(new java.awt.Font("Arimo", 3, 24)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log out");
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.setEnabled(false);
        logOutButton.setPreferredSize(new java.awt.Dimension(86, 28));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 15, 140, 40));

        RoleLabel.setFont(new java.awt.Font("Arimo", 2, 14)); // NOI18N
        RoleLabel.setForeground(new java.awt.Color(255, 255, 255));
        RoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(RoleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 220, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void bookInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookInventoryButtonActionPerformed
        logOutButton.setText("Back");
        mainFrame.GoBookManager();
    }//GEN-LAST:event_bookInventoryButtonActionPerformed

    private void manageUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUsersButtonActionPerformed
        logOutButton.setText("Back");
        mainFrame.GoUserManager();
    }//GEN-LAST:event_manageUsersButtonActionPerformed

    private void LendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LendingButtonActionPerformed
        logOutButton.setText("Back");
        mainFrame.GoLendingManagment();
    }//GEN-LAST:event_LendingButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        if(logOutButton.getText().compareTo("Back") == 0)
            mainFrame.GoHome();
        else {
            LendingButton.setEnabled(false);
            manageUsersButton.setEnabled(false);
            bookInventoryButton.setEnabled(false);
            logOutButton.setEnabled(false);
            UserNameLabel.setText("");
            RoleLabel.setText("");
            mainFrame.GoLogin();
        }
    }//GEN-LAST:event_logOutButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LendingButton;
    private javax.swing.JLabel RoleLabel;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JButton bookInventoryButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton manageUsersButton;
    // End of variables declaration//GEN-END:variables
}
