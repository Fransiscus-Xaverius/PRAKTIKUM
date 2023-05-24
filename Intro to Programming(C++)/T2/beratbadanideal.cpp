#include <iostream>
#include <math.h>

using namespace std;

int main(){

int jk,tb;
double bbskrg,bbt,bbp,bbi;

cout<<"Program Berat Ideal"<<endl<<endl;
cout<<"Gender"<<endl<<endl;
cout<<"1. Pria"<<endl;
cout<<"2. Wanita"<<endl<<endl;
cout<<"Pilih : ";cin>>jk;;
cout<<"Masukkan tinggi badan : ";cin>>tb;
cout<<"Masukkan berat badang sekarang : ";cin>>bbskrg;
cout<<"Keterangan : "<<endl;

double jangkauan;

if (jk==1){
    bbt = (tb-100);
    bbp = bbt*0.1;
    bbi = bbt-bbp;
    if (bbi<bbskrg){
        jangkauan = bbskrg - bbi;
        cout<<"Estimasi berat badan idealmu adalah "<<bbi<<" kilogram dan kamu perlu menurunkan berat badan sebanyak "<<jangkauan<<" kilogram dari berat badan sekarang.";
    }
    else if (bbi>bbskrg){
        jangkauan = bbi - bbskrg;
        cout<<"Estimasi berat badan idealmu adalah "<<bbi<<" kilogram dan kamu perlu menaikkan berat badan sebanyak "<<jangkauan<<" kilogram dari berat badan sekarang.";
    }
    else if (bbi==bbskrg){
        cout<<"Estimasi berat badan idealmu adalah "<<bbi<<" kilogram dan berat badanmu sekarang sudah ideal. ";
    }
}
else if (jk==2){
    bbt = (tb-100);
    bbp = bbt*0.15;
    bbi = bbt-bbp;
    if (bbi<bbskrg){
        jangkauan = bbskrg - bbi;
        cout<<"Estimasi berat badan idealmu adalah "<<bbi<<" kilogram dan kamu perlu menurunkan berat badan sebanyak "<<jangkauan<<" kilogram dari berat badan sekarang.";
    }
    else if (bbi>bbskrg){
        jangkauan = bbi - bbskrg;
        cout<<"Estimasi berat badan idealmu adalah "<<bbi<<" kilogram dan kamu perlu menaikkan berat badan sebanyak "<<jangkauan<<" kilogram dari berat badan sekarang.";
    }
    else if (bbi==bbskrg){
        cout<<"Estimasi berat badan idealmu adalah "<<bbi<<" kilogram dan berat badanmu sekarang sudah ideal. ";
    }
}
else
    cout<<"Invalid input";
}
