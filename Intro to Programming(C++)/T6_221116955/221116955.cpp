#include <iostream>
#include <string>
#include <time.h>
#include <conio.h>
#include <windows.h>

using namespace std;

void sharkmap(int shark[5], int sumy[5], int cek[5]){

int myarr[26][7];
for (int i=0; i<7;i++){
    for (int j=0; j<22;j++){
        if (i==0||j==0||j==21||i==6){
            cout<<"*";
        }
        else if (j==2){
            cout<<"|";
        }
        else if (shark[0]<21&&j==shark[0]&&shark[0]>2&&i==sumy[0]&&cek[0]==0){
            cout<<"1";
        }
        else if (shark[1]<21&&j==shark[1]&&shark[1]>2&&i==sumy[1]&&cek[1]==0){
            cout<<"2";
        }
        else if (shark[2]<21&&j==shark[2]&&shark[2]>2&&i==sumy[2]&&cek[2]==0){
            cout<<"3";
        }
        else if (shark[3]<21&&j==shark[3]&&shark[3]>2&&i==sumy[3]&&cek[3]==0){
            cout<<"4";
        }
        else if (shark[4]<21&&j==shark[4]&&shark[4]>2&&i==sumy[4]&&cek[4]==0){
            cout<<"5";
        }
        else cout<<" ";
    }
    cout<<endl;
}

}
void MainMenu(){
cout<<"Welcome to Typershark"<<endl;
cout<<"====================="<<endl;
cout<<"1. Play"<<endl;
cout<<"2. Highscore"<<endl;
cout<<"3. Exit"<<endl;
cout<<">>";

}

void countdown(int &c1, int &c2){
bool counting = true;
while(counting){
    c1++;
    if (c1==10){
        c2++;
        c1=0;
        cout<<c2<<"...";
    }
    if (c2==3){
        counting=false;
    }
    Sleep(100);
}
}

void timer(int &c1 , int &c2, int &c3, int &c4, int &detik){

        c1++;
        if (c1==10){
            c2++;
            c1=0;
            detik++;
        }
        if (c2==10){
            c2=0;
            c3++;
        }
        if (c3==6){
            c3=0;
            c4++;
        }
        cout<<"Time "<<c4<<":"<<c3<<c2<<endl;
}

void pengecek(string in,string kunci[5], string jawaban[5], int cek[5], int &counter){

for(int i =0; i<5; i++){
    if (in==kunci[i]){
        jawaban[i]=in;
        cek[i]=1;
        counter++;
    }
}

}

void displayjawaban(string jawaban[5], int counter){

for (int i = 0; i<5; i++){
    if (jawaban[i]=="n"){
        cout<<i+1<<". -"<<endl;
    }
    else cout<<i+1<<". "<<jawaban[i]<<endl;
    if (counter==5){
        cout<<"Game Over"<<endl;
    }
}
}

void gerakkiri(int shark[5], int detik, int &bentar, int cek[5]){

if (bentar<detik){
    for (int i=0; i<5;i++){
        if (cek[i]==0){
            shark[i]--;
        }
    }
    bentar = detik;
}
}

