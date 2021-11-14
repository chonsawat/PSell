package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hid;
	
	private String descrpition;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="username")
	private User username;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "treatment", 
				referencedColumnName = "tid")
	private Treatment treatment;
	
	@OneToMany(targetEntity=Medicine.class, 
			   mappedBy="history",
			   cascade=CascadeType.ALL, 
			   fetch = FetchType.LAZY)
	private List<Medicine> medicine;
	
	public History() {
		super();
	}
	

	public User getUsername() {
		return username;
	}


	public void setUsername(User username) {
		this.username = username;
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
