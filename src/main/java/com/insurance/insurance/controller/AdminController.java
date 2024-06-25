
package com.insurance.insurance.controller;
 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.insurance.insurance.model.Admin;
import com.insurance.insurance.repository.AdminRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;

@RestController

public class AdminController {
    @Autowired
    AdminRepository adminrepository;

    @GetMapping("/admins")
    public List<Admin>getAllaAdmins (){
     List<Admin> admin = adminrepository.findAll();
        return admin;
    }

    @GetMapping("/admins/{id}")    
    public Admin getAdmin(@PathVariable int id){
        Admin admin = adminrepository.findById(id).get();
        return admin;
    }
    
    @PostMapping("/admins/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createAdmin(@RequestBody Admin admin) {
        adminrepository.save(admin);
    }
    
    @PutMapping("/admins/update/{id}")
    public Admin updateAdmin(@PathVariable int id,@RequestBody Admin updateadmin) throws Exception{
        Admin admin = adminrepository.findById(id).get();
       if(admin == null){
        throw new Exception("admin not found");
       }
       admin.setFirst_Name(updateadmin.getFirst_Name());
       admin.setLast_Name(updateadmin.getLast_Name());
       admin.setAddress(updateadmin.getAddress());
       admin.setTell(updateadmin.getTell());
       Admin updateadmins = adminrepository.save(admin);
    return updateadmins;
    }

    @DeleteMapping("/admins/delete/{id}")
    public Admin deleteAdmin(@PathVariable int id) throws Exception{
        Admin admin = adminrepository.findById(id).get();
        if(admin == null){
         throw new Exception("admin not found");
        }
        
       adminrepository.deleteById(id);
        return admin;

     }
}
