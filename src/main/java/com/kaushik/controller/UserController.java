package com.kaushik.controller;

import com.kaushik.model.User;
import com.kaushik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @GetMapping("/api/user/{id}")
    public User findUserById(@PathVariable Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("User not found");
        }

    }


    @PutMapping("/api/user/{id}")
    public User updatedUser(@RequestBody User user,@PathVariable Long id) throws Exception{
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isPresent()){
            User existingUser = user1.get();
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            userRepository.save(existingUser);
            return existingUser;
        }
        throw new Exception("User is not avaiable");
    }

    @DeleteMapping("/api/user/{id}")
    public String deleteUserById(@PathVariable Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new Exception("User is not avaiable in db");
        }
        userRepository.deleteById(user.get().getId());
        return "User is deleted sucessfully";
    }
}
