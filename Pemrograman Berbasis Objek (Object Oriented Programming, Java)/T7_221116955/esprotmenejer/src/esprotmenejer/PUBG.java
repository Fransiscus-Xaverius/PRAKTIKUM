/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;

/**
 *
 * @author Frans
 */
public class PUBG extends Player{
    private int aim;
    private int luck;
    private int comms;

    public PUBG(String firstname, String ign, String lastname, int age) {
        super(firstname, ign, lastname, age);
    }
    
    public PUBG(int aim, int luck, int comms, String firstname, String ign, String lastname, int age) {
        super(firstname, ign, lastname, age);
        this.aim = aim;
        this.luck = luck;
        this.comms = comms;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getComms() {
        return comms;
    }

    public void setComms(int comms) {
        this.comms = comms;
    }
    
}
