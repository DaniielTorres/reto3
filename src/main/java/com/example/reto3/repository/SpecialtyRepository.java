package com.example.reto3.repository;

import com.example.reto3.entities.Doctor;
import com.example.reto3.entities.Specialty;
import com.example.reto3.repository.crudRepository.DoctorCrudRepository;
import com.example.reto3.repository.crudRepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {

    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    public List<Specialty> getAll(){
        return (List<Specialty>) specialtyCrudRepository.findAll();
    }

    public Specialty save(Specialty s){
        return specialtyCrudRepository.save(s);
    }

    public void delete(Specialty s){
        specialtyCrudRepository.delete(s);
    }

    public Optional<Specialty> getSpecialty(int id){
        return specialtyCrudRepository.findById(id);
    }


}
