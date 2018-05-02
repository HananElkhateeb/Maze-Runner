package Control;
import java.awt.Graphics;

public class MenuState extends State {
	private Assets assets;
	public MenuState(Handler handler) {
		super(handler);

	}

	public void tick() {
		// TODO Auto-generated method stub

	}

	public void render(Graphics g) {
//		Font fnt0=new Font("arial",Font.BOLD,50);
//		g.setFont(fnt0);
//		g.setColor(Color.white);
//		g.drawString("Maze Runner", 300, 100);
        g.drawImage(assets.btns[0], 100, 100, 500,500,null);
        g.drawImage(assets.btns[1], 600, 100, 500,500,null);
        g.drawImage(assets.btns[2], 1100, 100, 500,500,null);
	}

}
