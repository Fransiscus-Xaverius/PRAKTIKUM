#include <iostream>
#include <sstream>
#include <vector>
#include <string>
#include <conio.h>
#include <windows.h>
#include <math.h>
#include <fstream>

using namespace std;

void login(string password, vector<string> listpass,int userke, bool &credentials){

for (int i = 0; i<listpass.size(); i++){
    if (password==listpass[userke]){
        credentials=true;
    }
    else credentials = false;
}

}

void menuadmin(){

cout<<"Welcome, Admin"<<endl;
cout<<"1. Add Barang"<<endl;
cout<<"2. Edit Barang"<<endl;
cout<<"3. Delete Barang"<<endl;
cout<<"4. Exit"<<endl;
cout<<">>";

}

void menu(){

cout<<"Welcome to IndoNovember"<<endl;
cout<<"Username : ";

}

void menubeli(vector<string>listuser, vector<int> saldo, int userke){

cout<<"Hi, "<<listuser[userke]<<endl;
cout<<"Saldo "<<saldo[userke]<<endl;
cout<<"1. Beli Barang"<<endl;
cout<<"2. Cart"<<endl;
cout<<"3. Bayar"<<endl;
cout<<"4. Topup"<<endl;
cout<<"0. Exit"<<endl;

}

void tambahbarang(vector<string> &listbarang, vector<int> &hargabarang){
string nama;
int harga;
cout<<"Nama Barang : ";cin>>nama;
cout<<"Harga Barang : ";cin>>harga;
if (harga>0){
    listbarang.push_back(nama);
    hargabarang.push_back(harga);
}
else cout<<"Harga barang tidak valid (lebih kecil atau sama dengan 0)"<<endl;

}

void edit(vector<string> &listbarang, vector<int> &hargabarang, bool &editrun){
string nama;
int harga;
int index;
for (int i = 0; i<listbarang.size();i++){
    cout<<i+1<<". "<<listbarang[i]<<" - "<<hargabarang[i]<<endl;
}
cout<<"0. Exit"<<endl;
cout<<"Barang apa yang akan diedit?"<<endl;
cout<<">>";cin>>index;
if (index==0){
    editrun=false;
    system("CLS");
}
else {
    cin.ignore(256,'\n');
    cout<<"Nama Barang Baru : ";
    getline(cin,nama);
    cout<<"Harga Barang Baru : ";
    cin>>harga;
    if (harga>0){
        listbarang[index-1]=nama;
        hargabarang[index-1]=harga;
    }
    else cout<<"Harga barang tidak valid (lebih kecil atau sama dengan 0)"<<endl;
}

}

void deletebarang(vector<string> &listbarang, vector<int> &hargabarang, bool &admindelete){

vector<string> templist;
vector<int> tempharga;
string tempnama;
int harga;
int index;
for (int i = 0; i<listbarang.size();i++){
    cout<<i+1<<". "<<listbarang[i]<<" - "<<hargabarang[i]<<endl;
}
cout<<"Barang apa yang akan di-delete?"<<endl;
cout<<">>";cin>>index;
if (index==0){
    admindelete=false;
}
else {
    for (int i =0; i<listbarang.size();i++){
        if(i!=index-1){
            tempnama=listbarang[i];
            harga=hargabarang[i];
            templist.push_back(tempnama);
            tempharga.push_back(harga);
        }
    }
    listbarang.clear();
    hargabarang.clear();
    for (int y = 0; y<templist.size();y++){
        listbarang.push_back(templist[y]);
        hargabarang.push_back(tempharga[y]);
    }

}

}

void belibarang(vector<string> listbarang, vector<int> hargabarang, vector<string> &namacart, vector<int> &jumpembelian, bool &run, int &subtotal, vector<int> &totbarang){
    int x;
    int jum;
    int temp;
    cout<<"===================="<<endl;
    cout<<"DAFTAR BARANG"<<endl;
    cout<<"===================="<<endl;
    for (int i =0; i<listbarang.size();i++){
        cout<<i+1<<". "<<listbarang[i]<<" - "<<hargabarang[i]<<endl;
    }
    cout<<"0. Exit"<<endl;
    cout<<"Barang apa yang akan dibeli?"<<endl;
    cout<<">> ";cin>>x;
    if (x>0){
        cout<<"Jumlah Barang : ";cin>>jum;
        namacart.push_back(listbarang[x-1]);
        jumpembelian.push_back(jum);
        temp = hargabarang[x-1]*jum;
        totbarang.push_back(temp);
        subtotal += temp;
    }
    else {
        run=false;
    }
}

