package com.mycompany.sistema_de_biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private Connection cnn;
    public ConnectDB() {
        try {
            Class.forName ("com.mysql.jdbc.Driver");           
            cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "priscila", "Abcd1234!"); 
            System.out.println("Conectado");
       }
       catch (ClassNotFoundException e) {
            System.out.println ("Error: No se encontró el driver de MySQL");
       }
       catch (SQLException  ex) {
           System.out.println("NO Conectado:" + ex.getMessage());
       }
    }
    
    public Connection getConnection() {
        return cnn;
    }
}