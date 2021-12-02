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
public class EmpleadoPorHoras extends Empleado {

    private double salario;
    private double horas;

    public EmpleadoPorHoras(double salario, double horas, String firstName, String lastName, String socialSecurityNymber) {
        super(firstName, lastName, socialSecurityNymber);
        setSalario(salario);
        setHoras(horas);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario < 0.0 ? 0.0 : salario;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas >= 0.0 && horas <= 168.0 ? horas : 0;
    }

    @Override
    public String toString() {
        return "EmpleadoPorHoras: " + super.toString() + "Salario por horas: " + getSalario() + ", Horas laboradas: "
                + getHoras() + "\n";
    }
    @Override
    public double ingresos(){
        if(horas <=40)
            return salario * horas;
        else
            return 40 * salario + (horas-40) * salario * 1.5;
    }
}
