/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_de_biblioteca;

import java.sql.Connection;
import javax.swing.JFrame;

/**
 *
 * @author Priscila
 */
public class Sistema_de_biblioteca {

    public static void main(String[] args) {
        Connection connectDB = new ConnectDB().getConnection();
        BookManager bm = new BookManager(connectDB);
        bm.setVisible(true);
        //JFrame frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        //frame.setBounds(0, 0, 974, 683);
        //frame.setSize(1100, 600);
        //frame.add(new BooksPanel());
        //frame.setVisible(true);
    }
}
