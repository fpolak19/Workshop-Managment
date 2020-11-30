package com.filip.workshop_managment.service;

import com.filip.workshop_managment.models.Vehicle;
import com.filip.workshop_managment.reopsitory.VehicleRepository;
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
    public List<Vehicle> listAll() {
        List<Vehicle> vehicles = new ArrayList<>();
       vehicleRepository.findAll().forEach(vehicles::add);
        return vehicles;
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id).orElse(null);

    }

    @Override
    public Vehicle saveOrUpdate(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return null;
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);

    }

    @Override
    public void update(Long id, Vehicle vehicle) {
        List<Vehicle> vehicle1 = new ArrayList<>();
        for(int i=0; i<vehicle1.size(); i++){
            Vehicle updateVehicle = vehicle1.get(i);
            if(updateVehicle.getId().equals(id)){
                vehicle1.set(i,vehicle);
                return;
            }
        }
    }
}
