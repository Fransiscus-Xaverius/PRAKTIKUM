#include <iostream>
#include <conio.h>
#include <time.h>
#include <Windows.h>

using namespace std;

void Menu(){
cout<<"==============="<<endl;
cout<<"|  BOMBERMAN  |"<<endl;
cout<<"==============="<<endl;
cout<<"|1. Play      |"<<endl;
cout<<"|2. Highscore |"<<endl;
cout<<"|0. Exit      |"<<endl;
cout<<"==============="<<endl;
cout<<">>";
}

int rpy(){

int y = rand()%11+1;

return y;
}
int rpx(){

int x = rand()%13+1;

}

void Map(int px, int py, int cx, int cy, int cx2, int cy2, int cx3, int cy3, int bomx,int bomy,int ex1,int ey1,int ex2,int ey2,int ex3,int ey3){

for (int i = 0; i <13; i++){
    for (int j = 0; j<15;j++){
        if(i==0||i==12||j==14||j==0){
            cout<<"#";
        }
        else if (i%2==0&&i==j||i%2==0&&j%2==0){
            cout<<"#";
        }
        else if (i==py&&j==px){
            cout<<"P";
        }
        else if (i==cy&&j==cx||i==cy2&&j==cx2||i==cy3&&j==cx3){
            cout<<"@";
        }
        else if (i==bomy&&j==bomx&&bomy!=0&&bomx!=0){
            cout<<"B";
        }
        else if (i==ey1&&j==ex1||i==ey2&&j==ex2||i==ey3&&j==ex3){
            cout<<"E";
        }
        else{
            cout<<" ";
        }
    }
    cout<<endl;
}
}

void goUp(int &py, int px,int cx, int cx2, int cx3,int cy,int cy2,int cy3,int e1x,int e2x,int e3x,int e1y,int e2y,int e3y){
    if(py > 1&&px%2!=0){
        if (px==cx){
            if(py-1!=cy){
                py = py -1;
            }
        }
        else if (px==cx2){
            if(py-1!=cy2){
                py = py -1;
            }
        }
        else if (px==cx3){
            if(py-1!=cy3){
                py = py -1;
            }
        }
        else py = py-1;
    } else py = py;
}

void goDown(int &py, int px,int cx, int cx2, int cx3,int cy,int cy2,int cy3,int e1x,int e2x,int e3x,int e1y,int e2y,int e3y){
    if(py < 11&&px%2!=0){
        if(px==cx){
                if (py+1!=cy){
                    py = py+1;
                }
        }
        else if(px==cx2){
                if (py+1!=cy2){
                    py = py+1;
                }
        }
        else if(px==cx3){
                if (py+1!=cy3){
                    py = py+1;
                }
        }
        else py = py+1;
    } else py = py;
}

void goLeft(int &px, int py, int cx, int cx2, int cx3,int cy,int cy2,int cy3,int e1x,int e2x,int e3x,int e1y,int e2y,int e3y){
    if(px >1&&py%2!=0){
        if (py==cy){
            if(px-1!=cx){
                px = px -1;
            }
        }
        else if (py==cy2){
            if(px-1!=cx2){
                px = px -1;
            }
        }
        else if (py==cy3){
            if(px-1!=cx3){
                px = px -1;
            }
        }

        else px = px-1;
    }
     else px = px;
}

void goRight(int &px, int py, int cx, int cx2, int cx3,int cy,int cy2,int cy3,int e1x,int e2x,int e3x,int e1y,int e2y,int e3y){
    if(px<13&&py%2!=0){
        if (py==cy){
            if(px+1!=cx){
                px = px +1;
            }
        }
        else if (py==cy2){
            if(px+1!=cx2){
                px = px +1;
            }
        }
        else if (py==cy3){
            if(px+1!=cx3){
                px = px +1;
            }
        }
        else px = px+1;
    }
    else px = px;
}

void cekmati(int x, int y, int ex1,int ey1, int ex2, int ey2, int ex3, int ey3, bool &mati){
    if (x==ex1&&y==ey1||x==ex2&&y==ey2||x==ex3&&y==ey3){
        mati=true;
    }
}

void bom(int y, int x, int &bomx, int &bomy){
    bomx = x;
    bomy = y;
}

void cekbom(int &bomx, int &bomy, int x1, int x2, int x3, int y1, int y2, int y3){

if (bomx==x1&&bomy==y1||bomx==x2&&bomy==y2||bomx==x3&&bomy==y3){
    bomx = 0;
    bomy = 0;
}

}

void enemy1(int &px, int &py){
    bool movement =true;
    int rng;
        rng = rand()%4+1;
        while(movement){
        if (rng==1){
            if(px+1<13&&px+1%2!=0){
            px=px+1;
            movement=false;
            }
            else {
                px=px-1;
            }
        }
        else if (rng==2){
            if(px-1<13&&px-1%2!=0){
            px=px-1;
            movement=false;
            }
            else {
                px=px+1;
            }
        }
        else if (rng==3){
            if(py+1<13&&py+1%2!=0){
            py=py+1;
            movement=false;
            }
            else {
                py=py-1;
            }
        }
        else if (rng==4){
            if(py-1<13&&py-1%2!=0){
            py=py-1;
            movement=false;
            }
            else {
                py=py+1;
            }
        }
        else movement=false;
        }
}
void enemy2(int &px, int &py){
    bool movement =true;
    int rng;
        rng = rand()%4+1;
        while(movement){
        if (rng==1){
            px=px+1;
            movement=false;
        }
        else if (rng==2){
            px=px-1;
            movement=false;
        }
        else if (rng==3){
            py=py+1;
            movement=false;
        }
        else if (rng==4){
            py=py-1;
            movement=false;
        }
        }
}

