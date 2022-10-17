package com.example.reto3.repository.crudRepository;

import com.example.reto3.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor,Integer> {
}
