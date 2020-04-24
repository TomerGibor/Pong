import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Applet implements KeyListener{
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 800, WIDTH = 1200;
	private Player p1, p2;
	private Ball b;
	private Thread gameLoop;
	
	@Override
	public void init() {
		super.init();
		this.setSize(WIDTH, HEIGHT);
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.addKeyListener(this);
		gameLoop = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					update();
					repaint();
				}
			}
		});
	}
	
	@Override
	public void start() {
		super.start();
		p1 = new Player(0, WIDTH -30, HEIGHT/2 - 60, 120, 20, "Tomer");
		p2 = new Player(0, 10, HEIGHT/2 - 60, 120, 20, "Omri");
		b = new Ball(WIDTH/2 - 15, HEIGHT/2 - 15, 30);
		gameLoop.start();
	}
	
	
	public void newGame() {
		p1.setX(WIDTH - 30);
		p1.setY(HEIGHT/2 - 60);
		p2.setX(10);
		p2.setY(HEIGHT/2 - 60);
		b.setX(WIDTH/2 - 15);
		b.setY(HEIGHT/2 - 15);
	}
	
	public void collision() {
		if (b.getX() + b.getDm() >= p1.getX() && b.getX() + b.getDm() <= p1.getX() + p1.getWidth() && 
				b.getY() <= p1.getY() + p1.getHeight() && b.getY() +b.getDm() >= p1.getY()) {
			b.flipDx();
		}
		
		if (b.getX() <= p2.getX() + p2.getWidth() && b.getX() >= p2.getX() && 
				b.getY() <= p2.getY() + p2.getHeight() && b.getY() +b.getDm() >= p2.getY()) {
			b.flipDx();
		}
	}
	
	public void isEdgeX() {
		if (b.getX() < 0) {
			p1.incScore();
			newGame();
		}
		else if (b.getX() + b.getDm() > WIDTH) {
			p2.incScore();
			newGame();
		}
	}
	
	public void update() {
		p1.update();
		p2.update();
		b.update();
		collision();
		isEdgeX();
		b.incDx(0.005);
		b.incDy(0.005); 
	}
	
	public void paintFeild(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(WIDTH/2 - 125, HEIGHT/2 - 125, 250, 250);
		g.setColor(Color.BLACK);
		g.fillOval(WIDTH/2 - 121, HEIGHT/2 - 121, 242, 242);
		g.setColor(Color.WHITE);
		g.fillRect(WIDTH/2 - 3, 0, 6, HEIGHT);
	}
	
	public void paintScore(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Player 2: " + p2.getScore(), 40, 25);
		g.drawString("Player 1: " + p1.getScore(), WIDTH - 120, 25);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintFeild(g);
		p1.paint(g);
		p2.paint(g);
		b.draw(g);
		paintScore(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setSpeed(-10);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setSpeed(10);
		}		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			p2.setSpeed(-10);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			p2.setSpeed(10);
		}
	
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setSpeed(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setSpeed(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			p2.setSpeed(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			p2.setSpeed(0);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
