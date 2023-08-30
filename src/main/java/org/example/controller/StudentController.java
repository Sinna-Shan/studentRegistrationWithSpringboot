package org.example.controller;

import jakarta.validation.Valid;
import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;
import org.example.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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

    @PutMapping
    public boolean updateStudent(@RequestBody StudentDTO studentDTO){
        return serviceInterface.updateStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return serviceInterface.getAllStudents();
    }

    @GetMapping("/{firstName}")
    public List<StudentDTO> findByName(@PathVariable String firstName){
        return serviceInterface.findByName(firstName);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        return serviceInterface.deleteById(id);
    }
}
