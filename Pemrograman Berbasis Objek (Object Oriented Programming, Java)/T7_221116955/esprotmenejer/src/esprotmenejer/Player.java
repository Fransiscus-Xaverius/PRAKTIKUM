/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;

/**
 *
 * @author Frans
 */
public class Player {
    protected String firstname;
    protected String ign;
    protected String lastname;
    protected int age;
    protected boolean signed;

    public Player(String firstname, String ign, String lastname, int age) {
        this.firstname = firstname;
        this.ign = ign;
        this.lastname = lastname;
        this.age = age;
        this.signed = false;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
    
    public void sign(){
        this.signed=true;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
