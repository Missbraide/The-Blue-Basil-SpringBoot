package com.tbb.TheBlueBasil.data;

import com.tbb.TheBlueBasil.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
