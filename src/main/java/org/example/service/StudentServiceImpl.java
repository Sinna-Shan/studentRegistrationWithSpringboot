package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;
import org.example.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements ServiceInterface{
    @Autowired
    public StudentRepo studentRepo;
    @Autowired
    ModelMapper modelMapper;
    public StudentDAO saveStudent(StudentDTO studentDTO) {
        if(studentRepo.findByuserNameAndPassword(studentDTO.getUserName(),studentDTO.getPassword()) != null){
            StudentDAO map = modelMapper.map(studentDTO, StudentDAO.class);
            map.setPassword("-1");
            return map;
        }else{
            return studentRepo.save(modelMapper.map(studentDTO, StudentDAO.class));
        }
    }

    @Override
    public boolean isMatch(String userName, String password) {
        if(studentRepo.findByuserNameAndPassword(userName,password) != null){
            return true;
        }
        return false;


    }
}
