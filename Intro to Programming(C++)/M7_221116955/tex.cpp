#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>

using namespace std;

void mainmenu(){

cout<<"MENU UTAMA"<<endl;
cout<<"-----------------"<<endl;
cout<<"1. Tambah data"<<endl;
cout<<"2. Lihat Semua Data"<<endl;
cout<<"3. Laporan Keuangan"<<endl;
cout<<"4. Simpan"<<endl;
cout<<">>";
}

void tambahdata(vector<string> namapemasukan, vector<string> namapengeluaran, vector<int> pemasukan, vector<int> pengeluaran){
string tempnamapengeluaran;
string tempnamapemasukan;

//int x;
//    cout<<"Jenis Laporan"<<endl;
//    cout<<"1. Pemasukan"<<endl;
//    cout<<"2. Pengeluaran"<<endl;
//    cout<<">> ";cin>> x;
//
//    if (x==1){
//            cout<<"Nama Laporan";
//            cin.ignore(256,'\n');
//            getline(cin,tempnamapemasukan);
//            cout<<"Nominal : Rp ";
//            cin.ignore(256,'\n');
//            cin>>temppemasukan;
//            namapemasukan.push_back(tempnamapemasukan);
//            pemasukan.push_back(temppemasukan);
//        }
//    else if (x==2){
//            cout<<"Nama Laporan";
//            cin.ignore(256,'\n');
//            getline(cin,tempnamapengeluaran);
//            cout<<"Nominal : Rp ";
//            cin.ignore(256,'\n');
//            cin>>temppengeluaran;
//            namapemasukan.push_back(tempnamapengeluaran);
//            pemasukan.push_back(temppengeluaran);
//        }

}

void lihatdata(vector<string> namapemasukan, vector<string> namapengeluaran, vector<int>pemasukan, vector<int>pengeluaran){

cout<<"SEMUA LAPORAN"<<endl;
cout<<"------------------------------------"<<endl;
cout<<"Pemasukan"<<endl;
for (int i = 0; i<pemasukan.size(); i++){
    cout<<(i+1)<<". "<<namapemasukan[i]<<" - Rp "<<pemasukan[i]<<endl;

}
cout<<"Pengeluaran"<<endl;
for (int i = 0; i<pengeluaran.size();i++){
    cout<<(i+1)<<". "<<namapengeluaran[i]<<" - Rp "<<pengeluaran[i]<<endl;
}
cout<<"------------------------------------"<<endl;
}

void laporan(vector<string> namapemasukan, vector<string> namapengeluaran, vector<int>pemasukan, vector<int>pengeluaran, string namamaxpeng, string namamaxpem, int pengeluaranmax, int pemasukanmax){
int totalpengeluaran = 0;
int totalpemasukan = 0;

for (int i = 0; i<pengeluaran.size();i++){
    totalpengeluaran=totalpengeluaran+pengeluaran[i];
}

for (int i = 0; i<pemasukan.size();i++){
    totalpemasukan=totalpemasukan+pemasukan[i];



cout<<"LAPORAN KEUANGAN"<<endl;
cout<<"--------------------------------------"<<endl;

cout<<"Pemasukan terbesar : "<<namamaxpem<<" (Rp "<<pemasukanmax<<")"<<endl;
cout<<"Pengeluaran terbesar :"<<namamaxpeng<<" (Rp "<<pengeluaranmax<<")"<<endl;

cout<<endl;
cout<<"Total pemasukan  : Rp "<<totalpemasukan<<endl;
cout<<"Total pengeluaran : Rp "<<totalpengeluaran<<endl;
}

cout<<"Status Keuangan  :";

if (totalpemasukan>totalpengeluaran){
    cout<<"UNTUNG"<<(totalpemasukan-totalpengeluaran);
}
else if (totalpemasukan<totalpengeluaran){
    cout<<"RUGI"<<(totalpengeluaran-totalpemasukan);
}

}

void save(vector<int> pemasukan, vector<int> pengeluaran, vector<string> namapemasukan, vector<string> namapengeluaran){

ofstream untung;
untung.open("untung.txt", ios::app);
if (untung.is_open())
    {
                for(int i=0; i<pemasukan.size(); i++)
                {
                    untung << pemasukan[i] << endl;
                    if(i != pemasukan.size() - 1) untung << endl;
                }
    untung.close();
    }
ofstream rugi;
rugi.open("rugi.txt", ios::app);
if (rugi.is_open()){
    {
                for(int i=0; i<pengeluaran.size(); i++)
                {
                    rugi << pengeluaran[i] << endl;
                    if(i != pengeluaran.size() - 1) rugi << endl;
                }
    rugi.close();
    }
}

ofstream namauntung;
namauntung.open("untung.txt", ios::app);
if (namauntung.is_open())
    {
                for(int i=0; i<namapemasukan.size(); i++)
                {
                    namauntung << namapemasukan[i] << endl;
                    if(i != namapemasukan.size() - 1) namauntung << endl;
                }
    namauntung.close();
    }

ofstream namarugi;
namarugi.open("namauntung.txt", ios::app);
if (namauntung.is_open())
    {
                for(int i=0; i<namapengeluaran.size(); i++)
                {
                    namarugi << namapengeluaran[i] << endl;
                    if(i != namapengeluaran.size() - 1) namarugi << endl;
                }
    namarugi.close();
    }

}

int main(){
vector<string> namapemasukan;
vector<string> namapengeluaran;
vector<int> pemasukan;
vector<int> pengeluaran;
bool jalan = true;
bool tambah = false;
bool lihat = false;
int pengeluaranmax = 0;
int pemasukanmax = 0;
string namamaxpeng;
string namamaxpem;
int pil;
string tempnamapemasukan;
string tempnamapengeluaran;
int temppemasukan;
int temppengeluaran;
int x;
while(jalan){

    mainmenu();
    cin>>pil;
    if (pil==1){
    bool tambah = true;
    while(tambah){

    cout<<"Jenis Laporan"<<endl;
    cout<<"1. Pemasukan"<<endl;
    cout<<"2. Pengeluaran"<<endl;
    cout<<">> ";cin>>x;

    if (x==1){
            cout<<"Nama Laporan : ";
            cin.ignore(256,'\n');
            getline(cin,tempnamapemasukan);
            cout<<"Nominal : Rp ";
            cin>>temppemasukan;
            if (temppemasukan>pemasukanmax){
                pemasukanmax=temppemasukan;
                namamaxpem=tempnamapemasukan;
            }
            namapemasukan.push_back(tempnamapemasukan);
            pemasukan.push_back(temppemasukan);
             tambah=false;
        }
    else if (x==2){
            cout<<"Nama Laporan";
            cin.ignore(256,'\n');
            getline(cin,tempnamapengeluaran);
            cout<<"Nominal : Rp ";
            cin>>temppengeluaran;
            if (temppengeluaran>pengeluaranmax){
                pengeluaranmax=temppengeluaran;
                namamaxpeng=tempnamapengeluaran;
            }
            namapemasukan.push_back(tempnamapengeluaran);
            pemasukan.push_back(temppengeluaran);
             tambah=false;
        }

    }
    }
    else if (pil==2){
        bool lihat = true;
        while (lihat){
        lihatdata(namapemasukan,namapengeluaran,pemasukan,pengeluaran);
        lihat = false;
        }
    }
    else if (pil==3){
        laporan(namapemasukan,namapengeluaran,pemasukan,pengeluaran,namamaxpeng,namamaxpem,pengeluaranmax,pemasukanmax);
    }
    else if (pil==4){
        save(pemasukan,pengeluaran,namapemasukan,namapengeluaran);
    }
}


}
