/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simple_castlegame;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Frans
 */
public class SIMPLE_CASTLEGAME {

    public static void printCastle(){
        System.out.println(
        "*==============================*\n" +
        "|                              |\n" +
        "|                   T~~        |\n" +
        "|                   |          |\n" +
        "|                  /\"\\         |\n" +
        "|          T~~     |'| T~~     |\n" +
        "|      T~~ |    T~ WWWW|       |\n" +
        "|      |  /\"\\   |  |  |/\\T~~   |\n" +
        "|     /\"\\ WWW  /\"\\ |' |WW|     |\n" +
        "|    WWWWW/\\| /   \\|'/\\|/\"\\    |\n" +
        "|    |   /__\\/]WWW[\\/__\\WWWW   |\n" +
        "|    |\"  WWWW'|I_I|'WWWW'  |   |\n" +
        "|    |   |' |/  -  \\|' |'  |   |\n" +
        "|    |'  |  |LI=H=LI|' |   |   |\n" +
        "|    |   |' | |[_]| |  |'  |   |\n" +
        "|    |   |  |_|###|_|  |   |   |\n" +
        "|    '---'--'-/___\\-'--'---'   |\n" +
        "*==============================*");
    }
    public static void printMainMenu(ArrayList<Bruh> building){
        System.out.println("1. View Garrison");
        System.out.println("2. Tavern");
        if(building.get(0).isBuilt()){
            System.out.println("3. Barracks");
        }
        else{
            System.out.println("3. Construct Barracks (300G)");
        }
        if(building.get(1).isBuilt()){
            System.out.println("4. Archery Range");
        }
        else{
            System.out.println("4. Construct Archery Range (200G)");
        }
        if(building.get(2).isBuilt()){
            System.out.println("5. Balistae Factory");
        }
        else{
            System.out.println("5. Construct Balistae Factory (400G)");
        }
        if(building.get(3).isBuilt()){
            System.out.println("6. Inn");
        }
        else{
            System.out.println("6. Construct Inn (500G)");
        }
        System.out.println("7. Ready for Battle");
        System.out.print(">>");
    }
    
    public static void viewGarrisonMenu(){
        System.out.println("View which garrison?");
        System.out.println("1. Unassigned Troops");
        System.out.println("2. North Garrison");
        System.out.println("3. South Garrison");
    }
    
