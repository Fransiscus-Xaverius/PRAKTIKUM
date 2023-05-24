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
public class PUBGCOACH extends coach{

    private Scanner scInt = new Scanner(System.in);
    private int boost;
    
    public PUBGCOACH(String name) {
        super(name);
    }
    
    public void setBoost(){
        boolean chooseboost = true;
        while(chooseboost){
            System.out.println("Select Boost");
            System.out.println("1. Aim");
            System.out.println("2. Communication");
            System.out.println("3. Luck");
            System.out.print(">>");
            int pilboost = scInt.nextInt();
            if(pilboost==1||pilboost==2||pilboost==3){
                this.boost = pilboost;
                chooseboost=false;
            }
            else{
                System.out.println("Invalid command!");
            }
        }
    }
    
}
