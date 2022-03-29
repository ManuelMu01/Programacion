import java.util.LinkedList;

public class Rey extends Ficha {

	private static final long serialVersionUID = 6268941617942191637L;

	public Rey(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265A":"\u2654");

	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {

		LinkedList<Posicion> posibles=new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		int x=this.posicion.x, y=this.posicion.y;
		
		int posx[] = {x,  x+1,x+1,x+1,x  ,x-1,x-1,x-1};
		int posy[] = {y-1,y-1,y  ,y+1,y+1,y-1,y  ,y+1};
		
		for(int i=0;i<8;i++) {
		if ((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8) && (casillas[posx[i]][posy[i]]==null || casillas[posx[i]][posy[i]].color!=this.color)) posibles.add(new Posicion(posx[i],posy[i]));
		}
		//enrroque
		int xRey=0,yRey=0;
		//buscar rey
		for (int xx=0; xx<7 ;xx++) {
			for (int yy=0; yy<7 ; yy++) {
				if (casillas[xx][yy]!= null  && casillas[xx][yy].color == this.color) {
					if (casillas[xx][yy].forma  ==  ((casillas[xx][yy].color == 'B')? "\u265A":"\u2654")) {
						xRey=x; yRey=y;
					}
				}
			}
		}
		
		if ((xRey+1)<=7&&casillas[xRey+1][yRey]!= null && casillas[xRey+1][yRey].forma==((this.color == 'B')? "\u265C":"\u2656")) {
			posibles.add(new Posicion(xRey+1,yRey)); 
		}
		
		if ((xRey-1)>=0&& casillas[xRey-1][yRey]!= null && casillas[xRey-1][yRey].forma==((this.color == 'B')? "\u265C":"\u2656")) {
			posibles.add(new Posicion(xRey-1,yRey)); 
		}
		if ((xRey+2)<=7&&casillas[xRey+2][yRey]!= null && casillas[xRey+2][yRey].forma==((this.color == 'B')? "\u265C":"\u2656") && casillas[xRey+1][yRey]== null) {
			posibles.add(new Posicion(xRey+2,yRey)); 
		}
		
		if ((xRey-2)>=0&& casillas[xRey-2][yRey]!= null && casillas[xRey-2][yRey].forma==((this.color == 'B')? "\u265C":"\u2656") && casillas[xRey-1][yRey]== null) {
			posibles.add(new Posicion(xRey-2,yRey)); 
		}
		
		return posibles;
	}

}
