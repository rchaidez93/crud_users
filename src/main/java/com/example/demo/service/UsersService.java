package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    public Users save(Users user){
        return usersRepository.save(user);
    }

    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    public Optional<Users> findById(String id){
        return usersRepository.findById(id);
    }

    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }

    public void deleteById(String id) {
        usersRepository.deleteById(id);
    }
}
