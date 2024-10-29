/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heloo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class nhanVien {
    public static String createAcronym(String uniName){
        Set<String> excludeWords = new HashSet<>(Arrays.asList("and","of","in"));
        String[] words = uniName.split(" ");
        StringBuilder acronym = new StringBuilder();
        
        for(String word : words){
            if(!excludeWords.contains(word.toLowerCase())){
                acronym.append(word.charAt(0));
            }
        }
        return acronym.toString().toUpperCase() + " " + uniName;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        String[] universities = new String[t];
        for(int i =0 ; i<t; i++){
            universities[i] = sc.nextLine();
        }
        for(String university : universities){
            System.out.println(createAcronym(university));
        }
        sc.close();
    }
}