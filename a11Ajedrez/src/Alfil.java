import java.util.LinkedList;

public class Alfil extends Ficha {

	private static final long serialVersionUID = 1639103150087105286L;

	public Alfil(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265D":"\u2657");

	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		
		return null;
	}

}
