package com.springboot.thymeleafusage.controller;

import com.springboot.thymeleafusage.entity.Student;
import com.springboot.thymeleafusage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String helloWorld(Model theModel) {
        theModel.addAttribute("name", "Kayhan Öztürk");
        return "helloworld";
    }

    @GetMapping("/list")
    public String getStudentList(Model theModel) {
      /*  List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("kayhan", "Öztürk", new java.util.Date()));
        theModel.addAttribute("students", studentList);
       */
        List<Student> studentList = studentService.findAll();
        theModel.addAttribute("students", studentList);
        return "student/list-student";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("id") int id, Model theModel) {
        Student student = studentService.findById(id);
        theModel.addAttribute("student", student);
        return "student/student-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Student student = new Student();
        theModel.addAttribute("student", student);
        return "student/student-form";
    }

    @GetMapping("/deleteStudent")
    public String delete(@RequestParam("id") int theId) {
        //delete the student
        studentService.deleteById(theId);
        //redirect to /students/list
        return "redirect:/students/list";
    }
}
