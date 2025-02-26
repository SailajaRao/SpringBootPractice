package com.springboot.practice.service;

import com.springboot.practice.UserNotFoundException;
import com.springboot.practice.model.User;
import com.springboot.practice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSvc {
    @Autowired
    public UserRepo uRepo;
    
    public User addUser(User u){
        return uRepo.save(u);
    }
    
    public List<User> getAllUsers(){
        return uRepo.findAll();
    }
    
    public User getUserById(int id) {
        return uRepo.getById(id);
    }
    
    public User updateUser(int id, User u){
        if (uRepo.existsById(id)){
            User user = uRepo.getById(id);
            user.setUsername(u.getUsername());
            user.setPassword(u.getPassword());
            return uRepo.save(user);
        } else {
            return null;
        }
    }
    
    public String deleteUserById(int id){
        uRepo.deleteById(id);
        return "Deleted ID: " + id;
    }
    
    public String deletedAll(){
        uRepo.deleteAll();
        return "Deleted all Users";
    }
}
