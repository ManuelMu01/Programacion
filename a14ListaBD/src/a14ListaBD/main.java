package a14ListaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class main {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		String bd="lista_datos";
		
		String login="root";
		
		String pass="";
		
		String host="localhost";
		
		String url="";
		
		Connection con=null;
		
		try {
			url="jdbc:mysql://"+host+"/"+bd+"?useSSL=false";
				
			Class.forName("org.mariadb.jdbc.Driver");
			
			con=DriverManager.getConnection(url, login, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Lista de Productos");
		System.out.println("1) Añadir producto");
		System.out.println("2) Modificar producto");
		System.out.println("3) Eliminar producto");
		System.out.println("4) Consultar la lista de productos");
		
		switch(sc.nextLine()) {

			case "1":
	
				System.out.println("Nueva producto:");
				String pro=sc.nextLine();
				System.out.println("¿Que cantidad de "+pro+" quieres?");
				int can=Integer.parseInt(sc.nextLine());
				
				PreparedStatement stm;
//				cuando hago un insert recogere la PK
				ResultSet res;
				
				String insert="insert into productos (producto,cantidad) values (?,?)";
				
				try {                      //        hacer que me devuelva la PK
					stm=con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
					
					stm.setString(1, pro);
					stm.setInt(2, can);
			
					stm.executeUpdate();
//					recojer id
					res=stm.getGeneratedKeys();
					
//					me pongo en la primera fila
					res.next();
					
//																		recoje la PK obtenida
					System.out.println("Categoría insetada con el ID: "+res.getInt(1));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			break;
			
			
		}
	}

}
