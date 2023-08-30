package org.example.service;

import org.example.dto.AdminDTO;

public interface AdminServiceInterface {
    boolean save(AdminDTO adminDTO);

    boolean searchAdmin(String name, String password);
}
