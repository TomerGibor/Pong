
public class Player extends Paddle{
	private String name;
	private int score;
	
	public Player(int speed, int x, int y, int height, int width, String name) {
		super(speed, x, y, height, width);
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void incScore() {
		this.score++;
	}
	
	@Override
	public String toString() {
		return (name + ": " + score);
	}

}
