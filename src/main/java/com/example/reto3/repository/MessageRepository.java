package com.example.reto3.repository;

import com.example.reto3.entities.Doctor;
import com.example.reto3.entities.Message;
import com.example.reto3.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired

    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Message save(Message d){
        return messageCrudRepository.save(d);
    }

    public void delete(Message d){
        messageCrudRepository.delete(d);
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }


}
