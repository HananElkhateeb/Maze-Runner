package model;

import model.bombs.BombsFirstType;
import model.bombs.BombsSecondType;
import model.gifts.GiftsFirstType;
import model.gifts.GiftsSecondType;
import model.runner.Runner;

public class Factory {
	Runner player = Runner.getInstance();
	BombsFirstType bomb1 = BombsFirstType.getInstance();
	BombsSecondType bomb2 = BombsSecondType.getInstance();
	int numRemainedBomb1 = bomb1.getBOMB_NUMBER();
	int numRemainedBomb2 = bomb2.getBOMB_NUMBER();

   Object getBomb (final char c) {
		if(c == 'B'){
			numRemainedBomb1--;
			return new BombsFirstType();
		}else{
			numRemainedBomb2--;
			return new BombsSecondType();
		}

}

	Object getGift(final char c) {
		if(c == 'G'){
			player.setNumFirstTypeGift(player.getNumFirstTypeGift()+1);
			return new GiftsFirstType();
		} else{
			player.setNumSecondTypeGift(player.getNumSecondTypeGift()+1);
			return new GiftsSecondType();
		}
}

}
