#include <iostream>
#include <math.h>

using namespace std;

int main(){

float x;

cout<<"Masukkan suhu dalam celcius : ";
cin>>x;

float ream, fahr, kelv;

ream = 0.8*x;
kelv = x+273;
fahr = 1.8*x+32;
cout<<x<<" Celcius = "<<fahr<<" Fahrenheit"<<endl;
cout<<x<<" Celcius = "<<ream<<" Reamur"<<endl;
cout<<x<<" Celcius = "<<kelv<<" Kelvin"<<endl;

return 0;
}
