package model;

import java.awt.Point;

import Control.Handler;
import model.runner.Runner;

public interface Strategy {
//	Point left();
//	 Point up();
//	 Point down();
//	 Point right();
	void move(Handler handler, int x, int y);
	 void start();
	 void useWeapon(final char dir);

}
