/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;

/**
 *
 * @author Frans
 */
public class Dota extends Player{
    private int comms,role;

    public Dota(String firstname, String ign, String lastname, int age) {
        super(firstname, ign, lastname, age);
    }
    
    public Dota(int comms, int role, String firstname, String ign, String lastname, int age) {
        super(firstname, ign, lastname, age);
        this.comms = comms;
        this.role = role;
    }

    public int getComms() {
        return comms;
    }

    public void setComms(int comms) {
        this.comms = comms;
    }

    public String getRole() {
        if(this.role==1){
            return "Carry";
        }
        else if(this.role==2){
            return "Mid Lane";
        }
        else if(this.role==3){
            return "Off Lane";
        }
        else if(this.role==4){
            return "Soft Support";
        }
        else{
            return "Hard Support";
        }
    }

    public void setRole(int role) {
        this.role = role;
    }   
    
}
