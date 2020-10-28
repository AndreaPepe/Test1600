package controller;

import java.util.Random;
import java.util.Scanner;

import model.Combat;
import model.ICombat;
import model.Warrior;
import view.IView;
import view.View;

public class Game {

	public static void main(String[] args) throws InterruptedException {

		Warrior orc = new Warrior("Orc", 350, 30, 20, 50, 40);
		Warrior human = new Warrior("Human", 300, 40, 40, 40, 30);
		Warrior elf = new Warrior("Elf", 250, 50, 50, 20, 30);
		Warrior dwarf = new Warrior("Dwarf", 300, 40, 30, 50, 50);
		Warrior vampire = new Warrior("Vampire", 300, 40, 50, 40, 30);
		Warrior wizard = new Warrior("Wizard", 200, 60, 40, 60, 30);

		ICombat combat = new Combat();
		IView view = new View("C:\\Users\\Andrea Pepe\\Desktop\\eclipse-workspace\\CombatGame\\src\\view\\Templates\\");


		String cmd = ""; // input command from the player
		String res = ""; // response from the system
		try (Scanner stdInput = new Scanner(System.in)) {
			do {
				System.out.println("Please, insert a command ('help' for more details): ");
				cmd = stdInput.nextLine();

				// Switch to handle the various cases
				switch (cmd) {

				case "fighting":
					res = "Fighting is starting";
					break;

				case "help":
					res = "Insert 'fighting' to start the game or 'exit' to exit from the game";
					break;

				case "exit":
					res = "You are now exiting. Bye, see you soon ;)";
					break;

				default:
					res = "Wrong command inserted, retry. Insert 'help' if you don't know the available commands";
					break;
				}

				System.out.println(res);

				// HANDLE FIGHTING
				if (cmd.equalsIgnoreCase("fighting")) {
					System.out.println();
					System.out.println("Select your character ('orc','human', 'elf', 'dwarf', 'vampire', 'wizard') : ");

					Warrior player=null;
					Warrior enemy=null;

					String type = stdInput.nextLine();

					switch (type) {

					case "orc":
						player = orc;
						break;

					case "human":
						player = human;
						break;

					case "elf":
						player = elf;
						break;

					case "dwarf":
						player = dwarf;
						break;

					case "vampire":
						player = vampire;
						break;

					case "wizard":
						player = wizard;
						break;

					case "help":
						System.out.println(
								"Select one of these characters: 'orc','human', 'elf', 'dwarf', 'vampire', 'wizard'");
						break;

					default:
						System.out.println(
								"Wrong name inserted, retry. Insert 'help' if you don't know the available characters");
						break;
					}
					
					Random dice = new Random();
					int enemyNumber = dice.nextInt(6);
					
					switch(enemyNumber) {
					
					case 1:
						enemy = orc;
						break;
						
					case 2:
						enemy = human;
						break;
						
					case 3:
						enemy = elf;
						break;
						
					case 4:
						enemy = dwarf;
						break;
						
					case 5:
						enemy = vampire;
						break;
						
					case 6:
						enemy = wizard;
						break;
						
					default:
						enemy = human;
						break;
					}
					
					
					// RENDERING COMBAT FIELD
					System.out.println(view.renderCombatField(player.getType(), enemy.getType()));
					
					// FIGHT HANDLING
					int playerLife = player.getLifePoints();
					int enemyLife = enemy.getLifePoints();
					
					while(playerLife > 0 && enemyLife > 0) {
						
						System.out.println(view.renderCombat(playerLife, enemyLife));
						
						if(combat.speed(player) > combat.speed(enemy)) {		// CASE 1: player is faster than enemy
							int attack = combat.attack(player) - combat.defense(enemy);
							//System.out.println(view.renderAtk(attack));
							
							if(attack > 0) {
								enemyLife -= attack;
								System.out.println(view.renderCombatResult(player.getType(), attack));
								System.out.println(view.renderRemainingLife(enemy.getType(), enemyLife));
								
							}else {
								System.out.println(view.renderFailureAtk(player.getType()));
							}
						}
						else if(combat.speed(player) < combat.speed(enemy)){	// CASE 2: enemy is faster than player
							int attack = combat.attack(enemy) - combat.defense(player);
							//System.out.println(view.renderAtk(attack));
							
							if(attack > 0) {
								playerLife -= attack;
								System.out.println(view.renderCombatResult(enemy.getType(), attack));
								System.out.println(view.renderRemainingLife(player.getType(), playerLife));
								
							}else {
								System.out.println(view.renderFailureAtk(enemy.getType()));
							}
						}
						else {													// CASE 3: equal speed --> attack failure
							System.out.println("Failure attack due to equal speed");
						}
						
						Thread.sleep(3000); 
					}
					
					if(playerLife > 0) {
						System.out.println(view.renderFinalResult("YOU WIN!"));
					}else {
						System.out.println(view.renderFinalResult("YOU LOSE!"));
					}
				}
			} while (!cmd.equalsIgnoreCase("exit"));
		}

	}

}
