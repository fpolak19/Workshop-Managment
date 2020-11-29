package com.filip.workshop_managment.reopsitory;

import com.filip.workshop_managment.models.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
