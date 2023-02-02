/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.controller;

import com.garcia.Api.model.Course;
import com.garcia.Api.service.CourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexgaralv
 */
//Client
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
//Course
    @GetMapping("/Course")
    public List<Course> listCourses() {
        return courseService.listCourses();
    }

    @GetMapping("/Course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer id) {
        try {
            Course course = courseService.getCourseById(id);
            return ResponseEntity.ok(course);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/Course")
    public void newCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @PutMapping("/Course/{id}")
    public ResponseEntity<?> editCourse(@RequestBody Course course, @PathVariable Integer id) {
        try {
            Course courseExists = courseService.getCourseById(id);
            if (course.getCname() != null) {
                courseExists.setCname(course.getCname());
            }
            if (course.getCodeC() != null) {
                courseExists.setCodeC(course.getCodeC());
            }
            if (course.getPrice() != 0) {
                courseExists.setPrice(course.getPrice());
            }
            if (course.getCategory() != null) {
                courseExists.setCategory(course.getCategory());
            }
            courseExists.setActive(course.isActive());
            
            if (course.getImg_url() != null) {
                courseExists.setImg_url(course.getImg_url());
            }
            if (course.getDescription() != null) {
                courseExists.setDescription(course.getDescription());
            }
            
            courseService.saveCourse(courseExists);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Course/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }
}
