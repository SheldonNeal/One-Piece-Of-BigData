package com.zeal.sheldon.entity;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-10-08
 */
public class StudentComparator {
    public int compareByStudentScore(Student student1,Student student2){
        return student1.getScore() - student2.getScore();
    }

    public int compareByStudentName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }
}
