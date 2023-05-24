#include <iostream>

using namespace std;

int main(){
bool run = true;
int pil;
int x;
int tgl1,tgl2,bln1,bln2,thn1,thn2, selt, selb, selthn;
while (run){
    cout<<"Program Multifungsi"<<endl;
    cout<<"=========================="<<endl;
    cout<<"1. Menghitung selisih hari"<<endl;
    cout<<"2. Cek Bilangan Prima"<<endl;
    cout<<"3. Cetak segitiga"<<endl;
    cout<<"4. Keluar"<<endl;
    cout<<endl;
    cout<<"Pilih : ";cin>>pil;
    if (pil==1){
        cout<<"Menghitung selisih hari"<<endl;
        cout<<"======================="<<endl;
        cout<<"Masukkan tanggal 1 	:";cin>>tgl1;
        cout<<"Masukkan bulan 1 	:";cin>>bln1;
        cout<<"Masukkan tahun 1 	:";cin>>thn1;
        cout<<"-----------------------"<<endl;
        cout<<"Masukkan tanggal 2 	:";cin>>tgl2;
        cout<<"Masukkan bulan 2 	:";cin>>bln2;
        cout<<"Masukkan tahun 2 	:";cin>>thn2;
        if (thn1<thn2){
            selthn = thn2-thn1;
            if (bln1>bln2){
                selb = bln1-bln2;
                if (tgl1>tgl2){
                    selt = tgl1-tgl2;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
                else {
                    selt = tgl2-tgl1;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
            }
            else {
                selb = bln2-bln1;
                if (tgl1>tgl2){
                    selt = tgl1-tgl2;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
                else {
                    selt = tgl2-tgl1;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
            }

        }

        else if (thn1>thn2){
            selthn = thn1-thn2;
            if (bln1>bln2){
                selb = bln1-bln2;
                if (tgl1>tgl2){
                    selt = tgl1-tgl2;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
                else {
                    selt = tgl2-tgl1;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
            }
            else {
                selb = bln2-bln1;
                if (tgl1>tgl2){
                    selt = tgl1-tgl2;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
                else {
                    selt = tgl2-tgl1;
                    cout<<"Selisih : "<<selthn<<" tahun, "<<selb<<" bulan,"<<selt<<" hari"<<endl;
                }
            }

        }
    }

    else if (pil==2){
        bool cekprima = true;
        while (cekprima){
            cout<<"Masukkan bilangan : ";cin>>x;
            if (x!=-1){
            cout<<"Bilangan "<<x<<" ";
                if (x==2 || x==3 || x==5 || x==7 || x==11 || x==13) cout<<"merupakan ilangan Prima"<<endl;
                else if (x%2 == 0 || x%3 == 0 || x%5 == 0 || x%7 == 0 || x==1) {
                cout<<"bukan merupakan Bilangan Prima"<<endl;
                }
                else {
                cout<<"merupakan bilangan Prima"<<endl;
            }
            }
            else if (x==-1){
                cekprima =false;
            }
    }
    }
    else if (pil==3){
        bool cetakseg = true;
        int i, j, k, n;
        while (cetakseg){
            cout<<"Masukkan panjang segitiga : ";cin>>n;
            if (n==99){
                cetakseg =false;
            }
            else {
                if (n%2==0){
                    cout<<"angka tidak ganjil"<<endl;
                }
                else {
                    for (i = 1; i <= n; i++) {
                        for (k = 1; k < i; k++){
                            cout<<" ";
                        }
                        for (j = i; j <= n; j++){
                            cout<<"*"<<" ";
                        }
                            cout<<endl;
                    }

                    for (i = n - 1; i >= 1; i--) {
                        for (k = 1; k < i; k++){
                            cout<<" ";
                        }
                        for (j = i; j <= n; j++){
                            cout<<"*"<<" ";
                        }
                            cout << endl;
                    }
                }
            }
        }
    }
}

}

