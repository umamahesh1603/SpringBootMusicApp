package com.stackroute.service;

import com.stackroute.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

     public List<User> getAllUsers();

//    public List<User> findUser();

//    public List<User> findByName(String name);

    public void deleteById(int id);

  //  public List<User> updateByComments(String comments);
//public   Optional<User> findById(int id);

    public User save(User user);
}
