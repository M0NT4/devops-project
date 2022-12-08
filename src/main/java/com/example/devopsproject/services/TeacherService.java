package com.example.devopsproject.services;
import com.example.devopsproject.models.Teacher;
import com.example.devopsproject.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) throws Exception {

        Teacher createdTeacher = this.teacherRepository.save(teacher);
        return createdTeacher;
    }

    public List<Teacher> getAllTeachers() throws Exception {

        List<Teacher> teachers = this.teacherRepository.findAll();
        return teachers;
    }

    public Teacher getTeacherById(Long teacherId) throws Exception {

        Optional<Teacher> teacherData = this.teacherRepository.findById(teacherId);
        if(teacherData.isPresent()){
            Teacher teacher = teacherData.orElseThrow(()-> new Exception("teacher not found"));
            return teacher;
        }else{
            throw new  Exception("Teacher with this Id not found");
        }
    }
}
