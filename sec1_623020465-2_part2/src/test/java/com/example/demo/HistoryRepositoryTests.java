package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class HistoryRepositoryTests {
	
	@Autowired
	private UserRepository repo_user;
	@Autowired
	private MedicineRepository repo_medicine;
	@Autowired
	private TreatmentRepository repo_treatment;
	@Autowired
	private HistoryRepository repo_history;

	
	@Test
	@Transactional(propagation=Propagation.NEVER)
	public void testCreateData() {
		
		repo_user.save(new User("0998763754", "chonsawat", "ชนม์สวัสดิ์", "นาคนาม"));
		repo_user.save(new User("0973566421", "chonsawat", "Chonsawat", "Nakanam"));
		
		repo_treatment.save(new Treatment("รักษาแบบปกติ", 50.0));
		repo_treatment.save(new Treatment("รักษาประเภทตอง", 50000.0));
		
		repo_medicine.save(new Medicine("Astra", 2500.0));
//		repo_medicine.save(new Medicine("Phizers", 1500.0));
//		repo_medicine.save(new Medicine("Parezaltamol", 50.0));
//		repo_medicine.save(new Medicine("Sinofarm", 60000));
		
		
//		User user = repo_user.findByUsername("0973566421");
//		Treatment treat = repo_treatment.findByName("รักษาประเภทตอง");
//		List<Medicine> medicine = new ArrayList<Medicine>();
//		medicine.add(repo_medicine.findByName("Astra"));
//		medicine.add(repo_medicine.findByName("Phizers"));
//		
//		repo_history.save( new History("ครั้งแรกก็เจ็บดีนะ", user, treat, medicine) );
	}
	
//	@Test
//	public void testFindHistoryByUser() {
//		String user = "0973566421";
//		List<History> history = repo_history.findManyByUser(repo_user.findByUsername(user));
//		history = repo_history.findAll();
//		assertThat(history).isNotNull();
//	}
}
