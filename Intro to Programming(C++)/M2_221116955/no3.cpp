#include <iostream>
#include <math.h>

using namespace std;

int main(){

int x,y;

cout<<"Beli Buah"<<endl;
cout<<"1. Apel"<<endl;
cout<<"2. Jeruk"<<endl;
cout<<"3. Mangga"<<endl;
cout<<"Input : ";cin>>x;
cout<<"Banyak buah yang ingin dibeli : ";cin>>y;

int apel, jeruk, mangga, totl, jenis, diskon;
apel = 3000;
jeruk = 4000;
mangga = 5000;

if(x==1){
    totl = apel*y;
    jenis = 1;
}
else if (x==2){
    totl = jeruk*y;
    jenis = 2;
}
else if (x==3){
    totl = mangga*y;
    jenis = 3;
}
else{
    cout<<"invalid input, tidak ada buah yang dipilih";
}

if (y>=5){
    diskon = (totl*0.1);
    if (jenis==1){
    cout<<"Berhasil membeli buah apel sebanyak "<<y<<" buah dengan harga Rp. "<<totl<<" dan mendapat diskon sebesar Rp. "<<diskon;
    }
    else if (jenis==2){
    cout<<"Berhasil membeli buah jeruk sebanyak "<<y<<" buah dengan harga Rp. "<<totl<<" dan mendapat diskon sebesar Rp. "<<diskon;
    }
    else if (jenis==3){
    cout<<"Berhasil membeli buah mangga sebanyak "<<y<<" buah dengan harga Rp. "<<totl<<" dan mendapat diskon sebesar Rp. "<<diskon;
    }
    else {
        cout<<"invalid";
    }
}
else {
    if (jenis==1){
    cout<<"Berhasil membeli buah apel sebanyak "<<y<<" buah dengan harga Rp. "<<totl;
}
    else if (jenis==2){
    cout<<"Berhasil membeli buah jeruk sebanyak "<<y<<" buah dengan harga Rp. "<<totl;
}
    else if (jenis==3){
    cout<<"Berhasil membeli buah manga sebanyak "<<y<<" buah dengan harga Rp. "<<totl;
}
    else {
        cout<<"invalid";
    }



}
}
