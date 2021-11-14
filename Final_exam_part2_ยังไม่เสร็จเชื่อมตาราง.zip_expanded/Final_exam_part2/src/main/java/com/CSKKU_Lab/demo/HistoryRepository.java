package com.CSKKU_Lab.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoryRepository extends JpaRepository<History, Integer> {
	History findByUser(String username);
	
	@Query("SELECT u FROM History u WHERE u.user=:id OR (u.user is null AND :id is null)")
	List<History> findManyByUser(@Param("id") User user);
}