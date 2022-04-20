package com.outatime.app.models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private String universityDegree;
    private Long studentId;
    private List<Subject> subjects;

    public Student(String name, String surname, String universityDegree, Long studentId){
        this.name = name;
        this.surname = surname;
        this.universityDegree = universityDegree;
        this.studentId = studentId;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getUniversityDegree() {
        return universityDegree;
    }

    public void setUniversityDegree(String universityDegree) {
        this.universityDegree = universityDegree;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", universityDegree='" + universityDegree + '\'' +
                ", studentId=" + studentId +
                ", subjects=" + subjects +
                '}';
    }
}
