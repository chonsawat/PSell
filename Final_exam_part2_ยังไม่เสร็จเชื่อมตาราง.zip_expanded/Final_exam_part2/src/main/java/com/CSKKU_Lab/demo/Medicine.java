package com.CSKKU_Lab.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private double price;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="hid")
	private History history;
	
	public Medicine() {
		super();
	}

	public Medicine(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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