#include <math.h>
#include <iostream>

using namespace std;

int main(){



cout<<"**********************************"<<endl;
cout<<"*       Program Tambah Jam       *"<<endl;
cout<<"**********************************"<<endl;

int jam, menit,detik,tambahan;

cout<<" Jam   : ";
cin>>jam;

cout<<" Menit : ";
cin>>menit;

cout<<" Detik : ";
cin>>detik;

cout<<"----------------------------------"<<endl;
cout<<" Tambahan detik : ";
cin>>tambahan;
cout<<"----------------------------------"<<endl;

int jd, md, tjam,jamtot;

jd = jam*3600;
md = menit*60;
tjam = jd+md+detik;
jamtot = tjam+tambahan;

int aj, am, ad;

aj = (jamtot/3600)%60;
am = (jamtot/60)%60;
ad = jamtot%60;

cout<<" Hasil : "<<aj<<" jam "<<am<<" menit "<<ad<<" detik"<<endl;
cout<<"**********************************";
}
