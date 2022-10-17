package com.example.reto3.service;


import com.example.reto3.entities.Doctor;
import com.example.reto3.entities.Message;
import com.example.reto3.repository.MessageRepository;
import javafx.beans.binding.MapExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message d){
        if(d.getIdMessage()==null){
            return messageRepository.save(d);

        }else{
            Optional<Message> e = messageRepository.getMessage(d.getIdMessage());
            if(e.isPresent()){
                return d;
            }else{
                return messageRepository.save(d);

            }
        }

    }

    public Message update(Message d){
        if(d.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(d.getIdMessage());
            if(!e.isPresent()){
                if(d.getMessageText()!=null){
                    e.get().setMessageText(d.getMessageText());
                }




                messageRepository.save(e.get());
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
        Optional<Message>e= messageRepository.getMessage(id);
        if(e.isPresent()){
            messageRepository.delete(e.get());
            flag=true;
        }
        return flag;
    }


}
