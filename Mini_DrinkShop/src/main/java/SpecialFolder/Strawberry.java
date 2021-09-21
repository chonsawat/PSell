package SpecialFolder;

import Drink.Drink;

public class Strawberry extends Decorator {
	
	public Strawberry(Drink drink) {
		super(drink);
	}
	
	@Override
	public String getDetail() {
		return tmp.getDetail() + " + Strawberry";
	}

	@Override
	public double getCost() {
		return tmp.getCost() + 10;
	}

}
