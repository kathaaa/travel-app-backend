package com.travelapp.travel;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user.getName(), user.getEmail(),
                user.getPassword(), user.getProfilePhoto()));
    }


}
