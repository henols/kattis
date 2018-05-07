
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {
	public static void main(String[] args) throws FileNotFoundException {

		final Scanner sc;
		if (args.length == 1) {
			File file = new File(args[0]);
			sc = new Scanner(file);
		} else {
			sc = new Scanner(System.in);
		}
		while (sc.hasNextInt()) {
			int rows = sc.nextInt();
			if (rows > 0) {
				sc.nextLine();
				List<FileRep> files = IntStream.range(0, rows).mapToObj(i -> new FileRep(sc.nextLine()))
						.collect(toList());
				long uniqueFiles = files.stream().sequential().distinct().count();

				long hashCollisions = files.stream().mapToLong(file -> files.stream().skip(files.indexOf(file))
						.mapToInt(f -> (!file.equals(f) && file.getHash() == f.getHash()) ? 1 : 0).sum()).sum();

				System.out.println(uniqueFiles + " " + hashCollisions);
			}
		}
		sc.close();
	}
}
