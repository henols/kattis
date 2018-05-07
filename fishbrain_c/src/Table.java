
public class Table {
	private final int width;
	private final int lenth;

	public Table(int width, int lenth) {
		this.width = width;
		this.lenth = lenth;
	}

	@Override
	public String toString() {
		return "Table [width=" + width + ", lenth=" + lenth + "]";
	}

	public int getWidth() {
		return width;
	}

	public int getLenth() {
		return lenth;
	}

	public boolean inside(double x) {
		return x >= 0 && x <= width;
	}
}
