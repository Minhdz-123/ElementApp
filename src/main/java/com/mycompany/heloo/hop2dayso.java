package com.mycompany.heloo;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
public class hop2dayso {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(); 
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int[] dd = new int[100001];
            int temp = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                dd[a[i]] = 1;
        }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            
            for( int i=0; i<m ; i++){
                if(dd[b[i]] == 0){
                    System.out.println("No");
                    break;
                }
                if(dd[b[i]] == 1){
                    temp+=1;
                }
        }
            if(temp == m){
                System.out.println("Yes");
            }
 
        }}}