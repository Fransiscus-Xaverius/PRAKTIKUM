/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package limesederhana;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Frans
 */
public class LIMESEDERHANA {

    public static void menu(){
        System.out.println("== LIME ==");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.print(">>");
    }
    
    public static void usermenu(Account currentuser){
        String username = currentuser.getUsername();
        System.out.println("== Welcome "+username+" ==");
        System.out.println("1. List Contact");
        System.out.println("2. Chat");
        System.out.println("3. Group");
        System.out.println("4. Logout");
        System.out.print(">>");
    }
    
    public static void groupmenu(ArrayList<Group> grouplist, String username, ArrayList<Integer> allGroup){
        System.out.println("Groups");
        int urut = 1;
        for(int i =0;i<grouplist.size();i++){
            boolean cek = grouplist.get(i).isMember(username);
            if(cek){
                allGroup.add(i);
                System.out.println((urut)+". "+grouplist.get(i).getGroupname());
                urut++;
            }
        }
        System.out.println("99. Add Group");
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void addgroup(){
        System.out.println("Add Group");
        System.out.println("1. Create Group");
        System.out.println("2. Join Group");
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void main(String[] args) {
        boolean run = true;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        ArrayList<Account> user = new ArrayList<Account>();
        ArrayList<Chat> recentchat = new ArrayList<Chat>();
        ArrayList<Group> grouplist = new ArrayList<Group>();
        String usernamecek;
        String passcek;
        int groupcount = 0;
        String loginuser;
        String loginpass;
        Account currentuser;
        int index = -1;
        int pil;
        while(run){
            menu();
            pil = scInt.nextInt();
            if(pil==1){
                System.out.println("Login");
                System.out.print("Username : ");
                loginuser = scStr.nextLine();
                System.out.print("Password : ");
                loginpass = scStr.nextLine();
                boolean found = false;
                for(int i =0;i<user.size();i++){
                    String login = user.get(i).getUsername();
                    if(login.equals(loginuser)){
                        found=true;
                        index = i;
                        break;  
                    }
                }
                if(!found){
                    System.out.println("Username tidak ditemukan!");
                }
                else{
                    boolean credentials = false;
                    if(user.get(index).getPassword().equals(loginpass)){
                        credentials = true;
                    }
                    if(!credentials){
                        System.out.println("Password salah!");
                    }
                    else{
                        currentuser = user.get(index);
                        String username = currentuser.getUsername();
                        boolean logged_in = true;
                        int indexcontact = -1;
                        while(logged_in){
                            usermenu(currentuser);
                            String accountuser = currentuser.getUsername();
                            int pil_menu = scInt.nextInt();
                            ArrayList<Integer> allGroup = new ArrayList<Integer>();
                            int[] urut = new int[1]; 
                            if(pil_menu==1){
                                int OppositeID = -1;
                                boolean addnewcontact = true;
                                while(addnewcontact){
                                    System.out.println("Contacts");
                                    user.get(index).SeeContacts();
                                    System.out.println("99. Add Contact");
                                    System.out.println("0. Back");
                                    System.out.print(">>");
                                    int pilcon = scInt.nextInt();
                                    if(pilcon==99){
                                        boolean cek_avail=false;
                                        System.out.print("Enter new contact username : ");
                                        String newcontact = scStr.nextLine();
                                        if(newcontact.equals(currentuser.getUsername())){
                                            System.out.println("You can't add yourself to your list of contacts ");
                                        }
                                        else{
                                            for(int i =0;i<user.size();i++){
                                                String ceknama = user.get(i).getUsername();
                                                if (ceknama.equals(newcontact)){
                                                    cek_avail=true;
                                                    indexcontact = i;
                                                    break;
                                                }
                                            }
                                            if(cek_avail){
                                                user.get(indexcontact).addContact(currentuser.getUsername(), currentuser.getFrontname(), currentuser.getBackname());
                                                user.get(index).addContact(newcontact, user.get(indexcontact).getFrontname(), user.get(indexcontact).getBackname());
                                            }
                                            else{
                                                System.out.println("Contact tidak terdaftar di LIME");
                                            }
                                        }
                                    }
                                    else if(pilcon==0){
                                        addnewcontact=false;
                                    }
                                    else{
                                        int ID = -1;
                                        int userID = -1;
                                        int selected_ID = -1;
                                        String chosenuser = "";
                                        String chosenuserFN = "";
                                        String chosenuserLN = "";
                                        boolean isInContact = false;
                                        for(int i =0;i<user.get(index).jumlahkontak();i++){
                                            if((i)==(pilcon-1)){
                                                chosenuser = user.get(index).getContactName(i);
                                                chosenuserFN = user.get(index).getFirstName(i);
                                                chosenuserLN = user.get(index).getLastName(i);
                                                isInContact = true;
                                                selected_ID = i;
                                                break;
                                            }
                                        }
                                        if(isInContact){
                                            for(int i =0;i<user.size();i++){
                                                if(chosenuser.equals(user.get(i).getUsername())){
                                                    selected_ID = i;
                                                    break;
                                                }
                                            }
                                            int contact_ID = 0;
                                            for(int i =0;i<user.get(selected_ID).jumlahkontak();i++){
                                                if(user.get(selected_ID).getUsername().equals(currentuser.getUsername())){
                                                    contact_ID = i;
                                                    break;
                                                }
                                            }
                                            int menukontak;
                                            while(isInContact){
                                                System.out.println("Selected Contact : "+chosenuserFN+" "+chosenuserLN);
                                                System.out.println("1. Chat");
                                                System.out.println("2. Delete");
                                                System.out.println("3. Back");
                                                menukontak=scInt.nextInt();
                                                
                                                if(menukontak==1){
                                                    boolean msging = true;
                                                    while(msging){
                                                        user.get(index).getChat(username, chosenuser, pilcon-1, chosenuserFN, chosenuserLN);
                                                        String MSG = scStr.nextLine();
                                                        if(MSG.equals("0")){
                                                            msging=false;
                                                        }
                                                        else{
                                                            System.out.println(username);
                                                            user.get(index).SendChat(MSG, username, pilcon-1, user.get(index).getOwnFName(), user.get(index).getOwnLName());
                                                            user.get(selected_ID).SendChat(MSG, username, contact_ID, user.get(index).getOwnFName(), user.get(index).getOwnLName());
                                                            user.get(index).UpdateRecentChat(MSG, chosenuserFN,chosenuserLN,pilcon-1 );
                                                            user.get(selected_ID).UpdateRecentChat(MSG, chosenuserFN,chosenuserLN,contact_ID);
                                                        }
                                                    }
                                                }
                                                else if(menukontak==2){
                                                    user.get(index).deleteContact(pilcon-1);
                                                    user.get(selected_ID).deleteContact(contact_ID);
                                                    isInContact=false;
                                                }
                                                else if(menukontak==3){
                                                    isInContact=false;
                                                }
                                            }
                                        }
                                        else{
                                            System.out.println("Invalid Contact Index!");
                                        }
                                    }
                                }
                            }
                            else if(pil_menu==2){
                                boolean recentchatting = true;
                                while(recentchatting){
                                    System.out.println("Chats");
                                    user.get(index).seeRecentChat();
                                    System.out.println("0. Back"); 
                                    System.out.print(">>");
                                    String inputrecent = scStr.nextLine();
                                    if(inputrecent.equals("0")){
                                        recentchatting=false;
                                    }
                                    else{
                                        int chosenchat = -1;
                                        String chosenuser = "";
                                        String chosenuserFN = "";
                                        String chosenuserLN = "";
                                        int recentindex = Integer.valueOf(inputrecent)-1;
                                        if(recentindex<=user.get(index).AmountOfRecentChat()){
                                            chosenchat = user.get(index).getChatIndex(recentindex);
                                        }
                                        for(int i =0;i<user.get(index).jumlahkontak();i++){
                                            if(i==chosenchat){
                                                chosenuser = user.get(index).getContactName(i);
                                                chosenuserFN = user.get(index).getFirstName(i);
                                                chosenuserLN = user.get(index).getLastName(i); 
                                            }
                                        }
                                        boolean msging = true;
                                        while(msging){
                                            user.get(chosenchat).getChat(username,chosenuser,chosenchat,chosenuserFN,chosenuserLN);
                                            String MSG = scStr.nextLine();
                                            if(MSG.equals("0")){
                                                msging=false;
                                            }
                                            else{
                                                user.get(index).SendChat(MSG, username, chosenchat, user.get(index).getOwnFName(), user.get(index).getOwnLName());
                                                user.get(chosenchat).SendChat(MSG, username, chosenchat, user.get(index).getOwnFName(), user.get(index).getOwnLName());
                                                user.get(index).UpdateRecentChat(MSG, chosenuserFN,chosenuserLN,chosenchat );
                                                user.get(chosenchat).UpdateRecentChat(MSG, chosenuserFN,chosenuserLN,chosenchat);
                                            }
                                        }
                                    }
                                }
                            }
                            else if(pil_menu==3){
                                boolean viewgroup = true;
                                while(viewgroup){
                                    groupmenu(grouplist,currentuser.getUsername(),allGroup);
                                    int pilgroup = scInt.nextInt();
                                    if(pilgroup==0){
                                        viewgroup =false;
                                    }
                                    else if(pilgroup==99){
                                        boolean managegroup = true;
                                        while(managegroup){
                                            addgroup();
                                            int piladd = scInt.nextInt();
                                            if(piladd==1){
                                                System.out.print("Input new group name : ");
                                                String tempnewname = scStr.nextLine();
                                                groupcount++;
                                                int namelen = tempnewname.length();
                                                int ratus = groupcount/100;
                                                int puluh = groupcount/10;
                                                int satu = groupcount%10;
                                                char tempchar0 = tempnewname.charAt(0);
                                                char tempchar1 = tempnewname.charAt(1);
                                                char tempchar2 = tempnewname.charAt(2);
                                                String newgroupcode = ""+tempchar0+tempchar1+tempchar2+Integer.toString(namelen)+Integer.toString(ratus)+Integer.toString(puluh)+Integer.toString(satu);
                                                grouplist.add(new Group(tempnewname,newgroupcode));
                                                grouplist.get(groupcount-1).JoinGroup(currentuser.getUsername());;
                                                System.out.println("New Group ("+tempnewname+") was successfully created!");
                                                managegroup=false;
                                            }
                                            else if (piladd==2){
                                                System.out.print("Enter Group Code : ");
                                                int groupindex = -1;
                                                String joincode = scStr.nextLine();
                                                boolean foundgroup = false;
                                                for(int i =0;i<grouplist.size();i++){
                                                    if(grouplist.get(i).getGroupcode().equals(joincode)){
                                                        groupindex = i;
                                                        foundgroup=true;
                                                        break;
                                                    }
                                                }
                                                if(foundgroup){
                                                    grouplist.get(groupindex).JoinGroup(currentuser.getUsername());
                                                    System.out.println("Joined "+grouplist.get(groupindex).getGroupname());
                                                }
                                                else{
                                                    System.out.println("Unable to find a group with the code : "+joincode);
                                                }
                                            }
                                            else if (piladd==0){
                                                managegroup=false;
                                            }
                                        }
                                    }
                                    else{
                                         boolean viewinggroup = false;
                                         if(pilgroup<=grouplist.size()){
                                             viewinggroup=true;
                                             while(viewinggroup){
                                                int chosengroup = pilgroup-1;
                                                int group_ID = allGroup.get(chosengroup);
                                                String chosen_groupname = grouplist.get(group_ID).getGroupname();
                                                String chosen_groupcode = grouplist.get(group_ID).getGroupcode();
                                                int chosen_membercount = grouplist.get(group_ID).MemberCount();
                                                 System.out.println("Group name: "+chosen_groupname);
                                                 System.out.println("Group Member: "+chosen_membercount);
                                                 System.out.println("Group Code: "+chosen_groupcode);
                                                 System.out.println("1. Open Messages");
                                                 System.out.println("2. Edit name");
                                                 System.out.println("3. Add Member");
                                                 System.out.println("4. Remove Member");
                                                 System.out.println("0. Back");
                                                 int pilview = scInt.nextInt();
                                                 if(pilview==1){
                                                     boolean chatting = true;
                                                     while(chatting){
                                                         System.out.println("==============================");
                                                         System.out.println(grouplist.get(group_ID).getGroupname());
                                                         System.out.println("==============================");
                                                         grouplist.get(group_ID).SeeChat(user.get(index).getUsername());
                                                         System.out.println("==============================");
                                                         System.out.println("0. Back");
                                                         System.out.println("==============================");
                                                         System.out.print(">>");
                                                         String groupmsg = scStr.nextLine();
                                                         if(groupmsg.equals("0")){
                                                             chatting=false;
                                                         }
                                                         else{
                                                             grouplist.get(group_ID).sendChat(groupmsg, currentuser.getUsername(), currentuser.getOwnFName(), currentuser.getOwnLName());
                                                         }
                                                     }
                                                 }
                                                 else if(pilview==2){
                                                    System.out.print("Enter new group name :");
                                                    String ihatejava = scStr.nextLine();
                                                    char tempchar0 = ihatejava.charAt(0);
                                                    char tempchar1 = ihatejava.charAt(1);
                                                    char tempchar2 = ihatejava.charAt(2);
                                                    int namelen = ihatejava.length();
                                                    int ratus = groupcount/100;
                                                    int puluh = groupcount/10;
                                                    int satu = groupcount%10;
                                                    String newgroupcode = ""+tempchar0+tempchar1+tempchar2+Integer.toString(namelen)+Integer.toString(ratus)+Integer.toString(puluh)+Integer.toString(satu);
                                                    grouplist.get(group_ID).setGroupname(ihatejava);
                                                    grouplist.get(group_ID).setGroupcode(newgroupcode);
                                                    System.out.println("Successfully changed group name!");
                                                 }
                                                 else if(pilview==3){
                                                     boolean inviting = true;
                                                     while(inviting){
                                                        System.out.println("Select which contact would you like to invite to the group");
                                                        user.get(index).SeeContacts();
                                                        System.out.println("0. Back");
                                                        System.out.print(">>");
                                                        int pilmember = scInt.nextInt();
                                                        if(pilmember==0){
                                                            inviting=false;
                                                        }
                                                        else{
                                                           String newmember = user.get(index).getContactName(pilmember-1);
                                                           boolean kembar = grouplist.get(group_ID).cekIfJoined(newmember);
                                                           if(kembar){
                                                               System.out.println(newmember+" is already a member of the group chat!");
                                                           }
                                                           else{
                                                               grouplist.get(group_ID).JoinGroup(newmember);
                                                           }
                                                           inviting = false;
                                                        }
                                                     }
                                                 }
                                                 else if (pilview==4){
                                                     boolean removing = true;
                                                     while(removing){
                                                        System.out.println(grouplist.get(group_ID).getGroupname()+" Members");
                                                        grouplist.get(group_ID).seeMember();
                                                        System.out.println("0. Back");
                                                        System.out.print(">>");
                                                        int pilmember = scInt.nextInt();
                                                        if(pilmember==0){
                                                            removing=false;
                                                        }
                                                        else{
                                                            if(grouplist.get(group_ID).getMemberName(pilmember-1).equals(currentuser.getUsername())){
                                                                System.out.println("You're about to remove yourself from the group. Are you sure?");
                                                                System.out.println("1 = Yes, 2 = No");
                                                                System.out.print(">>");
                                                                int leavegroup = scInt.nextInt();
                                                                if(leavegroup==1){
                                                                    System.out.println("You left the group.");
                                                                    grouplist.get(group_ID).removeMember(pilmember-1);
                                                                }
                                                                else{
                                                                    System.out.println("BRUH");
                                                                }
                                                            }
                                                            else{
                                                                grouplist.get(group_ID).removeMember(pilmember-1);
                                                            }
                                                            removing=false;
                                                        }
                                                     }
                                                 }
                                                 else if (pilview==0){
                                                     viewinggroup=false;
                                                 }
                                             }
                                         }
                                         else{
                                             System.out.println("Invalid option!");
                                         }
                                    }
                                }
                            }
                            else if(pil_menu==4){
                                logged_in=false;
                            }
                        }
                    }
                }
                
            }
            else if(pil==2){
                System.out.println("Register");
                System.out.print("Username : ");
                usernamecek = scStr.nextLine();
                System.out.print("Password : ");
                passcek = scStr.nextLine();
                System.out.print("Confirm Password : ");
                String passcek2 =scStr.nextLine();
                if(passcek.equals(passcek2)){
                    System.out.print("First Name : ");
                    String firstname = scStr.nextLine();
                    System.out.print("Last Name : ");
                    String lastname = scStr.nextLine();
                    boolean sama = false;
                    if(user.size()!=0){
                        for(int i =0;i<user.size();i++){
                            if(user.get(i).getUsername().equals(usernamecek)){
                                sama = true;
                                break;
                            }
                        }   
                    }
                    if(!sama){
                        user.add(new Account(usernamecek,passcek,firstname,lastname));
                    }
                    else{
                        System.out.println("Username sudah terpakai!");
                    }
                }
                else{
                    System.out.println("Incorrect Password during confirmation!");
                }
            }
            else if(pil==0){
                run=false;
            }
        }
    }
    
}
