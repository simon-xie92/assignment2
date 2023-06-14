package com.cmpt276.assignment2.controllers;

import java.rmi.server.UID;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.ssl.SslBundleProperties.Key;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.engine.AttributeName;

import com.cmpt276.assignment2.models.Student;
import com.cmpt276.assignment2.models.StudentRepository;

import aj.org.objectweb.asm.Attribute;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class StudentsController {
    
    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/students/view")
    public String getAllStudents(Model model){
        System.out.println("getting users");
        List<Student> students = studentRepo.findAll();
        model.addAttribute("us", students);
        return "students/showAll";
    }
    
    @GetMapping("/students/view/{uid}")
    public String getStudent(Model model, @PathVariable int uid){
        
        System.out.println("GET Student " + uid);
        // call db
        List<Student> students = studentRepo.findByUid(uid);
       
        model.addAttribute("student", students);
        return "showStudent";
    }

    @GetMapping("/students/delete/{uid}")
    public String deleteStudent(Model model, @PathVariable int uid){
        System.out.println("DELETE Student " + uid);
        // call db
        List<Student> students = studentRepo.findByUid(uid);
        
        //couldnt figure out
        //model.addAttribute(attributeName:"student", students);
        return "showStudent";
    }
    
    @PostMapping("/students/edit/{uid}")
    public String editStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        
        System.out.println("edit");
        String newName = newstudent.get("name");
        int newWeight = Integer.parseInt(newstudent.get("weight"));
        int newHeight = Integer.parseInt(newstudent.get("height"));
        String newHaircolor = newstudent.get("haircolor");
        int newGpa = Integer.parseInt(newstudent.get("gpa"));
        studentRepo.save(new Student(newName, newWeight, newHeight, newHaircolor, newGpa));
        response.setStatus(201);
        
        return "students/addedStudent";
        
    }
    // data coming from form would be a PostMapping
    @PostMapping("/students/add")
    public String AddStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        
        System.out.println("key");
        String newName = newstudent.get("name");
        int newWeight = Integer.parseInt(newstudent.get("weight"));
        int newHeight = Integer.parseInt(newstudent.get("height"));
        String newHaircolor = newstudent.get("haircolor");
        int newGpa = Integer.parseInt(newstudent.get("gpa"));
        studentRepo.save(new Student(newName, newWeight, newHeight, newHaircolor, newGpa));
        response.setStatus(201);
        
        return "students/addedStudent";
        
    }
    
}