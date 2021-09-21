package SpecialFolder;

import Drink.Drink;

public class Honey extends Decorator {

	public Honey(Drink drink) {
		super(drink);
	}
	
	@Override
	public String getDetail() {
		return tmp.getDetail() + " + Honey";
	}

	@Override
	public double getCost() {
		return tmp.getCost() + 5;
	}

}
