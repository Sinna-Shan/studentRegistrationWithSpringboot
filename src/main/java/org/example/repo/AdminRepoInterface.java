package org.example.repo;

import org.example.dao.AdminDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepoInterface extends JpaRepository<AdminDAO,Integer> {

    List<AdminDAO> findByUserNameAndPassword(String userName, String password);
}
