package com.insurance.insurance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="Admin_FirstName")
    private String first_Name ;

    @Column(name ="Admin_LastName")
    private String last_Name ;

    @Column(name ="Admin_TelPhone")
    private int tell;

    @Column(name ="Admin_AddRess")
    private String address;

    public Admin(String first_Name, String last_Name, int tell, String address) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.tell = tell;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public int getTell() {
        return tell;
    }

    public void setTell(int tell) {
        this.tell = tell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 

     
}

