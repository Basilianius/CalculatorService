package my.web.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

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


}
