/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simple_castlegame;

/**
 *
 * @author Frans
 */
public class Squire extends Troops{
    int damage;
    int health;

    public Squire(int damage, int health) {
        this.damage = damage;
        this.health = health;
    }
    
    public String getTroopName() {
        return TroopName;
    }

    public void setTroopName() {
        this.TroopName = "Squires";
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
