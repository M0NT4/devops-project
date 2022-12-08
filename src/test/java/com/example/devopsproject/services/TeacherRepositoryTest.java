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

import com.example.devopsproject.models.Teacher;
import com.example.devopsproject.repositories.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherService teacherService;

    @MockBean
    private TeacherRepository teacherRepository;

    @Test
    void createTeacherTest() throws Exception{
        Teacher teacher = new Teacher(4L, "teacher");
        doReturn(teacher).when(teacherRepository).save(teacher);

        Teacher retTeacher = teacherService.createTeacher(teacher);

        Assertions.assertNotNull(retTeacher, "teacher is null");
        Assertions.assertSame(teacher, retTeacher, "not the same teacher");
    }

    @Test
    void getTeacherByIdTest() throws Exception{
        Teacher teacher = new Teacher(4L, "test");
        doReturn(Optional.of(teacher)).when(teacherRepository).findById(4L);

        Teacher retTeacher = teacherService.getTeacherById(4L);

        Assertions.assertSame(retTeacher, teacher, "not the same teacher");
    }

    @Test 
    void getAllTeachersTest() throws Exception{
        Teacher teacher1 = new Teacher(4L, "test1");
        Teacher teacher2 = new Teacher(5L, "test2");
        Teacher teacher3 = new Teacher(6L, "test3");

        doReturn(Arrays.asList(teacher1, teacher2, teacher3)).when(teacherRepository).findAll();
        List<Teacher> teachers = teacherService.getAllTeachers();

        Assertions.assertEquals(3, teachers.size(), "expected 3 teachers");

    }
}
