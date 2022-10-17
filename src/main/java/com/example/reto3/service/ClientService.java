package com.example.reto3.service;


import com.example.reto3.entities.Client;
import com.example.reto3.entities.Doctor;
import com.example.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client d){
        if(d.getIdClient()==null){
            return clientRepository.save(d);

        }else{
            Optional<Client> e = clientRepository.getClient(d.getIdClient());
            if(e.isPresent()){
                return d;
            }else{
                return clientRepository.save(d);

            }
        }

    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isPresent()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>e= clientRepository.getClient(id);
        if(e.isPresent()){
            clientRepository.delete(e.get());
            flag=true;
        }
        return flag;
    }


}
