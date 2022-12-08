package com.example.devopsproject.controllers;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.devopsproject.models.Student;
import com.example.devopsproject.models.Teacher;
import com.example.devopsproject.repositories.StudentRepository;
import com.example.devopsproject.repositories.TeacherRepository;
import com.example.devopsproject.services.StudentService;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private TeacherRepository teacherRepository;

    @MockBean
    private StudentRepository studentrepository;

  
    

    /*@Test
    public void testCreateStudent() throws Exception {
        Student student = new Student(4L, "student");
        Student student1 = new Student(4L, "student");
        doReturn(student1).when(studentService).createStudent(student, 4L);

        mockMvc.perform(post("/student/create/{id}", 4L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(student)))

                .andExpect(status().isOk());
    }
    
    @Test
    public void getAllStudentsTest() throws Exception {

        Student student1 = new Student(1l, "student 1");
        Student student2 = new Student(2l, "student 2");
        Student student3 = new Student(3L, "student 3");
        doReturn(Arrays.asList(student1, student2, student3)).when(studentrepository).findAll();
        List<Student> students = studentService.getAllStudents();

    }
        
        mockMvc.perform(get("/pet/all"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("putchi")))
                .andExpect(jsonPath("$[0].description", is("description of putchii test")))
                .andExpect(jsonPath("$[1].name", is("maka")))
                .andExpect(jsonPath("$[1].description", is("description of maka test")));
    }*/
}
