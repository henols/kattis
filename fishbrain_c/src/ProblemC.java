
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) throws FileNotFoundException {

		final Scanner sc;
		if (args.length == 1) {
			File file = new File(args[0]);
			sc = new Scanner(file);
		} else {
			sc = new Scanner(System.in);
		}

		Table table = new Table(sc.nextInt(), sc.nextInt());
		int radius = sc.nextInt();
		Ball ball1 = new Ball(sc.nextInt(), sc.nextInt(), radius, table);
		Ball ball2 = new Ball(sc.nextInt(), sc.nextInt(), radius, table);
		Ball ball3 = new Ball(sc.nextInt(), sc.nextInt(), radius, table);
		int h = sc.nextInt();

		double ball2AngleToHole = ball2.getAngleToPoint(0, table.getLenth());
		Point2D ball2StrikeCord = ball2.getStrikeBallCord(ball2AngleToHole, radius);

		double ball3AngleToHole = ball3.getAngleToPoint(table.getWidth(), table.getLenth());
		Point2D ball3StrikeCord = ball3.getStrikeBallCord(ball3AngleToHole, ball1.getRadius());

		double ball1AngleToBall3 = ball1.getAngleToPoint(ball3StrikeCord);
		Point2D ball1StrikeCord = ball1.getStrikeBallCord(ball1AngleToBall3, ball1.getRadius());

		Ball cueBallStrike = new Ball(ball1StrikeCord.getX(), ball1StrikeCord.getY(), radius, table);
		double cueBallAngleToBall2 = cueBallStrike.getAngleToPoint(ball2StrikeCord);

		double cueAngle = ball1AngleToBall3 - (cueBallAngleToBall2 - ball1AngleToBall3);

		double relH = h - cueBallStrike.getY();
		double distance = relH/ Math.tan(cueAngle) + cueBallStrike.getX();


		if (table.inside(distance)) {
			System.out.println(round(distance) + " " + toDegrees(cueAngle + Math.PI));
		} else {
			System.out.println("impossible");
		}
		sc.close();
	}

	private static String toDegrees(double cueAngle) {
		return round((Math.toDegrees(cueAngle) + 360.0) % 360.0);
	}

	private static String round(double value) {
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).toString();
	}
}
