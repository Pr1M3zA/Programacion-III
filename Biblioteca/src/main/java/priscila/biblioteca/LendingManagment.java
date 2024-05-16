package priscila.biblioteca;

import com.github.lgooddatepicker.components.DatePicker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LendingManagment extends javax.swing.JPanel {
    final private Connection connectDB;
    private MainFrame mainFrame;
    final private ImagesDB image;
    DatePicker lendingDate = new DatePicker(); 
    DatePicker PRDate = new DatePicker(); 
    DatePicker returnDate = new DatePicker();
    private Lending lending;
    
    public LendingManagment(MainFrame mainFrame, Connection connectDB) {
        this.connectDB = connectDB;
        this.image = new ImagesDB(connectDB);
        this.mainFrame = mainFrame;
        ImagesDB images = new ImagesDB(connectDB);
        initComponents();
        AdvancedSearchButton.setIcon(new ImageIcon(images.GetImage("MagnifyingGlass").getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        MapTownButton.setIcon(new ImageIcon(images.GetImage("MagnifyingGlass").getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        lendingDate.setBounds(45, 295, 280, 31);
        PRDate.setBounds(370, 295, 280, 31);
        returnDate.setBounds(685, 295, 280, 31);
        this.add(lendingDate);
        this.add(PRDate);
        this.add(returnDate);
        fillDataTable();
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        final Color YELLOW_RECTANGLE = new Color(180,153,82);
        final Color BROWN_RECT = new Color(131,90,73);
        
        g2d.setColor(YELLOW_RECTANGLE);
        g2d.fillRect(360, 0, 660, 80);
       
        g2d.drawImage(image.GetImage("logoOasisLib").getScaledInstance(292, 100, Image.SCALE_SMOOTH), 40, 2, null);
        g2d.drawImage(image.GetImage("lendingManagmentIcon").getScaledInstance(55,55, Image.SCALE_SMOOTH), 550, 10, null);
    }
    
    public void fillData(){
        Book book = new Book(connectDB, ISBNTextField.getText());
        if(book.isExist()){
            TittleTextField.setText(book.getBookTitle());
            returnDate.setVisible(!book.isAvailable());
            ReturnDateLabel.setVisible(!book.isAvailable());
            lending = new Lending(connectDB, ISBNTextField.getText());
            if(lending.isExists()) {
                ReadersNameTextField.setText(lending.getReadersName());
                DestinationTextField.setText(lending.getDestination());
                lendingDate.setDate(lending.getLendingDate());
                PRDate.setDate(lending.getPRDate());
                LendingButton.setText("Update");                
            }
            else {
                ReadersNameTextField.setText("");
                DestinationTextField.setText("");
                lendingDate.setDateToToday();
                PRDate.setDateToToday();
                LendingButton.setText("Save");
            }
        }
    }
    
    private void fillDataTable() {
        try {
            String [] columns = {"ISBN", "Book title", "Readers Name", "Destination", "Lending Date", "Programmed Return Date"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            String query = "SELECT l.isbn, b.book_title, l.readersName, l.destination, DATE_FORMAT(l.lendingDate, '%d-%m-%Y') AS lendingDate, DATE_FORMAT(l.programmedReturnDate, '%d-%m-%Y') AS programmedReturnDate FROM lending_managment l left JOIN books b ON l.isbn=b.isbn WHERE returned = 0";
            Statement st =  connectDB.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String [] row = {rs.getString("isbn"), rs.getString("book_title"), rs.getString("readersName"), rs.getString("destination"), rs.getString("lendingDate"), rs.getString("programmedReturnDate")}; 
                model.addRow(row);
            }
            BooksTable.setModel(model);
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BooksTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) showInfoRowSelected(BooksTable.getSelectedRow());
            }
        });
    }
    
    private void showInfoRowSelected(int row) {
        setISBN(BooksTable.getModel().getValueAt(row, 0).toString());
        fillData();
    }
    
    public void setISBN(String isbn) {
        ISBNTextField.setText(isbn);
    }    
    
    public void setDestination(String destination){
        DestinationTextField.setText(destination);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MapTownButton = new javax.swing.JButton();
        AdvancedSearchButton = new javax.swing.JButton();
        ISBNTextField = new javax.swing.JTextField();
        TittleTextField = new javax.swing.JTextField();
        DestinationTextField = new javax.swing.JTextField();
        ReadersNameLabel = new javax.swing.JLabel();
        DestinationLabel = new javax.swing.JLabel();
        ISBNLabel = new javax.swing.JLabel();
        ReturnDateLabel = new javax.swing.JLabel();
        TittleLabel = new javax.swing.JLabel();
        LendingDateLabel = new javax.swing.JLabel();
        PRDLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BooksTable = new javax.swing.JTable(){     public boolean isCellEditable(int row, int column) {         return false;     }; };
        ReadersNameTextField = new javax.swing.JTextField();
        BookInventoryManager = new javax.swing.JLabel();
        LendingButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        MapTownButton.setBackground(new java.awt.Color(198, 152, 31));
        MapTownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapTownButtonActionPerformed(evt);
            }
        });
        add(MapTownButton);
        MapTownButton.setBounds(610, 220, 40, 30);

        AdvancedSearchButton.setBackground(new java.awt.Color(198, 152, 31));
        AdvancedSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdvancedSearchButtonActionPerformed(evt);
            }
        });
        add(AdvancedSearchButton);
        AdvancedSearchButton.setBounds(290, 140, 40, 30);

        ISBNTextField.setBackground(new java.awt.Color(227, 221, 179));
        ISBNTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISBNTextFieldFocusLost(evt);
            }
        });
        add(ISBNTextField);
        ISBNTextField.setBounds(40, 140, 280, 31);

        TittleTextField.setBackground(new java.awt.Color(227, 221, 179));
        add(TittleTextField);
        TittleTextField.setBounds(40, 220, 280, 31);

        DestinationTextField.setBackground(new java.awt.Color(227, 221, 179));
        add(DestinationTextField);
        DestinationTextField.setBounds(370, 220, 280, 31);

        ReadersNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        ReadersNameLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        ReadersNameLabel.setForeground(new java.awt.Color(91, 52, 33));
        ReadersNameLabel.setText("Reader's name");
        add(ReadersNameLabel);
        ReadersNameLabel.setBounds(370, 110, 131, 22);

        DestinationLabel.setBackground(new java.awt.Color(255, 255, 255));
        DestinationLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        DestinationLabel.setForeground(new java.awt.Color(91, 52, 33));
        DestinationLabel.setText("Destination");
        add(DestinationLabel);
        DestinationLabel.setBounds(370, 190, 130, 22);

        ISBNLabel.setBackground(new java.awt.Color(255, 255, 255));
        ISBNLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        ISBNLabel.setForeground(new java.awt.Color(91, 52, 33));
        ISBNLabel.setText("Book to lend");
        add(ISBNLabel);
        ISBNLabel.setBounds(50, 110, 160, 22);

        ReturnDateLabel.setBackground(new java.awt.Color(255, 255, 255));
        ReturnDateLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        ReturnDateLabel.setForeground(new java.awt.Color(91, 52, 33));
        ReturnDateLabel.setText("Return Date");
        add(ReturnDateLabel);
        ReturnDateLabel.setBounds(690, 270, 104, 22);

        TittleLabel.setBackground(new java.awt.Color(255, 255, 255));
        TittleLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        TittleLabel.setForeground(new java.awt.Color(91, 52, 33));
        TittleLabel.setText("Book title");
        add(TittleLabel);
        TittleLabel.setBounds(50, 190, 130, 22);

        LendingDateLabel.setBackground(new java.awt.Color(255, 255, 255));
        LendingDateLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        LendingDateLabel.setForeground(new java.awt.Color(91, 52, 33));
        LendingDateLabel.setText("Lending Date");
        add(LendingDateLabel);
        LendingDateLabel.setBounds(50, 270, 210, 22);

        PRDLabel.setBackground(new java.awt.Color(255, 255, 255));
        PRDLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        PRDLabel.setForeground(new java.awt.Color(91, 52, 33));
        PRDLabel.setText("Programmed return date");
        add(PRDLabel);
        PRDLabel.setBounds(370, 270, 270, 22);

        BooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(BooksTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 350, 930, 270);

        ReadersNameTextField.setBackground(new java.awt.Color(227, 221, 179));
        add(ReadersNameTextField);
        ReadersNameTextField.setBounds(370, 140, 280, 31);

        BookInventoryManager.setBackground(new java.awt.Color(255, 255, 255));
        BookInventoryManager.setFont(new java.awt.Font("Arimo", 1, 36)); // NOI18N
        BookInventoryManager.setForeground(new java.awt.Color(255, 255, 255));
        BookInventoryManager.setText("Lending managment");
        add(BookInventoryManager);
        BookInventoryManager.setBounds(640, 20, 390, 42);

        LendingButton.setBackground(new java.awt.Color(216, 184, 97));
        LendingButton.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        LendingButton.setForeground(new java.awt.Color(255, 255, 255));
        LendingButton.setText("Save");
        LendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LendingButtonActionPerformed(evt);
            }
        });
        add(LendingButton);
        LendingButton.setBounds(760, 170, 180, 33);

        warningLabel.setBackground(new java.awt.Color(255, 255, 255));
        warningLabel.setFont(new java.awt.Font("Arimo", 1, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(102, 0, 0));
        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(warningLabel);
        warningLabel.setBounds(740, 220, 220, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void MapTownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapTownButtonActionPerformed
        mainFrame.GoTownMap();
    }//GEN-LAST:event_MapTownButtonActionPerformed

    private void AdvancedSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdvancedSearchButtonActionPerformed
        mainFrame.ShowAdvancedSearch(2);
    }//GEN-LAST:event_AdvancedSearchButtonActionPerformed

    private void ISBNTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISBNTextFieldFocusLost
       if(ISBNTextField.getText().length() > 0){
           fillData();
       }
    }//GEN-LAST:event_ISBNTextFieldFocusLost

    private void LendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LendingButtonActionPerformed
        if(DestinationTextField.getText().length() > 0 && ReadersNameTextField.getText().length() > 0) {
            if(returnDate.getDate() != null) {
                if(returnDate.getDate().isAfter(lendingDate.getDate())){
                    lending.setReturnDate(returnDate.getDate());
                    lending.returnBook();
                    fillDataTable();
                    JOptionPane.showMessageDialog(null, "The book was returned succesfully!", null, JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Invalid return date", null, JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                if(lendingDate.getDate().isAfter(PRDate.getDate()))
                    JOptionPane.showMessageDialog(null, "Invalid return date", null, JOptionPane.INFORMATION_MESSAGE);
                else{
                    lending.setReadersName(ReadersNameTextField.getText());
                    lending.setDestination(DestinationTextField.getText());
                    lending.setLendingDate(lendingDate.getDate());
                    lending.setPRDate(PRDate.getDate());
                    lending.ApplyChanges();
                    fillDataTable();
                    JOptionPane.showMessageDialog(null, "The data was saved", null, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "All fields must have data", null, JOptionPane.INFORMATION_MESSAGE);            
    }//GEN-LAST:event_LendingButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdvancedSearchButton;
    private javax.swing.JLabel BookInventoryManager;
    private javax.swing.JTable BooksTable;
    private javax.swing.JLabel DestinationLabel;
    private javax.swing.JTextField DestinationTextField;
    private javax.swing.JLabel ISBNLabel;
    private javax.swing.JTextField ISBNTextField;
    private javax.swing.JButton LendingButton;
    private javax.swing.JLabel LendingDateLabel;
    private javax.swing.JButton MapTownButton;
    private javax.swing.JLabel PRDLabel;
    private javax.swing.JLabel ReadersNameLabel;
    private javax.swing.JTextField ReadersNameTextField;
    private javax.swing.JLabel ReturnDateLabel;
    private javax.swing.JLabel TittleLabel;
    private javax.swing.JTextField TittleTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
