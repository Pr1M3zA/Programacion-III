package priscila.biblioteca;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Book {
    private String isbn;
    private String author;
    private String bookTitle;
    private String publisher;
    private int idGenre;
    private int idLanguage;
    private int yearPublication;
    private boolean exist;
    private BufferedImage cover;
    private Connection connectDB = null;
    private boolean available;

    
    public Book(Connection connectDB, String isbn, String author, String bookTitle, String publisher, int idGenre, int idLanguage, int yearPublication) {
        this.connectDB = connectDB;
        this.isbn = isbn;
        this.author = author;
        this.bookTitle = bookTitle;
        this.publisher = publisher;
        this.idGenre = idGenre;
        this.idLanguage = idLanguage;
        this.yearPublication = yearPublication;
    }

    public boolean isAvailable() {
        return available;
    }
    
    public Book(Connection connectDB, String isbn) {
        this.connectDB = connectDB;
        this.isbn = isbn;
        DataRead();
    }    

    public boolean isExist() {
        return exist;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }
    
    private void DataRead(){
        try {
            PreparedStatement pst = connectDB.prepareStatement("SELECT book_title, author, idLanguage, publisher, year_publication, idGenre, cover from books where isbn = ?");
            pst.setString(1, isbn);
            ResultSet rs = pst.executeQuery();
            exist = rs.next();
            if(exist){
                bookTitle = rs.getString("book_title");
                author = rs.getString("author");
                idLanguage = rs.getInt("idLanguage");
                publisher = rs.getString("publisher");
                yearPublication = rs.getInt("year_publication");
                idGenre = rs.getInt("idGenre");
                Blob img = rs.getBlob("cover");
                if(img != null){
                    byte[] imgBuffer = img.getBytes(1, (int)img.length());
                    cover = ImageIO.read(new ByteArrayInputStream(imgBuffer));                
                }
                else
                    cover = null;
            }
            else{
                bookTitle = "";
                author = "";
                idLanguage = 0; 
                publisher = "";
                yearPublication = 0; 
                idGenre = 0;
                cover = null;
            }
            Statement st = connectDB.createStatement();
            rs = st.executeQuery("SELECT returnDate FROM lending_managment WHERE isbn = '" + isbn + "' AND returned = 0 ");
            available = !rs.next();
            rs.close();
            st.close();
            pst.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage getCover() {
        return cover;
    }

    public void setCover(BufferedImage cover) {
        this.cover = cover;
    }
    
    public void ApplyChanges(){
        try {
            String command = "INSERT INTO books (book_title,author, idLanguage, publisher, year_publication, idGenre, isbn) VALUES (?, ?, ?, ?, ?, ?, ?)";
            if(exist)
                command = "UPDATE books SET book_title = ?, author = ?, idLanguage = ?, publisher = ?, year_publication = ?, idGenre = ? WHERE isbn = ?";
            PreparedStatement pst = connectDB.prepareStatement(command);
            pst.setString(1, bookTitle);
            pst.setString(2, author);
            pst.setInt(3, idLanguage);
            pst.setString(4, publisher);
            pst.setInt(5, yearPublication);
            pst.setInt(6, idGenre);
            pst.setString(7, isbn);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addCover(String fileCover){
        try {
            PreparedStatement pst = connectDB.prepareStatement("UPDATE books SET cover = ? WHERE isbn = ?");
            File coverFile = new File(fileCover);
            FileInputStream filestream = new FileInputStream(coverFile);
            pst.setBinaryStream(1, filestream, coverFile.length());
            pst.setString(2, isbn);
            pst.execute();
            pst.close();
        } catch (SQLException | FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    public void removeCover() {
        try {
            PreparedStatement pst = connectDB.prepareStatement("UPDATE books SET cover = NULL WHERE isbn = ?");
            pst.setString(1, isbn);
            pst.execute();
            pst.close();
            cover=null;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        
    }
    
    public void deleteBook(){
        try {
            PreparedStatement pst = connectDB.prepareStatement("DELETE FROM books WHERE isbn = ?");
            pst.setString(1, isbn);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }        
    }   
}
