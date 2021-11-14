package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test 
	public void testCreateUser() {
		User user = new User("0973566421", "chonsawat", "Chonsawat", "Nakanam");
		repo.save(new User("0998763754", "chonsawat", "ชนม์สวัสดิ์", "นาคนาม"));
		
		User savedUser = repo.save(user);		
		User existUser = entityManager.find(User.class, savedUser.getUid());
		
		assertThat(existUser.getUsername()).isEqualTo(user.getUsername());
	}
	
	@Test 
	public void testFindUserByEmail() {
		String username = "0973566421";
		User user = repo.findByUsername(username);
		assertThat(user).isNotNull();
	}
}
