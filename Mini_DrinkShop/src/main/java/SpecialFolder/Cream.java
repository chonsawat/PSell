package SpecialFolder;

import Drink.Drink;

public class Cream extends Decorator {
	
	public Cream(Drink drink) {
		super(drink);
	}
	
	@Override
	public String getDetail() {
		return tmp.getDetail() + " + Cream";
	}

	@Override
	public double getCost() {
		return tmp.getCost() + 3;
	}

}
