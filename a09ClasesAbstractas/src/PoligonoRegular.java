//     hay que poner asi el public cuando usemos clases abstractas
public abstract class PoligonoRegular {
	
	public int lados;
	
	public double longitud;
	
	public PoligonoRegular(int lados, double longitud) {
		
		this.lados = lados;
		
		this.longitud = longitud;
	}
	
	public double getPerimetro() {
		return this.lados*this.longitud;
	}
	
	//metodos abstractos van con public abstract
	public abstract double getArea();
}
