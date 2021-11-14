package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class TreatmentRepositoryTests {
	
	@Autowired
	private TreatmentRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test 
	public void testCreateTreatment() {
		Treatment treat = new Treatment("รักษาประเภทตอง", 50000.0);
		repo.save(new Treatment("รักษาแบบปกติ", 50.0));
		
		Treatment savedTreatment = repo.save(treat);		
		Treatment existTreatment = entityManager.find(Treatment.class, savedTreatment.getTid());
		
		assertThat(existTreatment.getName()).isEqualTo(treat.getName());
	}
	
	@Test
	public void testFindTreatmentByName() {
		String name = "รักษาประเภทตอง";
		Treatment treat = repo.findByName(name);
		assertThat(treat).isNotNull();
	}
}
