package com.outatime.app.repositories;

import com.outatime.app.models.*;
import java.util.List;

public interface IStudentRepository {
    //Return data
    List<Student> getStudents();

    boolean addStudent(Student student);

}
