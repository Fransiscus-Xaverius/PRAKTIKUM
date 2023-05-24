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
public class Heavy extends UrMom {
    private char sprite;
    public Heavy(int x, int y, int hp, int specialbar, String unitname) {
        super(x, y, hp, specialbar, unitname);
        this.sprite = 'H';
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
        boolean range = false;
        Scanner scan = new Scanner(System.in);
        int y=0;
        int x=0;
        int dead=0;
        String coord="";
        while(!range){
            System.out.println("Input the coordinates of where to throw the grenades! (X,Y)");
            System.out.println(">>");
            coord = scan.nextLine();
            y = Character.getNumericValue(coord.charAt(2));
            x = Character.getNumericValue(coord.charAt(0));
            if(x>0&&x<10&&y>0&&y<10){
                range=true;
            }
        }
        for(int i = y-1;i<=y+1;i++){
            for(int j = x-1;j<=x+1;j++){
                for(int p = 0;p<mob.size();p++){
                    int ZX = mob.get(p).getX();
                    int ZY = mob.get(p).getY();
                    if(ZX==j&&ZY==i){
                        mob.get(p).damaged();
                    }
                }
            }
        }
        int sp =units.get(dex).getSpecialbar();
        sp-=3;
        units.get(dex).setSpecialbar(sp);
        System.out.println("Heavy Mech threw a Grenade");
    }
    
    @Override
    public void Special_2(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> magneticfield){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which direction would you like to shoot");
        System.out.println("(W). Up");
        System.out.println("(A). Left");
        System.out.println("(S). Down");
        System.out.println("(D). Right");
        String move = scan.nextLine();
        int posX = units.get(dex).getX();
        int posY = units.get(dex).getY();
        if(move.equals("w")||move.equals("W")){
            for(int j = 0;j<mob.size();j++){
                for(int i = 1;i<posY;i++){
                    int ZX = mob.get(j).getX();
                    int ZY = mob.get(j).getY();
                    if(ZY==i&&ZX==posX){
                        mob.get(j).damaged();
                    }
                }
            }
        }
        else if(move.equals("a")||move.equals("A")){
            for(int j = 0;j<mob.size();j++){
                for(int i = 1;i<posX;i++){
                    int ZX = mob.get(j).getX();
                    int ZY = mob.get(j).getY();
                    if(ZY==posY&&ZX==i){
                        mob.get(j).damaged();
                    }
                }
            }
        }
        else if(move.equals("s")||move.equals("S")){
            for(int j = 0;j<mob.size();j++){
                for(int i = posY;i<10;i++){
                    int ZX = mob.get(j).getX();
                    int ZY = mob.get(j).getY();
                    if(ZY==i&&ZX==posX){
                        mob.get(j).damaged();
                    }
                }
            }
        }
        else if(move.equals("d")||move.equals("D")){
            for(int j = 0;j<mob.size();j++){
                for(int i = posX;i<10;i++){
                    int ZX = mob.get(j).getX();
                    int ZY = mob.get(j).getY();
                    if(ZY==posY&&ZX==i){
                        mob.get(j).damaged();
                    }
                }
            }
        }
    }
    
}
