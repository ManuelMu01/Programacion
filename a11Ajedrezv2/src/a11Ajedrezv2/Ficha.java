package a11Ajedrezv2;

import java.util.LinkedList;

public abstract class Ficha {

	Posicion posicion;
	
	char color;
	
	String forma;
	
	public Ficha(int x, int y, char color, String forma) {
		
		this.color = color;
		
		this.forma = forma;
		
		this.posicion = new Posicion(x,y);
		
	}
	
	public  abstract LinkedList<Posicion> PosiblesMovimientos(Tablero tab);
}
