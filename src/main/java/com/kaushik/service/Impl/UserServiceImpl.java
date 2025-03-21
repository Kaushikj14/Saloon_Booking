package com.kaushik.service.Impl;

import com.kaushik.exception.UserException;
import com.kaushik.model.User;
import com.kaushik.repository.UserRepository;
import com.kaushik.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException("User not found");


    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public void deleteUser(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserException("User is not avaiable in db");
        }
        userRepository.deleteById(user.get().getId());


    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
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
        throw new UserException("User is not avaiable");
    }
}
