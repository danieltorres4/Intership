package com.outatime.app.dummy;

import com.outatime.app.models.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DummyStudent {

    public static List<Student> getStudents(){
        return Arrays.asList(
                new Student("Ivan","Sanchez","Civil Engineering",1L),
                new Student("Alicia","Torres","Architecture",2L),
                new Student("Alejandra","Sanchez","Elementary School",3L),
                new Student("Daniel","Sanchez","Computing Engineering",4L)
        );

    }

    public static List<Student> getStudentsEmptyList(){
        return Collections.emptyList();
    }

    public static List<Student> getStudentNullList(){
        return null;
    }
}
