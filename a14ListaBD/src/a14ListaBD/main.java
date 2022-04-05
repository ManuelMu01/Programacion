package a14ListaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.RowSetInternal;

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
					System.out.println("Producto insetado con el ID: "+res.getInt(1));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			break;
			
			case "2":
//				hacer tmbn por nombre
				System.out.println("1) Modificar nombre \n2) Modificar cantidad");

				if (Integer.parseInt(sc.nextLine())==1) {
//					modificar  nombre
					System.out.println("ID del producto a modificar:");
					int id=Integer.parseInt(sc.nextLine());
					
					System.out.println("Nombre del nuevo producto");
					String nombre=sc.nextLine();
					stm=null;
					
					String update= "update productos set producto=? where id=?";
				
					try {
						stm=con.prepareStatement(update);
						
						stm.setString(1, nombre);
						stm.setInt(2, id);
						
						stm.executeUpdate();
						
						System.out.println("Datos actualizados");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				} else {
//					modificar cantidad
					System.out.println("ID del producto:");
					int id=Integer.parseInt(sc.nextLine());
					
					System.out.println("Nueva cantidad");
					can=Integer.parseInt(sc.nextLine());
					stm=null;
					
					String update= "update productos set cantidad=? where id=?";
				
					try {
						stm=con.prepareStatement(update);
						
						stm.setInt(1, can);
						stm.setInt(2, id);
						
						stm.executeUpdate();
						
						System.out.println("Datos actualizados");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				break;
				
			case "3":
				
				System.out.println("Id del producto a eliminar");
				int ide=Integer.parseInt(sc.nextLine());
				
//				para acordarme
				stm=null;
				res=null;
				
				String delete="delete from productos where producto=?";
				
				try {
					stm=con.prepareStatement(delete);
					stm.setInt(1, ide);
					stm.executeUpdate();
					
					System.out.println("Datos actualizados");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
				
			case "4":
				
				stm=null;
				res=null;
				
				String consulta="Select * from productos order by producto desc";
				
				try {       
					stm=con.prepareStatement(consulta);
					res=stm.executeQuery();
					
					while (res.next()) {               // muestras solo el titulo puedes ponerlo en el select
						System.out.println(res.getString("producto")+" - "+(res.getInt("cantidad")));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
		}
	}

}
