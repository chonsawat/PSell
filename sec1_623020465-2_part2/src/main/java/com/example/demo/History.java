package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="History")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hid;
	
	private String descrpition;
	
//	@ManyToOne
//	@JoinColumn(name="uid")
	private User username;
	
//	@OneToOne(mappedBy="tid")
	private Treatment treatment;
	
//	@OneToMany(mappedBy="history")
//	@JoinColumn(name="mid")
	private List<Medicine> medicine;
	
	public History() {
		super();
	}
	

	public History(String descrpition, User user, Treatment treatment, List<Medicine> medicine) {
		super();
		this.descrpition = descrpition;
		this.username = user;
		this.treatment = treatment;
		this.medicine = medicine;
	}


	public User getUser() {
		return username;
	}


	public void setUser(User user) {
		this.username = user;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getDescrpition() {
		return descrpition;
	}

	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}



	public List<Medicine> getMedicine() {
		return medicine;
	}



	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}




}
