/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m7;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Frans
 */
public class M7 {

    public static void DIRMATRIX(ArrayList<Matrix> listMatrix){
        for(int i =0;i<listMatrix.size();i++){
            System.out.print((i+1)+". "+listMatrix.get(i).getName());
            if(listMatrix.get(i).getTipe()==1){
                System.out.println(" (int)");
            }
            else if(listMatrix.get(i).getTipe()==2){
                System.out.println(" (double)");
            }
            else if(listMatrix.get(i).getTipe()==3){
                System.out.println(" (string)");
            }
        }
    }
    
    public static void MainMenu(ArrayList<Matrix> listMatrix){
        System.out.println("== Matrix Manipulator 2000 ==");
        DIRMATRIX(listMatrix);
        System.out.println("-------------------------------");
        System.out.println("77. Add Matrix");
        System.out.println("88. Multiply Matrix");
        System.out.println("99. Print Matrix Data");
        System.out.print(">>");
    }
    
    public static void main(String[] args) {
        boolean run = true;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        ArrayList<Matrix> listMatrix = new ArrayList<Matrix>();
        while(run){
            MainMenu(listMatrix);
            int pil = scInt.nextInt();
            if(pil==99){
                for(int j=0;j<listMatrix.size();j++){
                    System.out.println("Matrix "+listMatrix.get(j).getName());
                    if(listMatrix.get(j).getTipe()==1){
                        System.out.println("Type: Integer");
                    }
                    else if(listMatrix.get(j).getTipe()==2){
                        System.out.println("Type: Double");
                    }
                    else if(listMatrix.get(j).getTipe()==3){
                        System.out.println("Type: String");
                    }
                    listMatrix.get(j).seeIsi();
                }
            }
            else if(pil==88){
                System.out.println("Multiply Matrix");
                DIRMATRIX(listMatrix);
                System.out.print("Select Matrix 1 = ");
                int pilA = scInt.nextInt();
                System.out.print("Select Matrix 2 = ");
                int pilB = scInt.nextInt();
                pilA = pilA-1;
                pilB = pilB-1;
                int tipeA = listMatrix.get(pilA).getTipe();
                int tipeB = listMatrix.get(pilB).getTipe();
                if(tipeA==3||tipeB==3){
                    System.out.println("Matrix String tidak dapat dikali...");
                }
                else{
                    //gagal. Tidak bisa convert dari double ke integer, waktu tidak nutut
//                    Double[][] newMatrix = new Double[3][3];
//                    Double[][] A = new Double[3][3];
//                    Double[][] B = new Double[3][3];
//                    ArrayList<Double> RA = new ArrayList<Double>();
//                    for(int i =0;i<9;i++){
//                       
//                    }
//                    ArrayList<Double> RB = new ArrayList<Double>();
//                    Double[][] Hasil = new Double[3][3];
//                    int counter = 0;
//                    for(int i =0;i<3;i++){
//                        for(int j =0;j<3;j++){
//                            A[i][j]=(Double)RA.get(counter);
//                            counter=counter+1;
//                        }
//                    }
//                    counter = 0;
//                    for(int i =0;i<3;i++){
//                        for(int j =0;j<3;j++){
//                            B[i][j]=(Double)RB.get(counter);
//                            counter=counter+1;
//                        }
//                    }
//                    for(int i=0;i<3;i++){    
//                        for(int j=0;j<3;j++){          
//                            for(int k=0;k<3;k++){      
//                                Hasil[i][j]+=A[i][k]*B[k][j];      
//                            }
//                        }
//                    }
//                    ArrayList<Double> finalVal = new ArrayList<Double>();
//                    for(int i =0;i<3;i++){
//                        for(int j =0;j<3;j++){
//                            finalVal.add(Hasil[i][j]);
//                        }
//                    }
//                    System.out.print("Masukkan nama matrix baru = ");
//                    String newMatName = scStr.nextLine();
//                    listMatrix.add(new Matrix(newMatName,2));
//                    int dex =listMatrix.size()-1;
//                    listMatrix.get(dex).setIsi(finalVal);
//                    System.out.println("Sucesss~");
                }
            }
            else if(pil==77){
                System.out.println("Masukkan nama matrix : ");
                String newMatrixName = scStr.nextLine();
                int pilType=0;
                while(pilType<1||pilType>3){
                    System.out.println("Pilih tipe matrix");
                    System.out.println("1. Integer");
                    System.out.println("2. Float");
                    System.out.println("3. String");
                    System.out.print(">>");
                    pilType = scInt.nextInt();
                }
                if(pilType==1){
                    Matrix<Integer> newMatrix = new Matrix<Integer>(newMatrixName,pilType);
                    for(int i =0;i<9;i++){
                        if(i==0||i==4||i==8){
                            newMatrix.add(1);
                        }
                        else{
                            newMatrix.add(0);
                        }
                    }
                    listMatrix.add(newMatrix);
                }
                else if(pilType==2){
                    Matrix<Double> newMatrix = new Matrix<Double>(newMatrixName,pilType);
                    Double z = 0.0;
                    Double o = 1.0;
                    for(int i =0;i<9;i++){
                        if(i==0||i==4||i==8){
                            newMatrix.add(o);
                        }
                        else{
                            newMatrix.add(z);
                        }
                    }
                    listMatrix.add(newMatrix);
                }
                else if(pilType==3){
                    Matrix<String> newMatrix = new Matrix<String>(newMatrixName,pilType);
                    for(int i =0;i<9;i++){
                        newMatrix.add(" ");
                    }
                    listMatrix.add(newMatrix);
                }
            }
            else if(pil>0&&pil<=listMatrix.size()){
                pil = pil-1;
                boolean view = true;
                while(view){
                    System.out.println("Matrix: "+listMatrix.get(pil).getName());
                    String EditName = listMatrix.get(pil).getName();
                    int tipe = listMatrix.get(pil).getTipe();
                    System.out.print("Type: ");
                    if(tipe==1){
                        System.out.println("int");
                    }
                    else if(tipe==2){
                        System.out.println("double");
                    }
                    else{
                        System.out.println("string");
                    }
                    listMatrix.get(pil).seeIsi();
                    System.out.println("1. Change Value");
                    System.out.println("0. Back");
                    int pilEdit = scInt.nextInt();
                    if(pilEdit==1){
                        if(tipe==3){
                            ArrayList<String> Replacement = new ArrayList<String>();
                            for(int i =0;i<3;i++){
                                for(int j =0;j<3;j++){
                                    System.out.print(i+","+j+" = ");
                                    String p = scStr.nextLine();
                                    Replacement.add(p);
                                }
                            }
                            listMatrix.get(pil).setIsi(Replacement);
                        }
                        else if(tipe==2){
                            ArrayList<Double> Replacement = new ArrayList<Double>();
                            for(int i =0;i<3;i++){
                                for(int j =0;j<3;j++){
                                    System.out.print(i+","+j+" = ");
                                    Double p = scInt.nextDouble();
                                    Replacement.add(p);
                                }
                            }
                            listMatrix.get(pil).setIsi(Replacement);
                        }
                        else if(tipe==1){
                            ArrayList<Integer> Replacement = new ArrayList<Integer>();
                            for(int i =0;i<3;i++){
                                for(int j =0;j<3;j++){
                                    System.out.print(i+","+j+" = ");
                                    Integer p = scInt.nextInt();
                                    Replacement.add(p);
                                }
                            }
                            listMatrix.get(pil).setIsi(Replacement);
                        }
                    }
                    else if(pilEdit==0){
                        view=false;
                    }
                }
            }
            
        }
    }
    
}
