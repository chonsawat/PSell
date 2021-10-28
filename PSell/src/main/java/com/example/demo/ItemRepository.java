package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("SELECT u FROM Item u WHERE u.owner= ?1")
	List<Item> findByOwner(Long owner);
}
