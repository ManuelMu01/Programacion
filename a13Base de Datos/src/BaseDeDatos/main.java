package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.net.httpserver.Authenticator.Result;

public class main {

	public static void main(String[] args) {
		
//		base de datos a la que entraremos
		String bd="sakila";
		
//		usuario
		String login="root";
		
//		contra
		String pass="";
		
//		donde esta la base de datos ip
		String host="localhost";
		
		String url="";
		
		
		Connection con=null;
		
		try {
//			conectarnos: 
//			primero generamos la url que se va a concetar
			url="jdbc:mysql://"+host+"/"+bd+"?useSSL=false";
//			 							    que no use una conecsion segura
//			mira que este importado el mariaDB 
			Class.forName("org.mariadb.jdbc.Driver");
			
//			conectarse                           uset   pass
			con=DriverManager.getConnection(url, login, pass);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		hacer consulta
		PreparedStatement stm;
		
//		objeto que recoja los resultados
		ResultSet res;
		
		String consulta="Select * from film";
		
		try {
			stm=con.prepareStatement(consulta);
			
//			ejecutar consulta
			res=stm.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("title"));
			}
			
		} catch (SQLException e) {
			
		}
		
	}

}
