/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author SG702-21
 */
public abstract class Persona {
    private final String identificacion;
    private final String nombre;
    protected int edad;

    public Persona(String cedula, String nombre, int edad) {
        this.identificacion = cedula;
        this.nombre = nombre;
        setEdad(edad);
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public abstract void setEdad(int edad);    
    
}
