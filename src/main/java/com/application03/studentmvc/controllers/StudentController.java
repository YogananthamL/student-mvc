package com.application03.studentmvc.controllers;

import com.application03.studentmvc.entity.StudentEntity;
import com.application03.studentmvc.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentServiceImpl service;
    @Autowired
    public StudentController(StudentServiceImpl service){
        this.service=service;
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<StudentEntity> studentList=service.select();
        model.addAttribute("students",studentList);
        return "studentList";
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        StudentEntity student=new StudentEntity();
        model.addAttribute("student",student);
        return "studentForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") StudentEntity student){
        service.save(student);
        return"redirect:/students/list";
    }

    @GetMapping("/update")
    public String save(@RequestParam("studentId") int id,Model model){
        StudentEntity student=service.findById(id);
        model.addAttribute("student",student);
        return "studentForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int id){
        service.delete(id);
        return"redirect:/students/list";
    }
}
