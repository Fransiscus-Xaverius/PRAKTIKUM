/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esprotmenejer;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Frans
 */
public class Esprotmenejer {

    //MABAR VALORANT KO :V
    
    public static void mainmenu(){
        System.out.println("== Esport Manager ==");
        System.out.println("1. Register Player");
        System.out.println("2. Register Coach");
        System.out.println("3. Create team");
        System.out.println("4. List Team");
        System.out.println("5. Sparring");
        System.out.println("0. Exit");
        System.out.print(">>");
    }

    public static Player RegPlayer(){
        Player newP;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.print("First Name : ");
        String newFN = scStr.nextLine();
        System.out.print("Nickname : ");
        String newIGN = scStr.nextLine();
        System.out.print("Last Name : ");
        String newLN = scStr.nextLine();
        System.out.print("Age : ");
        int newAge = scInt.nextInt();
        
        newP = new Player(newFN,newIGN,newLN,newAge);
        
        return newP;
    }
    
    public static void choosegamemenu(){
        System.out.println("Choose a game");
        System.out.println("1. VALORANT");
        System.out.println("2. DOTA");
        System.out.println("3. PUBG");
        System.out.print(">>");
    }
    
    public static void selectRole(){
        System.out.println("Select Role:");
        System.out.println("1. Duelist");
        System.out.println("2. Initiator");
        System.out.println("3. Sentinel");
        System.out.println("4. Controller");
        System.out.print(">>");
    }
    
    public static void selectPos(){
        System.out.println("Select Role:");
        System.out.println("1. Carry");
        System.out.println("2. Mid Lane");
        System.out.println("3. Off Lane");
        System.out.println("4. Soft Support");
        System.out.println("5. Hard Support");
        System.out.print(">>");
    }
    
    public static ArrayList<coach> RegCoach(ArrayList<coach> unlistedcoach){
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.print("Name : ");
        String newName = scStr.nextLine();
        boolean choosegame = true;
        while(choosegame){
            System.out.println("Game : ");
            System.out.println("1. VALORANT");
            System.out.println("2. Dota");
            System.out.println("3. PUBG");
            System.out.print(">>");
            int newGame = scInt.nextInt();
            if(newGame==1){
                VALCOACH newC = new VALCOACH(newName);
                newC.setBoost();
                unlistedcoach.add(newC);
                choosegame=false;
            }
            else if(newGame==2){
                DOTACOACH newC = new DOTACOACH(newName);
                newC.setBoost();
                unlistedcoach.add(newC);
                choosegame=false;
            }
            else if(newGame==3){
                PUBGCOACH newC = new PUBGCOACH(newName);
                newC.setBoost();
                unlistedcoach.add(newC);
                choosegame=false;
            }
        }
        return unlistedcoach;
    }
    
