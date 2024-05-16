package com.mycompany.sistema_de_biblioteca;

public class Genero {
   int Id;
   String Descripcion;
   
   public Genero(int id, String Descripcion) {
       this.Id=id;
       this.Descripcion=Descripcion;
   }
   
   public int getId() {
       return Id;
   }
   
   public String getDescripcion() {
       return Descripcion;
   }
}
