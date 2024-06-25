package com.insurance.insurance.repository;

import com.insurance.insurance.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminRepository extends JpaRepository<Admin,Integer>{
    
}
