package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.AdminDTO;
import org.example.service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class adminController {
    @Autowired
    public AdminServiceInterface adminServiceInterface;

    @PostMapping
    public boolean saveAdmin(@Valid @RequestBody AdminDTO adminDTO){
        return adminServiceInterface.save(adminDTO);
    }

    @GetMapping("/{name}/{password}")
    public List<AdminDTO> searchAdmin(@PathVariable String name, @PathVariable String password){
        return adminServiceInterface.searchAdmin(name,password);
    }

}
