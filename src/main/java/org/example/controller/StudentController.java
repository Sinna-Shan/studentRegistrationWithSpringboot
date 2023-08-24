package org.example.controller;

import jakarta.validation.Valid;
import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;
import org.example.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    public ServiceInterface serviceInterface;
    @PostMapping
    public ResponseEntity<StudentDAO> saveStudent(@Valid @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(serviceInterface.saveStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userName}/{password}")
    public boolean isMatch(@PathVariable String userName, @PathVariable String password){
        return serviceInterface.isMatch(userName,password);


    }

}
