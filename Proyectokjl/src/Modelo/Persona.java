/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SG702-21
 */
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private Fecha fechaNac;

    public Persona(String id, String nombre, String apellido, Fecha fechaNac){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public int calcularEdad(Fecha hoy){
        return  fechaNac.diferencia(hoy)/365; 
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechaNac
     */
    public Fecha getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "id= " + id + ", nombre= " + nombre + ", apellido= " + apellido + ", fecha de Nacimiento= (AAAA/MM/DD) " + fechaNac.getAnio() + "/" + fechaNac.getMes() + "/" + fechaNac.getDia();
    }
        
}
