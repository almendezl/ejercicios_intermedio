/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import javax.swing.JOptionPane;
import mundo.*;
/**
 *
 * @author Angie Mendez
 */
public class SistemaPagos {
    public static void main(String[] args) {
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado(160000.0,"John", "Smith", "111-11-1111");
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras(4500.0, 40, "Karen", "Price", "222-22-2222");
        EmpleadoComision empleadoComision= new EmpleadoComision(3200000,0.06, "Sue", "Jones","333-33-333");
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(2100000,70000,0.04, 
                "Bob","Lewis","444-44-4444");
        
        String msg = "Empkeados procesador individualmente: \n\n";
        msg +=empleadoAsalariado +"Devengado: "+ empleadoAsalariado.ingresos() + "\n\n";
        msg +=empleadoPorHoras +"Devengado: "+ empleadoPorHoras.ingresos() + "\n\n";
        msg +=empleadoBaseMasComision +"Devengado: "+ empleadoBaseMasComision.ingresos() + "\n\n";
        
        JOptionPane.showMessageDialog(null, msg, "Sistema de pagos", JOptionPane.INFORMATION_MESSAGE);
        Empleado empleados [] = new Empleado[4];
        empleados [0] = empleadoAsalariado;
        empleados [1] = empleadoPorHoras;
        empleados [2] = empleadoComision;
        empleados [3] = empleadoBaseMasComision;
        
        msg = "Empleados procesados: \n\n";
        for(Empleado empleadoActual : empleados){
            msg+=empleadoActual;
            if(empleadoActual instanceof EmpleadoBaseMasComision){
                EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision)empleadoActual;
                double salarioBaseAnterior = empleado.getSalarioBase();
                empleado.setSalarioBase(1.10 *  salarioBaseAnterior);
                msg += "Nuevo salario con 10% e incremento: "+ empleado.getSalarioBase()+"\n";
            }
            msg += "Devengado: "+empleadoActual.ingresos()+"\n\n";
        }
        for (int i = 0; i < empleados.length; i++) {
            msg += "Empleado "+empleados[i].getClass().getName()+"\n";
        }
        JOptionPane.showMessageDialog(null, msg, "Sistema de Pagos", JOptionPane.INFORMATION_MESSAGE);
    }
}
