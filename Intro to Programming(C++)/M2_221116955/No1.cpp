#include <iostream>
#include <math.h>

using namespace std;

int main(){

float uh1,uh2,uh3,uh4;

cout<<"Masukkan nilai ulangan harian ke-1 : ";cin>>uh1;
cout<<"Masukkan nilai ulangan harian ke-2 : ";cin>>uh2;
cout<<"Masukkan nilai ulangan harian ke-3 : ";cin>>uh3;
cout<<"Masukkan nilai ulangan harian ke-4 : ";cin>>uh4;

float UTS,UAS;
cout<<"Masukkan nilai UTS : ";cin>>UTS;
cout<<"Masukkan nilai UAS : ";cin>>UAS;

float rtrt,pemu,pemt,pema;

rtrt = ((uh1+uh2+uh3+uh4)/4);
pemu = rtrt*0.3;
pemt = UTS*0.3;
pema = UAS*0.4;

float tot;

tot = pemu+pemt+pema;

if (tot>=90 && tot<=100){
    cout<<"Grade yang didapat adalah A dengan nilai akhir "<<tot;
}
else if (tot>=80 && tot<=89){
    cout<<"Grade yang didapat adalah B dengan nilai akhir "<<tot;
}
else if (tot>=70 && tot<=79){
    cout<<"Grade yang didapat adalah C dengan nilai akhir "<<tot;
}
else if (tot>=60 && tot<=69){
    cout<<"Grade yang didapat adalah D dengan nilai akhir "<<tot;
}
else if (tot<60){
    cout<<"Grade yang didapat adalah E dengan nilai akhir "<<tot;
}
else{
    cout<<"invalid";
}
}
