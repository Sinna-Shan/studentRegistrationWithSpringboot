package org.example.repo;

import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<StudentDAO,Integer> {
    StudentDAO findByNic(String nic);
    List<StudentDAO> findByFirstName(String firstName);
    void deleteByNic(String nic);
}
