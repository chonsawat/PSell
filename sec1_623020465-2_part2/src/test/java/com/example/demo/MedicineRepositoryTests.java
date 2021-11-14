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
public class MedicineRepositoryTests {
	
	@Autowired
	private MedicineRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test 
	public void testCreateMedicine() {
		Medicine medicine = new Medicine("Astra", 2500.0);
		repo.save(new Medicine("Phizers", 1500.0));
		repo.save(new Medicine("Parezaltamol", 50.0));
		repo.save(new Medicine("Sinofarm", 60000));
		
		Medicine savedMedicine = repo.save(medicine);		
		Medicine existMedicine = entityManager.find(Medicine.class, savedMedicine.getMid());
		
		assertThat(existMedicine.getName()).isEqualTo(medicine.getName());
	}
	
	@Test
	public void testFindMedicineByName() {
		String name = "Astra";
		Medicine treat = repo.findByName(name);
		assertThat(treat).isNotNull();
	}
}
