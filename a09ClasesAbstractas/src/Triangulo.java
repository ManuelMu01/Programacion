//     te obliga a meter el metodo abstract
public class Triangulo extends PoligonoRegular{
	
	public Triangulo(double l) {
		super(3,l);
		
	}
	
	public double getArea() {
//		altura
		double altura = Math.sqrt(Math.pow(longitud,2) - Math.pow(longitud/2, 2));
		
//		area
		double Area = longitud*altura/2;
		
		return Area;
	}
}
