package view;

import java.io.File;
import java.util.Scanner;

public class View implements IView {

	
	private String templatePath;
	
	
	public View(String templatePath) {
		super();
		this.templatePath = templatePath;
	}

	// method loading template from a file
	public String loadTemplate(String file) {
		String res = "";
		try {
			Scanner data = new Scanner(new File(templatePath + file));
			
			while(data.hasNextLine()) {
				res += data.nextLine() + "\n";
			}
		} catch(Exception e){
			
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	// Implements IView interface
	@Override
	public String renderCombatField(String playerType, String enemyType) {
		return loadTemplate("CombatField.txt").replace("[PlayerType]", playerType).replace("[EnemyType]", enemyType);
	}

	@Override
	public String renderCombat(int playerLife, int enemyLife) {
		return loadTemplate("Combat.txt").replace("[PlayerLife]", playerLife+"").replace("[EnemyLife]",enemyLife+"");
	}

	@Override
	public String renderCombatResult(String type, int atk) {
		return loadTemplate("CombatResult.txt").replace("Type", type).replace("[ATK]", atk+"");
	}

	@Override
	public String renderAtk(int atk) {
		return loadTemplate("Atk.txt").replace("[ATK]", atk+"");
	}
	@Override
	public String renderRemainingLife(String type, int lifePoints) {
		return loadTemplate("RemainingLife.txt").replace("Type", type).replace("[Life]", lifePoints+"");
	}

	@Override
	public String renderFailureAtk(String type) {
		return loadTemplate("FailureAtk.txt").replace("[Type]", type);
	}

	@Override
	public String renderFinalResult(String result) {
		return loadTemplate("FinalResult.txt").replace("[Result]", result);
	}
	
}
