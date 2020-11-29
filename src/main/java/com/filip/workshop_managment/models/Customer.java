package com.filip.workshop_managment.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="customer")
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String address;
    private String mobile;
    private String email;
    private String notes;
    @OneToMany(mappedBy = "customer")
    private  List<Vehicle> vehicle = new ArrayList<Vehicle>();
    public Customer(Long id, String fullName, String address, String mobile, String email, String notes) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.notes = notes;

    }
    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", notes='" + notes + '\'' +

                '}';
    }
}

