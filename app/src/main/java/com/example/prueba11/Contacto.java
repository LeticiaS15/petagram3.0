package com.example.prueba11;

public class Contacto {

private int id;
private String nombre;
private int foto;
private int Likes = 0 ;
   // private int TextNumeroP;





    public Contacto(int id,String nombre, int foto,int Likes) {
        this.id =id;
        this.nombre = nombre;
        this.foto = foto;
        this.Likes = Likes;
    }

    public Contacto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }
}
