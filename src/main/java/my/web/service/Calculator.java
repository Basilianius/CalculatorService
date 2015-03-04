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
        Endpoint.publish("http://localhost:8080/WS/calc", new Calculator());
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public String getCountry (int a) throws SQLException {
        String url = "jdbc:mysql://localhost:1985/sakila";
        String user = "root";
        String password = "!root!";

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT country FROM country WHERE country_id = " + a + ";");

        return rs.toString();
    }


}