void enemy3(int &px, int &py){
    bool movement =true;
    int rng;
        rng = rand()%4+1;
        while(movement){
        if (rng==1){
            px=px+1;
            movement=false;
        }
        else if (rng==2){
            px=px-1;
            movement=false;
        }
        else if (rng==3){
            py=py+1;
            movement=false;
        }
        else if (rng==4){
            py=py-1;
            movement=false;
        }
        }
}

void leaderboard(int highscore1, int highscore2,int highscore3,int highscore4,int highscore5){

cout<<"LEADERBOARD"<<endl;
cout<<"==========="<<endl;
cout<<"1. ";
if (highscore1>0){
    cout<<highscore1<<endl;
}
else cout<<"-"<<endl;
cout<<"2. ";
if (highscore1>0){
    cout<<highscore2<<endl;
}
else cout<<"-"<<endl;
cout<<"3. ";
if (highscore3>0){
    cout<<highscore3<<endl;
}
else cout<<"-"<<endl;
cout<<"4. ";
if (highscore4>0){
    cout<<highscore4<<endl;
}
else cout<<"-"<<endl;
cout<<"5. ";
if (highscore5>0){
    cout<<highscore5<<endl;
}
else cout<<"-"<<endl;

}

void timer(int &t, int &detik){
if (t==10){
    detik++;
    t=0;
}
t++;
cout<<detik<<endl;
}



void bomberman(){

int y,x,cx,cy,cx2,cy2,cx3,cy3;
int e1x,e2x,e3x;
int e1y,e2y,e3y;
int bomx,bomy;
int waktu = 0;
int detik = 0;
int w=0;
int d=0;
int stage = 1;
int ledakanx,ledakany;
bool cekp=true,cekc=true,cekE=true;
bool mati=false;

y = rpy();
x = rpx();
while(cekp){
if (y%2==0||x%2==0){
    y = rpy();
    x = rpx();
}
else cekp=false;
}
cx = rpx();
cy = rpy();
cx2 = rpx();
cy2 = rpy();
cx3 = rpx();
cy3 = rpy();
while (cekc){
if (cy3%2==0&&cx3%2==0||cy2%2==0&&cx2%2==0||cy%2==0&&cx%2==0||cy==y&&cx==x||cx==cx2&&cy==cy2||cx==cx3&&cy==cy3||cx2==cx3&&cy2==cy3){
    cx = rpx();
    cy = rpy();
    cx2 = rpx();
    cy2 = rpy();
    cx3 = rpx();
    cy3 = rpy();
}
else cekc=false;
}
e1x = rpx();
e2x = rpx();
e3x = rpx();
e1y = rpy();
e2y = rpy();
e3y = rpy();
while (cekE){
    if (e1x%2==0&&e1y%2==0||e2x%2==0&&e2y%2==0||e3x%2==0&&e3y%2==0||e1x==x&&e1y==y||e2x==x&&e2y==y||e3x==x&&e3y==y||e1x==e2x&&e1y==e2y||e1x==e3x&&e1y==e3y||e2x==e3x&&e2y==e3y){
        e1x = rpx();
        e2x = rpx();
        e3x = rpx();
        e1y = rpy();
        e2y = rpy();
        e3y = rpy();
    }
    else cekE=false;
}
bool run = true;
    while (true){
        system("CLS");
        cout<<"Stage-"<<stage<<endl;
        enemy1(e1x,e1y);
        enemy2(e2x,e2y);
        enemy3(e3x,e3y);
        Map(x,y,cx,cy,cx2,cy2,cx3,cy3,bomx,bomy,e1x,e1y,e2x,e2y,e3x,e3y);
        if (kbhit()){
            char j = getch();
           if (j=='w'||j=='W'){
                goUp(y,x,cx,cx2,cx3,cy,cy2,cy3,e1x, e2x, e3x, e1y, e2y, e3y );
            }
            else if (j=='a'||j=='A'){
                goLeft(x,y,cx,cx2,cx3,cy,cy2,cy3,e1x, e2x, e3x, e1y, e2y, e3y );
            }
            else if (j=='s'||j=='S'){
                goDown(y,x,cx,cx2,cx3,cy,cy2,cy3,e1x, e2x, e3x, e1y, e2y, e3y );
            }
            else if (j=='d'||j=='D'){
                goRight(x,y,cx,cx2,cx3,cy,cy2,cy3,e1x, e2x, e3x, e1y, e2y, e3y );
            }
            else if (j=='b'||j=='B'){
                bom(y,x,bomx,bomy);
            }
        }
        cekmati(x,y,e1x, e2x, e3x, e1y, e2y, e3y,mati);
        cekbom(bomx,bomy,e1x, e2x, e3x, e1y, e2y, e3y);
        if (mati==true){
            run=false;
        }
        Sleep(100);
    }

}


int main(){
    int highscore1,highscore2,highscore3,highscore4,highscore5;
    highscore1=highscore2=highscore3=highscore4=highscore5=0;
    srand(time(NULL));
    bool menuRun = true;
    bool game = false;
    int p;
    while (menuRun){
        Menu();
        cin>>p;
        system("cls");
        if (p==1){
            game = true;
            while (game){
            bomberman();
            }
        }
        else if (p==2){
            leaderboard(highscore1,highscore2,highscore3,highscore4,highscore5);
            getch();
            system("CLS");
        }
        else if (p==0){
            menuRun=false;
        }
    }
}
