package priscila.biblioteca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lending {
    private Connection connectDB;
    private String isbn;
    private String destination, readersName;
    private LocalDate lendingDate, PRDate, returnDate;
    private boolean exists;
    
    public Lending(Connection connectDB, String isbn) {
        this.connectDB = connectDB;
        this.isbn = isbn;
        DataRead();
    }
    
    private void DataRead(){
        try {
            PreparedStatement pst = connectDB.prepareStatement("SELECT readersName, destination, lendingDate, programmedReturnDate FROM lending_managment WHERE isbn = ? AND Returned = 0");
            pst.setString(1, isbn);
            ResultSet rs = pst.executeQuery();
            exists = rs.next();
            if(exists){
                readersName = rs.getString("readersName");
                destination = rs.getString("destination");
                lendingDate = rs.getDate("lendingDate").toLocalDate();
                PRDate = rs.getDate("programmedReturnDate").toLocalDate();
                returnDate = null;
            }
            else{
                readersName = "";
                destination = "";
                lendingDate = LocalDate.now();
                PRDate = LocalDate.now();
                returnDate = null;
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ApplyChanges(){
        try {
            String command = "INSERT INTO lending_managment (readersName, destination, lendingDate, programmedReturnDate, isbn, returned) VALUES (?, ?, ?, ?, ?, 0)";
            if(exists)
                command = "UPDATE lending_managment SET readersName = ?, destination = ?, lendingDate = ?, programmedReturnDate = ? WHERE isbn = ? AND returned = 0";
            PreparedStatement pst = connectDB.prepareStatement(command);
            pst.setString(1, readersName);
            pst.setString(2, destination);
            pst.setDate(3, Date.valueOf(lendingDate));
            pst.setDate(4, Date.valueOf(PRDate));
            pst.setString(5, isbn);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void returnBook() {
        try {
            if(exists && returnDate != null) {
                String command = "UPDATE lending_managment SET returned=1, returnDate = ? WHERE isbn = ?";
                PreparedStatement pst = connectDB.prepareStatement(command);
                pst.setDate(1, Date.valueOf(returnDate));
                pst.setString(2, isbn);
                pst.execute();
                pst.close();
            }    
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getReadersName() {
        return readersName;
    }

    public void setReadersName(String readersName) {
        this.readersName = readersName;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public LocalDate getPRDate() {
        return PRDate;
    }

    public void setPRDate(LocalDate PRDate) {
        this.PRDate = PRDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}