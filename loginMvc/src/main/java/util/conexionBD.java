package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    // fue un caso poner la verdadera URL
    private static final String URL = "jdbc:mysql://mysql-amigosdedonbosco.alwaysdata.net:3306/amigosdedonbosco_dasfinal";
    
    private static final String USER = "441605_1478";
    private static final String PASSWORD = "7CqF2Jbkze";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("🔗 Conectando a: " + URL);
            System.out.println("👤 Usuario: " + USER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }
    }
}