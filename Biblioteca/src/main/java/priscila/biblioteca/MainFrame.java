package priscila.biblioteca;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends javax.swing.JFrame {
    Connection connectDB = null;
    CardLayout cl;
    MenuBar menuBar;
    Genres genres;
    BookManager bookManager;
    UserManager userManager;
    LendingManagment lendingManagment;
    AdvancedSearch advancedSearch;
    TownMap townMap;
    User user;
    
    public MainFrame() {
        initComponents();
        ConnectDB();
        bookManager = new BookManager(this, connectDB);
        userManager = new UserManager(this, connectDB);
        lendingManagment = new LendingManagment(this, connectDB);
        advancedSearch = new AdvancedSearch(this, connectDB);
        townMap = new TownMap(this, connectDB);
        this.setIconImage(new ImagesDB(connectDB).GetImage("icon"));
        this.setResizable(false);
        menuBar = new MenuBar(this, connectDB); 
        this.add(menuBar, BorderLayout.NORTH);
        genres = new Genres(connectDB);
        GetBooks();
     
        MainPanel.add(new Login(this, connectDB), "Login");
        MainPanel.add(bookManager, "Book Manager");
        MainPanel.add(advancedSearch,"Advanced search");
        MainPanel.add(townMap, "Town map");
        MainPanel.add(userManager, "User manager");
        MainPanel.add(lendingManagment, "Lending managment");
        cl = (CardLayout)(MainPanel.getLayout());
        cl.show(MainPanel, "Login");
    }
    
    private void ConnectDB(){
        try {
            Class.forName ("com.mysql.jdbc.Driver");           
            connectDB=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "priscila", "Abcd1234!"); 
            System.out.println("Conectado");
            ImagesDB x = new ImagesDB(connectDB);
            //x.UploadResourceImage("userManagerIcon", "D://ImgResources//OasisiLib - UserManagerIcon.png");
        }
        catch (ClassNotFoundException e) {
            System.out.println ("Error: No se encontró el driver de MySQL");
        }
        catch (SQLException  ex){
            System.out.println("NO Conectado:" + ex.getMessage());
       }
    }
    
    public void GoHome(){
        cl.show(MainPanel, "Home");
        menuBar.setTextLogOut();
    }
    
    public void GoBookManager(){
        cl.show(MainPanel, "Book Manager");
    }
    
    public void GoUserManager(){
        cl.show(MainPanel, "User manager");
    }
    
    public void GoLendingManagment(){
        cl.show(MainPanel, "Lending managment");
    }
    
    public void GoTownMap(){
        cl.show(MainPanel, "Town map");
    }
    
    public void GoLogin(){
       cl.show(MainPanel, "Login");
    }
    
    public void setUser(User user){
        this.user = user;
        menuBar.setUser(user);
    }
    
    public void ShowAdvancedSearch(int invoked){
        advancedSearch.setInvoked(invoked);
        advancedSearch.getData("");
        cl.show(MainPanel, "Advanced search");
    }
    
    public void setISBNtoBookManager(String isbn) {
        bookManager.setISBN(isbn);
        bookManager.showData();
        GoBookManager();
    }
    
    public void setISBNtoLendingManagment(String isbn) {
        lendingManagment.setISBN(isbn);
        lendingManagment.fillData();
        GoLendingManagment();
    }    
    
    public void setDestinationToLendingManagment(String destination){
        lendingManagment.setDestination(destination);
        GoLendingManagment();        
    }
    
    private void GetBooks(){
        try {
            int totalBooks = 0;
            Statement st =  connectDB.createStatement();
            ResultSet rs = st.executeQuery("SELECT isbn FROM books");
            while(rs.next()){
               Book book = new Book(connectDB,rs.getString("isbn"));
               BookInfo info = new BookInfo(book, genres);
               Home.add(info);
               totalBooks++;
            }
            int rows = totalBooks/3;
            Home.setPreferredSize(new Dimension(950, 170 * rows));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        Home = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 700));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setPreferredSize(new java.awt.Dimension(1024, 600));
        MainPanel.setLayout(new java.awt.CardLayout());

        Home.setBackground(new java.awt.Color(255, 255, 255));
        ScrollPane.setViewportView(Home);

        MainPanel.add(ScrollPane, "Home");

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("unchecked")
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane ScrollPane;
    // End of variables declaration//GEN-END:variables
}
