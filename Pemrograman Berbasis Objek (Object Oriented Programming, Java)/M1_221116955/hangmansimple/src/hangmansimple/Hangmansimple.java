/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangmansimple;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Frans
 */
public class Hangmansimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean running = true;
        int pil;
        int diff=0;
        String playername;
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Random r = new Random();
        String[] dict1 = {
                "wifi",
                "java",
                "water",
                "glass",
                "chair",
                "bicycle",
                "train",
                "kitchen",
                "bread",
                "bird"
        };
        String[] dict2 = {
                "network",
                "webcam",
                "client",
                "library",
                "integer",
                "terminal",
                "server",
                "scanner",
                "phyton",
                "webpage"
        };
        String[] dict3 = {
                "keyboard",
                "breadcrumb",
                "database",
                "algorithm",
                "framework",
                "procedure",
                "function",
                "directory",
                "virtualization",
                "compiler"
        };
        int wordke = 1;
                        int life = 10;
                        int b[];
                        int score =0;
                        String word = "";
                        boolean check[] = new boolean[20];
        while(running){
            System.out.println("=== HANGMAN ===");
            System.out.println("1. Play");
            System.out.println("2. HighScore");
            System.out.println("0. Exit");
            System.out.print(">>");
            pil = sc.nextInt();
            if(pil==1){
                System.out.print("Input name:");
                playername = sc2.nextLine();
                while(diff<1||diff>3){ 
                    System.out.println("CHOOSE DIFFICULITY");
                    System.out.println("1. ez");
                    System.out.println("2. Normal");
                    System.out.println("3. HANG ME");
                    System.out.print(">>");
                    diff=sc.nextInt();
                }
                boolean game = true;
                boolean inisiasi = true;
                
                while(game){
                    if(inisiasi=true){
                        wordke = 1;
                        life = 10;
                        score =0;
                        if(diff==1){
                            int index = r.nextInt(dict1.length);
                            word = dict1[index];
                            int p = word.length();
                            check = new boolean[p];
                            for(int i = 0; i<2;i++){
                                check[i]=false;
                            }
                            for(int i=0;i<word.length();i++){
                                int j = r.nextInt(word.length());
                                boolean temp=check[i];
                                check[i]=check[j];
                                check[j]=check[i];
                            }
                            inisiasi=false;
                        }
                        else if(diff==2){
                            int index = r.nextInt(dict2.length);
                            word = dict2[index];
                            int p = word.length();
                            check = new boolean[p];
                            for(int i = 0; i<4;i++){
                                check[i]=false;
                            }
                            for(int i=0;i<word.length();i++){
                                int j = r.nextInt(word.length());
                                boolean temp=check[i];
                                check[i]=check[j];
                                check[j]=check[i];
                            }
                            inisiasi=false;
                        }
                        else if (diff==3){
                            int index = r.nextInt(dict3.length);
                            word = dict3[index];
                            int p = word.length();
                            check = new boolean[p];
                            for(int i = 0; i<6;i++){
                                check[i]=false;
                            }
                            for(int i=0;i<word.length();i++){
                                int j = r.nextInt(word.length());
                                boolean temp=check[i];
                                check[i]=check[j];
                                check[j]=check[i];
                            }
                            inisiasi=false;
                        }
                        
                    }
                    System.out.print("WORD ");
                    System.out.println(wordke);
                    System.out.print("Score :");
                    System.out.println(score);
                    System.out.println("Life :");
                    System.out.println(life);
                    for(int i =0;i<word.length();i++){
                        if(!check[i]){
                            System.out.print("_");
                        }
                        else{
                            System.out.print(word.charAt(i));
                        }
                    }
                    System.out.print("Guess:");
                    char ans = sc2.next().charAt(0);
                    boolean tf=false;
                    for(int i=0;i<word.length();i++){
                        if(ans==word.charAt(i)){
                            tf = true;
                            System.out.println("Correct guess");
                            check[i]=true;
                        }
                        else{
                            life--;
                        }
                    }
                    
                }
                
            }
            else if(pil==2){
                
            }
            else if(pil==0){
                running = false;
            }
        }
    }
    
}
