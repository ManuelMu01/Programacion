package A06PedirDiaMesA�o;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
//		formato
		SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoa�o = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatomes = new SimpleDateFormat("MM");
		SimpleDateFormat formatodia = new SimpleDateFormat("dd");
		
//		fecha
		Date miFecha = null;
		Date Fecha18 = new Date();
		boolean error=true;
		
		int dia=0,mes=0,a�o=0;
		int diamin=1,diamax=31,mesmin=1,mesmax=12, a�omin=Integer.parseInt(formatoa�o.format(Fecha18)),a�omax=1900;
		
		do {
			
			System.out.println("Introduce tu decha de nacimiento");
				System.out.println("D�a en que naciste");
				dia=Integer.parseInt(sc.nextLine());
				
				System.out.println("Mes en que naciste");
				mes=Integer.parseInt(sc.nextLine());
				
				System.out.println("A�o en que naciste");
				a�o=Integer.parseInt(sc.nextLine());
				
				if (dia<diamin||diamax<dia||mesmin>mes||mesmax<mes||a�omin<a�o||a�omax>a�o) {
					error = false;
					System.out.println("Edad erronea");
				}
				
			
		} while (!error);	

		
//		metemos fecha especifica
		try {
			miFecha=formato1.parse(dia+"/"+mes+"/"+a�o);
		} catch (ParseException e) {
			System.out.println("Formato incorrecto");
		}
				
//		modificar variables para poner la fecha de mayor de edad
		int a = Integer.parseInt(formatoa�o.format(Fecha18));
		int b = Integer.parseInt(formatomes.format(Fecha18));
	
		a = a - 18;
		String m1 = a+"";
		String m2 = b+"";
		
//		metemos fecha
		try {
			Fecha18=formato1.parse(formatodia.format(Fecha18)+"/"+m2+"/"+m1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(formato1.format(miFecha));
		System.out.println(formato1.format(Fecha18));

		if (miFecha.compareTo(Fecha18)==-1 || miFecha.compareTo(Fecha18)==0) System.out.println("Eres mayor de edad"); 
		if (miFecha.compareTo(Fecha18)==1) System.out.println("Eres menor de edad");
		
	}
}
