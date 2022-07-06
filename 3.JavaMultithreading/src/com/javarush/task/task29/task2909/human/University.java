package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        List<Student> stuList = getStudents();
        for (Student stu : stuList){
            if (stu.getAverageGrade() == averageGrade) return stu;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        List<Student> stuList = getStudents();
        Student stuWithMaxGrade = stuList.get(0);
        for (int i = 1; i < stuList.size(); i++) {
            if (stuList.get(i).getAverageGrade() > stuWithMaxGrade.getAverageGrade()) stuWithMaxGrade = stuList.get(i);
        }
        return stuWithMaxGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        List<Student> stuList = getStudents();
        Student stuWithMinGrade = stuList.get(0);
        for (int i = 1; i < stuList.size(); i++) {
            if (stuList.get(i).getAverageGrade() < stuWithMinGrade.getAverageGrade()) stuWithMinGrade = stuList.get(i);
        }
        return stuWithMinGrade;
    }

    public void expel(Student student) {
        List<Student> stud = getStudents();
        stud.remove(student);
        setStudents(stud);
    }
}