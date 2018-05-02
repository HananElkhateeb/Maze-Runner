package Control;
public class GateTile extends Tile {
	public GateTile( int id) {
		super(Assets.gift1, id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isSolid(){
		return true;
	}
}
