package com.example.demo.controller;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    //read
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersService.getAll();
    }

    @GetMapping("/users/searchByUsername")
    public Users searchByUsername(@RequestParam(name = "username") String username){
        return usersService.findByUsername(username);
    }

    //create
    @PostMapping("/users")
    public Users add(@RequestBody Users users){
        return usersService.save(users);
    }

    //update
    @PutMapping("/users/update")
    public Users updateUser(@RequestParam(name = "id") String id, @RequestBody Users user){
        return usersService.findById(id)
                .map(updateUser -> {
                    updateUser.setFname(user.fname);
                    updateUser.setLname(user.lname);
                    updateUser.setUsername(user.username);
                    return usersService.save(updateUser);
                })
                .orElseThrow(()-> new ResourceNotFoundException(id));
    }

    //delete
    @DeleteMapping("/users")
    public void deleteUser(@RequestParam(value = "id") String id){
        usersService.deleteById(id);
    }

}
