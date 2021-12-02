/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author Angie Mendez
 */
public class Libro {
    private String titulo;
    private String isbn;
    private double precio;
    private ArrayList comentarios;
    
    public Libro(String titulo, String isbn, double precio){
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
        this.comentarios = new ArrayList();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrecio() {
        return precio;
    }
    public boolean esIgual(String isbn){
        return this.isbn.equals(isbn);
    }
    public void addComentario(String comentaro, int calificacion){
        comentarios.add(new Comentario ( comentario, calificacion));
    }
    public ArrayList getComentarios(){
        return comentarios;
    }
}