    public static void backOption(){
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void menuYuusha(yuusha x){
        System.out.println(x.getName());
        System.out.println("1. Move");
        System.out.println("2. Stats");
        System.out.println("3. Banish");
    }
    
    public static void menuGomiNoHeishi(Troops heishi){
        System.out.println(heishi.getAmount()+" "+heishi.getTroopName());
        System.out.println("1. Move");
        System.out.println("2. Split");
        System.out.println("3. Stats");
        System.out.println("4. Banish");
    }
    
    public static void statMenuHeishi(Troops x){
        System.out.println(x.getTroopName());
        int amount = x.getAmount();
        int damageSendirian=0;
        int healthSendirian=0;
        
        if(x instanceof Squire){
            damageSendirian = 2;
            healthSendirian = 2;
        }
        else if(x instanceof Balistae){
            damageSendirian = 3;
            healthSendirian = 3;
        }
        else if(x instanceof Archers){
            damageSendirian = 1;
            healthSendirian = 1;
        }
        System.out.println("Attack (Individual) = "+damageSendirian);
        System.out.println("Attack (Collective) = "+(amount*damageSendirian));
        System.out.println("Health (Individual) = "+healthSendirian);
        System.out.println("Health (Collective) = "+(amount*healthSendirian));
    }
    
    public static void statMenuYuusha(yuusha hero){
        System.out.println(hero.getName());
        System.out.println("Level = "+hero.getLevel());
        System.out.println("Attack = "+hero.getDamage());
        System.out.println("Health = "+hero.getHealth());
    }
    
    public static void menuBuildingRecruitment(Bruh building, ArrayList<Troops> x, int[] gold){
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        boolean recruiting = true;
        while(recruiting){
            System.out.println("1. Hire "+building.getAssignedTroop());
            backOption();
            int pilsc = scInt.nextInt();
            if(pilsc==0){
                recruiting=false;
            }
            else if(pilsc==1){
                System.out.println("How many "+building.getAssignedTroop()+" would you like to hire?");
                System.out.print(">>");
                int amount = scInt.nextInt();
                if(amount>0&&amount<1000){
                    int TotalCost = amount*building.getCostPerUnit();
                    if(TotalCost>gold[0]){
                        System.out.println("Not enough gold. Stop being broke");
                    }
                    else{
                        int index=-1;
                        for(int i =0;i<8;i++){
                            if(!(x.get(i) instanceof Squire)&&!(x.get(i) instanceof Balistae)&&!(x.get(i) instanceof Archers)&&!(x.get(i) instanceof yuusha)){
                                index=i;
                                break;
                            }
                        }
                        if(index==-1){
                            System.out.println("There are no empty slots in the Garrison");
                        }
                        else{
                            String troopname = building.getAssignedTroop();
                            if(troopname.equals("Squire")){
                                x.set(index, new Squire(2,2));
                                x.get(index).setTroopName("Squire");
                                x.get(index).setAmount(amount);
                            }
                            else if(troopname.equals("Archers")){
                                x.set(index, new Squire(1,1));
                                x.get(index).setTroopName("Archers");
                                x.get(index).setAmount(amount);
                            }
                            else{
                                x.set(index, new Squire(3,3));
                                x.get(index).setTroopName("Balistae");
                                x.get(index).setAmount(amount);
                            }
                            gold[0]-=TotalCost;
                        }
                    }
                }
                else{
                    System.out.println("Maximum amount of hires is 999 units at once, and minimum amount of hires is 1 unit.");
                }
                recruiting=false;
            }
        }
    }
    
    public static void whereToMove(){
        System.out.println("Where to would you like to move this unit?");
        System.out.println("1. Unassigned Garrison");
        System.out.println("2. North Garrison");
        System.out.println("3. South Garrison");
    }
    
    public static void seeGarrison(ArrayList<Troops> x){
        for(int i =0;i<8;i++){
            if(x.get(i) instanceof yuusha){
                yuusha temp = (yuusha)x.get(i);
                System.out.println((i+1)+". "+temp.getName());
            }
            else if(x.get(i) instanceof Squire||x.get(i) instanceof Balistae||x.get(i) instanceof Archers){
                System.out.println((i+1)+". "+x.get(i).getAmount()+" "+x.get(i).getTroopName());
            }
            else{
                System.out.println((i+1)+". Empty");
            }
        }
        System.out.println("0. Cancel");
        System.out.println("Choose a slot");
        System.out.print(">>");
    }
    
    public static void moveUnit(ArrayList<Troops> a, ArrayList<Troops> b, int index, int pindah){
        Troops temp = a.get(index);
        a.set(index, b.get(pindah));
        b.set(pindah, temp);
    }
            
    public static void main(String[] args) {
        boolean game = true;
        String entername = "";
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        boolean firsttime = true;
        ArrayList <Troops> unassigned = new ArrayList <Troops>();
        ArrayList <Troops> North = new ArrayList <Troops>();
        ArrayList <Troops> South = new ArrayList <Troops>();
        ArrayList <Bruh> building = new ArrayList<Bruh>();
        int[] gold =new int[1];
        gold[0]=5000;
        while(game){
            if(firsttime){
                gold[0] =5000;
                unassigned.clear();
                North.clear();
                South.clear();
                building.clear();
                for(int i =0;i<8;i++){
                    unassigned.add(new Troops());
                }
                for(int i =0;i<8;i++){
                    North.add(new Troops());
                }
                for(int i =0;i<8;i++){
                    South.add(new Troops());
                }
                building.add(new Bruh("Barracks",false,"Squires",20));
                building.add(new Bruh("Archery Range",false,"Archers",10));
                building.add(new Bruh("Balistae Factory",false,"Balistae",30));
                building.add(new Bruh("Inn",false));
                System.out.print("Enter the name of your first hero:");
                entername = scStr.nextLine();
                unassigned.set(0, (new yuusha(entername,1)));
                firsttime=false;
            }
            System.out.println("Gold : "+gold[0]+"G");
            printCastle();
            printMainMenu(building);
            int pilmainmenu = scInt.nextInt();
            if(pilmainmenu==1){
                boolean assigningTroops = true;
                while(assigningTroops){
                    viewGarrisonMenu();
                    backOption();
                    int pilassign = scInt.nextInt();
                    if(pilassign==1){
                        boolean seeUnassigned = true;
                        while(seeUnassigned){
                            for(int i =0;i<8;i++){
                                if(unassigned.get(i) instanceof yuusha){
                                    yuusha hero = (yuusha)unassigned.get(i);
                                    System.out.println((i+1)+". "+hero.getName());
                                }
                                else if(unassigned.get(i) instanceof Balistae||unassigned.get(i) instanceof Archers||unassigned.get(i) instanceof Squire){
                                    System.out.println((i+1)+". "+unassigned.get(i).getAmount()+" "+unassigned.get(i).getTroopName());
                                }
                                else{
                                    System.out.println((i+1)+". Empty");
                                }
                            }
                            backOption();
                            int GarrisonEdit = scInt.nextInt();
                            if(GarrisonEdit==0){
                                seeUnassigned=false;
                            }
                            else if(GarrisonEdit<=unassigned.size()){
                                int index = GarrisonEdit-1;
                                if(unassigned.get(index) instanceof yuusha){
                                    boolean seeTroop = true;
                                    while(seeTroop){
                                        yuusha hero = (yuusha)unassigned.get(index);
                                        menuYuusha(hero);
                                        backOption();
                                        int whattoDo = scInt.nextInt();
                                        if(whattoDo==1){
                                            boolean movingTroops = true;
                                            while(movingTroops){
                                                whereToMove();
                                                backOption();
                                                int pilmove = scInt.nextInt();
                                                if(pilmove==1){
                                                    seeGarrison(unassigned);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(unassigned,unassigned,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if(pilmove==2){
                                                    seeGarrison(North);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(unassigned,North,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==3){
                                                    seeGarrison(South);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(unassigned,South,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==0){
                                                    movingTroops=false;
                                                }
                                            }
                                        }
                                        else if(whattoDo==2){
                                            statMenuYuusha(hero);
                                        }
                                        else if(whattoDo==3){
                                            System.out.println(hero.getName()+" was banished to the shadow realm...");
                                            seeTroop=false;
                                            unassigned.set(index, new Troops());
                                        }
                                        else if(whattoDo==0){
                                            seeTroop=false;
                                        }
                                    } 
                                }
                                else{
                                    boolean seeTroop=true;
                                    while(seeTroop){
                                        menuGomiNoHeishi(unassigned.get(index));
                                        backOption();
                                        int whattoDo = scInt.nextInt();
                                        if(whattoDo==1){
                                            boolean movingTroops = true;
                                            while(movingTroops){
                                                whereToMove();
                                                backOption();
                                                int pilmove = scInt.nextInt();
                                                if(pilmove==1){
                                                    seeGarrison(unassigned);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(unassigned,unassigned,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if(pilmove==2){
                                                    seeGarrison(North);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(unassigned,North,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==3){
                                                    seeGarrison(South);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(unassigned,South,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==0){
                                                    movingTroops=false;
                                                }
                                            }
                                        }
                                        else if(whattoDo==3){
                                            statMenuHeishi(unassigned.get(index));
                                        }
                                        else if(whattoDo==4){
                                            System.out.println(unassigned.get(index).getAmount()+" "+unassigned.get(index).getTroopName()+" was banished to the shadow realm...");
                                            seeTroop=false;
                                            unassigned.set(index, new Troops());
                                        }
                                        else if(whattoDo==0){
                                            seeTroop=false;
                                        }
                                    }
                                    
                                }
                            }
                            else{
                                System.out.println("There are no troops at this slot. Stop being broke and hire some.");
                            }
                        }
                    }
                    else if(pilassign==2){
                        boolean seeNorth = true;
                        while(seeNorth){
                            for(int i =0;i<8;i++){
                                if(North.get(i) instanceof yuusha){
                                    yuusha hero = (yuusha)North.get(i);
                                    System.out.println((i+1)+". "+hero.getName());
                                }
                                else if(North.get(i) instanceof Balistae||North.get(i) instanceof Archers||North.get(i) instanceof Squire){
                                    System.out.println((i+1)+". "+South.get(i).getAmount()+" "+South.get(i).getTroopName());
                                }
                                else{
                                    System.out.println((i+1)+". Empty");
                                }
                            }
                            backOption();
                            int GarrisonEdit = scInt.nextInt();
                            if(GarrisonEdit==0){
                                seeNorth=false;
                            }
                            else if(GarrisonEdit<=North.size()){
                                int index = GarrisonEdit-1;
                                if(North.get(index) instanceof yuusha){
                                   boolean seeTroop = true;
                                    while(seeTroop){
                                        yuusha hero = (yuusha)North.get(index);
                                        menuYuusha(hero);
                                        backOption();
                                        int whattoDo = scInt.nextInt();
                                        if(whattoDo==1){
                                            boolean movingTroops = true;
                                            while(movingTroops){
                                                whereToMove();
                                                backOption();
                                                int pilmove = scInt.nextInt();
                                                if(pilmove==1){
                                                    seeGarrison(unassigned);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(North,unassigned,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if(pilmove==2){
                                                    seeGarrison(North);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(North,North,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==3){
                                                    seeGarrison(South);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(North,South,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                            }
                                        }
                                        else if(whattoDo==2){
                                            
                                        }
                                        else if(whattoDo==3){
                                            System.out.println(hero.getName()+" was banished to the shadow realm...");
                                            seeTroop=false;
                                            North.set(index, new Troops());
                                        }
                                        else if(whattoDo==0){
                                            seeTroop=false;
                                        }
                                    } 
                                }
                                else{
                                    boolean seeTroop=true;
                                    while(seeTroop){
                                        menuGomiNoHeishi(North.get(index));
                                        backOption();
                                        int whattoDo = scInt.nextInt();
                                        if(whattoDo==1){
                                            boolean movingTroops = true;
                                            while(movingTroops){
                                                whereToMove();
                                                backOption();
                                                int pilmove = scInt.nextInt();
                                                if(pilmove==1){
                                                    seeGarrison(unassigned);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(North,unassigned,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if(pilmove==2){
                                                    seeGarrison(North);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(North,North,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==3){
                                                    seeGarrison(South);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(North,South,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                            }
                                        }
                                        else if(whattoDo==3){
                                            statMenuHeishi(North.get(index));
                                        }
                                        else if(whattoDo==4){
                                            System.out.println(North.get(index).getAmount()+" "+North.get(index).getTroopName()+" was banished to the shadow realm...");
                                            seeTroop=false;
                                            North.set(index, new Troops());
                                        }
                                        else if(whattoDo==0){
                                            seeTroop=false;
                                        }
                                    }
                                }
                            }
                            else{
                                System.out.println("There are no troops at this slot. Stop being broke and hire some.");
                            }
                        }
                    }
                    else if(pilassign==3){
                        boolean seeSouth = true;
                        while(seeSouth){
                            for(int i =0;i<8;i++){
                                if(South.get(i) instanceof yuusha){
                                    yuusha hero = (yuusha)South.get(i);
                                    System.out.println((i+1)+". "+hero.getName());
                                }
                                else if(South.get(i) instanceof Balistae||South.get(i) instanceof Archers||South.get(i) instanceof Squire){
                                    System.out.println((i+1)+". "+South.get(i).getAmount()+" "+South.get(i).getTroopName());
                                }
                                else{
                                    System.out.println((i+1)+". Empty");
                                }
                            }
                            backOption();
                            int GarrisonEdit = scInt.nextInt();
                            if(GarrisonEdit==0){
                                seeSouth=false;
                            }
                            else if(GarrisonEdit<=South.size()){
                                int index = GarrisonEdit-1;
                                if(South.get(index) instanceof yuusha){
                                    boolean seeTroop = true;
                                    while(seeTroop){
                                        yuusha hero = (yuusha)South.get(index);
                                        menuYuusha(hero);
                                        backOption();
                                        int whattoDo = scInt.nextInt();
                                        if(whattoDo==1){
                                            boolean movingTroops = true;
                                            while(movingTroops){
                                                whereToMove();
                                                backOption();
                                                int pilmove = scInt.nextInt();
                                                if(pilmove==1){
                                                    seeGarrison(unassigned);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(South,unassigned,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if(pilmove==2){
                                                    seeGarrison(North);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(South,North,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==3){
                                                    seeGarrison(South);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(South,South,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                            }
                                        }
                                        else if(whattoDo==2){
                                            
                                        }
                                        else if(whattoDo==3){
                                            System.out.println(hero.getName()+" was banished to the shadow realm...");
                                            South.set(index, new Troops());
                                        }
                                        else if(whattoDo==0){
                                            seeTroop=false;
                                        }
                                    } 
                                }
                                else{
                                    boolean seeTroop=true;
                                    while(seeTroop){
                                        menuGomiNoHeishi(South.get(index));
                                        backOption();
                                        int whattoDo = scInt.nextInt();
                                        if(whattoDo==1){
                                            boolean movingTroops = true;
                                            while(movingTroops){
                                                whereToMove();
                                                backOption();
                                                int pilmove = scInt.nextInt();
                                                if(pilmove==1){
                                                    seeGarrison(unassigned);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(South,unassigned,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if(pilmove==2){
                                                    seeGarrison(North);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(South,North,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                                else if (pilmove==3){
                                                    seeGarrison(South);
                                                    int pindahanBung = scInt.nextInt();
                                                    pindahanBung = pindahanBung-1;
                                                    moveUnit(South,South,index,pindahanBung);
                                                    seeTroop=false;
                                                    movingTroops=false;
                                                }
                                            }
                                        }
                                        else if(whattoDo==3){
                                            statMenuHeishi(South.get(index));
                                        }
                                        else if(whattoDo==4){
                                            System.out.println(South.get(index).getAmount()+" "+South.get(index).getTroopName()+" was banished to the shadow realm...");
                                            seeTroop=false;
                                            South.set(index, new Troops());
                                        }
                                        else if(whattoDo==0){
                                            seeTroop=false;
                                        }
                                    }
                                }
                            }
                            else{
                                System.out.println("There are no troops at this slot. Stop being broke and hire some.");
                            }
                        }
                    }
                    else if(pilassign==0){
                        assigningTroops=false;
                    }
                }
            }
            else if (pilmainmenu==2){
                boolean seeTavern=true;
                while(seeTavern){
                    System.out.println("1. Hire a hero");
                    System.out.println("2. Train a hero");
                    backOption();
                    int pilTavern = scInt.nextInt();
                    if(pilTavern==1){
                        boolean SummonHero = false;
                        for(int i=0;i<8;i++){
                            if(!(unassigned.get(i) instanceof Squire)&&!(unassigned.get(i) instanceof Balistae)&&!(unassigned.get(i) instanceof Archers)&&!(unassigned.get(i) instanceof yuusha)){
                                SummonHero=true;
                            }
                        }
                        if(SummonHero){
                            System.out.print("Enter a name for your new hero : ");
                            String newheroname = scStr.nextLine();
                            unassigned.add(new yuusha(newheroname,1));
                            gold[0]-=300;
                        }
                        else if(gold[0]<300){
                            System.out.println("Not enough money to hire a new hero. Stop being broke and start waging war");
                        }
                        else{
                            System.out.println("Not enough space to hire another hero.");
                        }        
                    }
                    else if(pilTavern==2){
                        boolean trainingArc = true;
                        while(trainingArc){
                            System.out.println("Which hero would you like to train?");
                            ArrayList<Integer> simpanIndex = new ArrayList<Integer>();
                            ArrayList<Integer> Location = new ArrayList<Integer>();
                            int urutan = 1;
                            for(int i =0;i<unassigned.size();i++){
                                if(unassigned.get(i) instanceof yuusha){
                                    yuusha temp = (yuusha)unassigned.get(i);
                                    System.out.println(urutan+". "+temp.getName()+" ("+temp.getLevel()+")");
                                    simpanIndex.add(i);
                                    Location.add(1);
                                    urutan++;
                                }
                            }
                            for(int i =0;i<North.size();i++){
                                if(North.get(i) instanceof yuusha){
                                    yuusha temp = (yuusha)North.get(i);
                                    System.out.println(urutan+". "+temp.getName()+" ("+temp.getLevel()+")");
                                    simpanIndex.add(i);
                                    Location.add(2);
                                    urutan++;
                                }
                            }
                            for(int i =0;i<South.size();i++){
                                if(South.get(i) instanceof yuusha){
                                    yuusha temp = (yuusha)South.get(i);
                                    System.out.println(urutan+". "+temp.getName()+" ("+temp.getLevel()+")");
                                    simpanIndex.add(i);
                                    Location.add(3);
                                    urutan++;
                                }
                            }
                            backOption();
                            int trainingmenu = scInt.nextInt();
                            if(trainingmenu==0){
                                trainingArc=false;
                            }
                            else if(trainingmenu>0&&trainingmenu<=urutan){
                                if(gold[0]<100){
                                    if(Location.get(trainingmenu-1)==1){
                                        yuusha temp = (yuusha)unassigned.get(simpanIndex.get(trainingmenu-1));
                                        temp.setLevel(temp.getLevel()+1);
                                        System.out.println(temp.getName()+" leveled up to level "+temp.getLevel());
                                        temp.levelUp();
                                        gold[0]-=100;
                                    }
                                    else if(Location.get(trainingmenu-1)==2){
                                        yuusha temp = (yuusha)North.get(simpanIndex.get(trainingmenu-1));
                                        temp.setLevel(temp.getLevel()+1);
                                        System.out.println(temp.getName()+" leveled up to level "+temp.getLevel());
                                        gold[0]-=100;
                                        temp.levelUp();
                                    }
                                    else if(Location.get(trainingmenu-1)==3){
                                        yuusha temp = (yuusha)South.get(simpanIndex.get(trainingmenu-1));
                                        temp.setLevel(temp.getLevel()+1);
                                        System.out.println(temp.getName()+" leveled up to level "+temp.getLevel());
                                        gold[0]-=100;
                                        temp.levelUp();
                                    }
                                }
                            }
                        }
                    }
                    else if(pilTavern==0){
                        System.out.println("Exiting the Tavern...");
                        seeTavern=false;
                    }
                }
            }
            else if (pilmainmenu==3){
                if(!building.get(0).isBuilt()){
                    building.get(0).setBuilt(true);
                    System.out.println(building.get(2).getName()+" was built");
                    gold[0]-=300;
                }
                else{
                    Bruh currentbuilding = building.get(0);
                    menuBuildingRecruitment(currentbuilding,unassigned,gold);
                }
            }
            else if (pilmainmenu==4){
                if(!building.get(1).isBuilt()){
                    building.get(1).setBuilt(true);
                    System.out.println(building.get(2).getName()+" was built");
                    gold[0]-=200;
                }
                else{
                    Bruh currentbuilding = building.get(1);
                    menuBuildingRecruitment(currentbuilding,unassigned,gold);
                }
            }
            else if (pilmainmenu==5){
                if(!building.get(2).isBuilt()){
                    building.get(2).setBuilt(true);
                    System.out.println(building.get(2).getName()+" was built");
                    gold[0]-=400;
                }
                else{
                    Bruh currentbuilding = building.get(2);
                    menuBuildingRecruitment(currentbuilding,unassigned,gold);
                }
            }
            else if (pilmainmenu==6){
                if(!building.get(3).isBuilt()){
                    building.get(3).setBuilt(true);
                    System.out.println(building.get(2).getName()+" was built");
                    gold[0]-=600;
                }
                else{
                    Bruh currentbuilding = building.get(2);
                    menuBuildingRecruitment(currentbuilding,unassigned,gold);
                }
            }
            else if (pilmainmenu==7){
            }
            else if (pilmainmenu==99){
                gold[0]+=1000;
            }
            
        }
    }
    
}
