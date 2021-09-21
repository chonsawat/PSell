package Drink;

import Enum.Cup;

public class Coffee implements Drink {

	Cup cup;
	public Coffee(Cup cup) {
		this.cup = cup;
	}
	
	@Override
	public String getDetail() {
		return "Coffee" + cup.getDetail(cup);
	}

	@Override
	public double getCost() {
		return cup.getPrice(cup) + 30;
	}

}
