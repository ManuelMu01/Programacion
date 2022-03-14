package a11Ajedrezv2;

import java.util.LinkedList;

public class Peon extends Ficha{

	public Peon(int x, int y, char color) {
		super(x, y, color, (color=='B' || color=='b')? "\u265F":"\u2659");
	}

	@Override
	public LinkedList<Posicion> PosiblesMovimientos(Tablero tab) {
		LinkedList<Posicion> posibles = new LinkedList<Posicion>();
		
		
		return null;
	}
	

}
