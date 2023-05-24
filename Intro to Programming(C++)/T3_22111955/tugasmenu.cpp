#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <math.h>

using namespace std;

int main(){

int menu;
int x=1;
int kjb;
int kjb2;
int kjb3;
int jb;
int hbtl=0;
int sjb,pjb,rjb,rbjb,prbjb;
int satu,puluh,ratus,ribu,pribu;
int angka;
int j = 1;
int i = 1;
int itot;
int ha;
int gnj;
int can;
int hak;
int k = 0;
srand(time(NULL));

do{
    int btl=0;
    cout<<"MENU"<<endl;
    cout<<"==========="<<endl;
    cout<<"1. Tebak Password"<<endl;
    cout<<"2. Number-n"<<endl;
    cout<<"0. Exit"<<endl;
    cout<<">>";cin>>menu;
    if (menu==1){
        int zh,zx;
int kjb,jb,kjb2;
int running =1;
srand(time(NULL));
int satu,puluh,ratus,ribu,pribu;
int btl = 0;
int kjb3;
kjb = rand() % 99999 +10000;
kjb2 = kjb;
kjb3 = kjb;
satu = kjb2%10;
puluh = (kjb2/10)%10;
ratus = (kjb2/100)%10;
ribu = (kjb2/1000)%10;
pribu = (kjb2/10000)%10;
int cek;
int checker =0;
int sama =0;

while(running==1){
    cout<<"Kunci jawaban: "<<kjb2<<endl;
    cout<<"Input: ";cin>>jb;
    if (jb==-1){
        running=0;
    }
    else{
    if (satu==puluh){
        sama++;
    }
    if (satu==ratus){
        sama++;
    }
    if (satu==ribu){
        sama++;
    }
    if (satu==pribu){
        sama++;
    }
    if (puluh==ratus){
        sama++;
    }
    if (puluh==ribu){
        sama++;
    }
    if (puluh==pribu){
        sama++;
    }
    if (ratus==ribu){
        sama++;
    }
    if (ratus==pribu){
        sama++;
    }
    if (ribu==pribu){
        sama++;
    }
    while(kjb!=0 && jb!=0){
        zh = jb%10;
        zx = kjb%10;
        kjb = kjb/10;
        jb = jb/10;

        if (zh==zx){
            btl++;
                }
        if (zh==satu || zh==puluh || zh==ratus || zh==ribu || zh==pribu && zh==zx){
            cek = 1;
        }
        if (cek==1){
            checker++;
        }

        }
        if (btl>=0 && btl<5){
        cout<<btl<<" angka benar dan berada di posisi yang tepat"<<endl;
            if ((((btl-checker)*-1)-sama)<0){
            cout<<((btl-checker)*-1)<<" angka benar namun berada di posisi yang salah."<<endl;
            }
            else {
                 cout<<(((btl-checker)*-1)-sama)<<" angka benar namun berada di posisi yang salah."<<endl;
            }
        }
        else if (btl==5){
            cout<<"Selamat Anda berhasil menebak password!";
            running=0;
        }
    }

}
    }
else if (menu==2){
    do{
        can = 1;
        cout<<"Input angka :";cin>>angka;
        itot = 0;
        k = 0;
        i = 1;
        j = 1;
        if (angka>0 && angka%2==0){
            do{
                cout<<"((";
                itot = 0;
                do{
                        for(j = 1; j <= i; j++) {
                            if (j<i){
                                cout << j << "+";
                                itot += j;
                            }
                            else {
                                cout<<j;
                                itot += j;
                            }

                        }
                        cout<<")+(";
                        if (i!=0 && i%2==0){
                            k=i;
                        }
                        else if (i==0){
                            k=0;
                        }
                        cout<<k<<"))*"<<i;
                        ha = ((itot+k)*i);
                        cout<<" = "<<ha;
                }while(j<=i);
                cout<<endl;
                i++;
            }while(i<=angka);
        }
        else if (angka>0 && angka%2==1){
            do{
                cout<<"((";
                itot = 1;
                gnj = 1;
                do{
                        for(j = 1; j <= i; j++) {
                            if (j<i){
                                cout << j << "*";
                                itot = itot*j;
                            }
                            else {
                                cout<<j;
                                itot = itot*j;
                            }
                        }
                        cout<<")-(";
                        k=i;
                        if (i!=0 && i%2==1){
                            gnj=i;
                        }
                        else if (i%2==0){
                            gnj=i-1;
                        }
                        cout<<k<<"))*"<<gnj;
                        ha = (itot-k);
                        hak = ha*gnj;
                        cout<<" = "<<hak;
                }while(j<=i);
                cout<<endl;
                i++;
            }while(i<=angka);
        }
        else if (angka<0){
            can=0;
}

    }while (can==1);
}

}while(menu!=0);
}
