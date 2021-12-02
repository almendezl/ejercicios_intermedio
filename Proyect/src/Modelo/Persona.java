/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Angie Mendez
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
public int calcularEdad(Fecha fechaActual){
    Fecha dato = new Fecha(0,0,0);
    return dato.diferencia(fechaNac, fechaActual)/365;
}
public String getId(){
    return id;
}
public void setId(String id){
    this.id = id;
}
public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
    this.nombre = nombre;
}
public String getApellido(){
    return apellido;
}
public void setApellido(String apellido){
    this.apellido = apellido;
}
public Fecha getFechaNac (){
    return fechaNac;
}
public void setFechaNac(Fecha fechaNac){
    this.fechaNac = fechaNac;
}
    
    
}
