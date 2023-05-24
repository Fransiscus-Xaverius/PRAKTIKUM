/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m5;
import java.util.Scanner;

/**
 *
 * @author Frans
 */
public class M5 {

    public static void menuEditor(){
        System.out.println("1. Add text");
        System.out.println("2. Select text");
        System.out.println("3. Change Text Color");
        System.out.println("4. Change BG Color");
        System.out.println("5. Select tool");
        System.out.println("6. Use Tool ");
    }
    
    public static void ToolMenu(){
        System.out.println("Tools");
        System.out.println("1. Delete Text");
        System.out.println("2. Cut Text");
        System.out.println("3. Copy Text");
        System.out.println("4. Paste Text");
        System.out.println("0. None");
        System.out.print(">>");
    }
    
    public static void ColorTool(){
        System.out.println("Text Color");
        System.out.println("1. Red");
        System.out.println("2. Green");
        System.out.println("3. Blue");
        System.out.println("4. Yellow");
        System.out.println("5. Purple");
        System.out.println("6. Cyan");
        System.out.println("7. White");
        System.out.println("8. Black");
        System.out.println("0. Default");
    }
    
    public static void main(String[] args) {
        boolean run = true;
        String CurrentText="";
        String SelectedText="";
        String newText="";
        String copas="";
        int start = -1;
        int end = -1;
        int pasteOrCopy=0;
        Scanner scInt= new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        Tool paste = new Paste("Paste Text");
        Tool copy = new Copy("Copy Text");
        Tool delete = new Delete("Delete Text");
        Tool cut = new Cut("Cut Text");
        Tool none = new Tool("None");
        Tool CurrentTool = new Tool("None");
        while(run){
            if(CurrentText.equals("")){
                System.out.println("<TEXTAREA>");
            }
            else{
                System.out.println(CurrentText);
            }
            System.out.println("---------------------");
            System.out.println("Selected Text: "+SelectedText);
            System.out.println("Selected Tool: "+CurrentTool.getName());
            System.out.println("Text Color: ");
            System.out.println("BG Color: ");
            System.out.println("Clipboard: ");
            System.out.println(copas);
            System.out.println("---------------------");
            menuEditor();
            System.out.print(">>");
            int pileditor = scInt.nextInt();
            if(pileditor==1){
                System.out.print("Enter new text :");
                newText = scStr.nextLine();
                if(CurrentText.equals("")){
                    CurrentText=newText;
                }
                else{
                    CurrentText= CurrentText+" "+newText;
                }
            }
            else if(pileditor==2){
                System.out.print("Enter Starting char :");
                start = scInt.nextInt();
                System.out.print("Enter Ending char :");
                end = scInt.nextInt();
                if(end>CurrentText.length()){
                    System.out.println("Invalid index!");
                }
                else if(start<0){
                    System.out.println("Invalid index!");
                }
                else if(CurrentText.equals("")){
                    System.out.println("there are no input text yet.");
                }
                else{
                    SelectedText=CurrentText.substring(start, end+1);
                }
            }
            else if(pileditor==3){
                
            }
            else if(pileditor==4){
                
            }
            else if(pileditor==5){
                ToolMenu();
                int pilTool = scInt.nextInt();
                if(pilTool==1){
                    CurrentTool.setName(delete.getName());
                }
                else if (pilTool==2){
                    CurrentTool.setName(cut.getName());
                }
                else if (pilTool==3){
                    CurrentTool.setName(copy.getName());
                }
                else if (pilTool==4){
                    CurrentTool.setName(paste.getName());
                }
                else if (pilTool==0){
                    CurrentTool.setName(none.getName());
                }
            }
            else if(pileditor==6){
                if(CurrentTool.getName().equals(delete.getName())){
                   if(start!=-1&&end!=-1){
                        String newString = delete.doToolShit(CurrentText, start, end+1, copas);
                        CurrentText = newString;
                        SelectedText = "";
                   }
                   else{
                       System.out.println("Invalid use of Tool");
                   }
                }
                else if(CurrentTool.getName().equals(cut.getName())){
                    if(start!=-1&&end!=-1){
                        String newString = cut.doToolShit(CurrentText, start, end, copas);
                        CurrentText = newString;
                        SelectedText="";
                        pasteOrCopy=1;
                   }
                   else{
                       System.out.println("Invalid use of Tool");
                   }
                }
                else if(CurrentTool.getName().equals(copy.getName())){
                    copas = copy.doToolShit(CurrentText, start, end, copas);
                    pasteOrCopy=2;
                }
                else if(CurrentTool.getName().equals(paste.getName())){
                    if(pasteOrCopy==0){
                        System.out.println("Nothing on Clipboard");
                    }
                    else{
                        if(pasteOrCopy==1){
                            copas=cut.ReturnTool();
                            String hasil = paste.doToolShit(CurrentText, start, end, copas);
                            CurrentText=hasil;
                        }
                        else if(pasteOrCopy==2){
                            copas = copy.doToolShit(CurrentText, start, end, copas);
                            String hasil = paste.doToolShit(CurrentText, start, end, copas);
                            CurrentText=hasil;
                        }
                    }
                }
            }
        }
    }
    
}
