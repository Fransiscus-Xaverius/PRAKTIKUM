/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;
import java.util.Scanner;
/**
 *
 * @author Frans
 */
public class VALCOACH extends coach{

    private int boost;
    private Scanner scInt = new Scanner(System.in);
    
    public VALCOACH(String name) {
        super(name);
        this.boost=0;
    }
    
    public void setBoost(){
        boolean chooseboost = true;
        while(chooseboost){
            System.out.println("Select Boost");
            System.out.println("1. Aim");
            System.out.println("2. Communication");
            System.out.print(">>");
            int pilboost = scInt.nextInt();
            if(pilboost==1||pilboost==2){
                this.boost = pilboost;
                chooseboost=false;
            }
            else{
                System.out.println("Invalid command!");
            }
        }
        
    }

    public int getBoost() {
        return boost;
    }
    
    

}
