import java.util.LinkedList;

public class Rey extends Ficha {

	private static final long serialVersionUID = 6268941617942191637L;

	public Rey(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265A":"\u2654");

	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {

		return null;
	}

}
