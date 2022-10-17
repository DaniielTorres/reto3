package com.example.reto3.service;



import com.example.reto3.entities.Doctor;
import com.example.reto3.entities.Specialty;
import com.example.reto3.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }
    public Optional<Specialty> getSpecialty(int id){
        return specialtyRepository.getSpecialty(id);
    }
    public Specialty save(Specialty d){
        if(d.getId()==null){
            return specialtyRepository.save(d);

        }else{
            Optional<Specialty> e =specialtyRepository.getSpecialty(d.getId());
            if(e.isPresent()){
                return d;
            }else{
                return specialtyRepository.save(d);

            }
        }

    }

    public Specialty update(Specialty d){
        if(d.getId()!=null){
            Optional<Specialty> e= specialtyRepository.getSpecialty(d.getId());
            if(!e.isPresent()){
                if(d.getName()!=null){
                    e.get().setName(d.getName());
                }




                specialtyRepository.save(e.get());
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
        Optional<Specialty>e=specialtyRepository.getSpecialty(id);
        if(e.isPresent()){
            specialtyRepository.delete(e.get());
            flag=true;
        }
        return flag;
    }


}
