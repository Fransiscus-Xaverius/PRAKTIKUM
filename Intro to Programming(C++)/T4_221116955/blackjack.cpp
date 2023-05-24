#include <iostream>
#include <time.h>
#include<stdlib.h>

using namespace std;

int main(){

int stage, c1,c2,c3,c4,c5,ct;
int pc1,pc2,pc3,pc4,pc5,pct;
bool blackjackrun = true;
stage = 1;
int turn = 2;
bool stagerun;
srand(time(NULL));
int qjk, qjk2, qjk3, qjk4, qjk5;
int pqjk, pqjk2, pqjk3, pqjk4, pqjk5;
int go;
bool fold1,fold2,fold3,fold4,fold5,fold6;
fold1=false;
fold2=false;
fold3=false;
fold4=false;
fold5=false;
fold6=false;



cout<<"     Welcome to Blackjack"<<endl;
cout<<"------------------------------"<<endl;
c1 = rand() % 11 + 2;
c2 = rand() % 11 + 2;
c3 = rand() % 11 + 2;
c4 = rand() % 11 + 2;
c5 = rand() % 11 + 2;
pc1 = rand() % 11 + 2;
pc2 = rand() % 11 + 2;
pc3 = rand() % 11 + 2;
pc4 = rand() % 11 + 2;
pc5 = rand() % 11 + 2;

while (blackjackrun){
    stagerun=true;
    cout<<"Stage-"<<stage<<endl;
    cout<<"Player      : ";
    if (c1==10){
                qjk = rand() % 3 + 1;
                switch (qjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                cout<<endl;
                }
            else if (c1>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<c1<<" "<<endl;
            }
            ct = c1;
    cout<<"Computer    : ";
    if (pc1==10){
                pqjk = rand() % 3 + 1;
                switch (pqjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                cout<<endl;
                }
            else if (pc1>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<pc1<<" "<<endl;
            }
            pct = pc1;
    cout<<"1. Draw"<<endl;
    cout<<"2. Fold"<<endl;
    cout<<"3. Exit"<<endl;
    cin>>go;
    while (stagerun){
        cout<<"Player      : ";
        if (turn==2){
            if (c1==10){
                switch (qjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (c1>=11){
                cout<<"A ";
            }
            else {
                cout<<c1<<" ";
            }
            if (go==1){
            if (c2==10){
                qjk2 = rand() % 3 + 1;
                switch (qjk2){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }

                cout<<endl;
                }
            else if (c2>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<c2<<" "<<endl;
            }
            ct = ct+c2;
            }
            else if (go==2){
                fold2 = true;
                cout<<"-Fold-"<<endl;
            }
            else if (go==3){
                stagerun=false;
            }
        }
        else if (turn==3){
            if (c1==10){
                switch (qjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
            }
            else if (c1>=11){
                cout<<"A ";
            }
            else {
                cout<<c1<<" ";
            }
            if (c2==10 && fold2==false){
                switch (qjk2){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (c2>=11 && fold2==false){
                cout<<"A ";
            }
            else if (fold2==true){
                cout<<"-Fold-"<<endl;
            }
            else {
                cout<<c2<<" ";
            }
            if (go==1 && fold2==false){
            if (c3==10){
                qjk3 = rand() % 3 + 1;
                switch (qjk3){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }

                cout<<endl;
                }
            else if (c2>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<c3<<" "<<endl;
            }
            ct = ct+c3;
            }
            else if (go==2){
                fold3 = true;
                cout<<"-Fold-"<<endl;
            }
            else if (go==3){
                stagerun=false;
            }
        }
        else if (turn==4){
            if (c1==10){
                switch (qjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
            }
            else if (c1>=11){
                cout<<"A ";
            }
            else {
                cout<<c1<<" ";
            }
            if (c2==10 && fold2==false){
                switch (qjk2){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (c2>=11 && fold2==false){
                cout<<"A ";
            }
            else if (fold2==true){
                cout<<"-Fold-";
            }
            else {
                cout<<c2<<" ";
            }
            if (fold2==false){
            if (c3==10){
                switch (qjk3){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (c3>=11){
                cout<<"A ";
            }
            else {
                cout<<c3<<" ";
            }
            if (go==1&&fold3==false&&fold2==false){
                if (c4==10){
                qjk4 = rand() % 3 + 1;
                switch (qjk4){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                cout<<endl;
                }
            else if (c4>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<c4<<" "<<endl;
            }
            ct=ct+c4;
            }
            else if (go==2){
                fold4 = true;
                cout<<"-Fold-"<<endl;
            }
            else if (go==3){
                stagerun=false;
            }
            }

        }
        if (turn==5){

        }
        cout<<"Computer :     ";
        if (turn==2){
            if (pc1==10){
                switch (pqjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (pc1>=11){
                cout<<"A ";
            }
            else {
                cout<<pc1<<" ";
            }
            if (pc2==10){
                pqjk2 = rand() % 3 + 1;
                switch (pqjk2){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                cout<<endl;
                }
            else if (pc2>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<pc2<<" "<<endl;
            }
            pct = pc1+pc2;
        }
        if (turn==3 && pct<19){
            if (pc1==10){
                switch (pqjk){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (pc1>=11){
                cout<<"A ";
            }
            else {
                cout<<pc1<<" ";
            }
            if (pc2==10){
                switch (pqjk2){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                }
            else if (pc2>=11){
                cout<<"A ";
            }
            else {
                cout<<pc2<<" ";
            }
            if (pc3==10){
                pqjk3 = rand() % 3 + 1;
                switch (pqjk3){
                case 3:
                    cout<<"K ";
                    break;
                case 2:
                    cout<<"Q ";
                    break;
                case 1:
                    cout<<"J ";
                    break;
                }
                cout<<endl;
                }
            else if (pc3>=11){
                cout<<"A "<<endl;
            }
            else {
                cout<<pc3<<" "<<endl;
            }
            pct = pct+pc3;
        }
        if (fold2==true||fold3==true||fold4==true||fold5==true){
            cout<<"Player Fold!!!"<<endl;
        }
        if (fold2==false&&fold3==false&&fold4==false&&fold5==false&&fold6==false){
        cout<<"1. Draw"<<endl;
        cout<<"2. Fold"<<endl;
        cout<<"3. Exit"<<endl;
            cin>>go;
        }
        if (ct>21){
            cout<<"You lose, computer wins!"<<endl;
            stagerun=false;
            blackjackrun=false;
        }
        else if (pct>21){
            cout<<"You win, computer loses!"<<endl;
            stagerun=false;
        }
        turn++;
        cout<<ct<<endl;
        }
    stage++;
    c1 = rand() % 11 + 2;
    c2 = rand() % 11 + 2;
c3 = rand() % 11 + 2;
c4 = rand() % 11 + 2;
c5 = rand() % 11 + 2;
pc1 = rand() % 11 + 2;
pc2 = rand() % 11 + 2;
pc3 = rand() % 11 + 2;
pc4 = rand() % 11 + 2;
pc5 = rand() % 11 + 2;
    }
}




