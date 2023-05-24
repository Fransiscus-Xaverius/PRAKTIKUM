#include <iostream>
#include <math.h>

using namespace std;

int main(){

float a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;

cout<<"Angka 1 : ";
cin>>a1;
cout<<"Angka 2 : ";
cin>>a2;
cout<<"Angka 3 : ";
cin>>a3;
cout<<"Angka 4 : ";
cin>>a4;
cout<<"Angka 5 : ";
cin>>a5;
cout<<"Angka 6 : ";
cin>>a6;
cout<<"Angka 7 : ";
cin>>a7;
cout<<"Angka 8 : ";
cin>>a8;
cout<<"Angka 9 : ";
cin>>a9;
cout<<"Angka 10 : ";
cin>>a10;

float rtrt;
rtrt = (a1+a2+a3+a4+a5+a6+a7+a8+a9+a10)/10;

float rta1,rta2,rta3,rta4,rta5,rta6,rta7,rta8,rta9,rta10;
rta1 = pow((a1-rtrt),2);
rta2 = pow((a2-rtrt),2);
rta3 = pow((a3-rtrt),2);
rta4 = pow((a4-rtrt),2);
rta5 = pow((a5-rtrt),2);
rta6 = pow((a6-rtrt),2);
rta7 = pow((a7-rtrt),2);
rta8 = pow((a8-rtrt),2);
rta9 = pow((a9-rtrt),2);
rta10 = pow((a10-rtrt),2);
float rtatot,rper,rhasil;
rtatot = rta1+rta2+rta3+rta4+rta5+rta6+rta7+rta8+rta9+rta10;
rper = rtatot/10;
rhasil = pow(rper,0.5);
cout<<"Rata-rata data : "<<rtrt<<endl;
cout<<"Standar Deviasi : "<<rhasil;

}
