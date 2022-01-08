package com.springboot.thymeleafusage.rest;

import com.springboot.thymeleafusage.entity.Student;
import com.springboot.thymeleafusage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Value("${team.name}")
    private String teamName;

    @Value("${coach.name}")
    private String coachName;

    //setup constructor injection.
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "<strong>Hello Spring Boot Project!</strong>";
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PostMapping("/student/update")
    public void update(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/names")
    public String getNames(){
        return "TeamName: " + teamName + " Coach Name: " + coachName;
    }
}
