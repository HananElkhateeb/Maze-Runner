package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Control.Handler;
import Control.ImageLoader;
import Control.Splash;
import model.bombs.BombsFirstType;
import model.bombs.BombsSecondType;
import model.gifts.Gifts;
import model.gifts.GiftsFirstType;
import model.gifts.GiftsSecondType;
import model.runner.Runner;
import model.runner.Weapon;

public class Play implements Strategy {
	Runner player = Runner.getInstance();
	Weapon w = Weapon.getInstance();
	Gifts gift1 = GiftsFirstType.getInstance();
	Gifts gift2 = GiftsSecondType.getInstance();

	ArrayList<ArrayList<Character>> maze1 = new ArrayList<ArrayList<Character>>();
	private int x;
	private int y;
	private Character currentCell;

	Factory factory = new Factory();

	public Play(final ArrayList<ArrayList<Character>> maze1) {
		this.maze1 = maze1;
	}

	@Override
	public void start() {
		x = 1;
		y = 1;
		player.setPosition(new Point(x, y));
		currentCell = maze1.get(x).get(y);
		maze1.get(x).set(y, 'R');
	}

	public void move(Handler handler, int a, int b) {
		if(!player.isLife()){
			handler.getGame().stop();	
		}
		else if (a == maze1.size() - 1 && b == maze1.size() - 2) {
			handler.getGame().stop();
			
		} else {
			Point point = player.getPosition();
			x = point.x;
			y = point.y;
			char c = maze1.get(a).get(b);
			if (c != ('+') && c != ('T')) {
				maze1.get(x).set(y, currentCell);
				x = a;
				y = b;
				player.setPosition(new Point(x, y));
				currentCell = maze1.get(x).get(y);
				this.Action(currentCell);
				currentCell = ' ';
				maze1.get(x).set(y, 'R');
			}
		}
	}

	@Override
	public void useWeapon(final char dir) {
		int bullets = w.getBullets();
		if (bullets > 0) {
			bullets = bullets - 1;
			w.setBullets(bullets);
			if (dir == 'R') {
				for (int i = 1; i <= 4; i++) {
					if (y + i < maze1.get(0).size()) {
						if (weaponAction(x, y + i)) {
							break;
						}
					} else {
						break;
					}
				}
			} else if (dir == 'L') {
				for (int i = 1; i <= 4; i++) {
					if (y - i > 0) {
						if (weaponAction(x, y - i)) {
							break;
						}
					} else {
						break;
					}
				}
			} else if (dir == 'U') {
				for (int i = 1; i <= 4; i++) {
					if (x - i > 0) {
						if (weaponAction(x - i, y)) {
							break;
						}
					} else {
						break;
					}
				}
			} else if (dir == 'D') {
				for (int i = 1; i <= 4; i++) {
					if (x + i < maze1.size()) {
						if (weaponAction(x + i, y)) {
							break;
						}
					} else {
						break;
					}
				}
			}
		}
	}

	public boolean weaponAction(int x, int y) {
		final char c = maze1.get(x).get(y);
		if (c == 'T') {
			maze1.get(x).set(y, ' ');
			return true;
		} else if (c == 'G' || c == 'J') {
			maze1.get(x).set(y, ' ');
			return true;
		} else if (c == 'B') {
			factory.getBomb(currentCell);
			maze1.get(x).set(y, ' ');
			return true;
		} else if (c == 'H') {
			factory.getBomb(currentCell);
			maze1.get(x).set(y, ' ');
			return true;
		} else if (c == '+') {
			return true;
		}
		return false;
	}

	private void Action(final Character c) {
		if (currentCell == 'G') {
			final GiftsFirstType g = (GiftsFirstType) factory.getGift(currentCell);
			g.effect();
		} else if (currentCell == 'J') {
			final GiftsSecondType g = (GiftsSecondType) factory.getGift(currentCell);
			g.effect();

		} else if (currentCell == 'B') {
			final BombsFirstType b = (BombsFirstType) factory.getBomb(currentCell);
			b.effect();

		} else if (currentCell == 'H') {
			final BombsSecondType b = (BombsSecondType) factory.getBomb(currentCell);
			b.effect();
		}
	}

	public void win() {

	}

}
