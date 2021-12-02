/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class PruebaLibreria {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        boolean terminar = false;
        while (!terminar) {
            int sel = Integer.parseInt(JOptionPane.showInputDialog("1.AGREGAR LIBROS \n2.MOSTRAR LIBROS"
                    + "\n3.BUSCAR LIBRO \n4.AGREGAR COMENTARIO \n5. SALIR"));
            switch (sel) {
                case 1:
                    String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
                    String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del libro:"));
                    libreria.agregarLibroCatalogo(new Libro(titulo, isbn, precio));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Los libros existentes en el catalogo son: "
                            + libreria.getLibros(), "Catalogo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    String isbn1 = JOptionPane.showInputDialog("Ingrese el ISBN del libro a buscar:");
                    Libro libro1 = libreria.buscarLibro(isbn1);
                    if (libro1 != null) {
                        JOptionPane.showMessageDialog(null, "Los datos del libro encontrado son: \n"
                                + "Titulo: " + libro1.getTitulo() + "\nISBN: " + libro1.getIsbn() + "\nPrecio: "
                                + libro1.getPrecio(), "Lirbo encontrado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El libro indicado no existe en el catalogo",
                                "Libro no encontrado", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 4:
                    String isbn2 = JOptionPane.showInputDialog("Ingrese el ISBN del libro a buscar:");
                    Libro libro2 = libreria.buscarLibro(isbn2);
                    if (libro2 != null) {
                        String comentario = JOptionPane.showInputDialog("Ingrese el comentario correspondiente:");
                        int calificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la calificacion para un libro(Valores enteros entre 0 y 5)"));
                        libro2.addComentario(comentario, calificacion);
                        libreria.updateLibro(libro2);
                    } else {
                        JOptionPane.showMessageDialog(null, "El libro indicado no existe en el catalogo",
                                "Libro no encontrado", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 5:
                    terminar = true;
                    JOptionPane.showMessageDialog(null, "Ingreso no valido, intente nuevamente", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
