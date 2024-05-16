package priscila.biblioteca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Languages {
     private Connection connectDB = null;
     private ArrayList<Language> languages = new ArrayList();
     
     public Languages(Connection connectDB){
          this.connectDB = connectDB;
          getData();
     }

    public ArrayList<Language> getLanguages() {
        return languages;
    }
     
     private void getData(){
          try {
            Statement stm = connectDB.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Id, Description FROM languages ORDER BY Id");
            while(rs.next())
                languages.add(new Language(rs.getInt("Id"), rs.getString("Description")));
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("MySQL ERROR: " + ex.getMessage());
        }
     }
     
     public ComboBoxModel<String> CBModel(){
            String[] str = new String[languages.size()];
            for(int i=0; i < languages.size(); i++) {
                str[i]=languages.get(i).getDescription();
            }
            ComboBoxModel model = new DefaultComboBoxModel(str);
            return model;
     }
     
     public int getId(String description){
         for(Language l: languages){
             if(l.getDescription().compareTo(description) == 0)
                 return l.getId();
         }
         return -1;
     }
     
     public String getDescription(int id){
         for(Language l: languages){
             if(l.getId() == id)
                 return l.getDescription();
         }
         return null;
     }     
}
