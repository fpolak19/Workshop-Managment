package com.filip.workshop_managment.service;

import com.filip.workshop_managment.models.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> listAll();

    Vehicle getById(Long id);

    Vehicle saveOrUpdate(Vehicle vehicle);

    void delete(Long id);


}
