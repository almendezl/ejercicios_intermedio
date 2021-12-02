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
public class EmpleadoComision extends Empleado {
    private double ventasBrutas;
    private double comision;

    public EmpleadoComision(double ventasBrutas, double comision, String firstName, String lastName, String socialSecurityNymber) {
        super(firstName, lastName, socialSecurityNymber);
        setVentasBrutas(ventasBrutas);
        setComision(comision);
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = ventasBrutas<0? 0: ventasBrutas;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision>0 && comision <1.0?comision : 0;
    }

    @Override
    public String toString() {
        return "Empleado Comision: " +super.toString()+ "Ventas Brutas: " 
                + getVentasBrutas() + ", Comision: " + getComision() + "\n";
    }

    @Override
    public double ingresos() {
        return getComision() * getVentasBrutas();
    }
    
    
}
