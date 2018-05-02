package Control;
public class Tree extends Objects {
	public Tree(int id) {
		super(Assets.tree, id);
	}
	public boolean isSolid() {
		return true;
	}
}
