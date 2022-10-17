package com.example.reto3.service;


import com.example.reto3.entities.Doctor;
import com.example.reto3.entities.Reservation;
import com.example.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation d){
        if(d.getIdReservation()==null){
            return reservationRepository.save(d);

        }else{
            Optional<Reservation> e = reservationRepository.getReservation(d.getIdReservation());
            if(e.isPresent()){
                return d;
            }else{
                return reservationRepository.save(d);

            }
        }

    }

    public Reservation update(Reservation d){
        if(d.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(d.getIdReservation());
            if(!e.isPresent()){
                if(d.getName()!=null){
                    e.get().setName(d.getName());
                }




                reservationRepository.save(e.get());
                return e.get();
            }else{
                return d;
            }
        }else{
            return d;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>e= reservationRepository.getReservation(id);
        if(e.isPresent()){
            reservationRepository.delete(e.get());
            flag=true;
        }
        return flag;
    }


}
