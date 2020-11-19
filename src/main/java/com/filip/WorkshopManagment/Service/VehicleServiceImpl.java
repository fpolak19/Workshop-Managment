package com.filip.WorkshopManagment.Service;

import com.filip.WorkshopManagment.Models.Vehicles;
import com.filip.WorkshopManagment.Reopsitory.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicles> listAll() {
        List<Vehicles> vehicles = new ArrayList<>();
       vehicleRepository.findAll().forEach(vehicles::add);
        return vehicles;
    }

    @Override
    public Vehicles getById(Long id) {
        return vehicleRepository.findById(id).orElse(null);

    }

    @Override
    public Vehicles saveOrUpdate(Vehicles vehicles) {
        vehicleRepository.save(vehicles);
        return null;
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);

    }

}
