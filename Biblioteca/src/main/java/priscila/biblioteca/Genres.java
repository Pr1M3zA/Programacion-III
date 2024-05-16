
package priscila.biblioteca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Genres {
     private Connection connectDB = null;
     private ArrayList<Genre> genres = new ArrayList();
     
     public Genres(Connection connectDB){
          this.connectDB = connectDB;
          getData();
     }

    public ArrayList<Genre> getGenres() {
        return genres;
    }
     
     private void getData(){
          try {
            Statement stm = connectDB.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Id, description FROM genres ORDER BY Id");
            while(rs.next())
                genres.add(new Genre(rs.getInt("Id"), rs.getString("description")));
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("MySQL ERROR: " + ex.getMessage());
        }
     }
     
     public ComboBoxModel<String> CBModel(){
            String[] str = new String[genres.size()];
            for(int i=0; i < genres.size(); i++) {
                str[i]=genres.get(i).getDescription();
            }
            ComboBoxModel model = new DefaultComboBoxModel(str);
            return model;
     }
     
     public int getId(String description){
         for(Genre g: genres){
             if(g.getDescription().compareTo(description) == 0)
                 return g.getId();
         }
         return -1;
     }
     
     public String getDescription(int id){
         for(Genre g: genres){
             if(g.getId() == id)
                 return g.getDescription();
         }
         return null;
     }
}
