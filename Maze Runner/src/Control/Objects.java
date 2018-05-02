package Control;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Objects {

	public static Objects[] objects = new Objects[265];
	public static Objects Gift = new Gift(0);
	public static Objects Bomb = new Bomb(1);
	public static Objects gate = new Gate(2);
	public static Objects tree = new Tree(3);
	public static Objects secondGift = new SecondGift(4);
	public static Objects secondBomb = new SecondBomb(5);
	public static final int TILE_WIDTH = 42;
	public static final int TILE_LENGTH = 42;
	protected BufferedImage texture;
	protected final int id;

	public Objects(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		objects[id] = this;
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_LENGTH, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getID() {
		return id;
	}

}