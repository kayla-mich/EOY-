import java.util.HashMap;
//Controlls the whole system of username and password
public class UserCredentials {
    private HashMap<String, String> credentials = new HashMap<>();


    public boolean containsKey(String username) {
        return credentials.containsKey(username);
    }


    public String get(String username) {
        return credentials.get(username);
    }


    public void put(String username, String password) {
        credentials.put(username, password);
    }
}


