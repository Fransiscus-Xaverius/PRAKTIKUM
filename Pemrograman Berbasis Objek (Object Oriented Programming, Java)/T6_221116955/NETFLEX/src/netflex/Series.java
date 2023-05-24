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
public class Series extends Type implements ShitTodo{
    private String desc;
    private float rating;
    private ArrayList<Movie> episodeList = new ArrayList<Movie>();
    private ArrayList<String> genre = new ArrayList<String>();

    public Series(String title, String desc) {
        super(title);
        this.desc = desc;
        this.rating=0;
    }
    
    public boolean SearchGenre(String x){
        boolean exist = false;
        for(int i =0;i<genre.size();i++){
            if(x.equals(genre.get(i))){
                exist = true;
            }
        }
        return exist;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    
    

    public ArrayList<Movie> getEpisodeList() {
        return episodeList;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    } 

    public void setEpisodeList(ArrayList<Movie> episodeList) {
        this.episodeList = episodeList;
    }
    
    @Override
    public void seeDesc(){
        System.out.println(this.title);
        System.out.println("Description: "+this.desc);
        System.out.print("Category: ");
        for(int i =0;i<genre.size();i++){
            System.out.print(genre.get(i));
            if(i<(genre.size()-1)){
                System.out.print(", ");
            }
        }
        System.out.println("");
        System.out.println("AVG Rating : "+this.rating);
        System.out.println("Episodes:");
        for(int i =0;i<episodeList.size();i++){
            System.out.println((i+1)+". "+episodeList.get(i).getTitle());
        }
        System.out.println("99. Add episode");
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    @Override
    public void addGenre(String x){
        if(genre.size()==0){
            genre.add(x);
        }
        else{
            boolean duplicate = false;
            for(int i =0;i<genre.size();i++){
                String cek = genre.get(i);
                if(x.equals(cek)){
                    duplicate = true;
                }
            }
            if(!duplicate){
                genre.add(x);
            }
        }
    }
    
    public void addEp(Movie x){
        if(episodeList.size()==0){
            this.episodeList.add(x);
        }
        else{
            boolean duplicate = false;
            String b = x.getTitle();
            for(int i =0;i<this.episodeList.size();i++){
                String cek = this.episodeList.get(i).getTitle();
                if(b.equals(cek)){
                    duplicate = true;
                }
            }
            if(!duplicate){
                this.episodeList.add(x);
            }
        }
    }
    
    @Override
    public void AddShit(Movie a, String x){
        addEp(a);
        addGenre(x);
    }
    
}
