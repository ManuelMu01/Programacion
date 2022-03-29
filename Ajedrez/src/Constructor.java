import java.util.Scanner;

public class Constructor {
	
	static Scanner sc=new Scanner(System.in);

	public Constructor() {
		
	}
	
	public void head (Tablero t) {
		System.out.println();
		System.out.println("            ┌─────────────┐");
		System.out.println("            │   Ajedrez   │");
		System.out.println("            └─────────────┘");
		System.out.println();
		t.pintar();
	}
	
	public void elegir_B_N (Tablero t) {
		boolean error=true;
		char tirada='N';
		
		System.out.println("Empiezan blancas o negras (b/n)");
		do {
			try {
				tirada = sc.nextLine().toUpperCase().charAt(0);
				if (tirada=='b' || tirada=='n' || tirada=='B' || tirada=='N') error = false;
				else throw new Exception();
			}catch (Exception e) {
				System.out.println("Blancas o Negras!!");
			}
		} while(error);
		
		t.tirada=tirada;

	}	
	
	public Posicion cojerFicha(Tablero t) {
		boolean movimientocorrecto=false;
		int x = 0 , y = 0;
		do {
			// mueve
			boolean errorpeta=true;String pos = null,xlet = null;
			do {
				try {
					System.out.println(t.tirada+": Que ficha quieres mover");
					pos = sc.nextLine();
					xlet=pos.substring(0,1);
					y=Integer.parseInt(pos.substring(1,2));
					x = t.Letranum(xlet,x);
					t.casillas[x][y].posiblesPosiciones(t).getFirst();
					if (t.casillas[x][y] != null && t.casillas[x][y].posiblesPosiciones(t)==null) { throw new Exception(); }
					errorpeta=false;
				} catch(NumberFormatException numeroInvalido){
					System.out.println("El primer digito tiene que ser una letra (x)");
				} catch(Exception noMov){
					System.out.println("No tienes movimientos validos en esta ficha");
				}
			} while (errorpeta);
			
			if (t.casillas[x][y]!=null && t.casillas[x][y].color==t.tirada) movimientocorrecto=true;
			else System.out.println("Pieza no valida");
			
			
		} while (movimientocorrecto==false);
		
		return (new Posicion(x,y));
	}

	public recogerPosV moverFicha(Tablero t,Posicion xy) {
		int xx=0;int yy = 0;boolean volver=false; 
		
		boolean movimientocorrecto=false;
		do {
			 boolean errorpeta=true;String pos = null,xxlet = null;
			try {	
				do {
					try {
				
						System.out.println(t.tirada+": Donde quieres mover  (v) para selecionar otra ficha");
						pos = sc.nextLine();
						
						if (pos.equals("v")) throw new Exception();
						
						xxlet=pos.substring(0,1);
						yy=Integer.parseInt(pos.substring(1,2));
						xx=t.Letranum(xxlet,xx);
					
						errorpeta=false;
					} catch(NumberFormatException e){
						System.out.println("El primer digito tiene que ser una letra (x)");
					}
				} while (errorpeta);
				
				
				// MIRAR SI ENRROCA parte 1 
				int enro=0;
				if (t.casillas[xy.x][xy.y].forma.equals((t.casillas[xy.x][xy.y].color=='B' || t.casillas[xy.x][xy.y].color=='b')? "\u265A":"\u2654") && t.casillas[xx][yy].forma.equals((t.casillas[xy.x][xy.y].color=='B' || t.casillas[xy.x][xy.y].color=='b')? "\u265C":"\u2656")) {
					enro=1;
				}
				
				if (t.mover(new Posicion(xy.x, xy.y),new Posicion (xx,yy))==0) movimientocorrecto=true;
				else System.out.println("No es un movimiento valido");
					
				// MIRAR SI ENRROCA parte 2
				if (enro==1) t.casillas[xy.x][xy.y]=new Torre(xy.x, xy.y, (t.casillas[xx][yy].color=='B')? 'B':'N');
			} catch(Exception volverMov) {
				movimientocorrecto=true;volver=true;
			}
			
		} while (movimientocorrecto==false);
		return new recogerPosV(xx,yy,volver);
	}

	public returnQueSalgaJaqueMate queSalgaJaqueMate(Tablero t) {
		boolean QueSalgaJaqueMate = false;  String fin=null;
		
		if (t.jaquemate(t)==0) {
			System.out.println("Jaque mate") ;
			if (t.tirada=='B') fin="Blancas"; 
			else fin="Negras";
			QueSalgaJaqueMate = true;
			
		} else if (t.jaqueNosotros(t)==1) { System.out.println("Jaque");}
	
		return new returnQueSalgaJaqueMate(fin,QueSalgaJaqueMate);
	}

	public boolean jaqueANosotrosAlMover(Tablero t,Posicion xy,recogerPosV xxyy) {
		boolean jaque = false;
		
		if(t.jaqueANosotrosAlMover(t)==1) {
			System.out.println("Si mueves ahi se hace Jaque mate, mueve en otro sitio");
			jaque=true;
			//ECHAR A DETRAS LA FICHA
			t.casillas[xy.x][xy.y]=t.casillas[xxyy.x][xxyy.y];  
			t.casillas[xxyy.x][xxyy.y]=null; 
			
			t.casillas[xy.x][xy.y].posicion=new Posicion(xy.x,xy.y);
			
		}
		return jaque;
	}

	public void resto (Tablero t) {
		t.convertirReina(t);
		t.pintar();
		
		if (t.tirada=='N') t.tirada='B';
		else t.tirada='N';
	}

	public void pintasTablas (Tablero t) {
		
		if (t.Tablas(t)==0) {
			System.out.println("            ┌────────────┐");
			System.out.println("            │   Tablas   │");
			System.out.println("            └────────────┘");
			
			if (t.tirada=='N') {
				System.out.println("       ┌────────────────────────┐");
				System.out.println("       │   Ha ganado: Blancas   │");
				System.out.println("       └────────────────────────┘");
				
				
			} else {
				System.out.println("      ┌───────────────────────┐");
				System.out.println("      │   Ha ganado: Negras   │");
				System.out.println("      └───────────────────────┘");
			}
			System.exit(0);
		}
	}

	public void pintasQuienGana (Tablero t,String fin) {
		System.out.println();
		System.out.println("          ┌───────────────────────┐");
		System.out.println("          │   Fin de la partida   │");
		System.out.println("          └───────────────────────┘");
		System.out.println();
		if (fin.equals("blancas")) {
			System.out.println("         ┌────────────────────────┐");
			System.out.println("         │   Ha ganado: Blancas   │");
			System.out.println("         └────────────────────────┘");
		} else {
			System.out.println("          ┌───────────────────────┐");
			System.out.println("          │   Ha ganado: Negras   │");
			System.out.println("          └───────────────────────┘");
		}
	}
}
