import java.util.LinkedList;

public class Peon extends Ficha {

	private static final long serialVersionUID = 7100012578621812349L;

	public Peon(int x, int y, char c) {
		super(x, y, c,(c=='B' || c=='b')? "\u265F":"\u2659");
	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		
		LinkedList<Posicion> posibles = new LinkedList<Posicion>();
		
		
		
		
		return null;
	}

}
