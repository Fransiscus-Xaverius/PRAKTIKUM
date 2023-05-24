/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netflex;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Frans
 */
public class Category extends Content implements ShitTodo,Comparable<Type>{
    private ArrayList<Type> contentOf = new ArrayList<Type>();

    public Category(String name) {
        super(name);
    }

    public ArrayList<Type> getContentOf() {
        return contentOf;
    }

    public void setContentOf(ArrayList<Type> contentOf) {
        this.contentOf = contentOf;
    }
    
    public void sortStuff(){
        for(int i =0;i<contentOf.size();i++){
            String a = contentOf.get(i).getTitle();
            for(int j =0;j<contentOf.size();i++){
                String b = contentOf.get(i).getTitle();
                if(b.charAt(0)>a.charAt(0)){
                    Collections.swap(contentOf, i, j);
                }
            }
        }
    }
    
    @Override
    public int compareTo(Type mov){
        Movie temp = (Movie) mov;
        String title = temp.getTitle();
        int stat = 1;
        for(int i =0;i<contentOf.size();i++){
            if(title.equals(contentOf.get(i).getTitle())){
                stat = 0;
            }
        }
        return stat;
    }
    
    @Override
    public void AddShit(Type x){
        int tryToAdd = compareTo(x);
        if(tryToAdd==1){
            contentOf.add(x);
            System.out.println("Added ("+x.getTitle()+") to ("+this.name+")");
        }
        else{
            System.out.println("Duplicate Entry, Failed to add content to "+this.name);
        }
    }
    
    @Override
    public void seeDesc(){
        for(int i =0;i<contentOf.size();i++){
            System.out.println((i+1)+". "+contentOf.get(i).getTitle());
        }
    }
}
