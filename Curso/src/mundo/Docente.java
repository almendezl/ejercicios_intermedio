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
public class Docente extends Persona{
    private String dedicacion;

    public Docente(String identificacion, String nombre, int edad, String dedicacion) {
        super(identificacion, nombre, edad);
        this.dedicacion = dedicacion;
    }

    /**
     * @param edad the edad to set
     */
    @Override
    public void setEdad(int edad) {
        this.edad = edad>=18?edad:18;
    }            

    /**
     * @return the dedicacion
     */
    public String getDedicacion() {
        return dedicacion;
    }

    /**
     * @param dedicacion the dedicacion to set
     */
    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }
}
