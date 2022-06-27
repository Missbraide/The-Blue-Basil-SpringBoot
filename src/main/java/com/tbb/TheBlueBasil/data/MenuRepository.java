package com.tbb.TheBlueBasil.data;

import com.tbb.TheBlueBasil.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
