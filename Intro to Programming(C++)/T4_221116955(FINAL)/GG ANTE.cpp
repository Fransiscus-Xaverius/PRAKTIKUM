#include <iostream>
#include <time.h>
#include<stdlib.h>

using namespace std;

int main(){

int rx, rxt,n,s, xd;
bool run = true;
int pil;
int ptsbl, ptshl;
int highscorebl_1 =0;
int highscorebl_2 =0;
int highscorebl_3 =0;
int highscorehl_1 =0;
int highscorehl_2 =0;
int highscorehl_3 =0;
int coba =3;
bool benar = false;
int kesempatan = 1;
bool dbl = true;
bool cheat = false;
bool cheating = false;
int dblpts;
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
srand(time(NULL));
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

while (run){
    cout<<"         GG ANTE     "<<endl;
    cout<<"========================"<<endl;
    cout<<"1. High low"<<endl;
    cout<<"2. Blackjack"<<endl;
    cout<<"3. High Score High Low"<<endl;
    cout<<"4. High Score Blackjack"<<endl;
    cout<<">>";cin>>pil;
    if (pil==1){
        ptshl = 0;
        bool highlow = true;
        cout<<"    Welcome to High low"<<endl;
        cout<<"-----------------------------"<<endl;
        rx = rand() % 50 + 1;
        cout<<"Your first number is "<<rx<<endl;
        s = 1;
        rxt = rx;
        while (highlow){
            xd = rand() % 50 + 1;
            if (rxt==xd){
                xd = rand() % 50 + 1;
            }
            if (cheating ==true){
                cout<<"Cheat activated : "<<xd<<endl;
            }
            if (s==1 && cheating==true){
                cout<<"Your first number is "<<rxt<<endl;
            }
            if (s!=1){
                cout<<"Current number is "<<rxt<<endl;
            }
            cout<<"Next number is..."<<endl;
            cout<<"1. High"<<endl;
            cout<<"2. Low"<<endl;
            cout<<"3. Double the points"<<endl;
            cout<<"4. Exit"<<endl;
            cout<<">> ";cin>>n;
            if (n==1 && xd>rxt){
                cout<<"You're right, nice guess"<<endl;
                ptshl = ptshl+5;
            }
            else if (n==2 && xd<rxt){
                cout<<"You're right, nice guess"<<endl;
                ptshl = ptshl+5;
            }
            else if (n==1 && xd<rxt){
                cout<<"You're wrong, GAME OVER!!!"<<endl;
                highlow=false;
            }
            else if (n==2 && xd>rxt){
                cout<<"You're wrong, GAME OVER!!!"<<endl;
                highlow=false;
            }
            else if (n==3){
                cout<<"You have "<<coba<<" chances to guess the number"<<endl;
                while (dbl){
                    cout<<"Guess-"<<kesempatan<<" : ";cin>>dblpts;
                    if (dblpts==xd && coba>1){
                        cout<<"You're right nice guess."<<endl;
                        ptshl = ptshl+10;
                        dbl=false;
                    }
                    else if (dblpts!=xd && coba>1){
                        kesempatan++;
                        coba--;
                        cout<<"You're wrong, "<<coba<<"chances left"<<endl;
                    }
                    else if (coba<=1){
                    cout<<"You're wrong, GAME OVER!!!"<<endl;
                    dbl = false;
                    highlow=false;
                }
                }
            int coba =3;
            bool benar = false;
            int kesempatan = 1;
            }
            else if (n==4){
                highlow=false;
            }
            else if (n==99){
                cheat = true;
            }
            if (cheat==true){
                rxt=rxt;
                cheating = true;
                cheat = false;
            }
            else {
                s++;
                rxt=xd;
            }
        }
        if (ptshl>highscorehl_3){
            cout<<"Congrats, you are on the leaderboard"<<endl;
            if(ptshl<highscorehl_2){
                highscorehl_3 = ptshl;
            }
            else{
                if (ptshl<highscorehl_1){
                    highscorehl_3 = highscorehl_2;
                    highscorehl_2 = ptshl;
                }
                else {
                    highscorehl_2 = highscorehl_1;
                    highscorehl_1 = ptshl;
                }
            }
        }
        ptshl = 0;
    }
    else if (pil==2){
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
                blackjackrun=false;
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
                blackjackrun=false;
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
                blackjackrun=false;
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
    ptsbl = stage*5;
    if (ptsbl>highscorebl_3){
            cout<<"Congrats, you are on the leaderboard"<<endl;
            if(ptsbl<highscorebl_2){
                highscorebl_3 = ptshl;
            }
            else{
                if (ptsbl<highscorebl_1){
                    highscorebl_3 = highscorebl_2;
                    highscorebl_2 = ptsbl;
                }
                else {
                    highscorebl_2 = highscorebl_1;
                    highscorebl_1 = ptsbl;
                }
            }
        }
    }
    else if (pil==3){
        cout<<"Highscore High Low"<<endl;
        cout<<"1. ";
        if (highscorehl_1==0){
            cout<<"-"<<endl;
        }
        else cout<<highscorehl_1<<endl;
        cout<<"2. ";
        if (highscorehl_2==0){
            cout<<"-"<<endl;
        }
        else cout<<highscorehl_2<<endl;
        cout<<"3. ";
        if (highscorehl_3==0){
            cout<<"-"<<endl;
        }
        else cout<<highscorehl_3<<endl;
    }
    else if (pil==4){
        cout<<"Highscore Blackjack"<<endl;
        cout<<"1. ";
        if (highscorebl_1==0){
            cout<<"-"<<endl;
        }
        else cout<<highscorebl_1<<endl;
        cout<<"2. ";
        if (highscorebl_2==0){
            cout<<"-"<<endl;
        }
        else cout<<highscorebl_2<<endl;
        cout<<"3. ";
        if (highscorebl_3==0){
            cout<<"-"<<endl;
        }
        else cout<<highscorebl_3<<endl;
    }
    else if (pil==5){
        run=false;
    }
    else {
        cout<<"Input invalid"<<endl;
    }
}

}
