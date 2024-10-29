/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heloo.Element;

public class Student {

    private String name;
    private String birthday;
    private String lop;
    private int score;
    public Student(String name, String birthday, String lop){
        this.name = name;
        this.birthday = birthday;
        this.lop = lop;
        this.score = 0;
    }
    
    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLop() {
        return lop;
    }

    public int getScore() {
        return score;
    }
    
    @Override
    public String toString(){
        return name + " "+ birthday + " " + lop + " "+ score;
    }

    
}
