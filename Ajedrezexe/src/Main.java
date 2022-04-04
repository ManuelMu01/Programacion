import java.util.Scanner;

public class Main {

	static Scanner sc=new Scanner(System.in);
	boolean volver=false;
	
	public static void main(String[] args) {
		
//		Poder enrrocar 2 saltos el rey																	listo
//		Arreglar el jaque mate  																		listo
//		poder tirar a2 a4 en vez de a  2 ,  a   4														listo
//		Mirar que no pete el programa en ningun lado													listo
//		Hacer un contructor	/ apuntes esta																listo
//		mirar qye donde que la ficha que quiera mover tenga algun movimientro disponible 				listo
//		si no quiero mover luego esa ficha poder dale a un d o alguna tecla y repetir ficha para cojer 	listo
//		Buscar como hacer un exe		
//		tablas																							listo
		
		String fin=null;
		Posicion xy=null;
		recogerPosV xxyy=null;
		returnQueSalgaJaqueMate r=null;
		boolean QueSalgaJaqueMate = false;
		boolean jaque;
		boolean volver;

		Tablero t=new Tablero();
		Constructor c = new Constructor();
		
		c.head(t);
		
		c.elegir_B_N(t);
		
		do {
			do {
				jaque=false; volver = false;
				
				do {
					xy=c.cojerFicha(t);
					xxyy=c.moverFicha(t,xy);
					
					volver= xxyy.volver;
			 	} while (volver);
				
				r = c.queSalgaJaqueMate(t);
				
				fin= r.fin;
				QueSalgaJaqueMate = r.QueSalgaJaqueMate;
				
				jaque = c.jaqueANosotrosAlMover(t, xy, xxyy); 	
				
			}while (jaque==true);
				
			c.resto(t);
			
			if (QueSalgaJaqueMate != true) {
				c.pintasTablas(t);
			}
			
		}while (fin==null);
		c.pintasQuienGana(t,fin);
	}
}

