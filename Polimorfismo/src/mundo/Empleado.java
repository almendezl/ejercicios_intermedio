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
public abstract class Empleado {
    private String firstName;
    private String lastName;
    private String socialSecurityNymber;

    public Empleado(String firstName, String lastName, String socialSecurityNymber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNymber = socialSecurityNymber;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNymber() {
        return socialSecurityNymber;
    }

    public void setSocialSecurityNymber(String socialSecurityNymber) {
        this.socialSecurityNymber = socialSecurityNymber;
    }

    @Override
    public String toString() {
        return  firstName + ", " + lastName + " - " + socialSecurityNymber + "\n";
    }
    public abstract double ingresos();
    
}
