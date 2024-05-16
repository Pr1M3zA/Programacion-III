/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priscila.biblioteca;

/**
 *
 * @author Priscila
 */
public class Genre {
      int Id;
      String description;
   
   public Genre(int id, String description) {
       this.Id=id;
       this.description=description;
   }
   
   public int getId() {
       return Id;
   }
   
   public String getDescription() {
       return description;
   }
}
