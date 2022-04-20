package com.outatime.app.services;

import com.outatime.app.exceptions.CreateStudentException;
import com.outatime.app.exceptions.SubjectsNotFoundException;
import com.outatime.app.models.*;
import com.outatime.app.repositories.*;
import java.util.*;

public class StudentServiceImpl implements IStudentService{

    private IStudentRepository repository;
    private ISubjectRepository subjectRepository;

    public StudentServiceImpl(IStudentRepository repository, ISubjectRepository subjectRepository) {
        this.repository = repository;
        this.subjectRepository = subjectRepository;
    }

    /*
    Method to search a Student. If Student is not found, the exception will appear
     */
    @Override
    public Student searchStudentByNameSurname(String name, String surname) {
        try {
            Optional<Student> studentOptional =  this.repository.getStudents().stream().filter(
                    student -> student.getName().equals(name) && student.getSurname().equals(surname)).findFirst();
            Student myStudent = null;

            if(studentOptional.isPresent()){
                List<Subject> subjects = this.subjectRepository.getMySubjects();

                myStudent = studentOptional.get();

                if(subjects.size() > 0){
                    myStudent.setSubjects(subjects);
                    return myStudent;
                }
                throw new SubjectsNotFoundException("No subjects registered! :(");

            } else{
                throw new NoSuchElementException("Cannot find the student! :(");
            }

        } catch(NullPointerException ex){
            throw new NullPointerException("List does not contain data");
        }
    }


    @Override
    public boolean createStudent(String name, String surname, String universityDegree, List<Subject> subjects) {
        Random randomId = new Random();

        if(!name.isEmpty() && !surname.isEmpty() && !universityDegree.isEmpty() && subjects.size() > 0){
            Student student = new Student(name, surname, universityDegree, randomId.nextLong());
            student.setSubjects(subjects);
            return this.repository.addStudent(student);
        }

        throw new CreateStudentException("An error has occurred while creating a Student. Ensure that the fields are not empty");

    }

}
