package a10interfaces;
	//			   no tengo que a�adir nada m�s solo implements golpeable y a�adir metodos
public class Arbol implements Golpeable {
	public Posicion pos;
	public int vida;
	
	public Arbol(Posicion p) {
		this.pos=p;
		this.vida=10;
	}

	@Override
	public void encajar(Golpeador g) {
		this.vida-=g.getPotencia();
	}
}
