package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Treatment")
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private double price;
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@OneToOne(mappedBy = "treatment")
	private History history;
	
	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public Treatment() {
		super();
	}

	public Treatment(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
