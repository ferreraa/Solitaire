package mvc.model;

public class Model {

	private Game game;
	
	public Model() {
		game = new Game();
	}
	
	@Override
	public String toString() {
		return game.toString();
	}
}
