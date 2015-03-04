package my.web.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.sql.*;

/**
 * Created by Basilianius on 14.02.2015.
 */
@WebService
public class Calculator {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1962/WS/calc", new Calculator());
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public String getCountry (int a){

        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }

        String url = "jdbc:mysql://localhost:1985/sakila";
        String username = "root";
        String password = "!root!";
        Connection connection = null;

        String b = "aaa";
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT country FROM country WHERE country_id = " + a + ";");

            int country = rs.findColumn("country");

            while(rs.next()) {
                b = rs.getString(country);
             }



        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        } finally {
            System.out.println("Closing the connection.");
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        return b;

    }


}
