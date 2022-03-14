import java.util.LinkedList;

public class Torre extends Ficha {


	private static final long serialVersionUID = 7531607304083539085L;

	public Torre(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265C":"\u2656");
	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {

		return null;
	}

}
