package com.example.reto3.repository;

import com.example.reto3.entities.Doctor;
import com.example.reto3.entities.Reservation;
import com.example.reto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired

    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Reservation save(Reservation d){
        return reservationCrudRepository.save(d);
    }

    public void delete(Reservation d){
        reservationCrudRepository.delete(d);
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }


}
