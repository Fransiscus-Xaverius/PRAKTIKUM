/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie_s_i._m_p_l_e;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Frans
 */
public class Zombie {
    private int hp;
    private boolean alive;
    private int type;
    private int x,y;
    private char symbol;
    private boolean stun;
    private int stunfor;
    private int facing;
    Random r = new Random();

    public Zombie(boolean alive) {
        this.alive = alive;
        this.stun = false;
        int generator = r.nextInt(100)+1;
        if(generator>0&&generator<=5){
            this.hp = 3;
            this.type = 1;
            this.symbol = 'Z';
        }
        else if(generator>5&&generator<=15){
            this.hp=1;
            this.type = 2;
            this.symbol = '@';
        }
        else if(generator>15&&generator<=25){
            this.hp=1;
            this.type = 3;
            this.symbol = 'N';
        }
        else{
            this.type = 4;
            this.symbol = 'z';
            this.hp = 1;
        }
        
        int arah = r.nextInt(4)+1;
        if(arah==1){
            this.facing = 1;
            this.x = 1;
            this.y = r.nextInt(9)+1;
        }
        else if (arah==2){
            this.facing = 2;
            this.x = 9;
            this.y = r.nextInt(9)+1;
        }
        else if (arah==3){
            this.facing = 3;
            this.y = 1;
            this.x = r.nextInt(9)+1;
        }
        else if (arah==4){
            this.facing = 4;
            this.y = 9;
            this.x = r.nextInt(9)+1;
        }
    }
    
    public void Stunned(){
        this.stun=true;
    }
    
    public void pathfinding(ArrayList<UrMom> units, ArrayList<Zombie>mob, int dex){
        boolean up = true;
        boolean down = true;
        boolean left = true;
        boolean right = true;
        int goUp = this.y-1;
        int goDown = this.y+1;
        int goLeft = this.x-1;
        int goRight = this.x+1;
        for(int i =0;i<units.size();i++){
            if(this.x==units.get(i).getX()&&goUp==units.get(i).getY()){
                up=false;
            }
            else if(this.x==units.get(i).getX()&&goDown==units.get(i).getY()){
                down=false;
            }
            else if(goLeft==units.get(i).getX()&&this.y==units.get(i).getY()){
                left=false;
            }
            else if(goRight==units.get(i).getX()&&this.y==units.get(i).getY()){
                right=false;
            }
        }
        for(int i =0;i<mob.size();i++){
            if(dex!=i){
                if(this.x==mob.get(i).getX()&&goUp==mob.get(i).getY()){
                    up=false;
                }
                else if(this.x==mob.get(i).getX()&&goDown==mob.get(i).getY()){
                    down=false;
                }
                else if(goLeft==mob.get(i).getX()&&this.y==mob.get(i).getY()){
                    left=false;
                }
                else if(goRight==mob.get(i).getX()&&this.y==mob.get(i).getY()){
                    right=false;
                }
            }
        }
        if(goUp==0){
            up=false;
        }
        else if(goDown==10){
            down=false;
        }
        else if(goLeft==0){
            left=false;
        }
        else if(goRight==10){
            right=false;
        }
        //1 = kiri
        //2 = kanan
        //3 = atas
        //4 = bawah
        //priority path
        if(this.facing==1){
            if(right){
                this.x = goRight;
            }
            else if(up){
                this.y = goUp;
            }
            else if(down){
                this.y = goDown;
            }
            else if(left){
                this.x = goLeft;
            }
        }
        else if(this.facing==2){
            if(left){
                this.x = goLeft;
            }
            else if(up){
                this.y = goUp;
            }
            else if(down){
                this.y = goDown;
            }
            else if(right){
                this.x = goRight;
            }
        }
        else if(this.facing==3){
            if(down){
                this.y = goDown;
            }
            else if(right){
                this.x = goRight;
            }
            else if(left){
                this.x = goLeft;
            }
            else if(up){
                this.y = goUp;
            }
        }
        else if(this.facing==4){
            if(up){
                this.y = goUp;
            }
            else if(right){
                this.x = goRight;
            }
            else if(left){
                this.x = goLeft;
            }
            else if(down){
                this.y = goDown;
            }
        }
    }
    
