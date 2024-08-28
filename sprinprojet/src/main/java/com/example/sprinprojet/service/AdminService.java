package com.example.sprinprojet.service;

import com.example.sprinprojet.Repository.AdminRepository;
import com.example.sprinprojet.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long idAdmin) {
        return adminRepository.findById(idAdmin).orElse(null);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
