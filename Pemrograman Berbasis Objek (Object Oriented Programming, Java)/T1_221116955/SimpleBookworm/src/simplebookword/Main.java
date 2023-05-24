/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplebookword;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Frans
 */
public class Main {

    public static void mainmenu(){
        System.out.println("##################");
        System.out.println("#====BOOKWORM====#");
        System.out.println("##################");
        System.out.println("# 1. Play        #");
        System.out.println("# 2. Word List   #");
        System.out.println("# 3. Highscore   #");
        System.out.println("# 0. Exit        #");
        System.out.println("##################");
        System.out.println(">> ");
    }
    
    public static void listmenu(int count, String[] wordlist){
        System.out.println("#####################");
        System.out.println("#   ==Word List==   #");
        System.out.println("#####################");
        if (count==0){
            System.out.println("# Wordlist is empty #");
        }
        else{
            for (int i=0;i<count;i++){
                int z = i+1;
                String hasil;
                if(z<10){
                    hasil = String.format("#   %d"+". "+ ""+"%-13s#\n",z,wordlist[i]);
                }
                else{
                    hasil = String.format("#  %-2d"+". "+ ""+"%-13s#\n",z,wordlist[i]);
                }
                System.out.printf(hasil);
            }
        }
        System.out.println("#####################");
        System.out.println("#  99. Add new word #");
        System.out.println("#   0. Back         #");
        System.out.println("#####################");
        System.out.println(">>");
    }
    
    public static void editmenu(int index, String[] wordlist){
        System.out.println("###################");
        System.out.println("#  ==Edit Word==  #");
        System.out.println("###################");
        String hasilformat = String.format("#  %-15s#",wordlist[index]);
        System.out.println(hasilformat);
        System.out.println("###################");
        System.out.println("#  1. Edit        #");
        System.out.println("#  2. Delete      #");
        System.out.println("#  0. Back        #");
        System.out.println("###################");
        System.out.println(">>");
    }
    
    public static void gamemenu(char[][] charsets,int enemycount, int hp, int enemyhp, int heal, String atk, int damage){
        int x = 0;
        System.out.println("#################################");
        String formating = String.format("# %-20s# DMG: %-2d #",atk.toUpperCase(),damage);
        System.out.println(formating);
        System.out.println("#################################");
        System.out.print("# Player | ");
        for(int y =0;y<4;y++){
            char t = Character.toUpperCase(charsets[x][y]);
            System.out.print(t);
            if(y<3){
                System.out.print("  ");
            }
            else{
                System.out.print(" ");
            }
        }
        x++;
        if(enemycount<10){
            System.out.println("| Enemy "+enemycount+" #");
        }
        else{
            System.out.println("| Enemy "+enemycount+"#");
        }
        String hasilformat = String.format("# HP: %-2d | ",hp);
        System.out.print(hasilformat);
        for(int y=0;y<4;y++){
            char t = Character.toUpperCase(charsets[x][y]);
            System.out.print(t);
            if(y<3){
                System.out.print("  ");
            }
            else{
                System.out.print(" ");
            }
        }
        x++;
        hasilformat = String.format("| HP: %-2d  # ",enemyhp);
        System.out.println(hasilformat);
        System.out.print("# Heal:"+heal+" | ");
        for(int y=0;y<4;y++){
            char t = Character.toUpperCase(charsets[x][y]);
            System.out.print(t);
            if(y<3){
                System.out.print("  ");
            }
            else{
                System.out.print(" ");
            }
        }
        x++;
        System.out.println("|         #");
        System.out.print("#        | ");
        for(int y=0;y<4;y++){
            char t = Character.toUpperCase(charsets[x][y]);
            System.out.print(t);
            if(y<3){
                System.out.print("  ");
            }
            else{
                System.out.print(" ");
            }
        }
        x++;
        System.out.println("|         #");
        System.out.println("#################################");
        System.out.print(">>");
    }
    
