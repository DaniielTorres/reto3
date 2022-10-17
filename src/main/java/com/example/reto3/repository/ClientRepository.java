package com.example.reto3.repository;

import com.example.reto3.entities.Client;
import com.example.reto3.entities.Doctor;
import com.example.reto3.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired

    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Client save(Client d){
        return clientCrudRepository.save(d);
    }

    public void delete(Client d){
        clientCrudRepository.delete(d);
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }


}
