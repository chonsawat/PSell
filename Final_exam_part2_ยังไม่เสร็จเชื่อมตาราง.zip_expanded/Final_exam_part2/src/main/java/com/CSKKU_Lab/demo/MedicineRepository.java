package com.CSKKU_Lab.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	Medicine findByName(String name);
}