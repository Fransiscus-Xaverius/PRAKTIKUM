/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;

/**
 *
 * @author Frans
 */
public class VALORANT extends Player{
    private int role, aim,comms;

    public VALORANT(String firstname, String ign, String lastname, int age) {
        super(firstname, ign, lastname, age);
    }
    
    public VALORANT(int role, int aim, int comms, String firstname, String ign, String lastname, int age) {
        super(firstname, ign, lastname, age);
        this.role = role;
        this.aim = aim;
        this.comms = comms;
    }

    public String getRole() {
        
        if(this.role==1){
            return "Duelist";
        }
        else if(this.role==2){
            return "Initiator";
        }
        else if(this.role==3){
            return "Sentinel";
        }
        else if(this.role==4){
            return "Controller";
        }
        else{
            return "";
        }
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public int getComms() {
        return comms;
    }

    public void setComms(int comms) {
        this.comms = comms;
    }

    
    
}
