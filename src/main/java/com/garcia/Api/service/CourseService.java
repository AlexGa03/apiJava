/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.service;
import com.garcia.Api.model.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garcia.Api.repository.CourseRepository;
/**
 *
 * @author alexgaralv
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository Prepository;
    
    public List<Course>listCourses(){
        return Prepository.findAll();
    
    }
    public void saveCourse(Course course){
        Prepository.save(course);
    }
    public Course getCourseById(Integer id){
        return Prepository.findById(id).get();
    }
    public void deleteCourse (Integer id){
        Prepository.deleteById(id);
    }
    
}
