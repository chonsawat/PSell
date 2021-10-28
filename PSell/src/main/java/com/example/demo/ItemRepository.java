package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sun.istack.Nullable;

public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("SELECT u FROM Item u WHERE u.user=:id OR (u.user is null AND :id is null)")
	List<Item> findByUser(@Param("id") User user);
}
