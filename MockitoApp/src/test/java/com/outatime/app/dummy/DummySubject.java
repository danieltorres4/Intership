package com.outatime.app.dummy;

import com.outatime.app.models.Subject;
import java.util.*;

public class DummySubject {
    public static List<Subject> getMySubjects(){
        return Arrays.asList(
                new Subject(1L, "Distributed Systems"),
                new Subject(2L, "Maven: Introduction and more"),
                new Subject(3L, "Mockito: Introduction and more")
        );
    }

    public static List<Subject> getMySubjectsVoidList(){
        return Collections.emptyList();
    }
}
