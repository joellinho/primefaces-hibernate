/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.test;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.*;

/**
 *
 * @author Kike
 */
public class SecurityServiceTest {

    SecurityService security;

    @Before
    public void init() {
        security = new SecurityService();
    }

    @After
    public void close() {
        security = null;
    }

    @Test @Ignore
    public void authenticateAdminWithValidCredentials() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLogin("ebassallo");
        userLogin.setPassword("P@ssw0rd");

        User user = security.authenticate(userLogin);
        Assert.assertNotNull(user);
        Assert.assertTrue(user.getRoleID() == 1);
    }

    @Test @Ignore
    public void authenticateCustomerWithValidCredentials() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLogin("tbassallo");
        userLogin.setPassword("P@ssw0rd");

        User user = security.authenticate(userLogin);
        Assert.assertNotNull(user);
        Assert.assertTrue(user.getRoleID() == 2);
    }

    @Test @Ignore
    public void authenticateAdminWithInvalidCredentials() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLogin("ebassallo");
        userLogin.setPassword("Password");

        User user = security.authenticate(userLogin);
        Assert.assertNull(user);
    }

    @Test @Ignore
    public void authenticateCustomerWithInvalidCredentials() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLogin("tbassallo");
        userLogin.setPassword("Password");

        User user = security.authenticate(userLogin);
        Assert.assertNull(user);
    }
}
