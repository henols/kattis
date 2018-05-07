

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

	private static final String[] PLAYER_NAMES = { "Gunnar", "Emma" };

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);

		List<Player> players = Arrays.stream(PLAYER_NAMES).map(name -> {
			Player player = new Player(name);
			if (sc.hasNextLine()) {
				Scanner lsc = new Scanner(sc.nextLine());
				while (lsc.hasNextInt()) {
					int start = lsc.nextInt();
					int sides = lsc.nextInt();
					player.addDie(new Die(start, sides));
				}
				lsc.close();
			}
			return player;

		}).collect(toList());

		if (players.size() == 2) {
			Player p1 = players.get(0);
			Player p2 = players.get(1);
			if (p1.getMaxScore() == p2.getMaxScore()) {
				System.out.println("Tie");
			} else {
				System.out.println(p1.getMaxScore() > p2.getMaxScore() ? p1.getName() : p2.getName());
			}
		}

		sc.close();
	}
}
