package com.example.reto3.controller;


import com.example.reto3.entities.Client;
import com.example.reto3.entities.Doctor;
import com.example.reto3.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAll(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int id){
        return doctorService.getDoctor(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor d){
        return doctorService.save(d);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int doctorId){
        return doctorService.delete(doctorId);
    }
}
