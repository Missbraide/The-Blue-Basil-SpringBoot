package com.tbb.TheBlueBasil.data;

import com.tbb.TheBlueBasil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
 User findByEmail(String email);


}
