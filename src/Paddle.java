import java.awt.Color;
import java.awt.Graphics;

public class Paddle{
	protected int speed, x, y, height, width;

	public Paddle(int speed, int x, int y, int height, int width) {
		super();
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void update() {
		this.y+=speed;
		if (this.y > Main.HEIGHT-this.height) {
			this.y = Main.HEIGHT-1-this.height;
		}
		if (this.y < 0) {
			this.y = 1;
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
