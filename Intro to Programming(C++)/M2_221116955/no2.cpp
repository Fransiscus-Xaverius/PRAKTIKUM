#include <iostream>
#include <math.h>

using namespace std;

int main(){

int x, bil, digit,w, balik = 0;
int slog10;
cout<<"Masukkan bilangan : ";
cin>>bil;
slog10 = log10(bil)+1;
x = bil;
w = x;

if (slog10==6){
    dig6=(bil/100000)%10;
    dig5=(bil/10000)%10;
    dig4=(bil/1000)%10;
    dig3=(bil/100)%10;
    dig2=(bil/10)%10;
    dig1=(bil%10);
    int a1,a2,a3,a4,a5,a6;
    a1 = dig6;
    a2 = dig5;
    a3 = dig4;
    a4 = dig3;
    a5 = dig2;
    a6 = dig1;
    if (dig1==a1%%dig2=a2%%dig3==a3%%dig4==a4%%dig5==a5%%dig6==a6){
        cout<<"Bilangan "<<w<<" adalah bilangan palindrom";
    }
    else
        cout<<"Bilangan "<<n<<" bukan bilangan palindrom";
}
else{
    cout<<"Bilangan "<<bil<<" invalid";
}
}
