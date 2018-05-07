import java.awt.geom.Point2D;

public class Ball {
	private final double x;
	private final double y;
	private final int radius;
	private Table table;

	public Ball(double x, double y, int radius, Table table) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.table = table;
	}

	public double getAngleToPoint(Point2D p) {
		return getAngleToPoint(p.getX(), p.getY());
	}

	public double getAngleToPoint(double x, double y) {
		double abscissa = x - this.x;
		double ordinate = y - this.y;
		return Math.atan2(ordinate, abscissa);
	}

	public Point2D getStrikeBallCord(double angle, int strikeBallRadius) {
		int totRadius = strikeBallRadius + radius;
		
		double strikeX = totRadius * Math.cos(angle - Math.PI ) + getX();
		double strikeY = totRadius * Math.sin(angle - Math.PI) + getY();
		
		return new Point2D.Double(strikeX, strikeY);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Ball [x=" + x + ", y=" + y + ", radius=" + radius + "]";
	}

}
