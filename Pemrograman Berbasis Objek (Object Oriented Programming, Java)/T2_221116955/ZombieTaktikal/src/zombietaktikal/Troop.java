/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombietaktikal;

/**
 *
 * @author Frans
 */
public class Troop {
    private String name;
    private int health;
    private int specialbar;
    private char symbol;
    private int x;
    private int y;
    private int maxhealth;
    private int defaultx,defaulty,defaulthp,defaultbar;

    public Troop(String name, int health, int specialbar, char symbol, int x, int y, int maxhealth) {
        this.name = name;
        this.health = health;
        this.specialbar = specialbar;
        this.symbol = symbol;
        this.x = x;
        this.y = y;
        this.maxhealth = maxhealth;
        this.defaultbar = this.specialbar;
        this.defaultx = this.x;
        this.defaulty = this.y;
        this.defaulthp = this.health;
    }
    
    public void reset(){
        this.specialbar=this.defaultbar;
        this.x = this.defaultx;
        this.y = this.defaulty;
        this.health = this.defaulthp;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpecialbar() {
        return specialbar;
    }

    public void setSpecialbar(int specialbar) {
        this.specialbar = specialbar;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
