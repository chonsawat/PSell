package SpecialFolder;

import Drink.Drink;

public class Oreo extends Decorator {

	public Oreo(Drink drink) {
		super(drink);
	}
	
	@Override
	public String getDetail() {
		return tmp.getDetail() + " + Oreo";
	}

	@Override
	public double getCost() {
		return tmp.getCost() + 2.5;
	}

}
