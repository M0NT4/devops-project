package com.example.devopsproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.devopsproject.models.Student;
import com.example.devopsproject.models.Teacher;
import com.example.devopsproject.repositories.StudentRepository;
import com.example.devopsproject.repositories.TeacherRepository;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private TeacherRepository teacherRepository;

    @MockBean
    private StudentRepository studentrepository;

    @Test
    void createStudentTest() throws Exception{
        Teacher teacher = new Teacher(4L, "teacher");
        doReturn(Optional.of(teacher)).when(teacherRepository).findById(4L);

        Student student = new Student(4L, "test", teacher);
        doReturn(student).when(studentrepository).save(student);
        Student retStudent = studentService.createStudent(student, 4L);

        Assertions.assertNotNull(retStudent, "student is null");
        Assertions.assertSame(student, retStudent, "not the same student");
        Assertions.assertSame(student.getTeacher(),teacher, "not the same teacher");
    }

    @Test
    void getStudentByIdTest() throws Exception{
        Student student = new Student(4L, "test");
        doReturn(Optional.of(student)).when(studentrepository).findById(4L);

        Student retStudent = studentService.getStudentById(4L);

        Assertions.assertSame(retStudent, student, "not the same student");
    }

    @Test 
    void getAllStudentsTest() throws Exception{
        Student student1 = new Student(4L, "tes1");
        Student student2 = new Student(5L, "test2");
        Student student3 = new Student(6L, "test3");

        doReturn(Arrays.asList(student1, student2, student3)).when(studentrepository).findAll();
        List<Student> students = studentService.getAllStudents();

        Assertions.assertEquals(3, students.size(), "expected 3 students");

    }
}
