package model.gifts;

import java.util.ArrayList;

import model.Context1;
import model.GetRandom;
import model.iterator.RandomNumbers;
import model.runner.Runner;

public class GiftsFirstType extends Gifts{

	private int GIFT_NUMBER = 0;
	ArrayList<ArrayList<Character>> maze1=new ArrayList<ArrayList<Character>>();
	Runner player = Runner.getInstance();
	private static GiftsFirstType gift1;
	public GiftsFirstType(){}
    public static GiftsFirstType getInstance() {
                                if (gift1 == null)
                              {
                                       gift1 = new  GiftsFirstType();
                              }
                    return gift1;
        }

	@Override
	public void random(final ArrayList<ArrayList<Character>> maze1) {
		RandomNumbers gifts = new RandomNumbers(GIFT_NUMBER);
		this.maze1 = maze1;
		final Context1 context = new Context1(new GetRandom());
		context.executeStrategy(maze1, gifts, 'G');
//		final GetRandom gift = new GetRandom();
//		gift.random(maze1, gifts, 'G');
	}
	//first type >> increase player's lives
	@Override
	public void effect(){
		final int lives = player.getLives();
		long scores = player.getScores();
		scores = scores+500 ;//to be updated
		player.setLives(lives+1);
		player.setScores(scores);
	}

	@Override
	public void setGiftsNum (int GIFT_NUMBER) {
		this.GIFT_NUMBER = GIFT_NUMBER;
	}

	@Override
	public int getGiftsNum () {
		return GIFT_NUMBER;
	}

}
