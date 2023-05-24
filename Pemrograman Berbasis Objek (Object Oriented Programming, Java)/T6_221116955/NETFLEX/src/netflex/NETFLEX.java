/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package netflex;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 *
 * @author Frans
 */
public class NETFLEX {

    public static void mainmenu(){
        System.out.println("## NETFLEX ##");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print(">>");
    }
    
    public static void AdminMenu(){
        System.out.println("## NETFLEX ##");
        System.out.println("1. Input New Category");
        System.out.println("2. Input New Movie");
        System.out.println("3. Input New Series");
        System.out.println("4. Edit Series");
        System.out.println("5. List Catalogue");
        System.out.println("0. Log Out");
        System.out.print(">>");
    }
    
    public static void UserMenu(User user){
        System.out.println("## NETFLEX ##");
        System.out.println("Welcome, "+user.getUsername());
        System.out.println("1. Browse category");
        System.out.println("2. Search");
        System.out.println("3. Watchlist");
        System.out.println("4. View watch history");
        System.out.println("0. Log Out");
        System.out.print(">>");
    }
    
    public static User getUser(ArrayList<User> listUser, String username){
        User dummy = new User("Dummy","Dummy");
        for(int i =0;i<listUser.size();i++){
            if(username.equals(listUser.get(i).getUsername())){
                return listUser.get(i);
            }
        }
        return dummy;
    }
    
    public static boolean checkDoubleCategory(ArrayList<Content> ContentList, String newCat){
        boolean duplicate = false;
        for(int i =0;i<ContentList.size();i++){
            String checkName = ContentList.get(i).getName();
            if(checkName.equals(newCat)){
                duplicate = true;
            }
        }
        return duplicate;
    }
    
    public static void AddCategory(ArrayList<Content> ContentList){
        int sizeOf = ContentList.size();
        Scanner sc = new Scanner(System.in);
        Scanner sInt = new Scanner(System.in);
        System.out.print("Enter new Category name : ");
        String newCat = sc.nextLine();
        if(sizeOf==0){
            ContentList.add(new Category(newCat));
        }
        else{
            boolean Check = checkDoubleCategory(ContentList,newCat);
            if(Check){
                System.out.println("Duplicate Category, cant add new Category.");
            }
            else{
                ContentList.add(new Category(newCat));
            }
        }
    }
    
    public static boolean kembar(ArrayList<User> listUser, String username){
        boolean state = false;
        for(int i =0;i<listUser.size();i++){
            String u = listUser.get(i).getUsername();
            if(u.equals(username)){
                state = true;
            }
        }
        return state;
    }
    
    public static void Register(ArrayList<User> listUser){
        Scanner sc = new Scanner(System.in);
        System.out.println("Register");
        System.out.print("Enter Username : ");
        String regUser = sc.nextLine();
        System.out.print("Enter Password : ");
        String regPass = sc.nextLine();
        System.out.print("Confirm your Password : ");
        String confirm = sc.nextLine();
        if(confirm.equals(regPass)){
            boolean alrUsed = kembar(listUser,regUser);
            if(!alrUsed){
                listUser.add(new User(regUser,regPass));
                System.out.println("Successfully created an account with the username "+regUser);
            }
            else{
                System.out.println("Username is already in use.");
            }
        }
        else{
            System.out.println("Password mismatch!");
        }
    }
    
    public static boolean credentials(ArrayList<User> listUser, String username, String password){
        boolean match = false;
        for(int i =0;i<listUser.size();i++){
            String u = listUser.get(i).getUsername();
            String p = listUser.get(i).getPassword();
            if(u.equals(username)&&p.equals(password)){
                match=true;
            }
        }
        return match;
    }
    
    public static void seeAllSeries(ArrayList<Series> allSeries){
        for(int i =0;i<allSeries.size();i++){
            System.out.println((i+1)+". "+allSeries.get(i).getTitle());
        }
        System.out.println("0.Cancel");
        System.out.print(">>");
    }
    
    public static boolean Duplicate(ArrayList<Series> allSeries, String x){
        boolean dupe = false;
        for(int i =0;i<allSeries.size();i++){
            String y = allSeries.get(i).getTitle();
            if(x.equals(y)){
                dupe=true;
            }
        }
        return dupe;
    }
    
    public static void BrowseCategory(ArrayList<Content> ContentList){
        System.out.println("Browse Category ");
        for(int i =0;i<ContentList.size();i++){
            System.out.println((i+1)+". "+ContentList.get(i).getName());
        }
        System.out.print(">>");
    }
    
