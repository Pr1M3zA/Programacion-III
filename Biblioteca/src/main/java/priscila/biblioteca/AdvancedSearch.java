package priscila.biblioteca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AdvancedSearch extends javax.swing.JPanel {
    final private Connection connectDB;
    Genres genres;
    MainFrame mainFrame;
    private int invoked; 
    //final private ImagesDB image;

    public void setInvoked(int invoked) {
        this.invoked = invoked;
    }
  
    public AdvancedSearch(MainFrame mainFrame, Connection connectDB) {
        this.mainFrame = mainFrame;
        this.connectDB = connectDB;
        genres = new Genres(connectDB);
        initComponents();
    }
    
    private ComboBoxModel<String> FillComboboxGenres() {
        return genres.CBModel();
    }   
    
    public void getData(String filter){
        try {
            String [] columns = {"ISBN", "Book title", "Author", "Genre", "Publisher"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            String query = "SELECT isbn, book_title, author, publisher, g.description AS genre FROM books b INNER JOIN Genres g ON b.idGenre = g.id";
            if(filter.length() > 0)
                query = query + " WHERE " + filter;
            Statement st =  connectDB.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String [] row = {rs.getString("isbn"), rs.getString("book_title"), rs.getString("author"), rs.getString("genre"), rs.getString("publisher")}; 
                model.addRow(row);
            }
            ResultsTable.setModel(model);
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchISBN = new javax.swing.JLabel();
        SearchAuthor = new javax.swing.JLabel();
        SearchBookTitle = new javax.swing.JLabel();
        SearchPublisher = new javax.swing.JLabel();
        SearchGenre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultsTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        AuthorField = new javax.swing.JTextField();
        ISBNField = new javax.swing.JTextField();
        PublisherField = new javax.swing.JTextField();
        BookTitleField = new javax.swing.JTextField();
        SelectButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        GenreField = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchISBN.setBackground(new java.awt.Color(139, 105, 78));
        SearchISBN.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SearchISBN.setForeground(new java.awt.Color(255, 255, 255));
        SearchISBN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchISBN.setText("ISBN");
        SearchISBN.setToolTipText("");
        SearchISBN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SearchISBN.setOpaque(true);
        SearchISBN.setPreferredSize(new java.awt.Dimension(244, 47));
        add(SearchISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 165, 29));

        SearchAuthor.setBackground(new java.awt.Color(178, 138, 65));
        SearchAuthor.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SearchAuthor.setForeground(new java.awt.Color(255, 255, 255));
        SearchAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchAuthor.setText("Author  ");
        SearchAuthor.setToolTipText("");
        SearchAuthor.setOpaque(true);
        SearchAuthor.setPreferredSize(new java.awt.Dimension(244, 47));
        add(SearchAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 67, 165, 29));

        SearchBookTitle.setBackground(new java.awt.Color(162, 129, 112));
        SearchBookTitle.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SearchBookTitle.setForeground(new java.awt.Color(255, 255, 255));
        SearchBookTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchBookTitle.setText("Book title");
        SearchBookTitle.setToolTipText("");
        SearchBookTitle.setOpaque(true);
        SearchBookTitle.setPreferredSize(new java.awt.Dimension(244, 47));
        add(SearchBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 67, 165, 29));

        SearchPublisher.setBackground(new java.awt.Color(168, 99, 42));
        SearchPublisher.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SearchPublisher.setForeground(new java.awt.Color(255, 255, 255));
        SearchPublisher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchPublisher.setText("Publisher  ");
        SearchPublisher.setToolTipText("");
        SearchPublisher.setOpaque(true);
        SearchPublisher.setPreferredSize(new java.awt.Dimension(244, 47));
        add(SearchPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 67, 165, 29));

        SearchGenre.setBackground(new java.awt.Color(196, 143, 47));
        SearchGenre.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SearchGenre.setForeground(new java.awt.Color(255, 255, 255));
        SearchGenre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchGenre.setText("Genre  ");
        SearchGenre.setToolTipText("");
        SearchGenre.setOpaque(true);
        SearchGenre.setPreferredSize(new java.awt.Dimension(244, 47));
        add(SearchGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 67, 165, 29));

        ResultsTable.setBackground(new java.awt.Color(255, 255, 255));
        ResultsTable.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        ResultsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ResultsTable.setPreferredSize(new java.awt.Dimension(1650, 635));
        ResultsTable.setSelectionBackground(new java.awt.Color(215, 175, 107));
        ResultsTable.setSelectionForeground(new java.awt.Color(31, 18, 3));
        ResultsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ResultsTable.setShowGrid(true);
        jScrollPane1.setViewportView(ResultsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 143, 1030, 360));

        AuthorField.setBackground(new java.awt.Color(227, 207, 179));
        AuthorField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        AuthorField.setForeground(new java.awt.Color(82, 43, 29));
        AuthorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorFieldActionPerformed(evt);
            }
        });
        add(AuthorField, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 102, 165, 29));

        ISBNField.setBackground(new java.awt.Color(227, 207, 179));
        ISBNField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        ISBNField.setForeground(new java.awt.Color(82, 43, 29));
        ISBNField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNFieldActionPerformed(evt);
            }
        });
        add(ISBNField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 102, 165, 29));

        PublisherField.setBackground(new java.awt.Color(227, 207, 179));
        PublisherField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        PublisherField.setForeground(new java.awt.Color(82, 43, 29));
        PublisherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherFieldActionPerformed(evt);
            }
        });
        add(PublisherField, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 102, 165, 29));

        BookTitleField.setBackground(new java.awt.Color(227, 207, 179));
        BookTitleField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        BookTitleField.setForeground(new java.awt.Color(82, 43, 29));
        BookTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookTitleFieldActionPerformed(evt);
            }
        });
        add(BookTitleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 102, 165, 29));

        SelectButton.setBackground(new java.awt.Color(143, 73, 0));
        SelectButton.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SelectButton.setForeground(new java.awt.Color(255, 255, 255));
        SelectButton.setText("Select");
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });
        add(SelectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, 125, 41));

        SearchButton.setBackground(new java.awt.Color(196, 173, 145));
        SearchButton.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(91, 52, 33));
        SearchButton.setText("Search");
        SearchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 113, -1));

        GenreField.setBackground(new java.awt.Color(227, 207, 179));
        GenreField.setEditable(true);
        GenreField.setModel(FillComboboxGenres());
        add(GenreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 103, 169, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void AuthorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorFieldActionPerformed

    private void ISBNFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNFieldActionPerformed

    private void PublisherFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherFieldActionPerformed

    private void BookTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookTitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookTitleFieldActionPerformed

    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButtonActionPerformed
       String isbnSelected = "";
        if(ResultsTable.getSelectedRow() >= 0)
           isbnSelected = ResultsTable.getModel().getValueAt(ResultsTable.getSelectedRow(), 0).toString();
        if(invoked == 1)
            mainFrame.setISBNtoBookManager(isbnSelected);
        if(invoked == 2)
            mainFrame.setISBNtoLendingManagment(isbnSelected);
    }//GEN-LAST:event_SelectButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String filter = "";
        if(ISBNField.getText().length() > 0)
            filter = filter + "isbn LIKE '%" + ISBNField.getText() + "%'";
        if(BookTitleField.getText().length() > 0)
            filter = filter + (filter.length() == 0 ? "" : " AND ") + "book_title LIKE '%" + BookTitleField.getText().replace(" ", "%") + "%'";
        if(AuthorField.getText().length() > 0)
            filter = filter + (filter.length() == 0 ? "" : " AND ") + "author LIKE '%" + AuthorField.getText().replace(" ", "%") + "%'";
        if(PublisherField.getText().length() > 0)
            filter = filter + (filter.length() == 0 ? "" : " AND ") + "publisher LIKE '%" + PublisherField.getText().replace(" ", "%") + "%'";
        int idGenre = genres.getId(GenreField.getSelectedItem().toString());
        if(idGenre != -1)
             filter = filter + (filter.length() == 0 ? "" : " AND ") + "idGenre = " + Integer.toString(idGenre);
        getData(filter);
    }//GEN-LAST:event_SearchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AuthorField;
    private javax.swing.JTextField BookTitleField;
    private javax.swing.JComboBox<String> GenreField;
    private javax.swing.JTextField ISBNField;
    private javax.swing.JTextField PublisherField;
    private javax.swing.JTable ResultsTable;
    private javax.swing.JLabel SearchAuthor;
    private javax.swing.JLabel SearchBookTitle;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SearchGenre;
    private javax.swing.JLabel SearchISBN;
    private javax.swing.JLabel SearchPublisher;
    private javax.swing.JButton SelectButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
