package org.example.service;

import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;

import java.util.List;

public interface ServiceInterface {
    public StudentDAO saveStudent(StudentDTO studentDTO);


    boolean updateStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();
    List<StudentDTO> findByName(String firstName);

    boolean deleteByNic(String nic);
}
