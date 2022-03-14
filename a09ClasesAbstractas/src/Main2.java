import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {

		LinkedList<PoligonoRegular> figuras = new LinkedList<PoligonoRegular>();
		boolean salir=true;
		
		do {
			System.out.println("Que quieres hacer");
			System.out.println("1) Crear un cuadrado");
			System.out.println("2) Crear un triangulo");
			System.out.println("3) Muestra el mas grande y salir");
			
			switch (sc.nextLine()) {

			case "1":
				System.out.println("Cual es la longitud del cuadrado");
				Double longitudc = Double.parseDouble(sc.nextLine());

				PoligonoRegular cuadrado = new Cuadrado(longitudc);
				figuras.add(cuadrado);

				break;

			case "2":
				System.out.println("Cual es la longitud del triangulo");
				Double longitudt = Double.parseDouble(sc.nextLine());

				PoligonoRegular triangulo = new Triangulo(longitudt);
				figuras.add(triangulo);

				break;

			case "3":

				PoligonoRegular max = null;

				for (PoligonoRegular f : figuras) {

					if (max == null)
						max = f;

					if (f.getArea() > max.getArea())
						max = f;
				}
				System.out.println(max.getArea());
				salir = false;
				break;
			}
		} while (salir);
	}

}
