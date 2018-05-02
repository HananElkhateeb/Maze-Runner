package model.gifts;

import java.util.ArrayList;

import model.Context1;
import model.GetRandom;
import model.iterator.RandomNumbers;
import model.runner.Runner;
import model.runner.Weapon;

public class GiftsSecondType extends Gifts{

	private int GIFT_NUMBER = 0;
	ArrayList<ArrayList<Character>> maze1=new ArrayList<ArrayList<Character>>();
	Weapon weapon = Weapon.getInstance();
	Runner player = Runner.getInstance();
	private static GiftsSecondType gift2;
	public GiftsSecondType(){}
    public static GiftsSecondType getInstance() {
                                if (gift2 == null)
                              {
                                       gift2 = new  GiftsSecondType();
                              }
                    return gift2;
        }

	@Override
	public void random(final ArrayList<ArrayList<Character>> maze1) {
		RandomNumbers gifts = new RandomNumbers(GIFT_NUMBER);
		this.maze1 = maze1;
		final Context1 context = new Context1(new GetRandom());
		context.executeStrategy(maze1, gifts, 'J');
//		final GetRandom gift = new GetRandom();
//		gift.random(maze1, gifts, 'J');
	}
	//first type >> increase weapon's bullets
	@Override
	public void effect(){
		final int bullets = weapon.getBullets();
		long scores = player.getScores();
		scores = scores+500;//to be updated
		weapon.setBullets(bullets+1);
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
