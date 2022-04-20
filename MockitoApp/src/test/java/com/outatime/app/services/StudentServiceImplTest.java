package com.outatime.app.services;

import com.outatime.app.dummy.*;
import com.outatime.app.exceptions.CreateStudentException;
import com.outatime.app.exceptions.SubjectsNotFoundException;
import com.outatime.app.models.Student;
import com.outatime.app.models.Subject;
import com.outatime.app.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private IStudentRepository repository;

    @Mock
    private ISubjectRepository subjectRepository;

    @InjectMocks
    private StudentServiceImpl service; //no interface, we must use the implementation

    /*@BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }*/

    @Test
    void testSuccessSearchStudentByNameSurname(){
        //IStudentRepository repository = new StudentRepositoryImpl();
        //IStudentRepository repository = mock(IStudentRepository.class);

        //IStudentService service = new StudentServiceImpl(repository);

        when(repository.getStudents()).thenReturn(DummyStudent.getStudents());
        when(subjectRepository.getMySubjects()).thenReturn(DummySubject.getMySubjects());

        Student student = service.searchStudentByNameSurname("Daniel","Sanchez");

        verify(repository, times(1)).getStudents();
        verify(subjectRepository, times(1)).getMySubjects();

        assertEquals("Daniel",student.getName());
        assertEquals(4L, student.getStudentId());
    }

    @Test
    void testFailSearchStudentByNameSurnameStudentEmptyList(){
        //IStudentRepository repository = mock(IStudentRepository.class);
        //IStudentService service = new StudentServiceImpl(repository);

        when(repository.getStudents()).thenReturn(DummyStudent.getStudentsEmptyList());

        Exception e = assertThrows(NoSuchElementException.class, () -> {
            service.searchStudentByNameSurname("Daniel","Sanchez");
        });

        verify(repository, times(1)).getStudents();
        verify(subjectRepository, never()).getMySubjects();

        assertEquals("Cannot find the student! :(", e.getMessage());
    }

    @Test
    void testFailSearchStudentByNameSurnameStudentNullList(){
        //IStudentRepository repository = mock(IStudentRepository.class);
        //IStudentService service = new StudentServiceImpl(repository);

        when(repository.getStudents()).thenReturn(null);
        Exception e = assertThrows(NullPointerException.class, () -> {
            service.searchStudentByNameSurname("Daniel","Sanchez");
        });

        verify(repository).getStudents();
        verify(subjectRepository, never()).getMySubjects();

        assertEquals("List does not contain data", e.getMessage());
    }

    /*
    With a list with students data, ensure that Student does not return due to the name or surname
    doesn't math with one of the list
     */
    @Test
    void testSearchStudentByNameSurnameDoesNotReturnStudentDueToNameOrSurnameDoesNotMatch(){
        when(repository.getStudents()).thenReturn(DummyStudent.getStudents());

        verify(subjectRepository, never()).getMySubjects();
        verify(repository, never()).getStudents();

        assertThrows(NoSuchElementException.class, () -> {
            service.searchStudentByNameSurname("Daniel","Torres");
        });
    }

    @Test
    void testFailSearchStudentByNameSurnameSubjectEmptyList() {
        when(repository.getStudents()).thenReturn(DummyStudent.getStudents());
        when(subjectRepository.getMySubjects()).thenReturn(DummySubject.getMySubjectsVoidList());

        Exception e = assertThrows(SubjectsNotFoundException.class, () -> {
            service.searchStudentByNameSurname("Ivan","Sanchez");
        });

        verify(repository, times(0)).addStudent(any(Student.class));
        verify(subjectRepository).getMySubjects();

        assertEquals("No subjects registered! :(", e.getMessage());
    }

    @Test
    void testSuccessCreateStudent() {
        List<Subject> subjects = Arrays.asList(
                new Subject(1L, "Distributed Systems"),
                new Subject(2L, "Maven: Introduction and more"),
                new Subject(3L, "Mockito: Introduction and more")
        );

        when(repository.addStudent(any(Student.class))).thenReturn(true);

        boolean result = service.createStudent("Emmet", "Brown", "Blacksmith", subjects);

        verify(repository, times(1)).addStudent(any(Student.class));
        verify(repository, never()).getStudents();

        assertTrue(result);
    }


    /*
    Test for CreateStudentException
     */
    @Test
    void testFailCreateStudent() {
        List<Subject> subjects = Collections.emptyList();
        //when(repository.addStudent(any(Student.class))).thenReturn(false);

        Exception e = assertThrows(CreateStudentException.class, () -> {
            boolean result = service.createStudent("Marty","McFly","Time traveler", subjects);
            assertTrue(result);
        });

        verify(repository, never()).addStudent(any(Student.class));
        verify(subjectRepository, never()).getMySubjects();

        assertEquals("An error has occurred while creating a Student. Ensure that the fields are not empty", e.getMessage());
    }
}