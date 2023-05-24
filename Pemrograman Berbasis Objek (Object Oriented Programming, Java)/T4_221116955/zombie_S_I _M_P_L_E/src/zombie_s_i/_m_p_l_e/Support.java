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
public class Support extends UrMom{
    private char sprite;
    private Scanner sc = new Scanner(System.in);
    public Support(int x, int y, int hp, int specialbar, String unitname) {
        super(x, y, hp, specialbar, unitname);
        this.sprite = 'S';
    }

    @Override
    public char getSprite() {
        return sprite;
    }

    public void setSprite(char sprite) {
        this.sprite = sprite;
    }
    
    @Override
    public void Special_1(ArrayList<UrMom> units, int index,ArrayList<Zombie> mob, ArrayList<Wire> wires){
        System.out.println("Which unit do you want to heal?");
        System.out.println("1. Support Unit");
        System.out.println("2. Assault Trooper");
        System.out.println("3. Heavy Mech");
        System.out.println("4. Tech Engineer");
        System.out.print(">>");
        int dex = sc.nextInt();
        int max = units.get(dex).getMaxHp();
        int currentHp = units.get(dex).getHp();
        int newHp = currentHp+=3;
        if(max<newHp){
            units.get(dex).setHp(max);
        }
        else{
            units.get(dex).setHp(newHp);
        }
        int currentbar = units.get(dex).getSpecialbar();
        currentbar-=3;
        units.get(dex).setSpecialbar(currentbar);
    }
    
    @Override
    public void Special_2(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, ArrayList<Wire> magneticfield){
        System.out.println("Which unit would you like to encourage?");
        
        int currentbar = units.get(dex).getSpecialbar();
        currentbar-=3;
        units.get(dex).setSpecialbar(currentbar);
    }
    
}
