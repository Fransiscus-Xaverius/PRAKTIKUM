#include <iostream>
#include <math.h>

using namespace std;

int main() {

float a,b;
a = 0;
b = 0;

cout<<"Input bilangan pertama : ";
cin>>a;
cout<<"Input bilangan kedua : ";
cin>>b;

float apb,amb,akb,per,tota;
apb = a+b;
amb = a-b;
akb = a*b;
per = (apb/amb);
tota = per*akb;

cout<<"Hasil : "<<tota;

return 0;

}
