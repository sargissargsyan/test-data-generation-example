package com.sargissargsyan;

import org.testng.annotations.Test;
import com.sargissargsyan.pages.LoginPage;
import com.sargissargsyan.pages.RegisterPage;
import com.sargissargsyan.utils.TestUtils;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class RegisterTest extends SeleniumBase {
    private String username = TestUtils.randomString(5);
    private String email = TestUtils.randomEmail(username);
    private String password = TestUtils.randomString(10);

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
