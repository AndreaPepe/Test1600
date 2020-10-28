package view;

public interface IView {

	public String renderCombatField(String playerType, String enemyType);
	
	public String renderCombat(int playerLife, int enemyLife);
	
	public String renderCombatResult(String type, int atk);
	
	public String renderAtk(int atk);
	
	public String renderRemainingLife(String type, int lifePoints);
	
	public String renderFailureAtk(String type);
	
	public String renderFinalResult(String result);
}
