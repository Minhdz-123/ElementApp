package com.mycompany.heloo;
import java.util.Scanner;

public class Heloo{
    public static void selectionSort(int[] a){
        int n = a.length;
        for(int i=0; i<n;i++){
            int temp=i;
            
            for(int j=i+1; j<n;j++){
                if(a[j]<a[temp]){
                    temp = j;
                }
            }
            int temp1 = a[temp];
            a[temp] = a[i];
            a[i] = temp1;
            
            System.out.printf("Buoc %d: ", i+1);
            for(int k=0; k<n;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
            
        }
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0; i<n;i++){
            a[i] = sc.nextInt();
        }
        selectionSort(a);
    }
    }