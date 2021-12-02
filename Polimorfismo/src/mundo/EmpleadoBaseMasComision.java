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
public class EmpleadoBaseMasComision extends EmpleadoComision {
    private double salarioBase;

    public EmpleadoBaseMasComision(double salarioBase, double ventasBrutas, double comision, String firstName, String lastName, String socialSecurityNymber) {
        super(ventasBrutas, comision, firstName, lastName, socialSecurityNymber);
        this.salarioBase = salarioBase;
    }



    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase<0? 0 :salarioBase;
    }

    @Override
    public String toString() {
        return super.toString()+ "Salario Base: " + salarioBase + "\n";
    }
    @Override
    public double ingresos(){
        return getSalarioBase();
    }
    
}
