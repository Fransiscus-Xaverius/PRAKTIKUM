#include <iostream>
#include <windows.h>
#include <conio.h>
#include <time.h>

using namespace std;

void printMap(int x, int y ,int x1, int y1, int x2, int y2, int x3, int y3){
    for (int a=0;a<10;a++){
        for (int b=0;b<10;b++){
            if (a==0||a==9||b==0||b==9){
                cout<<"*";
            }
            else if (a==x&&b==y){
                cout<<"x";
            }
            else if (a==x1&&b==y1 || a==x2&&b==y2 || a==x2&&b==y3){
                cout<<"o";
            }
            else {
                cout<<" ";
            }
        }
        cout<<endl;
    }
}

int randM(){
    return rand()%8+1;
}

bool checkNumpuk(int x, int y, int x1, int y1){
    bool check = false;
    if(x == x1 && y == y1){
        check = true;
    }
    return check;
}

void goUp(int &py){
    if(py > 0){
        py = py-1;
    } else py = py;
}

void goDown(int &py){
    if(py < 9){
        py = py+1;
    } else py = py;
}

void goLeft(int &px){
    if(px >0){
        px = px -1;
    }
     else px = px;
}

void goRight(int &px){
    if(px <9){
        px = px +1;
    }
    else px = px;
}
bool checkNumpuk1(int px, int py, int cx, int cy){
    bool check1 = false;
    if(px == cx && py == cy){
        check1 = true;
    }
    return check1;
}
bool checkNumpuk2(int px, int py, int cx, int cy){
    bool check2 = false;
    if(px == cx && py == cy){
        check2 = true;
    }
    return check2;
}
bool checkNumpuk3(int px, int py, int cx, int cy){
    bool check3 = false;
    if(px == cx && py == cy){
        check3 = true;
    }
    return check3;
}

void PrintMenu(){
cout<<"Welcome to All You Can Eat"<<endl;
cout<<"1. Play"<<endl;
cout<<"2. Highscore"<<endl;
cout<<"3. Exit"<<endl;
}

int main(){
    srand(time(NULL));
    int x,y,m1x,m1y,m2x,m2y,m3x,m3y;
    x = randM();
    y = randM();
    m1x = randM();
    m1y = randM();
    m2x = randM();
    m2y = randM();
    m3x = randM();
    m3y = randM();
    int score = 0;
    int waktu = 30;
    int highscore_1 =0;
    int highscore_2 =0;
    int highscore_3 =0;
    int o;
    bool jalan;
    bool menu = true;
    if (m1x==m2x && m1y==m2y || m1x==m3x && m1y==m3y){
        m1x = randM();
        m1y = randM();
    }
    else if (m2x==m3x && m2y==m3y){
        m2x = randM();
        m2y = randM();
    }
    while(menu){
    PrintMenu();
    cin>>o;
    if (o==1){
    jalan = true;
    do{
    system("CLS");
    cout<<"Time : "<<waktu<<endl;
    cout<<"Score : "<<score<<endl;

    printMap(x,y,m1x,m1y,m2x,m2y,m3x,m3y);
    if (kbhit()){
        char j = getch();
        if (j=='w'||j=='W'){
            goUp(x);
            waktu--;
            bool check1 = checkNumpuk1(x,y,m1x,m1y);
            bool check2 = checkNumpuk2(x,y,m2x,m3y);
            bool check3 = checkNumpuk3(x,y,m3x,m3y);
            if (check1==true){
                score=score+5;
                m1x = randM();
                m1y = randM();
            }
            else if (check2==true){
                score=score+5;
                m2x = randM();
                m2y = randM();
            }
            else if (check3==true){
                score=score+5;
                m3x = randM();
                m3y = randM();
            }

        }
        else if (j=='a'||j=='A'){
            goLeft(y);
            waktu--;
            bool check1 = checkNumpuk1(x,y,m1x,m1y);
            bool check2 = checkNumpuk2(x,y,m2x,m3y);
            bool check3 = checkNumpuk3(x,y,m3x,m3y);
            if (check1==true){
                score=score+5;
                m1x = randM();
                m1y = randM();
            }
            else if (check2==true){
                score=score+5;
                m2x = randM();
                m2y = randM();
            }
            else if (check3==true){
                score=score+5;
                m3x = randM();
                m3y = randM();
            }
        }
        else if (j=='S'||j=='s'){
            goDown(x);
            waktu--;
            bool check1 = checkNumpuk1(x,y,m1x,m1y);
            bool check2 = checkNumpuk2(x,y,m2x,m3y);
            bool check3 = checkNumpuk3(x,y,m3x,m3y);
            if (check1==true){
                score=score+5;
                m1x = randM();
                m1y = randM();
            }
            else if (check2==true){
                score=score+5;
                m2x = randM();
                m2y = randM();
            }
            else if (check3==true){
                score=score+5;
                m3x = randM();
                m3y = randM();
            }
        }
        else if (j=='d'||j=='D'){
            goRight(y);
            waktu--;
            bool check1 = checkNumpuk1(x,y,m1x,m1y);
            bool check2 = checkNumpuk2(x,y,m2x,m3y);
            bool check3 = checkNumpuk3(x,y,m3x,m3y);
            if (check1==true){
                score=score+5;
                m1x = randM();
                m1y = randM();
            }
            else if (check2==true){
                score=score+5;
                m2x = randM();
                m2y = randM();
            }
            else if (check3==true){
                score=score+5;
                m3x = randM();
                m3y = randM();
            }
        }
    }
    if (waktu==0){
        jalan=false;
        if (score>highscore_3){
            cout<<"Congrats, you are on the leaderboard"<<endl;
            if(score<highscore_2){
                highscore_3 = score;
            }
            else{
                if (score<highscore_1){
                    highscore_3 = highscore_2;
                    highscore_2 = score;
                }
                else {
                    highscore_2 = highscore_1;
                    highscore_1 = score;
                }
            }
        }
        getch();
        system("cls");
    }
    Sleep(100);
    }while(jalan);
    }
    if (o==2){
        system("cls");
        cout<<"== Leaderboard =="<<endl;
        cout<<"1. Score : "<<highscore_1<<endl;
        cout<<"2. Score : "<<highscore_2<<endl;
        cout<<"3. Score : "<<highscore_3<<endl;
    }
    if (o==3){
        menu=false;
    }
}
}
