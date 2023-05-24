#include <iostream>
#include <windows.h>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

void logscreen(){

cout<<"Welcome to Pesbuk"<<endl;
cout<<"1. Login"<<endl;
cout<<"2. Register"<<endl;
cout<<"0. Exit"<<endl;
cout<<">>";

}

void regis(vector<string> &username, vector<string> &password, int &jumakun){
string nama, pass;
int cek = 0;
cout<<"Pesbuk Registration"<<endl;
cout<<"Username : ";cin>>nama;
cout<<"Password : ";cin>>pass;
for (int i=0;i<username.size();i++){
    if (nama==username[i]){
        cek = 1;
    }
}
if (nama.size()>8){
    cout<<"Gagal mendaftar, panjang username maksimal 8 huruf"<<endl;
    system("PAUSE");
}
else if (jumakun>5){
    cout<<"Gagal Mendaftar, jumlah user teregistrasi maksimal 5 user"<<endl;
    system("PAUSE");
}
else if (cek==1){
    cout<<"Gagal Mendaftar, username tersebut telah dipakai sebelumnya."<<endl;
    system("PAUSE");
}
else{
    username.push_back(nama);
    password.push_back(pass);
    cout<<"Berhasil Register"<<endl;
    jumakun++;
    system("PAUSE");
}

}

void loginpesbuk(vector<string> username, vector<string> password, bool &login, int &userke){
cout<<"Pesbuk Login"<<endl;
string nama, pass;
int cek, cekpass;
cek = 0;
cekpass = 0;
cout<<"Username : ";cin>>nama;
cout<<"Password : ";cin>>pass;
for (int i=0;i<username.size();i++){
    if (nama==username[i]){
        cek = 1;
        userke = i;
    }
}
for (int j=0;j<username.size();j++){
    if (pass==password[j]){
        cekpass=1;
    }
}
if (cek==1&&cekpass==1){
    cout<<"Berhasil login."<<endl;
    login = true;
    system("PAUSE");
    system("CLS");
}
else {
    cout<<"Username/password salah, mohon coba lagi."<<endl;
    login = false;
    system("PAUSE");
    system("CLS");
}

}

void mainmenu(vector<string> username, vector<string> password, int userke){
    cout<<"Hello, "<<username[userke]<<endl;
    cout<<"What do you want to do?"<<endl;
    cout<<"======================="<<endl;
    cout<<"1. Chatting"<<endl;
    cout<<"0. Exit"<<endl;
    cout<<">>";
}

void selectchat(vector<string> username, int userke){
cout<<"Who do you want to Chat with?"<<endl;
for (int i=0; i<username.size();i++){
    if (i!=userke){
    cout<<i+1<<"."<<username[i]<<endl;;
    }
}
cout<<"0. Exit"<<endl;
cout<<">>";
}

void chatwith(vector<string> username, int pil3, int userke, vector<string> &message){

string pesan;
cout<<"Chat with "<<username[pil3-1]<<endl;
cout<<"======================="<<endl;
for (int i=0;i<message.size();i++){
    if (i%2==0){
        cout<<username[pil3-1]<<" : "<<message[i]<<endl;
    }
    else {
        cout<<username[userke]<<" : "<<message[i]<<endl;
    }
}
cout<<"======================="<<endl;
cin.ignore(256, '\n');
getline(cin, pesan);
message.push_back(pesan);
}

int main(){
    bool pesbuk =true;
    bool login = false;
    bool chat = false;
    int pil;
    int pil2;
    int pil3;
    int userke;
    int jum = 0;
    vector<string> username;
    vector<string> password;
    vector<string> message;
    while (pesbuk){
    logscreen();
    cin>>pil;
    if (pil==1){
        system("CLS");
        loginpesbuk(username, password, login, userke);
        while(login){
            mainmenu(username,password, userke);
            cin>>pil2;
            if (pil2==1){
                chat = true;
                while(chat){
                selectchat(username,userke);
                cin>>pil3;
                system("CLS");
                if (pil3==0){
                    chat=false;
                }
                else {
                    chatwith(username,pil3,userke,message);
                }
                }
            }
            else if (pil2==0){
                login=false;
            }
        }
    }
    else if (pil==2){
        system("CLS");
        regis(username, password, jum);
        system("CLS");
    }
    else if (pil==0){
        pesbuk=false;
    }
    }
}
