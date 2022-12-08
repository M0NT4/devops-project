package com.example.devopsproject.repositories;

import com.example.devopsproject.models.Teacher;
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
public class TeacherRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TeacherRepository repository;

    public ConnectionHolder getConnectionHolder() {
        return () -> dataSource.getConnection();
    }

    @Test
    @Order(1)
    void testSaveNewTeacher() {
        Teacher s = new Teacher("a");
        repository.save(s);
        List<Teacher> teachers = Lists.newArrayList(repository.findAll());
        Assertions.assertEquals(1, teachers.size(), "Expected 1 teacher");
    }

    @Test
    @Order(2)
    @DataSet("teachers.yml")
    void testGetAllTeachers() {
        List<Teacher> teachers = Lists.newArrayList(repository.findAll());
        Assertions.assertEquals(2, teachers.size(), "Expected 2 teachers");
    }

   

    @Test
    @Order(2)
    @DataSet("teachers.yml")
    void testGetTeacherById() {
        Optional<Teacher> teacher = repository.findById(1L);
        Assertions.assertTrue(teacher.isPresent(), "Expected teacher");
        Teacher s = teacher.get();
        Assertions.assertEquals(1, s.getId(), "Expected id 1");
        Assertions.assertEquals("name 1", s.getTeacherName(), "Expected name: name 1");
    }

}
