package com.example.techblogapi.controller;


import com.example.techblogapi.entity.User;
import com.example.techblogapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

     @Autowired
     private UserService userService;

     @PostMapping
     public ResponseEntity<User> addUser(@RequestBody User user)  {

          try {

              userService.addUser(user);
              return ResponseEntity.status(HttpStatus.CREATED).body(user);
          }catch(Exception err){

               return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
     }

    @GetMapping
     public ResponseEntity<Iterable<User>> getAllUser() {

          return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
     }

     @GetMapping("/{id}")
     public ResponseEntity<User> getSingleUser(@PathVariable int id) {

          Optional<User> newUser=userService.getSingleUser(id);
          if(newUser.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          return ResponseEntity.status(HttpStatus.OK).body(newUser.get());
     }

     @GetMapping("/email/{email}")
     public ResponseEntity<User> getSingleUserByEmail(@PathVariable String email) {

          Optional<User> newUser=userService.getSingleUserByEmail(email);
          if(newUser.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          return ResponseEntity.status(HttpStatus.OK).body(newUser.get());
     }


     @PutMapping("/{email}")
     public ResponseEntity<User> updateUser(@PathVariable String email,@RequestBody User user) {

          Optional<User> newUser=userService.updateUser(email,user);
          if(newUser.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUser.get());
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<User> deleteUser(@PathVariable int id) {

          try{
              userService.deleteUser(id);
              return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
          }
          catch (Exception err){
              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }
     }

}