package com.zeal.sheldon.entity;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-09-21
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareByStudentScore(Student student1,Student student2){
        return student1.getScore() - student2.getScore();
    }

    public static int compareByStudentName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }


    public  int compareByScore(Student student){
        return student.getScore() - this.getScore();
    }

    public  int compareByName(Student student){
        return student.getName().compareTo(this.getName());
    }
}
