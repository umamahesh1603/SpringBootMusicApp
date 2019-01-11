package com.stackroute.controller;


import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

     public UserController(UserService userService){
    this.userService=userService;
    }

    public void setUserService(UserService userService) {

        this.userService = userService;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)

    public ResponseEntity<User> saveUser(@RequestBody User user) {

          User user1 = userService.saveUser(user);

        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listOfUsers() {

        List<User> allUsers = userService.getAllUsers();

        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.DELETE)
    public void  deleteTrack(@PathVariable int id) {
        userService.deleteById(id);

    }

    @RequestMapping(value = "/users/{id}",method =RequestMethod.PUT)
    public ResponseEntity<User> updateStudent(@RequestBody User user, @PathVariable int id) {

        user.setId(id);

        userService.save(user);

        return ResponseEntity.noContent().build();
    }


//    @RequestMapping(value = "users/{name}", method = RequestMethod.GET)

//    public ResponseEntity<List<User>> findUser(@PathVariable("name") String name) {
//
//         List<User> answer = (List<User>) userService.findByName(name);
//         return (ResponseEntity<List<User>>) answer;
//
//
//
////        List<User> user2 = userService.findUser();
////
////        return new ResponseEntity<List<User>>(user2, HttpStatus.OK);
//    }




}
