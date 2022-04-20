package com.outatime.app.test;

import com.outatime.app.models.Student;
import com.outatime.app.repositories.*;
import com.outatime.app.services.*;

public class Test {
    public static void main(String[] args) {
        IStudentRepository repository = new StudentRepositoryImpl(); //@Mock
        ISubjectRepository subjectRepository = new SubjectRepositoryImpl(); //@Mock
        IStudentService service = new StudentServiceImpl(repository, subjectRepository); //@InjectMock

        Student student = service.searchStudentByNameSurname("Daniel","Sanchez");

        System.out.println("Student = " + student);
    }
}
