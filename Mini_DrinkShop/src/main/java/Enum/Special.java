package Enum;

import java.util.List;

import Drink.*;
import SpecialFolder.*;

public enum Special {
	Honey,
	Oreo,
	Cream,
	Strawberry;
	
	public static Drink addToDrink(Special special, Drink drink) {
		switch (special) {
		case Honey:
			return new Honey(drink);
		case Oreo:
			return new Oreo(drink);
		case Cream:
			return new Cream(drink);
		case Strawberry:
			return new Strawberry(drink);
		default:
			return drink;
		}
	}
	
	public static Drink getDrink(List<Special> addSpecial, Drink drink) {
		Drink temp = new Tea(Cup.Small); // new Tea() to handle initialize
		for ( int i=0; i<addSpecial.size(); i++ ) {
			if (i==0)
				temp = addToDrink(addSpecial.get(i), drink);
			else
				temp = addToDrink(addSpecial.get(i), temp);
		}
		return temp;
	}
}
