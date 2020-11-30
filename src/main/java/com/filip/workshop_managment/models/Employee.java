package com.filip.workshop_managment.models;

import javax.persistence.*;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String mobile;
    private String notes;

    public Employee(Long id, String fullName, String mobile, String notes) {
        this.id = id;
        this.fullName = fullName;
        this.mobile = mobile;
        this.notes = notes;
    }

    public Employee() {
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
