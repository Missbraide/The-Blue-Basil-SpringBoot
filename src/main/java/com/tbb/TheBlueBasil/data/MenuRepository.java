package com.tbb.TheBlueBasil.data;

import com.tbb.TheBlueBasil.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

//    @Query(nativeQuery = true)
//    List<Menu> findMenuItems(long id);
//
//
}
