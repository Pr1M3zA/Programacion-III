package priscila.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
   private String userName, firstName, lastName, password;
   int role;
   Connection connectDB;
   private boolean exists;

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public User(String userName, Connection connectDB) {
        this.userName = userName;
        this.connectDB = connectDB;
        DataRead();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    private void DataRead(){
       try {
           PreparedStatement pst = connectDB.prepareStatement("SELECT id, firstName, lastName, pass, role FROM users WHERE id = ?");
           pst.setString(1, userName);
           ResultSet rs = pst.executeQuery();
           exists = rs.next();
           if(exists){
               firstName = rs.getString("firstName");
               lastName = rs.getString("lastName");
               password = rs.getString("pass");
               role = rs.getInt("role");
           }
           else{
               firstName = "";
               lastName = "" ;
               password = "";
               role = 0;              
           }
       } catch (SQLException ex) {
           Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void ApplyChanges(){
       try {
           String query = "UPDATE users SET firstName = ?, lastName = ?, pass = ?, role = ? WHERE id = ?";
           if(!exists)
               query = "INSERT INTO users (firstName, lastName, pass, role, id) VALUES (?, ?, ?, ?, ?)";
           PreparedStatement pst = connectDB.prepareStatement(query);
           pst.setString(1, firstName);
           pst.setString(2, lastName);
           pst.setString(3, password);
           pst.setInt(4, role);
           pst.setString(5, userName);
           pst.execute();
           pst.close();
       } catch (SQLException ex) {
           Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
