package model.bombs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Context1;
import model.GetRandom;
import model.iterator.RandomNumbers;
import model.runner.Runner;

public class BombsFirstType extends Bombs {


	private int BOMB_NUMBER = 0;
	private static Map<String, Double> prop;
	ArrayList<ArrayList<Character>> maze1 = new ArrayList<ArrayList<Character>>();
    Runner player = Runner.getInstance();
    private static BombsFirstType bomb1;
	public BombsFirstType(){
		prop = new HashMap<>();
		prop.put("radius", 0.0);
	}
    public static BombsFirstType getInstance() {
                                if (bomb1 == null)
                              {
                                       bomb1 = new BombsFirstType();
                              }
                    return bomb1;
        }

    @Override
	public void random(final ArrayList<ArrayList<Character>> maze1) {
    	RandomNumbers bombs = new RandomNumbers(BOMB_NUMBER);
		this.maze1 = maze1;
		final Context1 context = new Context1(new GetRandom());
		context.executeStrategy(maze1, bombs, 'B');
//		final GetRandom bomb = new GetRandom();
//		bomb.random(maze1, bombs, 'B');
	}
//damage>> decrease in health
	@Override
	public void effect() {
	  int lives= player.getLives();
	  if(lives>0){
		  lives--;
		  player.setLives(lives);
	  }
	}

	@Override
	public void setBombsNum (int BOMB_NUMBER) {
		this.BOMB_NUMBER = BOMB_NUMBER;
	}

	@Override
	public int getBOMB_NUMBER() {
		return BOMB_NUMBER;
	}

}