void cart(vector<string> &namacart, vector<int> &jumpembelian, vector<int> &totbarang, int &subtotal, int userke, vector<string> listuser, bool &run){

int x;
int pil;
vector<string>templist;
vector<int>tempharga;
vector<int>tempjum;
int harga;
int jumlah;
string tempnama;

cout<<"=================================="<<endl;
cout<<listuser[userke]<<"'s Cart"<<endl;
cout<<"=================================="<<endl;
for (int z = 0; z<namacart.size();z++){
    cout<<z+1<<". "<<namacart[z]<<" - "<<jumpembelian[z]<<" buah - "<<totbarang[z]<<endl;
}
cout<<"Total : "<<subtotal<<endl;
cout<<"=================================="<<endl;
cout<<"1. Remove"<<endl;
cout<<"0. Exit"<<endl;
cout<<">> ";cin>>pil;
if (pil==0){
    run=false;
}
else {
   cout<<"Barang apa yang mau di-remove?"<<endl;
   cout<<">> ";cin>>x;
     for (int i =0; i<namacart.size();i++){
        if(i!=x-1){
            tempnama=namacart[i];
            jumlah=jumpembelian[i];
            harga=totbarang[i];
            templist.push_back(tempnama);
            tempharga.push_back(harga);
            tempjum.push_back(jumlah);
        }
        else {
            subtotal = subtotal-totbarang[i];
        }
    }
    namacart.clear();
    jumpembelian.clear();
    totbarang.clear();
    for (int y = 0; y<templist.size();y++){
        namacart.push_back(templist[y]);
        totbarang.push_back(tempharga[y]);
        totbarang.push_back(tempjum[y]);
    }

}

}

void cetaknota(int pul, int sat, vector<string> namacart, vector<int>jumpembelian, vector<int> totbarang, int subtotal, int userke, vector<string>listuser){
string abc = "NOTA";
ofstream nota;
stringstream nn;
nn<<abc<<pul<<sat<<".txt";
nota.open(nn.str());
nota<<"=============================="<<endl;
nota<<"            "<<abc<<pul<<sat<<endl;
nota<<"=============================="<<endl;
nota<<"Pembeli : "<<listuser[userke]<<endl;
nota<<"=============================="<<endl;
for (int i=0; i<namacart.size();i++){
    nota<<i+1<<". "<<namacart[i]<<" x "<<jumpembelian[i]<<" buah = "<<totbarang[i]<<endl;
}
nota<<"=============================="<<endl;
nota<<"Total Pembayaran       = "<<subtotal;
nota.close();
}

void save(vector<string> listuser, vector<string> listpass, vector<int> saldo, int nota, vector<string> listbarang, vector<int> hargabarang){

    ofstream saveuser;
    saveuser.open("listuser.txt");
    if(saveuser.is_open()){
    for (int i =0; i<listuser.size();i++){
        saveuser<<listuser[i];
        if (i!=listuser.size()-1){
            saveuser<<endl;
        }
    }
    }
    saveuser.close();

    ofstream password;
    password.open("listpass.txt");
    if(password.is_open()){
    for (int y = 0; y<listpass.size();y++){
        password<<listpass[y];
        if (y!=listpass.size()-1){
            password<<endl;
        }
    }
    }
    password.close();

    ofstream listsaldo;
    listsaldo.open("saldo.txt");
    if(listsaldo.is_open()){
    for (int z = 0; z<saldo.size();z++){
        listsaldo<<saldo[z];
        if (z!=saldo.size()-1){
            listsaldo<<endl;
        }
    }
    }
    listsaldo.close();

    ofstream nomornota;
    nomornota.open("NoNota.txt");
    if (nomornota.is_open()){
        nomornota<<nota;
    }
    nomornota.close();

    ofstream barang;
    barang.open("listbarang.txt");
    if (barang.is_open()){
        for (int i = 0; i<listbarang.size();i++){
            barang<<listbarang[i];
            if (i !=listbarang.size()-1){
                barang<<endl;
            }
        }
    }
    barang.close();

    ofstream harga;
    harga.open("hargabarang.txt");
    if (harga.is_open()){
        for (int y = 0; y<hargabarang.size();y++){
            harga<<hargabarang[y];
            if (y!=hargabarang.size()-1){
                harga<<endl;
            }
        }
    }
    harga.close();

}

