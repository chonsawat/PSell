package Drink;

import Enum.Cup;

public class Tea implements Drink {
	
	Cup cup;
	public Tea(Cup cup) {
		this.cup = cup;
	}

	@Override
	public String getDetail() {
		return "Tea" + cup.getDetail(cup);
	}

	@Override
	public double getCost() {
		return cup.getPrice(cup) + 20;
	}

}
