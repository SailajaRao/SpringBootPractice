package com.springboot.practice.controller;

import com.springboot.practice.service.UserSvc;
import com.springboot.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserSvc svc;
    
    @PostMapping
    public User createUser(@RequestBody User user){
        return svc.addUser(user);
    }
    
    @GetMapping
    public List<User> getAllUsers(){
        return svc.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return svc.getUserById(id);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User u){
        return svc.updateUser(id, u);
    }
    
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return svc.deleteUserById(id);
    }
    
    @DeleteMapping
    public String deleteAll(){
        return svc.deletedAll();
    }
}
