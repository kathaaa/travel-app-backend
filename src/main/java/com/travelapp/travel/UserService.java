package com.travelapp.travel;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //CRUD

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, String newName, String newEmail, String newPassword,
                           String newProfilePhoto ){
        return userRepository.findById(id).map(u -> {
            if(newName != null) u.setName(newName);
            if(newEmail != null) u.setEmail(newEmail);
            if(newPassword != null) u.setPassword(newPassword);
            if(newProfilePhoto != null) u.setProfilePhoto(newProfilePhoto);
            return userRepository.save(u);
        })
                .orElseThrow(()-> new RuntimeException("User not found"));

    }
}
