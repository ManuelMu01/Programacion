import java.util.LinkedList;

public class NuevaPieza extends Ficha  {
	
	public NuevaPieza(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "B":"N");
		
	}
	
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		LinkedList<Posicion> posibles=new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		
		int x = this.posicion.x;
		
		int y = this.posicion.y;
		
//		blancas
		if (this.color=='B' || this.color=='b') {


			if (casillas[x][y-2]==null) posibles.add(new Posicion(x,y-2)); 
			if (casillas[x][y-1]==null) posibles.add(new Posicion(x,y-1)); 
			if (casillas[x][y-3]==null) posibles.add(new Posicion(x,y-3)); 

			if (x<7 && x>0 && casillas[x+1][y-1]!=null &&  casillas[x+1][y-1].color!=this.color) posibles.add(new Posicion(x+1,y-1)); 
			if (x>0 && x<7 && casillas[x-1][y-1]!=null &&  casillas[x-1][y-1].color!=this.color) posibles.add(new Posicion(x-1,y-1)); 
			
		} else {	
//		Negras		

			if (casillas[x][y+1]==null) posibles.add(new Posicion(x,y+1)); 
			if (casillas[x][y+2]==null) posibles.add(new Posicion(x,y+2)); 
			if (casillas[x][y+3]==null) posibles.add(new Posicion(x,y+3)); 

			if (x<7 && x>0 && casillas[x-1][y+1]!=null && casillas[x-1][y+1].color!=this.color) posibles.add(new Posicion(x-1,y+1)); 
			if (x>0 && x<7 && casillas[x+1][y+1]!=null && casillas[x+1][y+1].color!=this.color) posibles.add(new Posicion(x+1,y+1)); 							
		}	
		
		return posibles;
	}

}
