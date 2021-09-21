package SpecialFolder;

import Drink.Drink;

public class Decorator implements Drink {
	Drink tmp;
	
	public Decorator(Drink drink) {
		tmp = drink;
	}
	
	@Override
	public String getDetail() {
		return tmp.getDetail();
	}

	@Override
	public double getCost() {
		return tmp.getCost();
	}

}
