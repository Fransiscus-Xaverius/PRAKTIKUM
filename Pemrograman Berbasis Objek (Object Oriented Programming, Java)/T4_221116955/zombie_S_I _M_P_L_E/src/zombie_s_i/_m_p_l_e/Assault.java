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
public class Assault extends UrMom {
    private char sprite;
    public Assault(int x, int y, int hp, int specialbar, String unitname) {
        super(x, y, hp, specialbar, unitname);
        this.sprite = 'A';
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
        int posx = units.get(dex).getX();
        int posy = units.get(dex).getY();
        for(int i = posy-2;i<=posy+2;i++){
            for(int j = posx-2;j<=posx+2;j++){
                for(int p =0;p<mob.size();p++){
                    int ZX = mob.get(p).getX();
                    int ZY = mob.get(p).getY();
                    if(ZX==j&&ZY==i){
                        mob.get(p).damaged();
                    }
                }
            }
        }
    }
    
    @Override
    public void Special_2(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> magneticfield){
        
    }
    
}
