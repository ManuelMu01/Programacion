package Temaa1;

import java.util.Scanner;

public class E5ProgramaEcuaciones2Grado {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		   /*
        1 -5 6  -> 3 y 2
        1 -2 1  -> 1
        -1 4 -7 -> No tiene soluci�n
     
        � -> Alt + 253
       */
      double a,b,c, discriminante, sol1, sol2;
     
      System.out.println("Resuelve una ecuaci�n de 2� Grado (aX� + bx + c = 0)");
      System.out.print  ("Introduce el valor de 'a': ");
      a=Double.parseDouble(sc.nextLine());
     
      if (a==0) {
          System.out.println("Esto no es una ecuaci�n de segundo grado!!!");
      } else {
         
          System.out.print  ("Introduce el valor de 'b': ");
          b=Double.parseDouble(sc.nextLine());
         
          System.out.print  ("Introduce el valor de 'c': ");
          c=Double.parseDouble(sc.nextLine());
         
          discriminante=Math.pow(b, 2)-(4*a*c);
         
          if (discriminante<0) {
              System.out.println("No tiene soluciones Reales");
          }
         
          if (discriminante==0) {
              sol1=-b/(2*a);
              System.out.println("�nica soluci�n: "+sol1);
          }
         
          if (discriminante>0) {
              sol1=(-b+Math.sqrt(discriminante))/(2*a);
              sol2=(-b-Math.sqrt(discriminante))/(2*a);
             
              System.out.println("Soluci�n 1: "+sol1);
              System.out.println("Soluci�n 2: "+sol2);
		
	}

      }}}
