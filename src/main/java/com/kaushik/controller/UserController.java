package com.kaushik.controller;

import com.kaushik.exception.UserException;
import com.kaushik.model.User;
import com.kaushik.repository.UserRepository;
import com.kaushik.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){

        User createdUser = userService.createUser(user);

        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

//    get all users
    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers(){

        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws Exception{

        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }


    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updatedUser(@RequestBody User user,@PathVariable Long id) throws Exception{
            User updatedUser = userService.updateUser(id,user);
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws Exception{
            userService.deleteUser(id);
            return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
    }
}
