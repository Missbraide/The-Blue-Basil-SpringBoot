package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.data.UserRepository;
import com.tbb.TheBlueBasil.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;



    public List<User> getAllUsers() {
        return null;
    }


    public void saveUser(User user) {

    }


    public User getUserById(long id) {
        return null;
    }


    public void deleteUserById(long id) {

    }
}
