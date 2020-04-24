import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x, y, dm;
	private double dx, dy;
	
	public Ball(int x, int y, int dm) {
		this.x = x;
		this.y = y;
		this.dm = dm;
		this.dx = 10;
		this.dy = 10;
	}

	public void update() {
		x += dx;
		y += dy;
		if (y < 0 || y > Main.HEIGHT - dm) {
			flipDy();
		}
	}
	
	public void flipDx() {
		dx *= -1;
	}
	
	public void flipDy() {
		dy *= -1;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(x, y, dm, dm);
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

	public double getDx() {
		return dx;
	}

	public void incDx(double d) {
		this.dx += d;
	}

	public int getDm() {
		return dm;
	}

	public void setDm(int dm) {
		this.dm = dm;
	}

	public double getDy() {
		return dy;
	}

	public void incDy(double d) {
		this.dy += d;
	}


	
}