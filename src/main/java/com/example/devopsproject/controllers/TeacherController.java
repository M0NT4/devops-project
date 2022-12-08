package com.example.devopsproject.controllers;
import com.example.devopsproject.models.Teacher;
import com.example.devopsproject.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
public class TeacherController {
    @Autowired
    TeacherService teacherService;


    @GetMapping("/all")
    public List<Teacher> getTeachers() throws Exception
    {
        List<Teacher> teachersList = this.teacherService.getAllTeachers();
        return teachersList;
    }


    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable("teacherId") Long teacherId) throws Exception
    {
        Teacher teacher = this.teacherService.getTeacherById(teacherId);
        return teacher;
    }

    @PostMapping("/create")
    public Teacher createNewTeacher(@RequestBody Teacher newTeacher) throws Exception
    {
        Teacher teacher = this.teacherService.createTeacher(newTeacher);
        return teacher;
    }

}
