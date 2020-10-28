package model;

import java.util.Random;

public class Combat implements ICombat {

	@Override
	public int attack(Warrior w) {
		int atk = w.getAtk();
		
		Random dice = new Random();				// A random dice 
		int magicNumber = dice.nextInt(100); 	// random number from 0 to 100
		
		atk += magicNumber;
		return atk;
		
	}

	@Override
	public int defense(Warrior w) {
		int def = w.getDef();
		
		Random dice = new Random();				// A random dice 
		int magicNumber = dice.nextInt(100); 	// random number from 0 to 100
		
		def += magicNumber;
		return def;
	}

	@Override
	public int speed(Warrior w) {
		int spd = w.getSpeed();
		
		Random dice = new Random();				// A random dice 
		int magicNumber = dice.nextInt(100); 	// random number from 0 to 100
		
		spd += magicNumber;
		return spd;
	}

	@Override
	public int agility(Warrior w) {
		int agility = w.getAgility();
		
		Random dice = new Random();				// A random dice 
		int magicNumber = dice.nextInt(100); 	// random number from 0 to 100
		
		agility += magicNumber;
		return agility;
	}
	
}
