
public class Cuadrado extends PoligonoRegular {

	public Cuadrado(double l) {
		super (4,l);
		
	}

	public double getArea() {
		return this.longitud*this.longitud;
	}
}
