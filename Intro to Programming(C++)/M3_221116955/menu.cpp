#include <iostream>

using namespace std;

int main(){
int inp,inp2;
int i, j;
int menu;
int n,a;
int ii = 0;
int h1,h2;
int md2;
int iii = 1;
do{
    cout<<"1. Pola"<<endl;
    cout<<"2. Bilangan Agak Prima"<<endl;
    cout<<"3. Deret Angka"<<endl;
    cout<<"0. Exit"<<endl;
    cout<<">>";cin>>menu;
    if (menu==1){
        do{
            cout<<"Input: ";
            cin>>inp;
            inp2=inp*2;
            for (i = 0; i < inp; i++) {


            for (j = i + 1; j < inp; j++)
                cout<< " " ;


            for (j = 0; j < (2 * i + 1); j++)
                cout<< "*";
                cout<<endl;
            }


            for (i = 0; i < 3; i++) {


                for (j = 0; j < 3; j++)
                cout<<"*";


                for (j = 0; j < (2 * inp - 2); j++)
                cout<<" ";


                for (j = 0; j < 3; j++)
                cout<< "*";
                cout<<endl;
    }
            n=0;
        }while(n!=0);
    }
    else if (menu==2){
        do{
            cout<<"Masukkan Angka = "<<endl;
            cout<<">>";
            cin>>n;
                cout<<"Faktor-faktor: ";
                for(a=n;a>0;a--){
                if(n%a==0){
                cout<<a<<" ";
                ii++;
                }
                }
                if(ii==4){
                    cout<<endl<<"Bilangan agak prima"<<endl;
                    }
                else{
                    cout<<endl<<"Bukan bilangan agak prima"<<endl;
                }
                n=0;
        }while(n!=0);
    }
    else if (menu==3){
        do{
        cout<<"Angka pertama: ";cin>>h1;
        cout<<"Angka kedua: ";cin>>h2;
        do{
            md2 = iii%10;

            if (iii==h2){
                cout<<"H"<<" ";
            }
            else if (md2==h2){
                cout<<"H"<<" ";
            }
            else {
                cout<<iii<<" ";
            }
            iii++;
        }while (iii<=h1);
        cout<<endl;
        n=0;
    }while (n!=0);
    }
}while(menu!=0);


}
