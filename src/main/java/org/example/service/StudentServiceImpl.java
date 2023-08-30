package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;
import org.example.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        return studentRepo.save(modelMapper.map(studentDTO, StudentDAO.class));
    }

    public boolean updateStudent(StudentDTO studentDTO){
        StudentDAO exsists = isExsists(studentDTO.getNic());
        if(exsists==null){
            studentRepo.save(modelMapper.map(studentDTO,StudentDAO.class));
        }else{
            exsists.setAge(studentDTO.getAge());
            exsists.setAddress(studentDTO.getAddress());
            exsists.setGender(studentDTO.getGender());
            exsists.setFirstName(studentDTO.getFirstName());
            exsists.setLastName(studentDTO.getLastName());
            exsists.setNic(studentDTO.getNic());
            exsists.setBatch(studentDTO.getBatch());
            studentRepo.save(exsists);
        }

        return true;
    }

    public List<StudentDTO> getAllStudents(){
        return modelMapper.map(studentRepo.findAll(), new TypeToken<List<StudentDTO>>(){}.getType());
    }

    @Override
    public List<StudentDTO> findByName(String firstName) {
        return modelMapper.map(studentRepo.findByFirstName(firstName),new TypeToken<List<StudentDTO>>(){}.getType());
    }

    @Override
    public boolean deleteByNic(String nic) {
        studentRepo.deleteByNic(nic);
        return true;
    }

    public StudentDAO isExsists(String nic){
        return studentRepo.findByNic(nic);
    }
}
