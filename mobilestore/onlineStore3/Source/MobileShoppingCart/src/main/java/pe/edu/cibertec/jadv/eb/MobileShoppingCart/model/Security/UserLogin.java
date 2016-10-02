package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:55 p.m.
 */
public class UserLogin {
    private String password;    
    private String userLogin;
    private User user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
