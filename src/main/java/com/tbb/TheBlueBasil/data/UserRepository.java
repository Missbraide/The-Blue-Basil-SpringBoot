package com.tbb.TheBlueBasil.data;

import com.tbb.TheBlueBasil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
