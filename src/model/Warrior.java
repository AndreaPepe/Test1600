package model;

public class Warrior {
	private String type;
	private int lifePoints;
	private int speed;
	private int agility;
	private int atk;
	private int def;
	
	// constructor using fields
	public Warrior(String type, int lifePoints, int speed, int agility, int atk, int def) {
		super();
		this.type = type;
		this.lifePoints = lifePoints;
		this.speed = speed;
		this.agility = agility;
		this.atk = atk;
		this.def = def;
	}

	// getter & setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	
	// toString
	@Override
	public String toString() {
		return "Warrior [type=" + type + ", lifePoints=" + lifePoints + ", speed=" + speed + ", agility=" + agility
				+ ", atk=" + atk + ", def=" + def + "]";
	}
	
	
	
	
	
	
	
}
