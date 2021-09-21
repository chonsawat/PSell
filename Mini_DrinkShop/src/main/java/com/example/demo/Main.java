package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import Drink.*;
import Enum.*;

public class Main {
	
	public static void showDrink(Drink drink) {
		System.out.println(drink.getDetail() + ": " + drink.getCost());
	}
	
	public static void main(String[] args) {
		Drink drink = new Tea(Cup.Small);
		List<Special> addSpecial = new ArrayList<Special>();
		addSpecial.add(Special.Honey);
		addSpecial.add(Special.Cream);
		showDrink(Special.getDrink(addSpecial, drink));

		drink = new Coffee(Cup.Large);
		addSpecial = new ArrayList<Special>();
		addSpecial.add(Special.Oreo);
		addSpecial.add(Special.Cream);
		showDrink(Special.getDrink(addSpecial, drink));
		
		drink = new Coffee(Cup.Small);
		addSpecial = new ArrayList<Special>();
		addSpecial.add(Special.Oreo);
		addSpecial.add(Special.Cream);
		addSpecial.add(Special.Strawberry);
		showDrink(Special.getDrink(addSpecial, drink));
		
		drink = new Coffee(Cup.ExtraLarge);
		addSpecial = new ArrayList<Special>();
		addSpecial.add(Special.Oreo);
		addSpecial.add(Special.Oreo);
		addSpecial.add(Special.Strawberry);
		addSpecial.add(Special.Cream);
		addSpecial.add(Special.Honey);
		showDrink(Special.getDrink(addSpecial, drink));
	}
	
}
