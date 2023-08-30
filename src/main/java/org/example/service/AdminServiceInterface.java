package org.example.service;

import org.example.dto.AdminDTO;
import org.example.dto.StudentDTO;

import java.util.List;

public interface AdminServiceInterface {
    boolean save(AdminDTO adminDTO);

    List<AdminDTO> searchAdmin(String name, String password);
}
