package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User user1= userRepository.save(user);
        return user1;

    }


    @Override
    public List<User> getAllUsers() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }

    @Override
    public void deleteById(int id) {
         userRepository.deleteById(id);

    }

    @Override
    public User save(User user) {
        User user2= userRepository.save(user);
        return user2;
    }


//    @Override
//    public List<User> findByName(String name) {
//        List<User> userListFound = (List<User>) userRepository.findByName(name);
//        return userListFound;
//    }


}
