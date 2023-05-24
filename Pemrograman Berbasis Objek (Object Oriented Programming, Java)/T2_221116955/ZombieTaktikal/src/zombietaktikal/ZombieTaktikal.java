/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zombietaktikal;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Frans
 */
public class ZombieTaktikal {

    public static void isiarena(char[][] arena){
        for(int y =0;y<11;y++){
            for(int x=0;x<11;x++){
                if(y==0||y==10){
                    arena[y][x]='#';
                }
                else if(x==0||x==10){
                    arena[y][x]='#';
                }
                else{
                    arena[y][x]=' ';
                }
            }
        }
    }
    
    public static void printmap(char[][] arena,boolean[] alive, int[] koordX, int[] koordY, int[] ZX, int[] ZY, boolean[] mobcount, int turn, int[] score){
        boolean zombie = false;
        System.out.println("Turn : "+turn);
        System.out.println("Score : "+score[0]);
        for(int i =0;i<11;i++){
            for(int j=0;j<11;j++){
                for(int mob =0;mob<10;mob++){
                    if(ZX[mob]==j&&ZY[mob]==i&&mobcount[mob]){
                        zombie=true;
                    }
                }
                if(j==koordX[0]&&i==koordY[0]){
                    System.out.print('S'+" ");
                }
                else if(j==koordX[1]&&i==koordY[1]){
                    System.out.print('A'+" ");
                }
                else if(j==koordX[2]&&i==koordY[2]){
                    System.out.print('H'+" ");
                }
                else if(zombie==true){
                    System.out.print('Z'+" ");
                    zombie=false;
                }
                else{
                    System.out.print(arena[j][i]+" ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void menu(){
        System.out.println("== ZCOM ==");
        System.out.println(" ");
        System.out.println("1. Play");
        System.out.println("2. Highscore");
        System.out.println("0. Exit");
    }
    
    public static void printaction(Troop[] troops,int giliran){
        System.out.println(troops[giliran].getName());
        System.out.print("HP : ");
        System.out.println(troops[giliran].getHealth());
        int specialbar = troops[giliran].getSpecialbar();
        System.out.print("Special: ");
        for(int i=0;i<specialbar;i++){
            System.out.print("=");
        }
        System.out.println("");
        System.out.println("1. Move");
        System.out.println("2. Attack");
        System.out.println("3. Special 1");
        System.out.println("4. Special 2");
        System.out.println("5. Call for Extraction");
        System.out.print(">>");
    }
    
    public static void printmove(){
        System.out.println("Up (W)");
        System.out.println("Left (A)");
        System.out.println("Down (S)");
        System.out.println("Right {D)");
    }
    
    public static int goUp(int koorX, int koorY, int[] ZY, int[] ZX, Troop[] troops){
        int tesUp = koorY-1;
        boolean tes = true;
        for(int i=0;i<3;i++){
            int PX=troops[i].getX();
            int PY=troops[i].getY();
            if(PX==koorX&&PY==tesUp){
                tes = false;
            }
        }
        for(int i =0;i<10;i++){
            if(ZY[i]==tesUp&&ZX[i]==koorX){
                tes = false;
            }
            if(tesUp==0){
                tes=false;
            }
        }
        int hasilakhir;
        if(tes==true){
            return tesUp;
        }
        else{
            return koorY;
        }
    }
    
    public static int goDown(int koorX, int koorY, int[] ZY, int[] ZX, Troop[] troops){
        int tesDown = koorY+1;
        boolean tes = true;
        for(int i=0;i<3;i++){
            int PX=troops[i].getX();
            int PY=troops[i].getY();
            if(PX==koorX&&PY==tesDown){
                tes = false;
            }
        }
        for(int i =0;i<10;i++){
            if(ZY[i]==tesDown&&ZX[i]==koorX){
                tes = false;
            }
            if(tesDown==0){
                tes=false;
            }
        }
        int hasilakhir;
        if(tes==true){
            return tesDown;
        }
        else{
            return koorY;
        }
    }
    
    public static int goLeft(int koorX, int koorY, int[] ZY, int[] ZX, Troop[] troops){
        int tesLeft = koorX-1;
        boolean tes = true;
        for(int i=0;i<3;i++){
            int PX=troops[i].getX();
            int PY=troops[i].getY();
            if(PX==tesLeft&&PY==koorY){
                tes = false;
            }
        }
        for(int i =0;i<10;i++){
            if(ZX[i]==tesLeft&&ZY[i]==koorY){
                tes = false;
            }
            if(tesLeft==0){
                tes=false;
            }
        }
        int hasilakhir;
        if(tes==true){
            return tesLeft;
        }
        else{
            return koorX;
        }
    }
    
    public static int goRight(int koorX, int koorY, int[] ZY, int[] ZX, Troop[] troops){
        int tesRight = koorX+1;
        boolean tes = true;
        for(int i=0;i<3;i++){
            int PX=troops[i].getX();
            int PY=troops[i].getY();
            if(PX==tesRight&&PY==koorY){
                tes = false;
            }
        }
        for(int i =0;i<10;i++){
            if(ZX[i]==tesRight&&ZY[i]==koorY){
                tes = false;
            }
            if(tesRight==0){
                tes=false;
            }
        }
        int hasilakhir;
        if(tes==true){
            return tesRight;
        }
        else{
            return koorX;
        }
    }
    
    public static void attack (boolean[] mobcount, int[] ZX, int[] ZY, int[] score, int giliran, Troop[] troops, boolean[] commence){
        Scanner scan = new Scanner(System.in);
        String coordinate = scan.nextLine();
        boolean valid = false;
        int attackY = Character.getNumericValue(coordinate.charAt(2));
        int attackX = Character.getNumericValue(coordinate.charAt(0));
        int posX = troops[giliran].getX();
        int posY = troops[giliran].getY();
        if(attackY>0 && attackY<10){
            valid=true;
        }
        if(attackX>0 && attackX<10){
            valid=true;
        }
        else{
            valid=false;
        }
        if(valid=true){
            if((posY-4<=attackY && posY+4>=attackY)&&(posX-4<=attackX && posX+4>=attackX)){
                for(int i =0;i<10;i++){
                    if(ZX[i]==attackX&&ZY[i]==attackY){
                        mobcount[i]=false;
                        System.out.println("Zombie Killed!");
                        score[0]+=10;
                        int specialbar = troops[giliran].getSpecialbar();
                        if(specialbar<5){
                            specialbar++;
                        }
                        ZX[i]=-1;
                        ZY[i]=-1;
                        troops[giliran].setSpecialbar(specialbar);
                        commence[0]=false;
                        break;
                    }
                }
                if(commence[0]==true){
                    System.out.println("Invalid coordinates!");
                }
            }
            else{
                System.out.println("Invalid Coordinate!, You missed");
            }
        }
    }
    
    public static void spawn(int[] ZX, int[] ZY, boolean[] alive){
        Random r = new Random();
        for(int i =0;i<10;i++){
            if(alive[i]==false){
                int tipe = r.nextInt(4)+1;
                boolean cek = true;
                int tempX, tempY;
                if(tipe==1){
                    while(cek){
                        tempX=1;
                        tempY=r.nextInt(9)+1;
                        cek=false;
                        for(int p =0;p<10;p++){
                            if(ZX[p]==tempX&&ZY[p]==tempY){
                                cek=true;
                            }
                        }
                        if(!cek){
                            ZX[i]=tempX;
                            ZY[i]=tempY;
                            alive[i]=true;
                        }
                    }
                }
                else if(tipe==2){
                    while(cek){
                        tempY=1;
                        tempX=r.nextInt(9)+1;
                        cek=false;
                        for(int p =0;p<10;p++){
                            if(ZX[p]==tempX&&ZY[p]==tempY){
                                cek=true;
                            }
                        }
                        if(!cek){
                            ZX[i]=tempX;
                            ZY[i]=tempY;
                            alive[i]=true;
                        }
                    }
                }
                else if(tipe==3){
                    while(cek){
                        tempX=9;
                        tempY=r.nextInt(9)+1;
                        cek=false;
                        for(int p =0;p<10;p++){
                            if(ZX[p]==tempX&&ZY[p]==tempY){
                                cek=true;
                            }
                        }
                        if(!cek){
                            ZX[i]=tempX;
                            ZY[i]=tempY;
                            alive[i]=true;
                        }
                    }
                }
                else if(tipe==4){
                    while(cek){
                        tempY=9;
                        tempX=r.nextInt(9)+1;
                        cek=false;
                        for(int p =0;p<10;p++){
                            if(ZX[p]==tempX&&ZY[p]==tempY){
                                cek=true;
                            }
                        }
                        if(!cek){
                            ZX[i]=tempX;
                            ZY[i]=tempY;
                            alive[i]=true;
                        }
                    }
                }
            }
        }
    }
    
    public static void Heal(Troop[] troops){
        Scanner scan = new Scanner(System.in);
        int index = 99;
        if(troops[0].getSpecialbar()>=3){
            boolean healingforepriwan = true;
            while(healingforepriwan){
                System.out.println("Who would you like to heal?");
                System.out.println("1. Support Unit");
                System.out.println("2. Assault Trooper");
                System.out.println("3. Heavy Mech");
                System.out.print(">>");
                index = scan.nextInt();
                if(index<4&&index>0){
                    healingforepriwan = false;
                }
            }
            int maxhp =troops[index-1].getMaxhealth();
            troops[index-1].setHealth(maxhp);
            System.out.println("Successfully healed "+troops[index-1].getName());
            int specialbar = troops[0].getSpecialbar();
            specialbar = specialbar-3;
            troops[0].setSpecialbar(specialbar);
        }
        else{
            System.out.println("Not enough special points");
        }
    }
    
    public static void encourage(Troop[] troops){
        Scanner scan = new Scanner(System.in);
        int index = 99;
        if(troops[0].getSpecialbar()>=3){
            boolean encourage = true;
            while(encourage){
                System.out.println("Who would you like to encourage?");
                System.out.println("1. Support Unit");
                System.out.println("2. Assault Trooper");
                System.out.println("3. Heavy Mech");
                index = scan.nextInt();
                if(index>0&&index<4){
                    encourage=false;
                }
            }
            troops[index-1].setSpecialbar(5);
            int bar=troops[0].getSpecialbar();
            bar-=3;
            troops[0].setSpecialbar(bar);
        }
    }
    
    public static void faceoff(Troop[] troops, int[] ZX, int[] ZY, boolean[] mobcount, int[] score){
        int posx = troops[1].getX();
        int posy = troops[1].getY();
        for(int i = posy-2;i<=posy+2;i++){
            for(int j = posx-2;j<=posx+2;j++){
                for(int p =0;p<10;p++){
                    if(ZX[p]==j&&ZY[p]==i){
                        ZX[p]=20;
                        ZY[p]=20;
                        mobcount[p]=false;
                        score[0]+=10;
                    }
                }
            }
        }
    }
    
    public static void moveZombie(Troop[] troops, int[] ZX, int[] ZY, boolean[] mobcount){
        int tesUp, tesDown, tesRight, tesLeft;
        Random r = new Random();
        boolean[] can = new boolean[4];
        boolean valid = true;
        for(int i =0;i<10;i++){
            if(mobcount[i]==true){
                for(int t =0;t<4;t++){
                    can[t]=true;
                }
                tesUp = ZY[i]-1;
                tesDown = ZY[i]+1;
                tesRight = ZX[i]+1;
                tesLeft = ZX[i]-1;
                for(int j=0;j<10;j++){
                    if(i!=j){
                        if(ZY[j]==tesUp&&ZX[i]==ZX[j]){
                            valid=false;
                            break;
                        }
                    }
                }
                if(valid){
                    if(tesUp>0){
                        for(int p =0;p<3;p++){
                            if(troops[p].getY()!=tesUp&&ZX[i]!=troops[p].getX()){
                                can[0]=false;
                                break;
                            }
                        }
                    }
                    else{
                        can[0]=false;
                    }
                }
                else{
                    can[0]=false;
                }
                valid=true;
                for(int j=0;j<10;j++){
                    if(i!=j){
                        if(ZY[j]==tesDown&&ZX[i]==ZX[j]){
                            valid=false;
                            break;
                        }
                    }
                }
                if(valid){
                    if(tesDown<10){
                        for(int p =0;p<3;p++){
                            if(troops[p].getY()!=tesDown&&ZX[i]!=troops[p].getX()){
                                can[1]=false;
                                break;
                            }
                        }
                    }
                    else{
                        can[1]=false;
                    }
                }
                else{
                    can[1]=false;
                }
                valid=true;
                for(int j=0;j<10;j++){
                    if(i!=j){
                        if(ZX[j]==tesRight&&ZY[i]==ZY[j]){
                            valid=false;
                            break;
                        }
                    }
                }
                if(valid){
                    if(tesRight<10){
                        for(int p =0;p<3;p++){
                            if(troops[p].getX()!=tesRight&&ZY[i]!=troops[p].getY()){
                                can[2]=false;
                                break;
                            }
                        }
                    }
                    else{
                        can[2]=false;
                    }
                }
                else{
                    can[2]=false;
                }
                valid=true;
                for(int j=0;j<10;j++){
                    if(i!=j){
                        if(ZX[j]==tesLeft&&ZY[i]==ZY[j]){
                            valid=false;
                            break;
                        }
                    }
                }
                if(valid){
                    if(tesLeft>0){
                        for(int p =0;p<3;p++){
                            if(troops[p].getX()==tesLeft&&ZY[i]==troops[p].getY()){
                                can[3]=false;
                                break;
                            }
                        }
                    }
                    else{
                        can[3]=false;
                    }
                }
                else{
                    can[3]=false;
                }
                boolean move = false;
                for(int z = 0; z<4;z++){
                    if(can[z]==true){
                        move=true;
                    }
                }
                while(move){
                    int arah = r.nextInt(4);
                    if(can[arah]==true){
                        if(arah==0){
                            ZY[i]=tesUp;
                            move=false;
                        }
                        else if(arah==1){
                            ZY[i]=tesDown;
                            move=false;
                        }
                        else if(arah==2){
                            ZX[i]=tesRight;
                            move=false;
                        }
                        else if(arah==3){
                            ZX[i]=tesLeft;
                            move=false;
                        }
                    }
                }
            }
        }
    }
    
    public static void grenade(int[] ZX, int[] ZY, boolean[] mobcount,int[] score, Troop[] troops){
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
                for(int p = 0;p<10;p++){
                    if(ZX[p]==j&&ZY[p]==i){
                        mobcount[p]=false;
                        ZX[p]=20;
                        ZY[p]=20;
                        dead++;       
                        score[0]+=10;
                    }
                }
            }
        }
        int sp =troops[2].getSpecialbar();
        sp-=3;
        troops[2].setSpecialbar(sp);
        System.out.println("Heavy Mech threw a Grenade at "+coord+" "+dead+" zombies killed!");
    }
    
    public static void machinegun(Troop[] troops, int ZX[], int[] ZY, boolean[] mobcount, int[] score){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which direction would you like to shoot");
        System.out.println("(W). Up");
        System.out.println("(A). Left");
        System.out.println("(S). Down");
        System.out.println("(D). Right");
        String move = scan.nextLine();
        int posY = troops[2].getY();
        int posX = troops[2].getX();
        if(move.equals("w")||move.equals("W")){
            for(int j = 0;j<10;j++){
                for(int i = 1;i<posY;i++){
                    if(ZY[j]==i&&ZX[j]==posX){
                        mobcount[j]=false;
                        score[0]+=10;
                    }
                }
            }
        }
        else if(move.equals("a")||move.equals("A")){
            for(int j = 0;j<10;j++){
                for(int i = 1;i<posX;i++){
                    if(ZY[j]==posY&&ZX[j]==i){
                        mobcount[j]=false;
                        score[0]+=10;
                    }
                }
            }
        }
        else if(move.equals("s")||move.equals("S")){
            for(int j = 0;j<10;j++){
                for(int i = posY;i<10;i++){
                    if(ZY[j]==i&&ZX[j]==posX){
                        mobcount[j]=false;
                        score[0]+=10;
                    }
                }
            }
        }
        else if(move.equals("d")||move.equals("D")){
            for(int j = 0;j<10;j++){
                for(int i = posX;i<10;i++){
                    if(ZX[j]==i&&ZY[j]==posY){
                        mobcount[j]=false;
                        score[0]+=10;
                    }
                }
            }
        }
    }
    
    public static void attackZombie(Troop[] troops, int[] ZX, int[] ZY, boolean[] mobcount){
        int tesUp, tesDown, tesLeft, tesRight;
        int posX, posY, objHP;
        for(int i =0;i<10;i++){
            if(mobcount[i]==true){
                tesUp=ZY[i]-1;
                tesDown=ZY[i]+1;
                tesLeft=ZX[i]-1;
                tesRight=ZX[i]+1;
                for(int j =0;j<3;j++){
                    posX = troops[j].getX();
                    posY = troops[j].getY();
                    objHP = troops[j].getHealth();
                    if(posX==tesLeft&&posY==ZY[i]||posX==tesRight&&posY==ZY[i]||posY==tesUp&&posX==ZX[i]||posY==tesDown&&posX==ZX[i]){  
                        objHP--;
                        troops[j].setHealth(objHP);
                    }
                }
            }
        }
    }
    
    public static void cekMati(Troop[] troops, boolean[] alive){
        for(int i =0;i<3;i++){
            int hp = troops[i].getHealth();
            if(hp<=0){
                alive[i]=false;
                System.out.println(troops[i].getName()+" mati.");
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] arena = new char[11][11];
        Troop[] troops = new Troop[3];
        boolean alive[] = new boolean[3];
        int koordX[] = new int[3];
        int koordY[] = new int[3];
        int ZX[] = new int [10];
        int ZY[] = new int [10];
        int[] score = new int[1];
        troops[0] = new Troop("Support Unit", 5, 5, 'S', 5, 6, 5);
        troops[1] = new Troop("Assault Trooper", 3, 5, 'A', 4, 5, 3);
        troops[2] = new Troop("Heavy Mech",4, 5, 'H', 6,5, 3);
        int scoreamount = 0;
        Highscore[] highscore = new Highscore[5];
        int turn = 1;
        boolean extracting = false;
        int extracted = 0;
        boolean mobcount[] = new boolean[10];
        Random r = new Random();
        Scanner scanLine = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int dex = 0;
        for(int i =0;i<3;i++){
            koordY[i] = troops[i].getY();
        }
        for(int i =0;i<3;i++){
            koordX[i] = troops[i].getX();
        }
        isiarena(arena);
        boolean run = true;
        int pil;
        while(run){
            menu();
            pil=scan.nextInt();
            if(pil==0){
                run=false;
            }
            else if(pil==1){
                boolean game = true;
                boolean initiate = true;
                while (game){
                    if(initiate){
                        score[0] = 0;
                        spawn(ZX,ZY,mobcount);
                        for(int i =0;i<3;i++){
                            alive[i]=true;
                        }
                        troops[0] = new Troop("Support Unit", 5, 5, 'S', 5, 6, 5);
                        troops[1] = new Troop("Assault Trooper", 3, 5, 'A', 4, 5, 3);
                        troops[2] = new Troop("Heavy Mech",4, 5, 'H', 6,5, 3);
                        turn = 1;
                        extracting = false;
                        extracted = 0;
                        initiate =false;
                    }
                    for(int giliran=0;giliran<3;giliran++){
                        if(alive[giliran]==true){
                            if(extracting==true){
                                System.out.println("Extraction in "+(extracted-turn)+" turns");
                            }
                            if(extracting==true&&extracted==turn){
                                game=false;
                                System.out.println("Successfully Extracted Squad!");
                                for(int i =0;i<10;i++){
                                    mobcount[i]=false;
                                }
                                break;
                            }
                            printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                            printaction(troops,giliran);
                            boolean[] commence = new boolean[1];
                            int pilmove = scan.nextInt();
                            if(pilmove==1){
                                for(int i =0;i<10;i++){
                                    printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                    System.out.println(troops[giliran].getName());
                                    printmove();
                                    String direction = scan.nextLine();
                                    if(direction.equals("w")||direction.equals("W")){
                                        int sumbuY = troops[giliran].getY();
                                        int sumbuX = troops[giliran].getX();
                                        int tryUp = goUp(sumbuX,sumbuY, ZY, ZX,troops);
                                        if(tryUp==sumbuY){
                                            i--;
                                            System.out.println("Invalid move!");
                                        }
                                        else{
                                            troops[giliran].setY(tryUp);
                                            koordY[giliran]=tryUp;
                                        }
                                    }
                                    else if(direction.equals("a")||direction.equals("A")){
                                        int sumbuY = troops[giliran].getY();
                                        int sumbuX = troops[giliran].getX();
                                        int tryLeft = goLeft(sumbuX,sumbuY, ZY, ZX,troops);
                                        if(tryLeft==sumbuX){
                                            i--;
                                            System.out.println("Invalid move!");
                                        }
                                        else{
                                            troops[giliran].setX(tryLeft);
                                            koordX[giliran]=tryLeft;
                                        }
                                    }
                                    else if(direction.equals("s")||direction.equals("S")){
                                        int sumbuY = troops[giliran].getY();
                                        int sumbuX = troops[giliran].getX();
                                        int tryDown = goDown(sumbuX,sumbuY, ZY, ZX,troops);
                                        if(tryDown==sumbuY){
                                            i--;
                                            System.out.println("Invalid move!");
                                        }
                                        else{
                                            troops[giliran].setY(tryDown);
                                            koordY[giliran]=tryDown;
                                        }
                                    }
                                    else if(direction.equals("D")||direction.equals("d")){
                                        int sumbuY = troops[giliran].getY();
                                        int sumbuX = troops[giliran].getX();
                                        int tryRight = goRight(sumbuX,sumbuY, ZY, ZX,troops);
                                        if(tryRight==sumbuX){
                                            i--;
                                            System.out.println("Invalid move!");
                                        }
                                        else{
                                            troops[giliran].setX(tryRight);
                                            koordX[giliran]=tryRight;
                                        }
                                    }
                                    else if(direction.equals("hold")){
                                        break;
                                    }
                                    else{
                                        System.out.println("Invalid move!");
                                        i--;
                                    }
                                }
                                printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                System.out.println("1. Attack");
                                System.out.println("2. Special 1");
                                System.out.println("3. Special 2");
                                System.out.println("5. Call for Extraction");
                                System.out.print(">>");
                                int aftermove = scan.nextInt();
                                if(aftermove==1){
                                    printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                    commence[0]=true;
                                    while(commence[0]){
                                        System.out.println("Enter the coordinate of the zombie that you want to attack!");
                                        System.out.print(">>");
                                        attack(mobcount, ZX,ZY,score,giliran,troops,commence); 
                                    }    
                                }
                                else if(aftermove==2){
                                    if(troops[giliran].getSpecialbar()>=3){
                                        printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                        if(giliran==0){
                                            Heal(troops);
                                        }
                                        else if(giliran==1){
                                            faceoff(troops,ZX,ZY,mobcount,score);
//                                            printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                        }
                                        else if(giliran==2){
                                            grenade(ZX,ZY,mobcount, score,troops);
//                                            printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                        }
                                    }
                                    else{
                                        System.out.println("Not enough special points! Turn wasted!");
                                    }
                                    printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                }
                                else if(aftermove==3){
                                    if(troops[giliran].getSpecialbar()>=3){
                                        if(giliran==0){
                                            encourage(troops);
                                        }
                                        else if(giliran==1){
                                            for(int i =0;i<3;i++){
                                                System.out.println("Enter the coordinate of the zombie that you want to attack!");
                                                System.out.print(">>");
                                                attack(mobcount, ZX,ZY,score,giliran,troops,commence);

                                            }
                                            System.out.println("Assault Trooper Used Advance Targetting, 3 Zombies killed.");
                                        }
                                        else if(giliran==2){
                                            machinegun(troops,ZX,ZY,mobcount,score);
                                        }
                                    }
                                    else{
                                        System.out.println("Not enough special points! Turn wasted!");
                                    }
                                }
                                else if(aftermove==5&&extracting==false){
                                    System.out.println("Extraction Requested!");
                                    System.out.println("Extraction in 3 turns");
                                    extracting = true;
                                    extracted = turn+3;
                                }
                                else if(aftermove==88){
                                    for(int i =0;i<10;i++){
                                        if(mobcount[i]==true){
                                            score[0]+=10;
                                            System.out.println("Cheat2 activated.");
                                            mobcount[i]=false;
                                            ZX[i]=20;
                                            ZY[i]=20;
                                            if(troops[giliran].getSpecialbar()<5){
                                                int specialamount = troops[giliran].getSpecialbar();
                                                specialamount++;
                                                troops[giliran].setSpecialbar(specialamount);
                                            }
                                            printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                        }
                                    }
                                }
                                else if(aftermove==99){
                                    for(int i =0;i<3;i++){
                                        int maxhp = troops[i].getMaxhealth();
                                        if(alive[i]==true){
                                            troops[i].setHealth(maxhp);
                                        }
                                    }
                                }
                                else{
                                    System.out.println("Invalid move!");
                                }
                            }
                            else if(pilmove==2){
                                commence[0]=true;
                                while(commence[0]){
                                    System.out.println("Enter the coordinate of the zombie that you want to attack!");
                                    System.out.print(">>");
                                    attack(mobcount, ZX,ZY,score,giliran,troops,commence); 
                                }
                            }
                            else if(pilmove==3){
                                if(troops[giliran].getSpecialbar()>=3){
                                    if(giliran==0){
                                        Heal(troops);
                                    }
                                    else if(giliran==1){
                                        faceoff(troops,ZX,ZY,mobcount,score);
                                        printmap(arena,alive,koordX,koordY,ZX,ZY,mobcount,turn,score);
                                    }
                                    else if(giliran==2){
                                        grenade(ZX,ZY,mobcount, score,troops);
                                    }
                                }
                                else{
                                    System.out.println("Not enough special points");
                                    giliran--;
                                }
                            }
                            else if(pilmove==4){
                                if(troops[giliran].getSpecialbar()>=3){
                                    if(giliran==0){
                                        encourage(troops);
                                    }
                                    else if(giliran==1){
                                        for(int i =0;i<3;i++){
                                            
                                            System.out.println("Enter the coordinate of the zombie that you want to attack!");
                                            System.out.print(">>");
                                            attack(mobcount, ZX,ZY,score,giliran,troops,commence);
                                            int bar = troops[giliran].getSpecialbar();
                                            bar-=2;
                                            troops[giliran].setSpecialbar(bar);
                                        }
                                        System.out.println("Assault Trooper Used Advance Targetting, 3 Zombies killed.");
                                    }
                                    else if(giliran==2){
                                        machinegun(troops,ZX,ZY,mobcount,score);
                                    }
                                }
                                else{
                                    System.out.println("Not enough special points");
                                    giliran--;
                                }
                            }
                            else if(pilmove==99){
                                for(int i =0;i<3;i++){
                                    int maxhp = troops[i].getMaxhealth();
                                    if(alive[i]==true){
                                        troops[i].setHealth(maxhp);
                                    }
                                }
                            }
                            else if(pilmove==88){
                                for(int i =0;i<10;i++){
                                    if(mobcount[i]==true){
                                        score[0]+=10;
                                        System.out.println("Cheat2 activated.");
                                        mobcount[i]=false;
                                        ZX[i]=20;
                                        ZY[i]=20;
                                        if(troops[giliran].getSpecialbar()<5){
                                            int specialamount = troops[giliran].getSpecialbar();
                                            specialamount++;
                                            troops[giliran].setSpecialbar(specialamount);
                                        }
                                    }
                                }
                            }
                            else if(pilmove==5&&extracting==false){
                                System.out.println("Extraction Requested!");
                                System.out.println("Extraction in 3 turns");
                                extracting = true;
                                extracted = turn+3;
                            }
                            else{
                                System.out.println("Invalid move!");
                                giliran--;
                            }
                        } 
                    }
                    if(alive[0]==false&&alive[1]==false&&alive[2]==false){
                        game=false;
                    }
                    moveZombie(troops,ZX,ZY,mobcount);
                    attackZombie(troops,ZX,ZY,mobcount);
                    cekMati(troops,alive);
                    spawn(ZX,ZY,mobcount);
                    turn++;
                }
                String highname;
                String temp;
                int temp2;
                if(extracting==true){
                    if(scoreamount<5){
                        System.out.println("You're in the highscore!");
                        System.out.print("Please enter your name : ");
                        highname = scanLine.nextLine();
                        highscore[scoreamount]= new Highscore(score[0],highname);
                        scoreamount++;
                        if(scoreamount>1){
                            for(int i =0;i<scoreamount;i++){
                                for(int j=i+1;j<scoreamount;j++){
                                    if(highscore[i].getScore()<highscore[j].getScore()){
                                        temp2 = highscore[i].getScore();
                                        temp = highscore[i].getNama();
                                        highscore[i].setScore(highscore[j].getScore());
                                        highscore[i].setNama(highscore[j].getNama());
                                        highscore[j].setScore(temp2);
                                        highscore[j].setNama(temp);
                                    }
                                }
                            }
                        }
                    }
                    else{
                        if(highscore[4].getScore()<score[0]){
                            System.out.println("You're in the highscore!");
                            System.out.print("Please enter your name : ");
                            highname = scanLine.nextLine();
                            highscore[4].setNama(highname);
                            highscore[4].setScore(score[0]);
                            for(int i =0;i<5;i++){
                                for(int j=i+1;j<5;j++){
                                    if(highscore[i].getScore()<highscore[j].getScore()){
                                        temp2 = highscore[i].getScore();
                                        temp = highscore[i].getNama();
                                        highscore[i].setScore(highscore[j].getScore());
                                        highscore[i].setNama(highscore[j].getNama());
                                        highscore[j].setScore(temp2);
                                        highscore[j].setNama(temp);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if (pil==2){
                System.out.println("====================");
                System.out.println("|@----Highscore----@|");
                System.out.println("====================");
                for(int i =0;i<scoreamount;i++){
                    System.out.print(i+1);
                    System.out.print(". ");
                    String name = highscore[i].getNama();
                    int Score = highscore[i].getScore();
                    System.out.println(name+" - "+Score);
                }
                System.out.println("====================");
            }
        }
    }
    
}
