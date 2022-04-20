package com.outatime.app.services;

import com.outatime.app.models.*;
import java.util.List;

public interface IStudentService {

    Student searchStudentByNameSurname(String name, String surname);
    boolean createStudent(String name, String surname, String universityDegree, List<Subject> subjects);
}
