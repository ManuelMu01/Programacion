import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Controlador ctr=new Controlador();	
		
		
		String opcion=null;
		double lon=0;
		
		do {
			System.out.println("1) A�adir Cuadrado");
			System.out.println("2) A�adir Tri�ngulo");
			System.out.println("S) Mostrar el mayor y Salir");
			opcion = sc.nextLine();
			
			if (!opcion.equalsIgnoreCase("s")) {
				System.out.println("Logitud del lado?");
				lon = Double.parseDouble(sc.nextLine());
			}
			
			if (opcion.equals("1")) {
				ctr.addCuadrado(new Cuadrado(lon));
			}
			if (opcion.equals("2")) {
				ctr.addTriangulo(new Triangulo(lon));
			} 
			
		} while (!opcion.equalsIgnoreCase("s"));
		
		PoligonoRegular elMayor=ctr.getMayor();

		if (elMayor==null) System.out.println("Nada que ver!!");
		else {
			System.out.println("Lados: "+elMayor.lados);
			System.out.println("Longitud del lado: "+elMayor.longitud);
			System.out.println("Per�metro: "+elMayor.getPerimetro());
			System.out.println("�rea: "+elMayor.getArea());
		}
		
		ctr.guardardatos();
	}

}