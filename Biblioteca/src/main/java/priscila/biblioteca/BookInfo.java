package priscila.biblioteca;

import java.awt.Image;
import javax.swing.ImageIcon;

public class BookInfo extends javax.swing.JPanel {
    private Book book;
    private Genres genres;
    
    public BookInfo(Book book, Genres genres) {
        this.book = book;
        this.genres = genres;
        initComponents();
        fillData();
    }
    
    private void fillData(){
        TitleLabel.setText(book.getBookTitle());
        AuthorLabel.setText(book.getAuthor());
        GenreLabel.setText(genres.getDescription(book.getIdGenre()));
        ISBN.setText(book.getIsbn());
        if(book.getCover() != null){
            CoverLabel.setIcon(new ImageIcon(book.getCover().getScaledInstance(90, 120, Image.SCALE_SMOOTH)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InfoPanel = new javax.swing.JPanel();
        CoverLabel = new javax.swing.JLabel();
        TitleLabel = new javax.swing.JLabel();
        GenreLabel = new javax.swing.JLabel();
        ISBN = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoPanel.setBackground(new java.awt.Color(201, 170, 147));
        InfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        InfoPanel.add(CoverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 90, 120));

        TitleLabel.setFont(new java.awt.Font("Arimo", 1, 14)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(91, 52, 33));
        TitleLabel.setText("jLabel2");
        InfoPanel.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 160, 50));

        GenreLabel.setFont(new java.awt.Font("Arimo", 1, 10)); // NOI18N
        GenreLabel.setForeground(new java.awt.Color(91, 52, 33));
        GenreLabel.setText("jLabel1");
        InfoPanel.add(GenreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, 20));

        ISBN.setFont(new java.awt.Font("Arimo", 3, 8)); // NOI18N
        ISBN.setForeground(new java.awt.Color(91, 52, 33));
        ISBN.setText("jLabel1");
        InfoPanel.add(ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, 20));

        AuthorLabel.setFont(new java.awt.Font("Arimo", 2, 10)); // NOI18N
        AuthorLabel.setForeground(new java.awt.Color(91, 52, 33));
        AuthorLabel.setText("jLabel1");
        InfoPanel.add(AuthorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 160, 20));

        add(InfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JLabel CoverLabel;
    private javax.swing.JLabel GenreLabel;
    private javax.swing.JLabel ISBN;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JLabel TitleLabel;
    // End of variables declaration//GEN-END:variables
}
