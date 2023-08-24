package org.example.service;

import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;

import java.util.List;

public interface ServiceInterface {
    public StudentDAO saveStudent(StudentDTO studentDTO);

    boolean isMatch(String userName, String password);
}
