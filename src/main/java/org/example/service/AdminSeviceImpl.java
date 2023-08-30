package org.example.service;

import org.example.dao.AdminDAO;
import org.example.dto.AdminDTO;
import org.example.repo.AdminRepoInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSeviceImpl implements AdminServiceInterface {
    @Autowired
    public AdminRepoInterface adminRepoInterface;

    @Autowired
    public ModelMapper modelMapper;
    @Override
    public boolean save(AdminDTO adminDTO) {
        List<AdminDAO> searchResults = adminRepoInterface.findByUserNameAndPassword(adminDTO.getUserName(), adminDTO.getPassword());
        if(!searchResults.isEmpty()){
            return false;
        }
        adminRepoInterface.save(modelMapper.map(adminDTO, AdminDAO.class));
        return true;
    }

    public List<AdminDTO> searchAdmin(String username, String password){
        return modelMapper.map(adminRepoInterface.findByUserNameAndPassword(username, password),new TypeToken<List<AdminDTO>>(){}.getType());

    }
}