void sorter(int &m1, int &m2, int &m3, int &m4 , int &m5, int &s1, int &s2, int &s3, int &s4, int &s5, string &n1, string &n2, string &n3, string &n4, string &n5, int secon, int minute, string nama, int &posisi){

posisi=6;

if (minute>m5){
    posisi--;
}
else if (minute==m5&&secon>s5){
    posisi--;
}

if (minute>m4){
    posisi--;
}
else if (minute==m4&&secon>s4){
    posisi--;
}

if (minute>m3){
    posisi--;
}
else if (minute==m3&&secon>s3){
    posisi--;
}

if (minute>m2){
    posisi--;
}
else if (minute==m2&&secon>s2){
    posisi--;
}

if (minute>m1){
    posisi--;
}
else if (minute==m1&&secon>s1){
    posisi--;
}

switch(posisi){

case 5:
    m5 = minute;
    n5 = nama;
    s5 = secon;
    break;
case 4:
    m5 = m4;
    n5 = m4;
    s5 = m4;
    m4 = minute;
    n4 = nama;
    s4 = secon;
    break;
case 3:
    m5 = m4;
    n5 = m4;
    s5 = m4;
    m4 = m3;
    n4 = n3;
    s4 = s3;
    m3 = minute;
    n3 = nama;
    s3 = secon;
    break;
case 2:
    m5 = m4;
    n5 = m4;
    s5 = m4;
    m4 = m3;
    n4 = n3;
    s4 = s3;
    m3 = m2;
    n3 = n2;
    s3 = s2;
    m2 = minute;
    n2 = nama;
    s2 = secon;
    break;
case 1:
    m5 = m4;
    n5 = m4;
    s5 = m4;
    m4 = m3;
    n4 = n3;
    s4 = s3;
    m3 = m2;
    n3 = n2;
    s3 = s2;
    m2 = m1;
    n2 = n1;
    s2 = s1;
    m1 = minute;
    n1 = nama;
    s1 = secon;
}

}

void resetjawab(string tebakan[50], int sumy[5], string kunci[5]){

 for (int i = 0; i<50;i++){
            int satu = rand()%10;
            int dua = rand()%10;
            string temp = tebakan[satu];
            tebakan[satu]=tebakan[dua];
            tebakan[dua]=temp;
        }

        for (int i = 0; i<5;i++){
            int s = rand()%4;
            int d = rand()%4;
            int c = sumy[s];
            sumy[s]=sumy[d];
            sumy[d]=c;
        }
        for (int i = 0; i<5; i++){
            kunci[i]=tebakan[i];
        }

}

void resetpos(int cek[5], int sharkpos[5]){
int y = 0;
for (int i = 0; i<5; i++){
    cek[i]=0;
}
for (int i = 21; i<26;i++){
    sharkpos[y]=i;
    y++;
}

}

void highscore(int m1, int m2, int m3, int m4 , int m5, int s1, int s2, int s3, int s4, int s5, string n1, string n2, string n3, string n4, string n5){

cout<<"1. ";
if (n1=="8888888"){
    cout<<" - "<<endl;
}
else{
    cout<<n1<<" - "<<m1<<" menit "<<s1<<" detik"<<endl;
}
cout<<"2. ";
if (n2=="8888888"){
    cout<<" - "<<endl;
}
else{
    cout<<n2<<" - "<<m2<<" menit "<<s2<<" detik"<<endl;
}
cout<<"3. ";
if (n3=="8888888"){
    cout<<" - "<<endl;
}
else{
    cout<<n3<<" - "<<m3<<" menit "<<s3<<" detik"<<endl;
}
cout<<"4. ";
if (n4=="8888888"){
    cout<<" - "<<endl;
}
else{
    cout<<n4<<" - "<<m4<<" menit "<<s4<<" detik"<<endl;
}
cout<<"5. ";
if (n5=="8888888"){
    cout<<" - "<<endl;
}
else{
    cout<<n5<<" - "<<m5<<" menit "<<s5<<" detik"<<endl;
}

system("PAUSE");

}