    public void move(ArrayList<UrMom> units, ArrayList<Zombie>mob, int dex){
        if (this.stun==false){
            if (this.type==1){
                int gerak = r.nextInt(2);
                if(gerak==1){
                    pathfinding(units,mob,dex);
                }
            }
            if (this.type==3){
                for(int i =0;i<2;i++){
                    pathfinding(units,mob,dex);
                }
            }
            else{
                pathfinding(units,mob,dex);
            }
        }
    }
    
    public void specialAttacks(ArrayList<UrMom> units, ArrayList<Zombie> mob){
        if(this.type==1){
            int unitY, unitX;
            int coorX, coorY;
            coorX = this.x;
            coorY = this.y;
            for(int i =0;i<units.size();i++){
                unitY = units.get(i).getY();
                unitX = units.get(i).getX();
                if(unitY==coorY+1&&unitX==coorX){
                    units.get(i).damage(2);
                }
                else if(unitY==coorY-1&&unitX==coorX){
                    units.get(i).damage(2);
                }
                else if(unitY==coorY&&unitX==coorX+1){
                    units.get(i).damage(2);
                }
                else if(unitY==coorY&&unitX==coorX-1){
                    units.get(i).damage(2);
                }
            }
        }
        else if(this.type==2){
            int coorX = this.x;
            int coorY = this.y;
            boolean trigger = false;
            for(int i =0;i<units.size();i++){
                for(int y = coorY-1;y<=coorY+1;y++){
                    for(int x = coorX-1;x<=coorX+1;x++){
                        if(units.get(i).getX()==x&&units.get(i).getY()==y){
                            trigger = true;
                            break;
                        }
                    }
                }
            }
            if(trigger){
                int korban = 0;
                System.out.println("Zombie Exploded");
                for(int y = coorY-1;y<=coorY+1;y++){
                    for(int x = coorX-1;x<=coorX+1;x++){
                        for(int i = 0;i<mob.size();i++){
                            boolean kaboom = false;
                            if(mob.get(i).getX()==x&&mob.get(i).getY()==y){
                                kaboom = mob.get(i).damaged();
                                kaboom = mob.get(i).damaged();
                                if(kaboom){
                                    korban++;
                                }
                            }
                        }
                    }
                }
                for(int i=0;i<units.size();i++){
                    for(int y = coorY-1;y<=coorY+1;y++){
                        for(int x = coorX-1;x<=coorX+1;x++){
                            if(units.get(i).getX()==x&&units.get(i).getY()==y){
                                units.get(i).damage(2);
                                System.out.println(units.get(i).getUnitname()+" takes 2 damage");
                            }
                        }
                    }
                }
                if(korban!=0){
                    System.out.println(korban+" zombies died");
                }
            }
        }
        else{
            int unitY, unitX;
            int coorX, coorY;
            coorX = this.x;
            coorY = this.y;
            for(int i =0;i<units.size();i++){
                unitY = units.get(i).getY();
                unitX = units.get(i).getX();
                if(unitY==coorY+1&&unitX==coorX){
                    units.get(i).damage(2);
                }
                else if(unitY==coorY-1&&unitX==coorX){
                    units.get(i).damage(2);
                }
                else if(unitY==coorY&&unitX==coorX+1){
                    units.get(i).damage(2);
                }
                else if(unitY==coorY&&unitX==coorX-1){
                    units.get(i).damage(2);
                }
            }
        }
    }
    
    public boolean isAlive(){
        return this.alive;
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
    
    public void isDead(){
        this.alive = false;
    }
    
    public char sprite(){
        return this.symbol;
    }
    
    public boolean damaged(){
        this.hp=this.hp-1;
        if(hp==0){
            this.alive= false;
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getType(){
        return this.type;
    }
    
}
