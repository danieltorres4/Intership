package com.outatime.app.repositories;
import com.outatime.app.models.Subject;

import java.util.List;

public interface ISubjectRepository {
    List<Subject> getMySubjects();
}
