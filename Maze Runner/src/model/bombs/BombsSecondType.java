package model.bombs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Context1;
import model.GetRandom;
import model.iterator.RandomNumbers;
import model.runner.Runner;

public class BombsSecondType extends Bombs{

	private int BOMB_NUMBER = 0;
	private static Map<String, Double> prop;
	ArrayList<ArrayList<Character>> maze1 = new ArrayList<ArrayList<Character>>();
    Runner player = Runner.getInstance();

    private static BombsSecondType bomb2;
	public BombsSecondType(){
		prop = new HashMap<>();
		prop.put("radius", 0.0);
	}
    public static BombsSecondType getInstance() {
                                if (bomb2 == null)
                              {
                                       bomb2 = new BombsSecondType();
                              }
                    return bomb2;
        }

    @Override
	public void random(final ArrayList<ArrayList<Character>> maze1) {
    	RandomNumbers bombs = new RandomNumbers(BOMB_NUMBER);
		this.maze1 = maze1;
		final Context1 context = new Context1(new GetRandom());
		context.executeStrategy(maze1, bombs, 'H');
//		final GetRandom bomb = new GetRandom();
//		bomb.random(maze1, bombs, 'H');
	}
//damage>> decrease in score
	@Override
	public void effect() {
	  long scores = player.getScores();
	  scores = scores-300; //to be updated ..
	  player.setScores(scores);
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
