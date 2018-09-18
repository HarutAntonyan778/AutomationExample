package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginPageTest extends Hooks {

    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage().get();
        loginPage.maximizeBrowserSize();
    }


    @Test(description = "Check that login field exist")
    public void checkLoginFieldExist() {
        Assert.assertTrue(loginPage.isLoginFieldExist(), "LoginField is missing");
    }

    @Test(description = "Check that password field exist")
    public void checkPasswordFieldExist() {
        Assert.assertTrue(loginPage.isPasswordFieldExist(), "PasswordField is missing");
    }

    @Test(description = "Check that login button exist")
    public void checkLoginButtonExist() {
        Assert.assertTrue(loginPage.isLoginButtonExist(), " Login button is missing");
    }

    @Test(description = "Check that stay signed in checkbox exist")
    public void checkStaySignedInButtonExist() {
        Assert.assertTrue(loginPage.isStaySignedInCheckBoxExist(), "Stay Signed In checkbox is missing");
    }


    @Test(description = "Login with empty password", dependsOnMethods = {"checkLoginFieldExist", "checkLoginButtonExist"})
    public void testLoginWithEmptyPassword() {
        loginPage.fillLoginField("ThisisLogin");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isEmptyFieldErrorExist(), "Error for empty password is missing");
        Assert.assertTrue(loginPage.isEmptyFieldErrorTextCorrect("Enter Login Password ,"));
    }


    @Test(description = "Login with empty login", dependsOnMethods = {"checkPasswordFieldExist", "checkLoginButtonExist"})
    public void testLoginWithEmptyLogin() {
        loginPage.fillPasswordField("ThisisPassword");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isEmptyFieldErrorExist(), "Error for empty login is missing");
        Assert.assertTrue(loginPage.isEmptyFieldErrorTextCorrect("Enter Login Id ,"));
    }


    @Test(description = "Login with invalid credentials", dependsOnMethods = {"checkLoginFieldExist", "checkPasswordFieldExist", "checkLoginButtonExist"})
    public void testLoginWithInvalidCredentials() {
        loginPage.loginWithInvalidCredentials();
        Assert.assertTrue(loginPage.isLoginErrorExist());
        Assert.assertTrue(loginPage.isLoginErrorTextCorrect("Userid or Password did Not Match !!"));
    }

}
