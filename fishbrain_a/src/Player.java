

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	List<Die> dice = new ArrayList<>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addDie(Die die) {
		dice.add(die);
	}

	public int getMaxScore() {
		return dice.stream().mapToInt(die -> die.getMaxScore()).sum();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", dice=" + dice + "]";
	}
}
