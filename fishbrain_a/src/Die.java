

public class Die {
	private int start;
	private int sides;

	public Die(int start,int sides) {
		this.start = start;
		this.sides = sides;
	}

	@Override
	public String toString() {
		return "Die [start=" + start + ", sides=" + sides + "]";
	}	

	public int getMaxScore(){
		return start + sides;
	}
}
