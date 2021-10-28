package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
public class ItemRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void testFindItemByUserOwner() {
		User user = new User();
		user.setEmail("chonsawat.naknam@gmail.com");
		user.setPassword("chonsawat");
		user.setFirstName("Chonsawat");
		user.setLastName("Nakanam");
		repo.save(user);
		
		String email = "chonsawat.naknam@gmail.com";
		user = repo.findByEmail(email);
		
		Item item = new Item();
		item.setItemName("a");
		item.setPath("images/a.png");
		item.setOwner(user.getId());
		
		assertThat(item.getPath()).isEqualTo("images/a.png");
		itemRepo.save(item);
		
//		Item items = itemRepo.findByOwner(owner);
//		assertThat(items).isNotNull();
	}
}
