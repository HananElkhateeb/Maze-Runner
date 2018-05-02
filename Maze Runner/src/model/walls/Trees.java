package model.walls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.GetRandom;
import model.iterator.RandomNumbers;

public class Trees extends Walls{
	@SuppressWarnings("unused")
	private int TREE_NUMBER = 0;
	private static Map<String, Double> prop;
	ArrayList<ArrayList<Character>> maze1 = new ArrayList<ArrayList<Character>>();
	private static Trees tree;
    private Trees (){
    prop = new HashMap<>();
	prop.put("size", 0.0);
    }

    public static Trees getInstance() {
        if (tree == null)
      {
               tree = new Trees();
      }
        return tree;
    }


    @Override
	public void random(ArrayList<ArrayList<Character>> maze1) {
    	RandomNumbers trees = new RandomNumbers(TREE_NUMBER);
		this.maze1 = maze1;
		GetRandom bomb = new GetRandom();
		bomb.random(maze1, trees, 'T');
	}

	@Override
	public boolean damage () {
		return true;
	}

	@Override
	public void setTreesNum (int TREE_NUMBER) {
		this.TREE_NUMBER = TREE_NUMBER;
	}
}