void load(vector<string> &listuser, vector<string> &listpass, vector<int> &saldo, int &nota, vector<string> &listbarang, vector<int> &hargabarang){

    listuser.clear();
    listpass.clear();
    listbarang.clear();
    saldo.clear();
    hargabarang.clear();

    string tempuser, temppass,tempbarang;
    int nonota,tempsaldo,tempharga;

    ifstream loaduser("listuser.txt", ios::in);
    if (loaduser.is_open()){
         while(!loaduser.eof()){
                getline(loaduser, tempuser);
                listuser.push_back(tempuser);
        }
        loaduser.close();
    }

    ifstream loadpass("listpass.txt", ios::in);
    if (loadpass.is_open()){
         while(!loadpass.eof()){
                getline(loadpass, temppass);
                listpass.push_back(temppass);
        }
        loadpass.close();
    }

    ifstream loadsaldo("saldo.txt", ios::in);
    if (loadsaldo.is_open()){
         while(!loadsaldo.eof()){
                loadsaldo>>tempsaldo;
                saldo.push_back(tempsaldo);
        }
        loadsaldo.close();
    }

    ifstream loadbarang("listbarang.txt", ios::in);
    if (loadbarang.is_open()){
         while(!loadbarang.eof()){
                getline(loadbarang, tempbarang);
                listbarang.push_back(tempbarang);
        }
        loadbarang.close();
    }

    ifstream loadharga("hargabarang.txt", ios::in);
    if (loadharga.is_open()){
         while(!loadharga.eof()){
                loadharga>>tempharga;
                hargabarang.push_back(tempharga);
        }
        loadbarang.close();
    }

    ifstream nomornota("NoNota.txt", ios::in);
    if (nomornota.is_open()){
        nomornota>>nonota;
        nota = nonota;
    }
    nomornota.close();

}

int main(){
    bool run = true;
    string username;
    vector<string> listuser;
    string password;
    vector<string> listpass;
    vector<int> saldo;
    vector<string> listbarang;
    vector<int> hargabarang;
    vector<string> namacart;
    vector<int> jumpembelian;
    vector<int> totharga;
    int subtotal=0;
    int cek=0;
    bool salahpass=false;
    bool credentials;
    int userke;
    int piladmin;
    int nota=1;

    load(listuser,listpass,saldo,nota,listbarang,hargabarang);

    int pul = nota/10;
    int sat = nota%10;

    while(run){
        if (salahpass==true){
            cout<<"Password Salah!!!"<<endl;
        }
        menu();
        getline(cin,username);
        cout<<"Password : ";
        getline(cin,password);
        if (password=="-1"&&username=="-1"){
            run=false;
        }
        else if (password=="admin"&&username=="admin"){
            bool admin = true;
            system("CLS");
            while (admin){
                menuadmin();
                cin>>piladmin;
                if (piladmin==1){
                    tambahbarang(listbarang,hargabarang);
                    system("CLS");
                }
                else if (piladmin==2){
                    bool editrun = true;
                    while(editrun){
                        edit(listbarang,hargabarang,editrun);
                    }
                }
                else if (piladmin==3){
                    bool admindelete=true;
                    while(admindelete){
                        deletebarang(listbarang,hargabarang,admindelete);
                        system("CLS");
                    }
                }
                else if (piladmin==4){
                    admin=false;
                    cin.ignore(256,'\n');
                    system("CLS");
                }
            }
        }
        else {
            for (int i = 0; i<listuser.size();i++){
                if (username==listuser[i]){
                    cek = 1;
                    userke = i;

                }
            }
            if (cek==1){
                login(password,listpass,userke,credentials);
                if (credentials==true){
                    salahpass=false;
                    int pilcus;
                    bool beli=true;
                    while(beli){
                        menubeli(listuser,saldo,userke);
                        cin>>pilcus;
                        if (pilcus==1){
                            bool lihat =true;
                            while(lihat){
                                belibarang(listbarang,hargabarang,namacart,jumpembelian,lihat,subtotal,totharga);
                            }
                        }
                        else if (pilcus==2){
                            bool viewcart=true;
                            while(viewcart){
                                cart(namacart,jumpembelian,totharga,subtotal,userke,listuser,viewcart);
                            }
                        }
                        else if (pilcus==3){
                            bool bayar =true;
                            while (bayar){
                                if (subtotal>saldo[userke]){
                                    system("CLS");
                                    cout<<"Saldo Tidak mencukupi"<<endl;
                                    bayar=false;
                                }
                                else {
                                    cetaknota(pul,sat,namacart,jumpembelian,totharga,subtotal,userke,listuser);
                                    cout<<"Nota Tercetak!"<<endl;
                                    nota++;
                                    saldo[userke]=saldo[userke]-subtotal;
                                    bayar=false;
                                    namacart.clear();
                                    jumpembelian.clear();
                                    subtotal=0;
                                    totharga.clear();
                                    system("pause");
                                }
                            }
                        }
                        else if (pilcus==4){
                            saldo[userke]+=10000;
                        }
                        else if (pilcus==0){
                            beli=false;

                            cin.ignore(256,'\n');
                        }
                    }

                }
                else {
                    salahpass=true;
                }
            }
            else {
                listuser.push_back(username);
                listpass.push_back(password);
                int saldoawal=0;
                saldo.push_back(saldoawal);

            }

        }
    }
    save(listuser,listpass,saldo,nota,listbarang,hargabarang);



}
