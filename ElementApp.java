package com.mycompany.heloo.hoahoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ElementApp extends ElementLookup {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO DUOBINGO!");
        System.out.println("1. practice with ElementLookup");
        System.out.println("2. play ElementGame");
        int choice = 0;
        
        do{
            System.out.print("please choose 1 option (1 or 2): ");
        
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng sau khi nhập số
            
            if(choice !=1 && choice !=2){
                System.out.println("fuck u!!! try again!!!");
}
            }while(choice !=1 && choice !=2);
        
        if(choice==2){
            ElementGame obj1 = new ElementGame();
            obj1.display1();
        }
        else if(choice==1){
            ElementLookup obj2 = new ElementLookup();
            obj2.display();
        }
        

        scanner.close();
    }
}


