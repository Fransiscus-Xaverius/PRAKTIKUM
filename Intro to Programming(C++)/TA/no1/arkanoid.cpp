#include <iostream>
#include <windows.h>
#include <conio.h>
#include <string>

using namespace std;

void menu(){

    cout<<"  ARKANOID  "<<endl;
    cout<<"------------"<<endl;
    cout<<"1. Play"<<endl;
    cout<<"2. Highscore"<<endl;
    cout<<"0. Exit"<<endl;
    cout<<">> ";

}

void printMap(int posisiawal[3]){

for (int i = 0; i<19; i++){
    for (int y = 0; y<19;y++){
        if (i==0){
            cout<<"# ";
        }
        else if (y==0||y==18){
            cout<<"# ";
        }
        else if (i==1&&y>0||i==2&&y>0||i==3&&y>0){
            cout<<"= ";
        }
        else if (i==18&&y==8||i==18&&y==9||i==18&&y==10){
            cout<<"- ";
        }
        else {
            cout<<"  ";
        }
    }
    cout<<endl;
}

}

void printLeaderboard(){

cout<<"Highscore"<<endl;
cout<<"1. -"<<endl;
cout<<"2. -"<<endl;
cout<<"3. -"<<endl;

}

int main(){
int x;
string name;
int score = 0;
int posisiawal[3]={9,10,11};
bool run = true;
while(run){
    menu();
    cin>>x;
    if (x==1){
        cout<<"Name : ";
        cin.ignore(256,'\n');
        getline(cin,name);
        bool maingame= true;
        while(maingame){
            system("CLS");
            cout<<"Player : "<<name<<endl;
            cout<<"Score : "<<score<<endl;
             printMap(posisiawal);
            Sleep(100);
        }
    }
    else if (x==2){
        system("CLS");
        printLeaderboard();
        system("PAUSE");
        system("CLS");
    }
    else if (x==0){
        run=false;
    }

}

}
