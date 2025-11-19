package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionmysql {
    public static final String username = "441605";
    public static final String pwd = "ezkbJ2FqC7";
    public static final String db = "amigosdedonbosco_amigosdedonbosco";
    public static final String url =
        "jdbc:mysql://mysql-amigosdedonbosco.alwaysdata.net:3306/" + db
        + "?useSSL=false&serverTimezone=UTC";
    
    public static Connection obtenerConexion(){
        Connection cn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, username, pwd);
            System.out.println("Conexión exitosa!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cn;
    }
}
