/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie_s_i._m_p_l_e;
import java.util.ArrayList;
/**
 *
 * @author Frans
 */
public class UrMom {
    // dont ask why class namenya begini sy stress ko, tugas 2 saya amburadul maap.
    
    private int x,y;
    private int hp;
    private int maxHp;
    private int specialbar;
    private String unitname;
    private boolean alive;

    public UrMom(int x, int y, int hp, int specialbar, String unitname) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.maxHp = hp;
        this.specialbar = specialbar;
        this.unitname = unitname;
        this.alive = true;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpecialbar() {
        return specialbar;
    }

    public void setSpecialbar(int specialbar) {
        this.specialbar = specialbar;
    }
    
    public char getSprite(){
        System.out.println(" Error Overriding Method ");
        return 'x';
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }
    
    public boolean goUp(ArrayList<Zombie> mob, ArrayList<UrMom> units){
        int tryUp = this.y-1;
        boolean nabrak = false;
        for(int i =0;i<mob.size();i++){
            int cekZomX = mob.get(i).getX();
            int cekZomY = mob.get(i).getY();
            if(cekZomY==tryUp&&cekZomX==this.x){
                nabrak = true;
            }
        }
        for(int i =0;i<units.size();i++){
            int cekX = units.get(i).getX();
            int cekY = units.get(i).getY();
            if(cekY==tryUp&&cekX==this.x){
                nabrak = true;
            }
        }
        if(!nabrak){
            this.y = tryUp;
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean goDown(ArrayList<Zombie> mob, ArrayList<UrMom> units){
        int tryDown = this.y+1;
        boolean nabrak = false;
        for(int i=0;i<mob.size();i++){
            int cekZomX = mob.get(i).getX();
            int cekZomY = mob.get(i).getY();
            if(cekZomY==tryDown&&cekZomX==this.x){
                nabrak = true;
            }
        }
        for(int i=0;i<units.size();i++){
            int cekZomX = units.get(i).getX();
            int cekZomY = units.get(i).getY();
            if(cekZomY==tryDown&&cekZomX==this.x){
                nabrak = true;
            }
        }
        if(!nabrak){
            this.y = tryDown;
            return false;
        }
        else{
            return true;
        }
    }
    public boolean goLeft(ArrayList<Zombie> mob){
        int tryLeft = this.x-1;
        boolean nabrak = false;
        for(int i =0;i<mob.size();i++){
            int cekZomX = mob.get(i).getX();
            int cekZomY = mob.get(i).getY();
            if(cekZomY==this.y&&cekZomX==tryLeft){
                nabrak=true;
            }
        }
        if(!nabrak){
            this.y = tryLeft;
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean goRight(ArrayList<Zombie> mob){
        int tryRight = this.x+1;
        boolean nabrak = false;
        for(int i =0;i<mob.size();i++){
            int cekZomX = mob.get(i).getX();
            int cekZomY = mob.get(i).getY();
            if(cekZomY==this.y&&cekZomX==tryRight){
                nabrak=true;
            }
        }
        if(!nabrak){
            this.y = tryRight;
            return false;
        }
        else{
            return true;
        }
    }
    
    public void addSpecialPoints(int x){
        this.specialbar+=x;
        if(this.specialbar>5){
            this.specialbar=5;
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    
    public void damage(int damage){
        this.hp = this.hp-damage;
    }
    
    public void isDead(){
        this.alive = false;
    }
    
    public boolean Status(){
        return this.alive;
    }
    
    public void Special_1(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> wires){
        
    }
    
    public void Special_2(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> magneticfield){
        
    }
    
}
