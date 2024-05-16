package priscila.biblioteca;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


 public class BookManager extends javax.swing.JPanel {
    final private Connection connectDB;
    final private ImagesDB image;
    private boolean bookExist = false;
    Genres genres;
    Languages languages;
    Book book;
    MainFrame mainFrame;
    
    public BookManager(MainFrame mainFrame, Connection connectDB) {
        this.connectDB = connectDB;
        this.mainFrame = mainFrame;
        languages = new Languages(connectDB);
        genres = new Genres(connectDB);
        initComponents();
        this.image = new ImagesDB(connectDB, "corner2");
        BufferedImage icon = new ImagesDB(connectDB).GetImage("trashIcon");
        SearchButton.setIcon(new ImageIcon(image.GetImage("MagnifyingGlass").getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        removeCoverButton.setIcon(new ImageIcon(icon.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        removeCoverButton.setVisible(false);
        DeleteBookButton.setVisible(false);
        ISBNTextField.requestFocus();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        final Color ORANGE_RECTANGLE = new Color(180,122,82);
        final Color BROWN_RECT = new Color(131,90,73);
        
        g2d.setColor(ORANGE_RECTANGLE);
        g2d.fillRect(360, 0, 660, 80);
        g2d.setColor(BROWN_RECT);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(10, 150, 250, 333);
        
        g2d.drawImage(image.MirrorVertical().getScaledInstance(200, 200, Image.SCALE_SMOOTH), 840, 400, null);
        g2d.drawImage(image.Rotate(180).getScaledInstance(200, 200, Image.SCALE_SMOOTH), -30, 400, null);
        g2d.drawImage(image.GetImage("logoOasisLib").getScaledInstance(292, 100, Image.SCALE_SMOOTH), 40, 2, null);
        g2d.drawImage(image.GetImage("bookManagerIcon").getScaledInstance(80,80, Image.SCALE_SMOOTH), 640, 0, null);
    }
    
    private ComboBoxModel<String> FillComboboxGenres() {
        return genres.CBModel();
    }   
    
    private ComboBoxModel<String> FillComboboxLanguages() {
        return languages.CBModel();
    }
    
    public void setISBN(String isbn) {
        ISBNTextField.setText(isbn);
        ISBNTextField.requestFocus();
    }
    
    public void showData(){
        book = new Book(connectDB, ISBNTextField.getText());
        InUseTextField.setVisible(book.isExist());
        InUseabel.setVisible(book.isExist());
        DeleteBookButton.setVisible(book.isAvailable() && book.isExist());
        if(book.isExist()){
            InUseTextField.setText(book.isAvailable() ? "Available" : "Not available");
            AddCoverButton.setEnabled(true);
            BookTitleTextField.setText(book.getBookTitle());
            AuthorTextField.setText(book.getAuthor());
            PublisherTextField.setText(book.getPublisher());
            YearOfPublicationTextField.setText(Integer.toString(book.getYearPublication()));
            GenreComboBox.setSelectedItem(genres.getDescription(book.getIdGenre()));
            LanguageComboBox.setSelectedItem(languages.getDescription(book.getIdLanguage()));
            if(book.getCover() != null){
                AddCoverButton.setVisible(false);
                removeCoverButton.setVisible(true);
                CoverLabel.setIcon(new ImageIcon(book.getCover().getScaledInstance(CoverLabel.getWidth(), CoverLabel.getHeight(), Image.SCALE_SMOOTH)));
            }
            else{
                AddCoverButton.setVisible(true);
                removeCoverButton.setVisible(false);
                CoverLabel.setIcon(null);
            }
            NewBookButton.setText("Apply changes");

        }
        else{
            NewBookButton.setText("New book");
            AddCoverButton.setVisible(true);
            removeCoverButton.setVisible(false);
            BookTitleTextField.setText("");
            AuthorTextField.setText("");
            PublisherTextField.setText("");
            YearOfPublicationTextField.setText("");
            GenreComboBox.setSelectedIndex(0);
            LanguageComboBox.setSelectedIndex(0);
            InUseTextField.setText("");
        }
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InUseTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        AuthorTextField = new javax.swing.JTextField();
        YearOfPublicationTextField = new javax.swing.JTextField();
        ISBNTextField = new javax.swing.JTextField();
        BookTitleTextField = new javax.swing.JTextField();
        PublisherTextField = new javax.swing.JTextField();
        LanguageComboBox = new javax.swing.JComboBox<>();
        NewBookButton = new javax.swing.JButton();
        InUseabel = new javax.swing.JLabel();
        PublisherLabel = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        languageLabel = new javax.swing.JLabel();
        ISBNLabel = new javax.swing.JLabel();
        BookInventoryManager = new javax.swing.JLabel();
        YearOfPublicationLabel = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        BookTitleLabel = new javax.swing.JLabel();
        AddCoverButton = new javax.swing.JButton();
        GenreComboBox = new javax.swing.JComboBox<>();
        removeCoverButton = new javax.swing.JButton();
        CoverLabel = new javax.swing.JLabel();
        DeleteBookButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InUseTextField.setBackground(new java.awt.Color(227, 207, 179));
        InUseTextField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        InUseTextField.setForeground(new java.awt.Color(91, 52, 33));
        InUseTextField.setFocusable(false);
        InUseTextField.setPreferredSize(new java.awt.Dimension(334, 31));
        add(InUseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 422, -1, -1));

        SearchButton.setBackground(new java.awt.Color(133, 67, 20));
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 40, 30));

        AuthorTextField.setBackground(new java.awt.Color(227, 207, 179));
        AuthorTextField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        AuthorTextField.setForeground(new java.awt.Color(91, 52, 33));
        AuthorTextField.setPreferredSize(new java.awt.Dimension(334, 31));
        add(AuthorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 257, -1, -1));

        YearOfPublicationTextField.setBackground(new java.awt.Color(227, 207, 179));
        YearOfPublicationTextField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        YearOfPublicationTextField.setForeground(new java.awt.Color(91, 52, 33));
        YearOfPublicationTextField.setPreferredSize(new java.awt.Dimension(334, 31));
        add(YearOfPublicationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        ISBNTextField.setBackground(new java.awt.Color(227, 207, 179));
        ISBNTextField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        ISBNTextField.setForeground(new java.awt.Color(91, 52, 33));
        ISBNTextField.setPreferredSize(new java.awt.Dimension(334, 31));
        ISBNTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ISBNTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISBNTextFieldFocusLost(evt);
            }
        });
        ISBNTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextFieldActionPerformed(evt);
            }
        });
        add(ISBNTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        BookTitleTextField.setBackground(new java.awt.Color(227, 207, 179));
        BookTitleTextField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        BookTitleTextField.setForeground(new java.awt.Color(91, 52, 33));
        BookTitleTextField.setPreferredSize(new java.awt.Dimension(334, 31));
        add(BookTitleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        PublisherTextField.setBackground(new java.awt.Color(227, 207, 179));
        PublisherTextField.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        PublisherTextField.setForeground(new java.awt.Color(91, 52, 33));
        PublisherTextField.setPreferredSize(new java.awt.Dimension(334, 31));
        add(PublisherTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 257, -1, -1));

        LanguageComboBox.setBackground(new java.awt.Color(227, 207, 179));
        LanguageComboBox.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        LanguageComboBox.setForeground(new java.awt.Color(91, 52, 33));
        LanguageComboBox.setModel(FillComboboxLanguages());
        LanguageComboBox.setBorder(null);
        LanguageComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LanguageComboBox.setPreferredSize(new java.awt.Dimension(334, 31));
        LanguageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageComboBoxActionPerformed(evt);
            }
        });
        add(LanguageComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        NewBookButton.setBackground(new java.awt.Color(159, 78, 21));
        NewBookButton.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        NewBookButton.setForeground(new java.awt.Color(255, 255, 255));
        NewBookButton.setText("New book");
        NewBookButton.setActionCommand("");
        NewBookButton.setPreferredSize(new java.awt.Dimension(154, 32));
        NewBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBookButtonActionPerformed(evt);
            }
        });
        add(NewBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 180, -1));

        InUseabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        InUseabel.setForeground(new java.awt.Color(91, 52, 33));
        InUseabel.setText("Status");
        add(InUseabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, -1, -1));

        PublisherLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        PublisherLabel.setForeground(new java.awt.Color(91, 52, 33));
        PublisherLabel.setText("Publisher");
        add(PublisherLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        AuthorLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        AuthorLabel.setForeground(new java.awt.Color(91, 52, 33));
        AuthorLabel.setText("Author");
        add(AuthorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 230, -1, -1));

        languageLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        languageLabel.setForeground(new java.awt.Color(91, 52, 33));
        languageLabel.setText("Language");
        add(languageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        ISBNLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        ISBNLabel.setForeground(new java.awt.Color(91, 52, 33));
        ISBNLabel.setText("ISBN");
        add(ISBNLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 150, -1, -1));

        BookInventoryManager.setBackground(new java.awt.Color(255, 255, 255));
        BookInventoryManager.setFont(new java.awt.Font("Arimo", 1, 36)); // NOI18N
        BookInventoryManager.setForeground(new java.awt.Color(255, 255, 255));
        BookInventoryManager.setText("Book Manager");
        add(BookInventoryManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        YearOfPublicationLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        YearOfPublicationLabel.setForeground(new java.awt.Color(91, 52, 33));
        YearOfPublicationLabel.setText("Year of Publication");
        add(YearOfPublicationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 310, -1, -1));

        genreLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        genreLabel.setForeground(new java.awt.Color(91, 52, 33));
        genreLabel.setText("Genre");
        add(genreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 390, -1, -1));

        BookTitleLabel.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        BookTitleLabel.setForeground(new java.awt.Color(91, 52, 33));
        BookTitleLabel.setText("Book Title");
        add(BookTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        AddCoverButton.setBackground(new java.awt.Color(159, 78, 21));
        AddCoverButton.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        AddCoverButton.setForeground(new java.awt.Color(255, 255, 255));
        AddCoverButton.setText("+ Add cover");
        AddCoverButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddCoverButton.setEnabled(false);
        AddCoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCoverButtonActionPerformed(evt);
            }
        });
        add(AddCoverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        GenreComboBox.setBackground(new java.awt.Color(227, 207, 179));
        GenreComboBox.setFont(new java.awt.Font("Arimo", 0, 14)); // NOI18N
        GenreComboBox.setForeground(new java.awt.Color(91, 52, 33));
        GenreComboBox.setModel(FillComboboxGenres());
        GenreComboBox.setBorder(null);
        GenreComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GenreComboBox.setPreferredSize(new java.awt.Dimension(334, 31));
        add(GenreComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 422, -1, -1));

        removeCoverButton.setBackground(new java.awt.Color(133, 67, 20));
        removeCoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCoverButtonActionPerformed(evt);
            }
        });
        add(removeCoverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 50, 30));
        add(CoverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, 335));

        DeleteBookButton.setBackground(new java.awt.Color(77, 9, 9));
        DeleteBookButton.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        DeleteBookButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBookButton.setText("Delete book");
        DeleteBookButton.setActionCommand("");
        DeleteBookButton.setPreferredSize(new java.awt.Dimension(154, 32));
        DeleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookButtonActionPerformed(evt);
            }
        });
        add(DeleteBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void AddCoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCoverButtonActionPerformed
        JFileChooser file = new JFileChooser();
        FileFilter imgFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        file.setFileFilter(imgFilter);
        if(file.showDialog(this, "Ok") == JFileChooser.APPROVE_OPTION){
            try {
                book.addCover(file.getSelectedFile().toString());
                File img = new File(file.getSelectedFile().toString()); 
                BufferedImage cover = ImageIO.read(img);
                book.setCover(cover);
                this.repaint();
            } catch (IOException ex) {
                Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddCoverButtonActionPerformed

    private void ISBNTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNTextFieldActionPerformed

    private void ISBNTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISBNTextFieldFocusGained
        //AddCoverButton.setEnabled(false);
        ISBNTextField.setText("");
        AuthorTextField.setText("");
        YearOfPublicationTextField.setText("");
        BookTitleTextField.setText("");
        PublisherTextField.setText("");
        GenreComboBox.setSelectedIndex(0);
        LanguageComboBox.setSelectedIndex(0);
        AddCoverButton.setEnabled(false);
        book = null;
        CoverLabel.setIcon(null);
    }//GEN-LAST:event_ISBNTextFieldFocusGained

    private void ISBNTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISBNTextFieldFocusLost
        if(ISBNTextField.getText().length() != 0){
            showData();
        }
    }//GEN-LAST:event_ISBNTextFieldFocusLost

    private void LanguageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LanguageComboBoxActionPerformed

    private void NewBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBookButtonActionPerformed
        book.setBookTitle(BookTitleTextField.getText());
        book.setAuthor(AuthorTextField.getText());
        book.setPublisher(PublisherTextField.getText());
        book.setIdGenre(genres.getId(GenreComboBox.getSelectedItem().toString()));
        book.setIdLanguage(languages.getId(LanguageComboBox.getSelectedItem().toString()));
        book.setYearPublication(Integer.parseInt(YearOfPublicationTextField.getText()));
        book.ApplyChanges();
        JOptionPane.showMessageDialog(null, "The book was saved succesfully!", null, JOptionPane.INFORMATION_MESSAGE);
        AddCoverButton.setEnabled(true);
    }//GEN-LAST:event_NewBookButtonActionPerformed

    private void removeCoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCoverButtonActionPerformed
        book.removeCover();
    }//GEN-LAST:event_removeCoverButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        mainFrame.ShowAdvancedSearch(1);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void DeleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBookButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Are you sure?","Delete book?",dialogButton);
        if(dialogButton == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "The book was deleted succesfully", null, JOptionPane.INFORMATION_MESSAGE);
            book.deleteBook();
            showData();
        }
    }//GEN-LAST:event_DeleteBookButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCoverButton;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JTextField AuthorTextField;
    private javax.swing.JLabel BookInventoryManager;
    private javax.swing.JLabel BookTitleLabel;
    private javax.swing.JTextField BookTitleTextField;
    private javax.swing.JLabel CoverLabel;
    private javax.swing.JButton DeleteBookButton;
    private javax.swing.JComboBox<String> GenreComboBox;
    private javax.swing.JLabel ISBNLabel;
    private javax.swing.JTextField ISBNTextField;
    private javax.swing.JTextField InUseTextField;
    private javax.swing.JLabel InUseabel;
    private javax.swing.JComboBox<String> LanguageComboBox;
    private javax.swing.JButton NewBookButton;
    private javax.swing.JLabel PublisherLabel;
    private javax.swing.JTextField PublisherTextField;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel YearOfPublicationLabel;
    private javax.swing.JTextField YearOfPublicationTextField;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JButton removeCoverButton;
    // End of variables declaration//GEN-END:variables
}
