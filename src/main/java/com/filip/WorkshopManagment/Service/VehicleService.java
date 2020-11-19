package com.filip.WorkshopManagment.Service;

import com.filip.WorkshopManagment.Models.Vehicles;

import java.util.List;

public interface VehicleService {
    List<Vehicles> listAll();

    Vehicles getById(Long id);

    Vehicles saveOrUpdate(Vehicles vehicles);

    void delete(Long id);


}
