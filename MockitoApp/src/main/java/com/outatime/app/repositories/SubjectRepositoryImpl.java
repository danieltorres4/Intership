package com.outatime.app.repositories;

import com.outatime.app.models.Subject;
import java.util.*;

public class SubjectRepositoryImpl implements ISubjectRepository{
    @Override
    public List<Subject> getMySubjects() {
        return Arrays.asList(
                new Subject(1L, "Distributed Systems"),
                new Subject(2L, "E-Commerce and Web Development"),
                new Subject(3L, "Advanced Databases"),
                new Subject(4L, "Maven: Introduction and more"),
                new Subject(5L, "Mockito: Introduction and more")
        );
    }
}