    public static void seeTeam(Team X){
        boolean hasCoach = true;
        if(X.getC().getName().equals("")){
            hasCoach = false;
        }
        String game = "";
        if(X.getGame()==1){
            game="VALORANT";
        }
        else if(X.getGame()==2){
            game="Dota";
        }
        else{
            game="PUBG";
        }
        System.out.println("Game : "+game);   
        System.out.println("Team : "+X.getName());
        if(hasCoach){
            System.out.println("Coach : "+X.getC().getName());
        }
        else{
            System.out.println("Coach : ");
        }
        System.out.println("Team Score : "+X.CalcScore());
        System.out.println("Member");
        X.seeMembers();
        System.out.println("==============================");
        System.out.println("1. Enlist Player");
        System.out.println("2. Remove Player");
        System.out.println("3. Hire Coach");
        System.out.println("4. Rebrand Team Name");
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static ArrayList<Player> seeUnsigned(ArrayList<Player> unsigned, int game ){
        ArrayList <Player> eligible = new ArrayList<Player>();
        if(game==1){
            for(int i =0;i<unsigned.size();i++){
                if(unsigned.get(i) instanceof VALORANT&&!unsigned.get(i).isSigned()){
                    eligible.add(unsigned.get(i));
                }
            }
        }
        else if(game==2){
            for(int i =0;i<unsigned.size();i++){
                if(unsigned.get(i) instanceof Dota&&!unsigned.get(i).isSigned()){
                    eligible.add(unsigned.get(i));
                }
            }
        }
        else if(game==3){
            for(int i =0;i<unsigned.size();i++){
                if(unsigned.get(i) instanceof PUBG&&!unsigned.get(i).isSigned()){
                    eligible.add(unsigned.get(i));
                }
            }
        }
        
        return eligible;   
    }
    
    public static void seeEligible(ArrayList<Player> eligible){
        for(int i =0;i<eligible.size();i++){
            Player p = eligible.get(i);
            System.out.println((i+1)+". "+p.getFirstname()+" \""+p.getIgn()+"\" "+p.getLastname());
        }
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void seePlayerInfo(Player p){
        System.out.println("Name: "+p.getFirstname()+" \""+p.getIgn()+"\" "+p.getLastname());
        if(p instanceof VALORANT){
            VALORANT P = (VALORANT) p;
            String role = P.getRole();
            System.out.println("Aim: "+P.getAim());
            System.out.println("Communication: "+P.getComms());
            System.out.println("Prefered Role: "+role);
        }
        else if(p instanceof Dota){
            Dota P = (Dota) p;
            System.out.println("Communication: "+P.getComms());
            String role = P.getRole();
            System.out.println("Prefered Role: "+role);
        }
        else if(p instanceof PUBG){
            PUBG P = (PUBG) p;
            System.out.println("Aim: "+P.getAim());
            System.out.println("Luck: "+P.getLuck());
            System.out.println("Communication: "+P.getComms());
        }
        System.out.println("1. Enlist");
        System.out.println("0. Back");
    }
    
    public static void main(String[] args) {
        boolean run = true;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        ArrayList<Player> unsigned = new ArrayList<Player>();
        ArrayList<Team> teamList = new ArrayList<Team>();
        ArrayList<coach> unlistedcoach = new ArrayList<coach>();
        
        while(run){
            mainmenu();
            int pilMenu = scInt.nextInt();
            if(pilMenu==1){
                Player RegP = RegPlayer();
                choosegamemenu();
                int pilgame = scInt.nextInt();
                if(pilgame==1){
                    boolean newVal=true;
                    int nAim = 0;
                    int nComm = 0;
                    int nRole = 0;
                    VALORANT newVLR = new VALORANT(RegP.getFirstname(),RegP.getIgn(),RegP.getLastname(),RegP.getAge());
                    while(newVal){
                        selectRole();
                        nRole = scInt.nextInt();
                        System.out.print("Aim : ");
                        nAim = scInt.nextInt();
                        System.out.print("Communication : ");
                        nComm = scInt.nextInt();
                        if(nAim>=0&&nAim<=100&&nComm>=0&&nComm<=100&&nRole>=0&&nRole<=4){
                            newVal=false;
                        }
                        else{
                            System.out.println("Invalid amount.");
                        } 
                    }
                    newVLR.setAim(nAim);
                    newVLR.setComms(nComm);
                    newVLR.setRole(nRole);
                    unsigned.add(newVLR);
                }
                else if(pilgame==2){
                    boolean newDOTO=true;
                    int nComm = 0;
                    int nPos = 0;
                    Dota newDota = new Dota(RegP.getFirstname(),RegP.getIgn(),RegP.getLastname(),RegP.getAge());
                    while(newDOTO){
                        selectPos();
                        nPos = scInt.nextInt();
                        System.out.print("Communication : ");
                        nComm = scInt.nextInt();
                        if(nComm>=0&&nComm<=100){
                            newDOTO=false;
                        }
                        else{
                            System.out.println("Invalid amount.");
                        } 
                    }
                    newDota.setRole(nPos);
                    newDota.setComms(nComm);
                    unsigned.add(newDota);
                }
                else if(pilgame==3){
                    boolean newPubg = true;
                    int nAim = 0;
                    int nComm = 0;
                    int nLuck = 0;
                    PUBG newPUBG = new PUBG (RegP.getFirstname(),RegP.getIgn(),RegP.getLastname(),RegP.getAge());
                    while(newPubg){
                        System.out.print("Aim : ");
                        nAim = scInt.nextInt();
                        System.out.print("Luck : ");
                        nLuck = scInt.nextInt();
                        System.out.print("Communication : ");
                        nComm = scInt.nextInt();
                        if(nAim>=0&&nAim<=100&&nComm>=0&&nComm<=100&&nLuck>=0&&nLuck<=100){
                            newPubg=false;
                        }
                        else{
                            System.out.println("Invalid amount.");
                        }
                    }
                    newPUBG.setAim(nAim);
                    newPUBG.setLuck(nLuck);
                    newPUBG.setComms(nComm);
                    unsigned.add(newPUBG);
                }
            }
            else if(pilMenu==2){
                unlistedcoach=RegCoach(unlistedcoach);
            }
            else if(pilMenu==3){
                System.out.print("Team Name : ");
                String newName = scStr.nextLine();
                boolean choosegame = true;
                while(choosegame){
                    choosegamemenu();
                    int newGame = scInt.nextInt();
                    if(newGame==1){
                        ArrayList<VALORANT> member = new ArrayList<VALORANT>();
                        teamList.add(new Team(member,newName,newGame));
                        choosegame=false;
                    }
                    else if(newGame==2){
                        ArrayList<Dota> member = new ArrayList<Dota>();
                        teamList.add(new Team(member,newName,newGame));
                        choosegame=false;
                    }
                    else if(newGame==3){
                        ArrayList<PUBG> member = new ArrayList<PUBG>();
                        teamList.add(new Team(member,newName,newGame));
                        choosegame=false;
                    }
                }
                System.out.println("Created new Team : "+newName);
            }
            else if(pilMenu==4){
                if(teamList.size()==0){
                    System.out.println("There are no registered Teams at the moment! Please register a new team and try again.");
                }
                else{
                    for(int i =0;i<teamList.size();i++){
                        System.out.println((i+1)+". "+teamList.get(i).getName()+"("+teamList.get(i).seeGame()+")");
                    }
                    System.out.print(">>");
                    int pilteam = scInt.nextInt();
                    pilteam = pilteam-1;
                    if(pilteam<0||pilteam>teamList.size()-1){
                        System.out.println("Invalid Team Index..");
                    }
                    else{
                        boolean seeingTeam = true;
                        while(seeingTeam){
                            seeTeam(teamList.get(pilteam));
                            Team current = teamList.get(pilteam);
                            int pilSee = scInt.nextInt();
                            if(pilSee==1){
                                ArrayList<Player> eligible = seeUnsigned(unsigned,teamList.get(pilteam).getGame());
                                boolean PlayerMarket = true;
                                while(PlayerMarket){
                                    seeEligible(eligible);
                                    int pilPlayer = scInt.nextInt();
                                    pilPlayer = pilPlayer-1;
                                    if(pilPlayer<-1||pilPlayer>eligible.size()-1){
                                        System.out.println("Invalid index.. cant add player to the team");
                                    }
                                    else if(pilPlayer==-1){
                                        System.out.println("Cancelling process of adding new Player...");
                                        PlayerMarket=false;
                                    }
                                    else{
                                        boolean interesting = true;
                                        while(interesting){
                                            Player interest = eligible.get(pilPlayer);
                                            
                                            seePlayerInfo(interest);
                                            int EnlistOption = scInt.nextInt();
                                            if(EnlistOption==1){
                                                if(!current.isFull()){
                                                    if(current.getGame()==1){
                                                        VALORANT P = (VALORANT) interest;
                                                        P.sign();
                                                        current.add(P);
                                                    }
                                                    else if(current.getGame()==2){
                                                        Dota P = (Dota) interest;
                                                        P.sign();
                                                        current.add(P);
                                                    }
                                                    else if(current.getGame()==3){
                                                        PUBG P = (PUBG) interest;
                                                        P.sign();
                                                        current.add(P);
                                                    }
                                                }
                                                else{
                                                    System.out.println("The Maximum Amount of players in the team has been reached. Remove a player first before adding more.");
                                                }
                                                interesting=false;
                                                PlayerMarket=false;
                                            }
                                            else if(EnlistOption==0){
                                                interesting=false;
                                            }
                                        }

                                    } 
                                }
                            }
                            else if(pilSee==2){
                                boolean removing = true;
                                while(removing){
                                    System.out.println("Which Player would you like to remove?");
                                    ArrayList <Player> SignedPlayers = current.getMember();
                                    seeEligible(SignedPlayers);
                                    int pilRemove = scInt.nextInt();
                                    pilRemove=pilRemove-1;
                                    if(pilRemove<-1||pilRemove>SignedPlayers.size()-1){
                                        System.out.println("Invalid index..");
                                    }
                                    else if(pilRemove==-1){
                                        removing=false;
                                        System.out.println("Cancelling removal of player");
                                    }
                                    else{
                                        SignedPlayers.get(pilRemove).setSigned(false);
                                        SignedPlayers.remove(pilRemove);
                                        current.setMember(SignedPlayers);
                                        removing=false;
                                    }
                                }
                            }
                            else if(pilSee==3){
                                int game = current.getGame();
                                ArrayList<coach> eligiblecoach = new ArrayList<>();
                                if(game==1){
                                    for(int i =0;i<unlistedcoach.size();i++){
                                        if(unlistedcoach.get(i) instanceof VALCOACH&&!unlistedcoach.get(i).isSigned()){
                                            eligiblecoach.add(unlistedcoach.get(i));
                                        }
                                    }
                                }
                                else if(game==2){
                                    for(int i =0;i<unlistedcoach.size();i++){
                                        if(unlistedcoach.get(i) instanceof DOTACOACH&&!unlistedcoach.get(i).isSigned()){
                                            eligiblecoach.add(unlistedcoach.get(i));
                                        }
                                    }
                                }
                                else if(game==3){
                                    for(int i =0;i<unlistedcoach.size();i++){
                                        if(unlistedcoach.get(i) instanceof PUBGCOACH&&!unlistedcoach.get(i).isSigned()){
                                            eligiblecoach.add(unlistedcoach.get(i));
                                        }
                                    }
                                }
                                boolean hiringCoach = true;
                                while(hiringCoach){
                                    for(int i =0;i<eligiblecoach.size();i++){
                                        System.out.println((i+1)+". "+unlistedcoach.get(i).getName());
                                    }
                                    System.out.println("0. Back");
                                    System.out.print(">>");
                                    int pilCoach = scInt.nextInt();
                                    pilCoach=pilCoach-1;
                                    if(pilCoach<-1||pilCoach>eligiblecoach.size()-1){
                                       System.out.println("Invalid index..");
                                    }
                                    else if(pilCoach==-1){
                                        hiringCoach=false;
                                    }
                                    else{
                                        boolean HasCoach = current.hasCoach();
                                        if(HasCoach){
                                            coach temp = current.getC();
                                            temp.Fire();
                                            eligiblecoach.get(pilCoach).Sign();
                                            current.setC(eligiblecoach.get(pilCoach));
                                        }
                                        else{
                                            eligiblecoach.get(pilCoach).Sign();
                                            current.setC(eligiblecoach.get(pilCoach));
                                        }
                                        hiringCoach=false;
                                    }
                                }
                            }
                            else if(pilSee==4){
                                System.out.print("Enter new Team name : ");
                                String newName = scStr.nextLine();
                                current.setName(newName);
                                System.out.println("Successfully rebranded the team to "+newName);
                            }
                            else if(pilSee==0){
                                seeingTeam=false;
                            }
                        }
                    } 
                }
            }
            else if(pilMenu==5){
                for(int i =0;i<teamList.size();i++){
                    System.out.println((i+1)+". "+teamList.get(i).getName()+"("+teamList.get(i).seeGame()+")");
                }
                System.out.print(">>");
                int pilteam = scInt.nextInt();
                pilteam = pilteam-1;
                if(pilteam<0||pilteam>teamList.size()-1){
                    System.out.println("Invalid Team Index..");
                }
                else{
                    Team T1 = teamList.get(pilteam);
                    ArrayList<Team> temp = teamList;
                    temp.remove(pilteam);
                    for(int i =0;i<temp.size();i++){
                        System.out.println((i+1)+". "+temp.get(i).getName()+"("+temp.get(i).seeGame()+")");
                    }
                    System.out.print(">>");
                    int pilteam2 = scInt.nextInt();
                    pilteam2 = pilteam2-1;
                    Team T2 = temp.get(pilteam2);
                    if(T1.getGame()==T2.getGame()){
                        System.out.println(T1.getName()+" dan "+T2.getName()+" sparring. Score keduanya bertambah 50..");
                        T1.spar();
                        T2.spar();
                        temp.add(T1);
                    }
                    else{
                        System.out.println("Game doesn't match [returning to main menu]");
                        temp.add(T1);
                    }
                }
                
                
            }
            else if(pilMenu==0){
                run=false;
            }
        }
    }
    
}
