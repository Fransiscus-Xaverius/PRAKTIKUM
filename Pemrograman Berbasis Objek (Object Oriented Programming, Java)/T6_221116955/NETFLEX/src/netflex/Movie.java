/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netflex;
import java.util.ArrayList;
/**
 *
 * @author Frans
 */
public class Movie extends Type implements ShitTodo{

    private String desc;
    private float rating;
    private String genre;

    public Movie(String title, String desc) {
        super(title);
        this.desc = desc;
        this.rating = 0;
    }
    
    @Override
    public void EditRating(int x){
        if (this.rating==0){
            this.rating=x;
        }
        else{
            float p = this.rating+(float)x;
            p = p/2;
            this.rating=p;
        }
    }
    
    public boolean SearchGenre(String x){
        if(x.equals(this.genre)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getGenre(){
        return this.genre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public void seeDesc(){
        System.out.println("Nama Movie : "+this.title);
        System.out.println("Deskripsi : "+this.desc);
        System.out.println("Category : "+this.genre);
        System.out.println("AVG Rating : "+this.rating);
    }
    
    @Override
    public void AddShit(Movie e, String x){
        
    }

    @Override
    public void addGenre(String x) {
        this.genre=x;
    }
}
