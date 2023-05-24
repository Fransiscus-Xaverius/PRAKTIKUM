/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie_s_i._m_p_l_e;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Frans
 */
public class Engineer extends UrMom {
    private char sprite;
    private Scanner sc = new Scanner(System.in);
    public Engineer(int x, int y, int hp, int specialbar, String unitname) {
        super(x, y, hp, specialbar, unitname);
        this.sprite = 'T';
    }
    
    @Override
    public char getSprite() {
        return sprite;
    }

    public void setSprite(char sprite) {
        this.sprite = sprite;
    }
    
    @Override
    public void Special_1(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> wires){
        System.out.println("Which direction would you like to deploy");
        System.out.println("w. Up");
        System.out.println("a. Left");
        System.out.println("s. Down");
        System.out.println("d. Right");
        System.out.print(">>");
        char move =sc.next().charAt(0);
        int coorX, coorY;
        coorX = units.get(3).getX();
        coorY = units.get(3).getY();
        if(move=='s'){
            wires.add(new Wire(coorX+2,coorY+1,5));
            wires.add(new Wire(coorX+1,coorY+1,5));
            wires.add(new Wire(coorX,coorY+1,5));
            wires.add(new Wire(coorX-1,coorY+1,5));
            wires.add(new Wire(coorX-2,coorY+1,5));
        }
        else if(move=='a'){
            wires.add(new Wire(coorX-1,coorY+2,5));
            wires.add(new Wire(coorX-1,coorY+1,5));
            wires.add(new Wire(coorX-1,coorY,5));
            wires.add(new Wire(coorX-1,coorY-1,5));
            wires.add(new Wire(coorX-1,coorY-2,5));
        }
        else if(move=='w'){
            wires.add(new Wire(coorX+2,coorY-1,5));
            wires.add(new Wire(coorX+1,coorY-1,5));
            wires.add(new Wire(coorX,coorY-1,5));
            wires.add(new Wire(coorX-1,coorY-1,5));
            wires.add(new Wire(coorX-2,coorY-1,5));
        }
        else if(move=='d'){
            wires.add(new Wire(coorX+1,coorY+2,5));
            wires.add(new Wire(coorX+1,coorY+1,5));
            wires.add(new Wire(coorX+1,coorY,5));
            wires.add(new Wire(coorX+1,coorY-1,5));
            wires.add(new Wire(coorX+1,coorY-2,5));
        }
        int currentbar = units.get(dex).getSpecialbar();
        currentbar-=3;
        units.get(dex).setSpecialbar(currentbar);
    }
    
    @Override
    public void Special_2(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> magneticfield){
        System.out.println("Enter the coordinates to put your Magnetic Field");
        System.out.print("X : ");
        int x = sc.nextInt();
        System.out.print("Y : ");
        int y = sc.nextInt();
        magneticfield.add(new Wire(x-2,y-2,5));
        magneticfield.add(new Wire(x-1,y-2,5));
        magneticfield.add(new Wire(x,y-2,5));
        magneticfield.add(new Wire(x+1,y-2,5));
        magneticfield.add(new Wire(x+2,y-2,5));
        magneticfield.add(new Wire(x-2,y-1,5));
        magneticfield.add(new Wire(x-1,y-1,5));
        magneticfield.add(new Wire(x,y-1,5));
        magneticfield.add(new Wire(x+1,y-1,5));
        magneticfield.add(new Wire(x+2,y-1,5));
        magneticfield.add(new Wire(x-2,y,5));
        magneticfield.add(new Wire(x-1,y,5));
        magneticfield.add(new Wire(x,y,5));
        magneticfield.add(new Wire(x+1,y,5));
        magneticfield.add(new Wire(x+2,y,5));
        magneticfield.add(new Wire(x-2,y+1,5)); 
        magneticfield.add(new Wire(x-1,y+1,5));
        magneticfield.add(new Wire(x,y+1,5));
        magneticfield.add(new Wire(x+1,y+1,5));
        magneticfield.add(new Wire(x+2,y+1,5));
        magneticfield.add(new Wire(x-2,y+2,5));
        magneticfield.add(new Wire(x-1,y+2,5));
        magneticfield.add(new Wire(x,y+2,5));
        magneticfield.add(new Wire(x+1,y+2,5));
        magneticfield.add(new Wire(x+2,y+2,5));
        int currentbar = units.get(dex).getSpecialbar();
        currentbar-=3;
        units.get(dex).setSpecialbar(currentbar);
    }
    
}
