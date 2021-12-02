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
public class Libreria {
    private ArrayList catalogo;
    public Libreria(){
        catalogo = new ArrayList();
    }
    public void agregarLibroCatalogo(Libro libro){
        Libro unLibro = buscarLibro(libro.getIsbn());
        if(unLibro == null)
            catalogo.add(libro);
    }
    public ArrayList getCatalogo(){
        return catalogo;
    }
    public Libro buscarLibro(String isbn){
        int  i = 0;
        int totalLibros = catalogo.size();
        Libro libro = null;
        boolean encontrado = false;
        while(i < totalLibros && !encontrado){
            libro = (Libro) catalogo.get(i);
            if(libro.esIgual(isbn))
                encontrado = true;
            i++;
        }
        if(encontrado)
            return libro;
        else 
            return null;
    }
    public int estimarLibrosComentados(){
        int librosComentados = 0;
        Libro libro = null;
        for (int i = 0; i < catalogo.size(); i++) {
            libro = (Libro)catalogo.get(i);
            if(libro.getComentarios().size() > 0)
                librosComentados ++;
        }
        return librosComentados;
    }
    public String getLibros (){
        String listado = " ";
        Libro unLibro;
        for (int i = 0; i < catalogo.size(); i++) {
            unLibro = (Libro)catalogo.get(i);
            listado += "\nTituo del libro: "+ unLibro.getTitulo() +
                    "\nISBN: "+ unLibro.getIsbn() +"\n";
        }
        return listado;
    }
    public void updateLibro(Libro unLibro){
        Libro ref;
        for (int i = 0; i < catalogo.size(); i++) {
            ref = (Libro)catalogo.get(i);
            if(ref.getIsbn().equals(unLibro.getIsbn()))
                catalogo.set(i,unLibro);
        }
    }
}