int main(){
    bool maingame = true;
    int pil1;
    bool refresh;
    int posisi;
    int counter=0;
    int c1,c2,c3,c4;
    int m1,m2,m3,m4,m5;
    int s1,s2,s3,s4,s5;
    m1=m2=m3=m4=m5=0;
    s1=s2=s3=s4=s5=0;
    int minute;
    int secon;
    string n1,n2,n3,n4,n5;
    n1=n2=n3=n4=n5="8888888";
    int sumy[5];
    for (int y = 0; y<5;y++){
        sumy[y]=y+1;
    }
    int sharkpos[5]={21,22,23,24,25};
    int bentar = 0;
    int detik = 0;
    int cek[5]={0,0,0,0,0};
    string nama;
    string in;
    string jawaban[5]={"n","n","n","n","n"};
    c1=c2=c3=c4=0;
    while (maingame){
        string tebakan[50]={"deal","prime","earn","heal","transport","overjoyed","direction","badge","sofa","basket","soak","degree","meat","train", //14
        "crow","brush","numerous","instinctive","flashy","level","mighty","fact","arithmetic","sweater","fly","clam","unhealthy","hose","drunk",    //29
        "difficult","berserk","zoom","simple","obsolete","beginner","chief","tacky","gainful","frail","curious","permit","flesh","kick","peaceful",  //44
        "snore","sleep","solid","taste","dead","power"}; // 50
        srand(time(NULL));
        string kunci[5];
        for (int i = 0; i<50;i++){
            int satu = rand()%10;
            int dua = rand()%10;
            string temp = tebakan[satu];
            tebakan[satu]=tebakan[dua];
            tebakan[dua]=temp;
        }

        for (int i = 0; i<5;i++){
            int s = rand()%4;
            int d = rand()%4;
            int c = sumy[s];
            sumy[s]=sumy[d];
            sumy[d]=c;
        }
        for (int i = 0; i<5; i++){
            kunci[i]=tebakan[i];
        }
        bool menu = true;
        bool typeshark = false;
        while(menu){
            system("CLS");
            MainMenu();
            cin>>pil1;
            if (pil1==1){
                system("CLS");
                cout<<"Enter your name : ";
                cin.ignore(256, '\n');
                getline(cin,nama);
                countdown(c1,c2);
                typeshark = true;
                c1=c2=0;
                while(typeshark){
                    while(refresh){
                        Sleep(100);
                        system("CLS");
                        timer(c1,c2,c3,c4,detik);
                        sharkmap(sharkpos,sumy,cek);
                        displayjawaban(jawaban,counter);
                        cout<<"Jawaban : ";
                        if (kbhit()){
                            cin>>in;
                            pengecek(in, kunci,jawaban,cek,counter);
                        }
                        gerakkiri(sharkpos,detik,bentar,cek);
                        if(sharkpos[0]<=2||sharkpos[1]<=2||sharkpos[2]<=2||sharkpos[3]<=2||sharkpos[4]<=2){
                            refresh=false;
                            typeshark=false;
                            cout<<"Game Over"<<endl;
                            minute = c4;
                            secon = ((c3*10)+c2);
                            sorter(m1,m2,m3,m4,m5,s1,s2,s3,s4,s5,n1,n2,n3,n4,n5,secon,minute,nama,posisi);
                            resetpos(cek,sharkpos);
                            c1=c2=c3=c4=0;
                            resetjawab(tebakan,sumy,kunci);
                            if (posisi!=6){
                                cout<<"Congratulations, You are in the leaderboard!!!"<<endl;
                            }
                            cout<<secon<<endl;
                            system("PAUSE");
                        }
                        else if (counter==5){
                            refresh=false;
                            typeshark=false;
                            minute = c4;
                            secon = ((c3*10)+c2);
                            sorter(m1,m2,m3,m4,m5,s1,s2,s3,s4,s5,n1,n2,n3,n4,n5,secon,minute,nama,posisi);
                            resetpos(cek,sharkpos);
                            c1=c2=c3=c4=0;
                            resetjawab(tebakan,sumy,kunci);
                            if (posisi!=6){
                                cout<<"Congratulations, You are in the leaderboard!!!"<<endl;
                            }
                            system("PAUSE");
                        }
                    }
                }

            }
            else if (pil1==2){
                system("CLS");
                highscore(m1,m2,m3,m4,m5,s1,s2,s3,s4,s5,n1,n2,n3,n4,n5);
            }
            else if (pil1==3){
                system("CLS");
                menu=false;
                maingame=false;
            }
        }

    }

}
