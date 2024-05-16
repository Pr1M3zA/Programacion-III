
package priscila.biblioteca;

public class Language {
      int Id;
      String description;
   
   public Language(int id, String description) {
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
