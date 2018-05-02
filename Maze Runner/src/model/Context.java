package model;

import java.awt.Point;

import Control.Handler;
import model.runner.Runner;

public class Context {
	private final Strategy strategy;

	public Context(final Strategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(final Character dir){
		strategy.useWeapon(dir);
	}
//	public Point executeStrategy1(){
//		return strategy.right();
//	}
//	public Point executeStrategy2(){
//		return strategy.left();
//	}
//	public Point executeStrategy3(){
//		return strategy.down();
//	}
//	public Point executeStrategy4(){
//		return strategy.up();
//	}
	public void executeStrategy4(Handler handler, int x, int y){
		 strategy.move(handler, x, y);
	}
	public void executeStrategyStart(){
	 strategy.start();
	}
}