    public static void highscore(int scoreamount, int[] score, String[] record){
        System.out.println("######################");
        System.out.println("#==== High Score ====#");
        System.out.println("######################");
        String hasil="";
        if(scoreamount>0){
            for(int i =0;i<scoreamount;i++){
                int pos = i+1;
                if(pos<10){
                    hasil = String.format("# %d. %-9s - %3d #",pos,record[i],score[i]);;
                }
                else{
                    hasil = String.format("#%-2d. %-9s - %3d #",pos,record[i],score[i]);
                }
                System.out.println(hasil);
            }
            System.out.println("######################");
        }
        System.out.println("# 0. Exit            #");
        System.out.println("######################");
        System.out.print(">>");
    }
    
    
    public static void main(String[] args) {
       boolean run = true;
       Scanner sc = new Scanner(System.in);
       Scanner scan = new Scanner(System.in);
       int wordcount = 0;
       String[] wordlist;
       wordlist = new String[20];
       char [][] charsets;
       charsets = new char[4][4];
       Random r = new Random();
       boolean[][] terpakai=new boolean[4][4];
       boolean scramble;
       int enemycount=1;
       int hp=0;
       int enemyhp=0;
       int heal=0;
       int damage = 0;
       String atk ="";
       int enemyatk;
       boolean same=false;
       int[] score = new int[10];
       String[] record = new String[10];
       int scoreamount = 0;
       int totalscore = 0;
       int index = 0;
       boolean ditambah = false;
       while(run){
           mainmenu();
           int pil=sc.nextInt();
           if (pil==1 && wordcount==0){
               System.out.println("Wordlist masih kosong! Tidak dapat memulai permainan.");
           }
           else if(pil==1 && wordcount>0){
               boolean game = true;
               while(game){
                        boolean start = true;
                        boolean initialization = true;
                        scramble=true;
                        while(start){
                            if(initialization == true){
                                boolean arr [][] = new boolean[4][4];
                                for(int i =0;i<4;i++){
                                    for(int j=0;j<4;j++){
                                        arr[i][j]=true;
                                    }
                                }
                                terpakai = new boolean[4][4];
                                for(int i =0;i<4;i++){
                                    for(int j=0;j<4;j++){
                                        terpakai[i][j]=false;
                                    }
                                }
                                enemycount = 1;
                                initialization=false;
                                scramble=true;
                                hp = 20;
                                enemyhp = 20;
                                heal = 1;
                                damage = 0;
                            }
                            if(scramble==true){
                                int idxtaken = r.nextInt(wordcount);
                                String randomword = wordlist[idxtaken];
//                                System.out.println(randomword);
//                                Untuk test^ 
                                int len = 0;
                                for(int i =0;i<4;i++){
                                    for(int j=0;j<4;j++){
                                        if(len<randomword.length()){
                                            charsets[i][j]=randomword.charAt(len);
                                            len++;
                                        }
                                        else{
                                            charsets[i][j]=(char)(r.nextInt(26)+'a');
                                        }
                                    }
                                }
                                for(int i=0;i<100;i++){
                                    for(int j=0;j<100;j++){
                                        int randomx = r.nextInt(4);
                                        int randomy = r.nextInt(4);
                                        char container = charsets[randomx][randomy];
                                        charsets[randomx][randomy]=charsets[randomy][randomx];
                                        charsets[randomy][randomx]=container;
                                    }
                                }
                                for(int i =0;i<4;i++){
                                    for(int j=0;j<4;j++){
                                        terpakai[i][j]=false;
                                    }
                                }
                                scramble=false;
                            }
                            gamemenu(charsets,enemycount,hp,enemyhp,heal,atk,damage);
                            String input = scan.nextLine();
                            if(input.equals("cheat")){
                                hp=20;
                            }
                            else if(input.equals("scramble")){
                                scramble=true;
                                hp=hp-2;
                            }
                            else if(input.equals("heal")){
                                if(heal<1){
                                    System.out.println("No Heals");
                                }
                                else{
                                    if(hp==20){
                                    System.out.println("Can't heal! You're already at max HP");
                                    }
                                    else if(hp>10){
                                        int amount = 20-hp;
                                        hp=hp+amount;
                                        heal--;
                                    }
                                    else{
                                        hp+=10;
                                        heal--;
                                    }
                                }
                            }
                            else if(input.equals("attack")){
                                same =false;
                                for(int i =0;i<wordcount;i++){
                                    if(atk.equals(wordlist[i])){
                                        same=true;
                                    }
                                }
                                if(same==true){
                                    enemyhp-=damage;
                                    System.out.println("Player attack. Enemy take "+damage+" damage.");
                                    atk ="";
                                    damage =0;
                                    if(enemyhp>0){
                                        enemyatk = (int)Math.floor(Math.random()*(5-2+1)+2);
                                        hp-=enemyatk;
                                        System.out.println("Enemy attack. Player take "+enemyatk+" damage.");
                                    }
                                    else{
                                        System.out.println("Enemy died. Player move to the next level.");
                                        enemycount++;
                                        enemyhp=20;
                                        if(heal<3){
                                            heal++;
                                        }
                                    }
                                    for(int i =0;i<4;i++){
                                        for(int j=0;j<4;j++){
                                            if(terpakai[i][j]==true){
                                                charsets[i][j]=(char)(r.nextInt(26)+'a');
                                                terpakai[i][j]=false;
                                            }
                                        }
                                    }
                                }
                            }
                            else if(input.equals("clear")){
                                atk ="";
                                damage=0;
                                for(int i =0;i<4;i++){
                                    for(int j=0;j<4;j++){
                                        terpakai[i][j]=false;
                                    }
                                }
                            }
//                            else if(input.equals("test")){
//                                enemycount++;
//                            }
//                            else if(input.equals("test2")){
//                                hp=2;
//                            }
//                            ^ Untuk test.
                            else{
                                int posx = Character.getNumericValue(input.charAt(2));
                                int posy = Character.getNumericValue(input.charAt(0));
                                if(posx<4 && posy<4){
                                    if(terpakai[posx][posy]==false){
                                        char c = charsets[posx][posy];
                                        atk = atk+c;
                                        terpakai[posx][posy]=true;
                                        if(c=='z'||c=='x'||c=='q'){
                                            damage+=5;
                                        }
                                        else if(c=='a'||c=='i'||c=='u'||c=='e'||c=='o'){
                                            damage+=1;
                                        }
                                        else{
                                            damage+=2;
                                        }
                                    }
                                    else{
                                        System.out.println("Huruf Sudah terpakai");
                                    }
                                }
                                else{
                                    System.out.println("Invalid Input!");
                                }
                            }
                            if(hp<1){
                                game=false;
                                start=false;
                                enemycount--;
                                totalscore=enemycount;
                                System.out.println("You died. You got through "+totalscore+" levels");
                            }
                            
                    }
               }
               if(scoreamount==0 && totalscore!=0){
                   System.out.println("You got into the highscore.");
                   System.out.println("Please input your name:");
                   record[0] = scan.nextLine();
                   score[0]=totalscore;
                   scoreamount++;
               }
               else{
                   boolean cekscore = false;
                   for(int i =0;i<10;i++){
                       if(score[i]<totalscore){
                          cekscore=true;
                       }
                   }
                   if(cekscore==true){
                       String tempname;
                       System.out.println("You got into the highscore.");
                       System.out.println("Please input your name:");
                       tempname = scan.nextLine();
                       if(scoreamount<10){
                           score[scoreamount]=totalscore;
                           record[scoreamount]=tempname;
                           scoreamount++;
                       }
                       else{
                           score[scoreamount-1]=totalscore;
                           record[scoreamount-1]=tempname;
                       }
                       for (int i = 0; i < 10; i++) {
                           for (int j = i+1; j < 10; j++) {
                               if(score[i] < score[j]){
                                    int temp1 = score[i];
                                    String temp2 = record[i];
                                    score[i] = score[j];
                                    record[i] = record[j];
                                    score[j] = temp1;
                                    record[j] = temp2;
                                }
                            }
                       }
                   }
               }
            }
           else if(pil==2){
               boolean menulist = true;
               while(menulist){
                    listmenu(wordcount, wordlist);
                    int pillist = sc.nextInt();
                    if(pillist==99){
                        System.out.println("New Word :");
                        String newword = scan.nextLine();
                        boolean cekkata = true;
                        if(newword.length()>18){
                            System.out.println("Kata terlalu panjang!");
                        }
                        else if(wordcount>=20){
                            System.out.println("Wordlist Sudah Penuh!");
                        }
                        else{
                            for(int i = 0;i<newword.length();i++){
                                char z = newword.charAt(i);
                                int ascii = (int)z;
                                if(ascii<65 || ascii>90 && ascii<97 || ascii>122){
                                    cekkata = false;
                                }
                            }
                            if(cekkata==true){
                                wordlist[wordcount]=newword.toLowerCase();
                                wordcount++;
                            }
                            else{
                                System.out.println("Kata baru invalid (mengandung special characters)");
                            }
                        }
                    }
                    else if (pillist==0){
                        menulist = false;
                    }
                    else{
                        int chooseword = pillist-1;
                        if (chooseword<wordcount){
                            boolean ngedit = true;
                            while(ngedit){
                                editmenu(chooseword,wordlist);
                                int piledit = sc.nextInt();
                                if(piledit==1){
                                    System.out.println("Kata Baru :");
                                    String editword = scan.nextLine();
                                    if(editword.length()>18){
                                        System.out.println("Kata terlalu panjang!");
                                    }
                                    else{
                                        boolean cekedit = true;
                                        for(int i = 0;i<editword.length();i++){
                                            char m = editword.charAt(i);
                                            int ascii2 = (int)m;
                                            if(ascii2<65 || ascii2>90 && ascii2<97 || ascii2>122){
                                                cekedit=false;
                                            }
                                        }
                                        if(cekedit==true){
                                            wordlist[chooseword]=editword;
                                        }
                                        else{
                                            System.out.println("Kata baru invalid (mengandung special characters)");
                                        }
                                    }
                                    ngedit=false;
                                }
                                else if (piledit==2){
                                    for(int i = chooseword; i<wordcount;i++){
                                        wordlist[i]=wordlist[i+1];
                                    }
                                    wordcount--;
                                    ngedit=false;
                                }
                                else if (piledit==0){
                                    ngedit = false;
                                }
                            }
                        }
                    }
               }
           }
           else if (pil==3){
               boolean checkhighscore = true;
               while(checkhighscore){
                   highscore(scoreamount,score,record);
                   int p=sc.nextInt();
                   if(p==0){
                       checkhighscore=false;
                   }
               }
           }
           else if (pil==0){
               run=false;
           }
       }
    }
    
}
