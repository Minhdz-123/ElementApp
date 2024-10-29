/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heloo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class so4so7 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String s = ip.next();
        Set<Character> filter = new HashSet<>(Arrays.asList('4', '7'));
        long len = s.chars().filter(c -> filter.contains((char) c)).count();
        if (len == 4 || len == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

