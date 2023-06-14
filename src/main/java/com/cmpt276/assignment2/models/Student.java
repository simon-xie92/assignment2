package com.cmpt276.assignment2.models;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String haircolor;
    private int gpa;

    public Student(){
    }
    public Student(String name, int weight, int height, String haircolor, int gpa) {
        
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.haircolor = haircolor;
        this.gpa = gpa;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getHaircolor() {
        return haircolor;
    }
    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }
    public int getGpa() {
        return gpa;
    }
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    

    
}
