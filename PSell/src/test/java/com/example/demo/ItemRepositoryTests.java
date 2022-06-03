package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.annotations.Filter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@DisplayName("InsertItems")
	public void testInsertItem() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("admin");
		
		User user = new User();
		user.setEmail("chonsawat.naknam@gmail.com");
		user.setPassword(encodedPassword);
		user.setFirstName("Chonsawat");
		user.setLastName("Nakanam");
		repo.save(user);
		
		String email = "chonsawat.naknam@gmail.com";
		user = repo.findByEmail(email);
		
		Item item1 = new Item();
		item1.setId((long) 1);
		item1.setItemName("Cute");
		item1.setPath("images/trap.png");
		item1.setUser(user);
		
		Item item2 = new Item();
		item2.setId((long) 2);
		item2.setItemName("Mob");
		item2.setPath("images/mob.png");
		item2.setUser(user);

		Item item3 = new Item();
		item3.setId((long) 3);
		item3.setItemName("Women");
		item3.setPath("images/women.jpg");
		
		Item item4 = new Item();
		item4.setId((long) 4);
		item4.setItemName("Smart");
		item4.setPath("images/light.jpg");
		
		itemRepo.save(item1);
		itemRepo.save(item2);
		itemRepo.save(item3);
		itemRepo.save(item4);
	}
	
	@Test
	@DisplayName("FindListItemWhereOwnerNotNull")
	public void testFindItemOwnerNotNull() {	
		String email = "chonsawat.naknam@gmail.com";
		User user = repo.findByEmail(email);
		
		List<Item> items = itemRepo.findByUser(user);
		for (var item : items) {
			System.out.println("Show items name: " + item.getItemName());
		}
		
		assertThat(items).isNotEmpty();
	}
	
	@Test
	@DisplayName("FindListItemWhereOwnerIsNull")
	public void testFindItemOwnerIsNull2() {		
		List<Item> items = itemRepo.findByUser(null);
		for (var item : items) {
			System.out.println("Show null items name: " + item.getItemName());
		}
		assertThat(items).isNotEmpty();
	}
	
	@Test
	@DisplayName("FindItem")
	public void testFindItem2() {
		
		Item item = itemRepo.findById((long) 1).get();
		
		System.out.println("Show items detail:\nID: " + item.getId() +
				"\nName: " + item.getItemName() +
				"\nPath: " + item.getPath() +
				"\nOwner: " + item.getUser()
		);
		
		assertThat(item).isNotNull();
	}
	
	@Test
	@DisplayName("FindItemAndSetOwner")
	public void testFindItemAndSetOwner() {
		
		User user = repo.findByEmail("chonsawat.nakanam@kkumail.com");
		Item item = itemRepo.findById((long) 4).get();
		
		repo.save(user);
		item.setUser(user);
		itemRepo.save(item);
		
		assertThat(item).isNotNull();
	}
	
}
