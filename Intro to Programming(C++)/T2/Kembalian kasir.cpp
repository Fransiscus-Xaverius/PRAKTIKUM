#include<iostream>
#include<math.h>
using namespace std;

int main() {

  int a,b,num;
  cout<<"Masukkan total belanja   : Rp. ";
  cin>>a;
  cout<<"Masukkan uang pembayaran : Rp. ";
  cin>>b;

if(a>b){
    cout<<"Uang pembayaran kurang";
  }
else if (b>a){
    num = b - a;
    cout<<"Total kembalian		 : Rp. "<<num<<endl;
     if ( num == 0 ) {
    cout<<"nol";
  }
  if ( num >= 1000 ) {
    int left = ((num - ( num % 1000 )) / 1000 );
    bool hundred = false;
    if ( log10(left) >= 2 ) {
      int digit = ( left - ( left % 100 )) / 100;
      if ( digit == 1 ) cout << "se";
      else if ( digit == 2 ) cout << "dua ";
      else if ( digit == 3 ) cout << "tiga ";
      else if ( digit == 4 ) cout << "empat ";
      else if ( digit == 5 ) cout << "lima ";
      else if ( digit == 6 ) cout << "enam ";
      else if ( digit == 7 ) cout << "tujuh ";
      else if ( digit == 8 ) cout << "delapan ";
      else if ( digit == 9 ) cout << "sembilan ";
      left = left % 100;
      hundred = true;
    }
    if ( hundred ) cout << "ratus ";
    bool tens = false;
    if ( log10(left) >= 1 ) {
      int digit = ( left - ( left % 10 )) / 10;
      if ( digit == 1 && left != 10 ) {
        digit = left % 10;
        if ( digit == 1 ) cout << "se";
        else if ( digit == 2 ) cout << "dua ";
        else if ( digit == 3 ) cout << "tiga ";
        else if ( digit == 4 ) cout << "empat ";
        else if ( digit == 5 ) cout << "lima ";
        else if ( digit == 6 ) cout << "enam ";
        else if ( digit == 7 ) cout << "tujuh ";
        else if ( digit == 8 ) cout << "delapan ";
        else if ( digit == 9 ) cout << "sembilan ";
        cout << "belas ";
        left = 0;
      } else {
        if ( digit == 1 ) cout << "se";
        else if ( digit == 2 ) cout << "dua ";
        else if ( digit == 3 ) cout << "tiga ";
        else if ( digit == 4 ) cout << "empat ";
        else if ( digit == 5 ) cout << "lima ";
        else if ( digit == 6 ) cout << "enam ";
        else if ( digit == 7 ) cout << "tujuh ";
        else if ( digit == 8 ) cout << "delapan ";
        else if ( digit == 9 ) cout << "sembilan ";
        cout << "puluh ";
      }
      left = left % 10;
      tens = true;
    }
    if ( left > 0 ) {
      int digit = left;
      if ( digit == 1 ) cout << "se";
      else if ( digit == 2 ) cout << "dua ";
      else if ( digit == 3 ) cout << "tiga ";
      else if ( digit == 4 ) cout << "empat ";
      else if ( digit == 5 ) cout << "lima ";
      else if ( digit == 6 ) cout << "enam ";
      else if ( digit == 7 ) cout << "tujuh ";
      else if ( digit == 8 ) cout << "delapan ";
      else if ( digit == 9 ) cout << "sembilan ";
    }
    cout << "ribu ";
  }
  int right = num % 1000;
  bool hundred = false;
  if ( log10(right) >= 2 ) {
    int digit = ( right - ( right % 100 )) / 100;
    if ( digit == 1 ) cout << "se";
    else if ( digit == 2 ) cout << "dua ";
    else if ( digit == 3 ) cout << "tiga ";
    else if ( digit == 4 ) cout << "empat ";
    else if ( digit == 5 ) cout << "lima ";
    else if ( digit == 6 ) cout << "enam ";
    else if ( digit == 7 ) cout << "tujuh ";
    else if ( digit == 8 ) cout << "delapan ";
    else if ( digit == 9 ) cout << "sembilan ";
    right = right % 100;
    hundred = true;
  }
  if ( hundred ) cout << "ratus ";
  bool tens = false;
  if ( log10(right) >= 1 ) {
    int digit = ( right - ( right % 10 )) / 10;
    if ( digit == 1 && right != 10 ) {
      digit = right % 10;
      if ( digit == 1 ) cout << "se";
      else if ( digit == 2 ) cout << "dua ";
      else if ( digit == 3 ) cout << "tiga ";
      else if ( digit == 4 ) cout << "empat ";
      else if ( digit == 5 ) cout << "lima ";
      else if ( digit == 6 ) cout << "enam ";
      else if ( digit == 7 ) cout << "tujuh ";
      else if ( digit == 8 ) cout << "delapan ";
      else if ( digit == 9 ) cout << "sembilan ";
      cout << "belas ";
      right = 0;
    } else {
      if ( digit == 1 ) cout << "se";
      else if ( digit == 2 ) cout << "dua ";
      else if ( digit == 3 ) cout << "tiga ";
      else if ( digit == 4 ) cout << "empat ";
      else if ( digit == 5 ) cout << "lima ";
      else if ( digit == 6 ) cout << "enam ";
      else if ( digit == 7 ) cout << "tujuh ";
      else if ( digit == 8 ) cout << "delapan ";
      else if ( digit == 9 ) cout << "sembilan ";
      cout << "puluh ";
    }
    right = right % 10;
    tens = true;
  }
  if ( right > 0 ) {
    int digit = right;
    if ( digit == 1 ) cout << "satu ";
    else if ( digit == 2 ) cout << "dua ";
    else if ( digit == 3 ) cout << "tiga ";
    else if ( digit == 4 ) cout << "empat ";
    else if ( digit == 5 ) cout << "lima ";
    else if ( digit == 6 ) cout << "enam ";
    else if ( digit == 7 ) cout << "tujuh ";
    else if ( digit == 8 ) cout << "delapan ";
    else if ( digit == 9 ) cout << "sembilan ";
  }
}
else {
    cout<<"Invalid";
}



}