    public static void main(String[] args) {
        boolean run = true;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<Content> ContentList = new ArrayList<Content>();
        ArrayList<Series> allSeries = new ArrayList<Series>();
        ArrayList<Movie> allMovie = new ArrayList<Movie>();
        while(run){
            mainmenu();
            int pil = scInt.nextInt();
            if(pil==1){
                System.out.print("Username : ");
                String logUser = scStr.nextLine();
                System.out.print("Password : ");
                String logPass = scStr.nextLine();
                if(logUser.equalsIgnoreCase("admin")&&logPass.equalsIgnoreCase("admin")){
                    boolean LogAsAdmin = true;
                    while(LogAsAdmin){
                        AdminMenu();
                        int pilAdmin = scInt.nextInt();
                        if(pilAdmin==1){
                            AddCategory(ContentList);
                        }
                        else if (pilAdmin==2){
                            if(ContentList.size()==0){
                                System.out.println("There are currently no categories that are registered to the system. Please add a category first before adding a new movie.");
                            }
                            else{
                                System.out.print("Enter new Movie Title : ");
                                String newTitle = scStr.nextLine();
                                System.out.print("Enter new Movie Description:");
                                String newDesc = scStr.nextLine();
                                for(int i =0;i<ContentList.size();i++){
                                    System.out.println((i+1)+". "+ContentList.get(i).getName());
                                }
                                System.out.print(">>");
                                int pil_genre = scInt.nextInt();
                                pil_genre = pil_genre-1;
                                if(pil_genre<0||pil_genre>(ContentList.size()-1)){
                                    System.out.println("Invalid Index! failed to add new Movie..");
                                }
                                else{
                                    Movie NewContainer = new Movie(newTitle,newDesc);
                                    String genre = ContentList.get(pil_genre).getName();
                                    NewContainer.addGenre(genre);
                                    System.out.println(genre);
                                    ContentList.get(pil_genre).AddShit(NewContainer);
                                    boolean AlreadyIn = false;
                                    for(int i =0;i<allMovie.size();i++){
                                        String a = allMovie.get(i).getTitle();
                                        if(a.equals(newTitle)){
                                            AlreadyIn = true;
                                        }
                                        else{
                                        }
                                    }
                                    if(!AlreadyIn){
                                        allMovie.add(NewContainer);
                                    }
                                }
                            }
                        }
                        else if (pilAdmin==3){
                            if(allMovie.size()==0){
                                System.out.println("There are no registered Movies to be added as Episodes on the Series. Please add a Movie before creating a Series.");
                            }
                            else{
                                System.out.print("Series name: ");
                                String newTitle = scStr.nextLine();
                                System.out.print("Description: ");
                                String newDesc = scStr.nextLine();
                                System.out.println("Episodes: ");
                                for(int i =0;i<allMovie.size();i++){
                                    System.out.println((i+1)+". "+allMovie.get(i).getTitle());
                                }
                                System.out.print(">>");
                                String Dex = scStr.nextLine();
                                String[] DexArr = Dex.split(",");
                                ArrayList<Integer> IndexContainer = new ArrayList<Integer>();
                                for(int i =0;i<DexArr.length;i++){
                                    String c = DexArr[i];
                                    int dex = Integer.parseInt(String.valueOf(c));
                                    dex = dex-1;
                                    if(dex>-1&&dex<allMovie.size()){
                                        IndexContainer.add(dex);
                                    }
                                }
                                ArrayList<Movie> dexAdd = new ArrayList<Movie>();
                                for(int i =0;i<IndexContainer.size();i++){
                                    int x = IndexContainer.get(i);
                                    dexAdd.add(allMovie.get(x));
                                }
                                if(allSeries.size()==0){
                                    Series newSeries = new Series(newTitle,newDesc);
                                    newSeries.setEpisodeList(dexAdd);
                                    ArrayList<String> GenreContainer = new ArrayList<String>();
                                    for(int i =0;i<dexAdd.size();i++){
                                        GenreContainer.add(dexAdd.get(i).getGenre());
                                    }
                                    for(int i =0;i<GenreContainer.size();i++){
                                        newSeries.addGenre(GenreContainer.get(i));
                                    }
                                    allSeries.add(newSeries);
                                }
                                else{
                                    boolean dupe = Duplicate(allSeries, newTitle);
                                    if(dupe){
                                        System.out.println("Duplicate Series Entity. Failed to add new Series.");
                                    }
                                    else{
                                        Series newSeries = new Series(newTitle,newDesc);
                                        newSeries.setEpisodeList(dexAdd);
                                        ArrayList<String> GenreContainer = new ArrayList<String>();
                                        for(int i =0;i<dexAdd.size();i++){
                                            GenreContainer.add(dexAdd.get(i).getGenre());
                                        }
                                        for(int i =0;i<GenreContainer.size();i++){
                                            newSeries.addGenre(GenreContainer.get(i));
                                        }
                                        allSeries.add(newSeries);
                                    }
                                }
                                
                            }
                        }
                        else if (pilAdmin==4){
                            System.out.println("Series:");
                            boolean seeSeries = true;
                            while(seeSeries){
                                seeAllSeries(allSeries);
                                int pilseries = scInt.nextInt();
                                pilseries = pilseries-1;
                                if(pilseries==-1){
                                    seeSeries=false;
                                }
                                else if(pilseries<0&&pilseries>(allSeries.size()-1)){
                                    System.out.println("invalid index");
                                }
                                else{
                                    Series ChosenSeries = allSeries.get(pilseries);
                                    ChosenSeries.seeDesc();
                                    int piledit = scInt.nextInt();
                                    if(piledit==99){
                                        System.out.print("Enter new episode name : ");
                                        String newEp = scStr.nextLine();
                                        System.out.print("Enter new episode description : ");
                                        String newDesc = scStr.nextLine();
                                        System.out.println("Choose Genre : ");
                                        for(int i =0;i<ContentList.size();i++){
                                            System.out.println((i+1)+". "+ContentList.get(i).getName());
                                        }
                                        int pilGenre = scInt.nextInt();
                                        pilGenre=pilGenre-1;
                                        if(pilGenre<-1&&pilGenre>(ContentList.size()-1)){
                                            System.out.println("invalid Index, failed in adding new Episode.");
                                        }
                                        else{
                                            String newGenre = ContentList.get(pilGenre).getName();
                                            Movie newMovie = new Movie(newEp,newDesc);
                                            ChosenSeries.AddShit(newMovie, newGenre);
                                            System.out.println("Added episode ("+newEp+") with genre ("+newGenre+")");
                                        }
                                    }
                                }
                            }
                            
                        }
                        else if (pilAdmin==5){
                            System.out.println("Catalogue");
                            ArrayList<Type> allStuff = new ArrayList<Type>();
                            for(int i =0;i<allSeries.size();i++){
                                allStuff.add(allSeries.get(i));
                            }
                            for(int i =0;i<allMovie.size();i++){
                                allStuff.add(allMovie.get(i));
                            }
                            for(int i =0;i<allStuff.size();i++){
                                String a = allStuff.get(i).getTitle();
                                for(int j=0;j<allStuff.size();j++){
                                    String b = allStuff.get(j).getTitle();
                                    if(a.charAt(0)<b.charAt(0)){
                                        Collections.swap(allStuff, i, j);
                                    }
                                }
                            }
                            for(int i =0;i<allStuff.size();i++){
                                if(allStuff.get(i) instanceof Series){
                                    System.out.println((i+1)+". "+allStuff.get(i).getTitle()+" (Series)");
                                }
                                else{
                                    System.out.println((i+1)+". "+allStuff.get(i).getTitle());
                                }
                            }
                            
                        }
                        else if (pilAdmin==0){
                            LogAsAdmin=false;
                        }
                    }
                }
                else{
                    boolean match = credentials(userList,logUser,logPass);
                    if(match){
                        User CurrentUser = getUser(userList,logUser);
                        boolean LogAsUser = true;
                        ArrayList<Type> watchList = CurrentUser.getWatchList();
                        ArrayList<Type> History = CurrentUser.getHistory();
                        while(LogAsUser){
                            UserMenu(CurrentUser);
                            int piluser = scInt.nextInt();
                            if(piluser==1){
                                ArrayList<Type> allStuff = new ArrayList<Type>();
                                for(int i =0;i<allSeries.size();i++){
                                    allStuff.add(allSeries.get(i));
                                }
                                for(int i =0;i<allMovie.size();i++){
                                    allStuff.add(allMovie.get(i));
                                }
                                for(int i =0;i<allStuff.size();i++){
                                    String a = allStuff.get(i).getTitle();
                                    for(int j=0;j<allStuff.size();j++){
                                        String b = allStuff.get(j).getTitle();
                                        if(a.charAt(0)<b.charAt(0)){
                                            Collections.swap(allStuff, i, j);
                                        }
                                    }
                                }
                                BrowseCategory(ContentList);
                                ArrayList<Integer> IndexContainer =  new ArrayList<Integer>();
                                String Dex = scStr.next();
                                String[] DexArr = Dex.split(",");
                                for(int i =0;i<DexArr.length;i++){
                                    String c = DexArr[i];
                                    int dex = Integer.parseInt(String.valueOf(c));
                                    dex = dex-1;
                                    if(dex>-1&&dex<allMovie.size()){
                                        IndexContainer.add(dex);
                                    }
                                }
                                ArrayList<String> tags = new ArrayList<String>();
                                for(int i =0;i<IndexContainer.size();i++){
                                    tags.add(ContentList.get(IndexContainer.get(i)).getName());
                                }
                                ArrayList<Type> Result = new ArrayList<Type>();
                                for(int i =0;i<allStuff.size();i++){
                                    if(allStuff.get(i) instanceof Series){
                                        Series t = (Series)allStuff.get(i);
                                        boolean inTag = false;
                                        for(int j =0;j<tags.size();j++){
                                            String x = tags.get(j);
                                            if(t.SearchGenre(x)){
                                                inTag=true;
                                            }
                                        }
                                        if(inTag){
                                            Result.add(t);
                                        }
                                    }
                                    else{
                                        Movie t = (Movie)allStuff.get(i);
                                        boolean inTag = false;
                                        for(int j =0;j<tags.size();j++){
                                            String x = tags.get(j);
                                            if(t.SearchGenre(x)){
                                                inTag=true;
                                            }
                                        }
                                        if(inTag){
                                            Result.add(t);
                                        }
                                    }
                                }
                                System.out.println("Result:");
                                for(int i =0;i<Result.size();i++){
                                    if(Result.get(i) instanceof Series){
                                        System.out.println((i+1)+". "+Result.get(i).getTitle()+" (Series)");
                                    }
                                    else{
                                        System.out.println((i+1)+". "+Result.get(i).getTitle());
                                    }
                                }
                                System.out.print(">>");
                                int pilres = scInt.nextInt();
                                pilres = pilres-1;
                                if(pilres<0||pilres>(Result.size()-1)){
                                    System.out.println("Invalid Index");
                                }
                                else{
                                    if(Result.get(pilres) instanceof Series){
                                        Series t = (Series)Result.get(pilres);
                                        t.seeDesc();
                                        System.out.println("99. Add to WatchList");
                                        System.out.println("0. Back");
                                        int pilItem = scInt.nextInt();
                                        if(pilItem==99){
                                            watchList.add(t);
                                            System.out.println(t.getTitle()+" added to Watch List");
                                        }
                                    }
                                    else{
                                        Movie t = (Movie)Result.get(pilres);
                                        t.seeDesc();
                                        System.out.println("99. Add to WatchList");
                                        System.out.println("0. Back");
                                        int pilItem = scInt.nextInt();
                                        if(pilItem==99){
                                            watchList.add(t);
                                            System.out.println(t.getTitle()+" added to Watch List");
                                        }
                                    }
                                }
                                
                            }
                            else if(piluser==2){
                                
                            }
                            else if(piluser==3){
                                System.out.println("Watch List: ");
                                for(int i =0;i<watchList.size();i++){
                                    System.out.println((i+1)+". "+watchList.get(i).getTitle());
                                }
                                System.out.print(">>");
                                int pilWatch = scInt.nextInt();
                                pilWatch=pilWatch-1;
                                if(pilWatch<0||pilWatch>(watchList.size()-1)){
                                    System.out.println("Invalid Index!");
                                }
                                else{
                                    System.out.println("You have watched "+watchList.get(pilWatch).getTitle());
                                    boolean RateOnlyFans = true;
                                    int inprating =0;
                                    while(RateOnlyFans){
                                        System.out.print("Please give your rating (0-5):");
                                        inprating= scInt.nextInt();
                                        if(inprating>-1&&inprating<6){
                                            RateOnlyFans=false;
                                        }
                                        else{
                                            System.out.println("Invalid rating! Please enter again.");
                                        }
                                    }
                                    System.out.println("Thank You for Your Rating");
                                    watchList.get(pilWatch).EditRating(inprating);
                                    History.add(watchList.remove(pilWatch));
                                }
                            }
                            else if(piluser==4){
                                System.out.println("Watch History");
                                for(int i =0;i<History.size();i++){
                                    System.out.println((i+1)+". "+History.get(i).getTitle());
                                }
                            }
                            else if(piluser==0){
                                CurrentUser.setWatchList(watchList);
                                CurrentUser.setHistory(History);
                                LogAsUser=false;
                            }
                        }
                    }
                    else{
                        System.out.println("Wrong Username/Password!");
                    }
                }
            }
            else if(pil==2){
                Register(userList);
            }
            else if(pil==3){
                run=false;
            }
        }
    }
    
}
