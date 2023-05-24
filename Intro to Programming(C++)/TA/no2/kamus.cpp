#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
#include <vector>

using namespace std;

void menu(){
cout<<"Kamus"<<endl;
cout<<"1. Tambah Kata"<<endl;
cout<<"2. Lihat Semua Kata"<<endl;
cout<<"3. Cari Kata"<<endl;
cout<<"0. Exit"<<endl;
cout<<">> ";
}

void addkata(vector<string> &listkata , vector<string> &desc, bool ABC[26], int ABC1[26]){
string katabaru;
bool kembar = false;
string deskripsi;
cout<<"Kata : ";
cin.ignore(256,'\n');
getline(cin,katabaru);
for (int i = 0; i<listkata.size();i++){
    if(listkata[i]==katabaru){
        kembar = true;
    }
}
if (kembar == true){
    cout<<"Kata kembar"<<endl;
}
else {
    listkata.push_back(katabaru);
    char a = katabaru.front();


    cout<<"Deskripsi : ";
    getline(cin,deskripsi);
    desc.push_back(deskripsi);
}

}

void liatkata(vector<string> &listkata, vector<string> &desc, bool ABC[26], int abc[26], bool &run){

int counter;
string temp;
vector<string> templist;
vector<string> tempdesc;
string lis;
string des;
char x;
int b,p,t;
bool pilihan;
bool cetak[26];
for (int y = 0; y<26;y++){
    ABC[y]=cetak[y];
}

for (int i = 0; i<listkata.size();i++){
    cout<<i+1<<". "<<listkata[i]<<endl;
}
cout<<"0. Kembali"<<endl;
cout<<">>";
cin>>b;
t=b;
pilihan=true;
if (b-1==-1){
    run=false;
    pilihan=false;
}
while(pilihan){
    cout<<"Kata: "<<listkata[t-1]<<endl;
    cout<<"Deskripsi: "<<desc[t-1]<<endl;
    cout<<"1. Hapus kata ini"<<endl;
    cout<<"0. Kembali"<<endl;

    cout<<">> ";cin>>p;
    if (p==1){
        for (int i = 0; i<listkata.size();i++){
            if (i!=p){
                lis=listkata[i];
                des=desc[i];
                templist.push_back(lis);
                tempdesc.push_back(des);
            }
        }
        listkata.clear();
        desc.clear();
        for (int y = 0; y<templist.size();y++){
        lis=templist[y];
        des=tempdesc[y];
        listkata.push_back(lis);
        desc.push_back(des);
        pilihan=false;
        run=true;
        }
    }
    else if (p==0){
        pilihan=true;
    }
}

}

void save(vector<string> listkata, vector<string> desc){

    ofstream savekata;
    savekata.open("listkata.txt");
    if(savekata.is_open()){
    for (int i =0; i<listkata.size();i++){
        savekata<<listkata[i];
        if (i!=listkata.size()-1){
            savekata<<endl;
        }
    }
    }
    savekata.close();

    ofstream savedesc;
    savedesc.open("listdesc.txt");
    if(savedesc.is_open()){
    for (int i =0; i<desc.size();i++){
        savedesc<<desc[i];
        if (i!=desc.size()-1){
            savedesc<<endl;
        }
    }
    }
    savedesc.close();

}

void load(vector<string> &listkata, vector<string> &desc){

string tempkata;
string tempdesc;

ifstream loadkata("listkata.txt", ios::in);
    if (loadkata.is_open()){
         while(!loadkata.eof()){
                getline(loadkata, tempkata);
                listkata.push_back(tempkata);
        }
        loadkata.close();
    }

ifstream loaddesc("listdesc.txt", ios::in);
    if (loaddesc.is_open()){
         while(!loaddesc.eof()){
                getline(loaddesc, tempdesc);
                desc.push_back(tempdesc);
        }
        loaddesc.close();
    }

}

int main(){
int pil;
vector<string> listkata;
vector<string> desc;
bool ABC [26]={false};
int jumabc[26]={0};
bool run = true;
bool liat = false;
listkata.clear();
desc.clear();
load(listkata,desc);
while(run){

    menu();
    cin>>pil;
    if (pil==1){
        addkata(listkata,desc,ABC,jumabc);
        save(listkata,desc);
    }
    else if (pil==2){
        liat = true;
        while(liat){
            liatkata(listkata, desc, ABC, jumabc,liat);
        }
        save(listkata,desc);
    }
    else if (pil==3){

    }
    else if (pil==0){
        run=false;
        save(listkata,desc);
    }




}



}
