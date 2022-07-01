package com.tbb.TheBlueBasil.services;

import com.tbb.TheBlueBasil.data.MenuRepository;
import com.tbb.TheBlueBasil.data.ReservationRepository;
import com.tbb.TheBlueBasil.data.UserRepository;
import com.tbb.TheBlueBasil.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {


   
        @Autowired
        private UserRepository userRepository;



        public List<User> getAllUsers() {
            return userRepository.findAll();
        }


        public void saveUsers(User user) {
            this.userRepository.save(user);
        }


        public User getUserById(long id) {
            Optional< User > optional = userRepository.findById(id);
            User user = null;
            if (optional.isPresent()) {
                user = optional.get();
            } else {
                throw new RuntimeException(" Users not found for id :: " + id);
            }
            return user;
        }


        public void deleteUsersById(long id) {
            this.userRepository.deleteById(id);
        }
    



//    @Autowired
//    UserRepository UserRepository;
//    ReservationRepository reservationRepository;
//    MenuRepository menuRepository;
//
//
//    public List<User> findAll(){
//
//        return UserRepository.findAll();
//
//    }
//
//
//    @Transactional(rollbackOn = {NoSuchElementException.class})
//    public User findByEmail(String email) throws NoSuchElementException{
//        return UserRepository.findById((email)).orElseThrow();
//    }
//
//
//    @Transactional(rollbackOn = {NoSuchElementException.class})
//    public User findByUsername(String Username) throws NoSuchElementException{
//        return UserRepository.findById((Username)).orElseThrow();
//    }
//
//
//
//
//    public void deleteUserById(String email) {
//        this.UserRepository.deleteById(email);
//
//    }
//
//    public void saveOrUpdate(User User) {
//        UserRepository.save(User);
//
//    }
//
//    public List<User> findAllSortedBy(Sort sort){
//        return UserRepository.findAll(sort);
//    }
//
//
//
//    public User getUserById(String email) {
//        return UserRepository.findById(email).orElseThrow();
//
//    }
}