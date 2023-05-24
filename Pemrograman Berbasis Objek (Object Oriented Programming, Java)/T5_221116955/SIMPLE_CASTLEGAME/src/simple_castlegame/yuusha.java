/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simple_castlegame;

/**
 *
 * @author Frans
 */
public class yuusha extends Troops{
    private String name;
    private int level;
    private int health;
    private int damage;

    public yuusha(String name, int level) {
        this.name = name;
        this.level = level;
        this.health=100;
        this.damage=10;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
    
    public void levelUp(){
        this.health+=30;
        this.damage+=10;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
    
}
