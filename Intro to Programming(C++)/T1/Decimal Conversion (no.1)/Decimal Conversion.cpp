#include <iostream>
#include <math.h>

using namespace std;

int main(){
    int n;
    cout<<"======================================"<<endl;
    cout<<"          Decimal Conversion"<<endl;
    cout<<"======================================"<<endl;
    cout<<" Masukkan Bilangan Decimal : ";
    cin>>n;
    cout<<"--------------------------------------"<<endl;

    int pd = (log10(n)) + 1;
    cout<<" Panjang Bilangan : "<<pd<<" digit"<<endl;
    cout<<"--------------------------------------"<<endl;

    int s,p,ra,ri;
    s = n%10;
    p = (n/10)%10;
    ra = (n/100)%10;
    ri = (n/1000)%10;

    cout<<" Digit 1 : "<<ri<<endl;
    cout<<" Digit 2 : "<<ra<<endl;
    cout<<" Digit 3 : "<<p<<endl;
    cout<<" Digit 4 : "<<s<<endl;

    cout<<"--------------------------------------"<<endl;

    long long int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;

    a1 = 10000000000*((n & 1024)/1024);
    a2 = 1000000000*((n & 512)/512);
    a3 = 100000000*((n & 256)/256);
    a4 = 10000000*((n & 128)/128);
    a5 = 1000000*((n & 64)/64);
    a6 = 100000*((n & 32)/32);
    a7 = 10000*((n & 16)/16);
    a8 = 1000*((n & 8)/8);
    a9 = 100*((n & 4)/4);
    a10 = 10*((n & 2)/2);
    a11 = 1*((n & 1)/1);


    cout<<" Bilangan biner    : ";
    cout<<a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + a11<<endl;

    int sis1,sis2,sis3,ha1,ha2,ha3,sis4;

    ha1= n/8;
    sis1= n%8;
    ha2= ha1/8;
    sis2= ha1%8;
    ha3 = ha2/8;
    sis3 = ha2%8;
    sis4 = ha3%8;

    cout<<" Bilangan octal    : ";
    cout<<sis4<<sis3<<sis2<<sis1<<endl;
    cout<<"======================================"<<endl;



}
