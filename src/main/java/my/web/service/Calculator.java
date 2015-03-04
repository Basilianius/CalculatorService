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



        String url = "jdbc:mysql//127.0.0.1:1985/sakila";
        String user = "root";
        String password = "!root!";

        String b = "";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT country FROM country WHERE country_id = " + a + ";");

            b = rs.toString();
            //if (rs.next()) {

            //}

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return b;

    }


}
