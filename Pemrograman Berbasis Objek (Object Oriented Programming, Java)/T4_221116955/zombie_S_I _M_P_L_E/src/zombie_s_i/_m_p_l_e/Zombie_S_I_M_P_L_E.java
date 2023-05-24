/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zombie_s_i._m_p_l_e;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Frans
 */
public class Zombie_S_I_M_P_L_E {

    public static void menu(){
        System.out.println("== ZCOM ==");
        System.out.println("1. Play");
        System.out.println("2. Highscore");
        System.out.println("0. Exit");
        System.out.print(">>");
    }
    
    public static void generatemap(char[][] map){
        for(int i =0;i<11;i++){
            for(int j =0;j<11;j++){
                if(i==0||i==10||j==0||j==10){
                    map[i][j]='#';
                }
                else{
                    map[i][j]=' ';
                }
            }
        }
    }
    
    public static void printmap(char[][] map, ArrayList<Zombie> mob, ArrayList<UrMom> units, ArrayList<Wire> wires, ArrayList<Wire> magneticfield){
        for(int i =0;i<11;i++){
            for(int j = 0;j<11;j++){
                int ID = -1;
                int PID = -1;
                int WireID = -1;
                int fieldID = -1;
                for(int dex = 0;dex<mob.size();dex++){
                    if(i==mob.get(dex).getY()&&j==mob.get(dex).getX()&&mob.get(dex).isAlive()==true){
                        ID=dex;
                    }
                }
                for(int dex = 0;dex<units.size();dex++){
                    if(units.get(dex).getX()==j&&units.get(dex).getY()==i){
                        PID=dex;
                    }
                }
                for(int dex = 0;dex<wires.size();dex++){
                    if(wires.get(dex).getX()==j&&wires.get(dex).getY()==i){
                        WireID = dex;
                    }
                }
                for(int dex = 0;dex<magneticfield.size();dex++){
                    if(magneticfield.get(dex).getX()==j&&magneticfield.get(dex).getY()==i){
                        fieldID = dex;
                    }
                }
                if(ID!=-1){
                    System.out.print(mob.get(ID).sprite()+" ");
                }
                else if(PID!=-1){
                    System.out.print(units.get(PID).getSprite()+" ");
                }
                else if(i>0&&i<10&&j>0&&j<10&&PID==-1&&ID==-1&&WireID!=-1&&wires.get(WireID).getTurn()!=0){
                    System.out.print("% ");
                }
                else if(i>0&&i<10&&j>0&&j<10&&PID==-1&&ID==-1&&WireID==-1&&fieldID!=-1&&magneticfield.get(fieldID).getTurn()!=0){
                    System.out.print("~ ");
                }
                else{
                    System.out.print(map[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void cekMob(ArrayList<Zombie> mob){
        for(int i =0;i<mob.size();i++){
            boolean checkAlive = mob.get(i).isAlive();
            if(!checkAlive){
                mob.remove(i);
            }
        }
    }
    
    public static boolean cekNabrak(ArrayList<Zombie> mob){
        int[] posX = new int[2];
        int[] posY = new int[2];
        int index = -1;
        boolean nabrak = false;
        for(int i =0;i<mob.size();i++){
            for(int j =0;j<mob.size();j++){
                if(i!=j){
//                    System.out.println("cek "+i);
//                    System.out.println("cek "+j);
                    posX[0]=mob.get(i).getX();
                    posX[1]=mob.get(j).getX();
                    posY[0]=mob.get(i).getY();
                    posY[1]=mob.get(j).getY();
//                    for(int z =0;z<2;z++){
//                        System.out.println(posX[z]);
//                        System.out.println(posY[z]);
//                    }
                    if(posX[0]==posX[1]&&posY[0]==posY[1]){
                        nabrak = true;
                        index = i;
                        mob.get(index).isDead();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void respawnCheck(ArrayList<Zombie> mob){
        int size = mob.size();
        for(int i=size;i<10;i++){
            mob.add(new Zombie(true));
        }
    }
    
    public static void RESPAWN(ArrayList<Zombie> mob){
        boolean cek = true;
        while(cek){
            respawnCheck(mob);
            cek = cekNabrak(mob);
            cekMob(mob);
//            System.out.println("Nabrak");
        }
    }
    
    
    public static void goLeft(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob){
        int tesLeft = units.get(dex).getX()-1;
        boolean tes = true;
        for(int i=0;i<3;i++){
            if(i!=dex){
                int PX=units.get(i).getX();
                int PY=units.get(i).getY();
                if(PX==tesLeft&&PY==units.get(dex).getY()){
                    tes = false;
                }
            }
        }
        for(int i =0;i<10;i++){
            if(mob.get(i).getX()==tesLeft&&mob.get(i).getY()==units.get(dex).getY()){
                tes = false;
            }
            if(tesLeft==0){
                tes=false;
            }
        }
        int hasilakhir;
        if(tes==true){
            units.get(dex).setX(tesLeft);
        }
    }
    
    public static void goRight(ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob){
        int tesRight = units.get(dex).getX()+1;
        boolean tes = true;
        for(int i=0;i<3;i++){
            if(i!=dex){
                int PX=units.get(i).getX();
                int PY=units.get(i).getY();
                if(PX==tesRight&&PY==units.get(dex).getY()){
                    tes = false;
                }
            }
        }
        for(int i =0;i<10;i++){
            if(mob.get(i).getX()==tesRight&&mob.get(i).getY()==units.get(dex).getY()){
                tes = false;
            }
            if(tesRight==10){
                tes=false;
            }
        }
        if(tes==true){
            units.get(dex).setX(tesRight);
        }
    }
    
    public static void ActionMenu(boolean moved){
        if(!moved){
            System.out.println("");
            System.out.println("1. Move");
            System.out.println("2. Attack");
            System.out.println("3. Special 1");
            System.out.println("4. Special 2");
            System.out.println("5. Call for extraction");
            System.out.print(">>");
        }
        else{
            System.out.println("");
            System.out.println("1. Attack");
            System.out.println("2. Special 1");
            System.out.println("3. Special 2");
            System.out.println("4. Call for extraction");
            System.out.print(">>");
        }
    }
    
    public static void attack (ArrayList<UrMom> units, int dex, ArrayList<Zombie> mob, boolean[] commence){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter coordinates(X,Y)");
        String coordinate = scan.nextLine();
        boolean valid = false;
        commence[0]=false;
        int attackY = Character.getNumericValue(coordinate.charAt(2));
        int attackX = Character.getNumericValue(coordinate.charAt(0));
        int posX = units.get(dex).getX();
        int posY = units.get(dex).getY();
        if(attackY>0 && attackY<10){
            valid=true;
        }
        if(attackX>0 && attackX<10){
            valid=true;
        }
        else{
            valid=false;
        }
        if(valid){
            if((posY-4<=attackY && posY+4>=attackY)&&(posX-4<=attackX && posX+4>=attackX)){
                for(int i =0;i<10;i++){
                    int ZX = mob.get(i).getX();
                    int ZY = mob.get(i).getY();
                    if(ZX==attackX&&ZY==attackY){
                        boolean isDead = mob.get(i).damaged();
                        if(isDead){
                            System.out.println("Zombie Killed");
                            units.get(dex).addSpecialPoints(1);
                            commence[0]=true;
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("Invalid Coordinate!, You missed");
            }
        }
        else{
            System.out.println("Invalid Coordinate!");
        }
    }

    public static void main(String[] args) {
        char[][] map = new char[11][11];
        Scanner scStr = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        generatemap(map);
        boolean run = true;
        ArrayList<Zombie> mob = new ArrayList<Zombie>();
        ArrayList<UrMom> units = new ArrayList<UrMom>();
        ArrayList<Wire> wires = new ArrayList<Wire>();
        ArrayList<Wire> magneticfield = new ArrayList<Wire>();
        ArrayList<PlayerScore> scorelist = new ArrayList<PlayerScore>();
        boolean alldead = false;
        int turn = 1;
        int[] score = new int[1];
        while(run){
            int pilmenu;
            menu();
            pilmenu = scInt.nextInt();
            if(pilmenu==1){
                boolean game = true;
                boolean initiate = true;
                int extraction = 0;
                boolean ext = false;
                while(game){
                    if(initiate){
                        score[0] = 0;
                        mob.clear();
                        units.clear();
                        wires.clear();
                        RESPAWN(mob);
                        magneticfield.clear();
                        initiate = false;
                        alldead = false;
                        units.add(new Support(5,6,5,5,"Support Unit"));
                        units.add(new Assault(4,5,3,5,"Assault Trooper"));
                        units.add(new Heavy(6,5,4,5,"Heavy Mech"));
                        units.add(new Engineer(5,4,4,5,"Tech Engineer"));
                        System.out.println(mob.size());
                    }
                    if(ext){
                        System.out.println("Extraction in "+(extraction-turn)+" turn(s)");
                    }
                    for(int i =0;i<4;i++){
                        System.out.println("Turn : "+turn);
                        System.out.println("Score : "+score[0]);
                        printmap(map,mob,units,wires,magneticfield);
                        boolean attack = false;
                        boolean special_1 = false;
                        boolean special_2 = false;
                        boolean moved = false;
                        System.out.println(units.get(i).getUnitname());
                        System.out.println("HP : "+units.get(i).getHp());
                        System.out.print("Special: ");
                        for(int c = 0;c<units.get(i).getSpecialbar();c++){
                            System.out.print("=");
                        }
                        ActionMenu(moved);
                        int Choice = scInt.nextInt();
                        if(Choice==1){ 
                            for(int j = 0;j<10;j++){
                                System.out.println(j);
                                printmap(map,mob,units,wires,magneticfield);
                                System.out.print("Move : ");
                                String direction = scStr.next();
                                if(direction.equals("w")||direction.equals("W")){
                                    units.get(i).goUp(mob,units);
                                }
                                else if(direction.equals("a")||direction.equals("A")){
                                    goLeft(units,i,mob);
                                }
                                else if(direction.equals("s")||direction.equals("S")){
                                    units.get(i).goDown(mob,units);
                                }
                                else if(direction.equals("d")||direction.equals("D")){
                                    goRight(units,i,mob);
                                }
                                else if(direction.equals("hold")||direction.equals("Hold")||direction.equals("HOLD")){
                                    j=11;
                                }
                            }
                            moved=true;
                        }
                        else if(Choice==2){
                            attack = true;
                        }
                        else if(Choice==3){
                            special_1 = true;
                        }
                        else if(Choice==4){
                            special_2 = true;
                        }
                        else if(Choice==5){
                            extraction=turn+5;
                            ext = true;
                        }
                        else if(Choice==66){
                            units.get(i).setHp(1);
                        }
                        else if(Choice==77){
                            i=5;
                        }
                        else if (Choice==88){
                            for(int z =0;z<mob.size();z++){
                                mob.get(z).isDead();
                            }
                        }
                        else if (Choice==99){
                            for(int l = 0;l<units.size();l++){
                                if(units.get(l).Status()){
                                    int maxhp = units.get(l).getMaxHp();
                                    units.get(l).setHp(maxhp);
                                }
                            }
                        }
                        if(moved){
                            printmap(map,mob,units,wires,magneticfield);
                            ActionMenu(moved);
                            int pilaftermove = scInt.nextInt();
                            if(pilaftermove==1){
                                attack=true;        
                            }
                            else if(pilaftermove==2){
                                special_1=true;
                            }
                            else if(pilaftermove==3){
                                special_2=true;
                            }
                            else if(pilaftermove==4){
                                extraction=turn+5;
                                ext=true;
                            }
                            else if(pilaftermove==66){
                                units.get(i).setHp(1);
                            }
                            else if(pilaftermove==77){
                                i=5;
                            }
                            else if(pilaftermove==88){
                                for(int z =0;z<mob.size();z++){
                                    mob.get(z).isDead();
                                }
                            }
                            else if(pilaftermove==99){
                                for(int l = 0;l<units.size();l++){
                                    if(units.get(l).Status()){
                                        int maxhp = units.get(l).getMaxHp();
                                        units.get(l).setHp(maxhp);
                                    }
                                }
                            }
                        }
                        if(special_1){
                            if(units.get(i).getSpecialbar()<3){
                                System.out.println("Special bar is not enough");
                            }
                            else{
                                units.get(i).Special_1(units, i, mob,wires);
                            }
                        }
                        else if(special_2){
                            if(units.get(i).getSpecialbar()<3){
                                System.out.println("Special bar is not enough");
                            }
                            else{
                                if(units.get(i).getUnitname().equals("Assault Trooper")){
                                    for(int j=0;j<3;j++){
                                        boolean[] commence = new boolean[1];
                                        attack(units,i,mob,commence);
                                        if(!commence[0]){
                                            System.out.println("You missed.");
                                        }
                                        System.out.println((i+1)+"/3 shots");
                                    }
                                }
                                else{
                                    units.get(i).Special_2(units, i, mob, magneticfield);
                                }
                            }
                        }
                        else if(attack){
                            boolean[] commence = new boolean[1];
                            attack(units,i,mob,commence);
                            if(!commence[0]){
                                System.out.println("You missed. Turn wasted.");
                            }
                        }
                        for(int z =0;z<mob.size();z++){
                            boolean cekZombie = mob.get(z).isAlive();
                            if(!cekZombie){
                                int type = mob.get(z).getType();
                                if(type==1){
                                    score[0]+=5;
                                }
                                else if(type==2){
                                     score[0]+=2;
                                }
                                else if(type==3){
                                    score[0]+=2;
                                }
                                else if(type==4){
                                    score[0]+=1;
                                }
                            }
                        }
                    }
                    RESPAWN(mob);
                    int matigblg = 0;
                    boolean Jebaited = false;
                    for(int i =0;i<mob.size();i++){
                        for(int j =0;j<wires.size();j++){
                            boolean NginjekKokMati = false;
                            if(mob.get(i).getX()==wires.get(j).getX()&&mob.get(i).getY()==wires.get(j).getY()){
                                NginjekKokMati = mob.get(i).damaged();
                                if(NginjekKokMati){
                                    mob.get(i).isDead();
                                    matigblg++;
                                    Jebaited = true;
                                }
                            }
                        }
                    }
                    if(Jebaited){
                        System.out.println(matigblg+" Zombies died stepping on barbed wires");
                    }
                    for(int i =0;i<mob.size();i++){
                        for(int j =0;j<magneticfield.size();j++){
                            int fieldX = magneticfield.get(j).getX();
                            int fieldY = magneticfield.get(j).getY();
                            int zombieX = mob.get(i).getX();
                            int zombieY = mob.get(i).getY();
                            if(fieldX==zombieX&&zombieY==fieldY){
                                mob.get(i).Stunned();
                            }
                        }
                    }
                    for(int i =0;i<mob.size();i++){
                        mob.get(i).move(units, mob, i);
                    }
                    System.out.println("Zombie's Turn");
                    printmap(map,mob,units,wires,magneticfield);
                    for(int i =0;i<mob.size();i++){
                        mob.get(i).specialAttacks(units, mob);
                    }
                    for(int i =0;i<units.size();i++){
                        if(units.get(i).getHp()<=0){
                            units.get(i).isDead(); 
                        }
                        boolean cekAlive = units.get(i).Status();
                        if(!cekAlive){
                            System.out.println(units.get(i).getUnitname()+" died");
                            units.remove(i);
                        }
                    }
                    turn++;
                    for(int i =0;i<wires.size();i++){
                        wires.get(i).countdown();
                    }
                    for(int i =0;i<magneticfield.size();i++){
                        magneticfield.get(i).countdown();
                    }
                    if(ext&&turn==extraction){
                        game=false;
                    }
                    if(units.size()==0){
                        System.out.println("Game Over, all of your troops died..");
                        game=false;
                        alldead=true;
                    }
                }
                if(!alldead){
                    System.out.print("Enter your name : ");
                    String playername = scStr.nextLine();
                    scorelist.add(new PlayerScore(playername,score[0]));
                }
            }
            else if(pilmenu==2){
                for(int i =0;i<scorelist.size();i++){
                    System.out.println(scorelist.get(i).getName()+"-"+scorelist.get(i).getScore());
                }
            }
            else if(pilmenu==0){
                run=false;
            }
        }
    }
    
}
