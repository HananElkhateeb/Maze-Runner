package Control;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import model.runner.Runner;
import model.runner.Weapon;

public class GameState extends State {
    private Player player;
    private World world;
    Runner playe = Runner.getInstance();
    Weapon weapon = Weapon.getInstance();
    public GameState(Handler handler){
    	super(handler);
    	world = new World(handler);
    	handler.setWorld(world);
    	player = new Player(handler,25,0);
    	
    	
    }
    
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		world.render(g);
		player.render(g);
		Font fnt0=new Font("arial",Font.BOLD,30);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SCORE :"+playe.getScores(), 15, 45);
		g.drawString("lives :"+playe.getLives(), 170, 25);
		g.drawString("bullets :"+weapon.getBullets(), 290, 25);
		g.drawString("life :"+playe.isLife(), 440, 25);
		g.drawString("number of gift1 :"+playe.getNumFirstTypeGift(), 580, 25);
		g.drawString("number of gift2 :"+playe.getNumSecondTypeGift(), 840, 25);
		
	}

}
