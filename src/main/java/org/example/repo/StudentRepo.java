package org.example.repo;

import org.example.dao.StudentDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<StudentDAO,Integer> {
    StudentDAO findByuserNameAndPassword(String userName, String password);
}
