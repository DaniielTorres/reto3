package com.example.reto3.repository.crudRepository;

import com.example.reto3.entities.Client;
import com.example.reto3.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
