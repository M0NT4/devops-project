package com.example.devopsproject.repositories;

import com.example.devopsproject.models.Student;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@ExtendWith(DBUnitExtension.class)
@SpringBootTest
@ActiveProfiles("test1")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class StudentRepositoryTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private StudentRepository repository;

    public ConnectionHolder getConnectionHolder() {
        return () -> dataSource.getConnection();
    }

    @Test
    @Order(1)
    void testSaveNewStudent() {
        Student s = new Student("a");
        repository.save(s);
        List<Student> students = Lists.newArrayList(repository.findAll());
        Assertions.assertEquals(1, students.size(), "Expected 1 student");
    }

    @Test
    @DataSet("students.yml")
    @Order(2)
    void testGetAllStudents() {
        List<Student> students = Lists.newArrayList(repository.findAll());
        Assertions.assertEquals(2, students.size(), "Expected 2 students");
    }

    @Test
    @DataSet("students.yml")
    @Order(3)
    void testGetStudentById() {
        Optional<Student> student = repository.findById(1L);
        Assertions.assertTrue(student.isPresent(), "Expected student");
        Student s = student.get();
        Assertions.assertEquals(1, s.getId(), "Expected id 1");
        Assertions.assertEquals("name 1", s.getStudentName(), "Expected name: name 1");
    }
}
