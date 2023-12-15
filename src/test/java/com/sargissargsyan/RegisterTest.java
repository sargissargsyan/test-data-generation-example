package com.sargissargsyan;

import com.sargissargsyan.pages.LoginPage;
import com.sargissargsyan.pages.RegisterPage;
import com.sargissargsyan.utils.TestUtils;
import org.testng.annotations.Test;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class RegisterTest extends SeleniumBase {
    private final String username = TestUtils.randomString(5);
    private final String email = TestUtils.randomEmail(username);
    private final String password = TestUtils.randomString(10);

    @Test
    public void register() {
        RegisterPage registerPage = new RegisterPage().open();
        registerPage.setFullName("Fullish Name");
        registerPage.setUsername(username);
        registerPage.setpassword(password);
        registerPage.setEmail(email);
        registerPage.clickSignUpButton();

        LoginPage loginPage = new LoginPage().open();
        loginPage.login(email, password);

        //do checks
    }
}
