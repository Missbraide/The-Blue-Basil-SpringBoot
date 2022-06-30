package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.data.MenuRepository;
import com.tbb.TheBlueBasil.data.ReservationRepository;
import com.tbb.TheBlueBasil.data.UserRepository;
import com.tbb.TheBlueBasil.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    ReservationRepository reservationRepository;
    MenuRepository menuRepository;


    public List<User> findAll(){

        return userRepository.findAll();

    }


    @Transactional(rollbackOn = {NoSuchElementException.class})
    public User findByEmail(String email) throws NoSuchElementException{
        return userRepository.findById((email)).orElseThrow();
    }


    @Transactional(rollbackOn = {NoSuchElementException.class})
    public User findByUsername(String username) throws NoSuchElementException{
        return userRepository.findById((username)).orElseThrow();
    }




    public void deleteUserById(String email) {
        this.userRepository.deleteById(email);

    }

    public void saveOrUpdate(User user) {
       userRepository.save(user);

    }

    public List<User> findAllSortedBy(Sort sort){
        return userRepository.findAll(sort);
    }



    public User getUserById(String email) {
      return userRepository.findById(email).orElseThrow();

    }
}
