package sortable1;

/**
 * An immutable network user with a login name and password.
 * @author John Gibson
 */
public class NetworkUser {
    
    private final String login;
    private final String password;

    /**
     * Creates a network user with a given login name and password.
     */
    public NetworkUser(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    /**
     * Returns the user's login.
     */
    public String getLogin() {
        return login;
    }
    
    /**
     * Returns the user's password.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Returns the user's login-password info.
     */
    @Override
    public String toString() {
        return login + ", " + password;
    }
    
}