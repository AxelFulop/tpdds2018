package Servicios;

import java.util.ArrayList;
import java.util.List;

public class Token {
    public static List<String> tokens = new ArrayList<String>();


    public static void addToken(String token) {
        tokens.add(token);
    }

    public static void deleteToke(String token) {
        tokens.remove(token);
    }

    public static Boolean isAuth(String token,String id) {
        if (tokens.indexOf(token) >= 0 && SHA256Builder.generarHash256(id).equals(token))
            return true;
        return false;
    }
}
