/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Angie Mendez
 */
public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    public EmpleadoAsalariado(double salarioSemanal, String firstName, String lastName, String socialSecurityNymber) {
        super(firstName, lastName, socialSecurityNymber);
        setSalarioSemanal(salarioSemanal);
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal < 0.0 ? 0.0 : salarioSemanal;
    }

    @Override
    public String toString() {
        return "Empleado Asalariado" + super.toString() + " Salario Semanal: "
                + getSalarioSemanal() + "\n";
    }
    @Override
    public double ingresos(){
    return getSalarioSemanal();
}
}
