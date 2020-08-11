
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Rios
 */
public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/bd_ventas?useSSL=false&serverTimezone=UTC";
    String user="root";
    String pass="1234";
    public Connection Conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion a la base de datos" + "....... Lista");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
        return con;
    }
    
}
