package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseObjectPage<LoginPage> {

    @FindBy(id = "ctl00_CPHContainer_txtUserLogin")
    private WebElement loginField;

    @FindBy(id = "ctl00_CPHContainer_txtPassword")
    private WebElement passwordField;

    @FindBy(id = "ctl00_CPHContainer_chkRememberMe")
    private WebElement staySignedInCheckBox;

    @FindBy(id = "ctl00_CPHContainer_btnLoginn")
    private WebElement loginButton;

    @FindBy(id = "ctl00_CPHContainer_lblOutput")
    private WebElement invalidLoginOrPasswordError;

    @FindBy(id = "ctl00_CPHContainer_valsAll")
    private WebElement emptyLoginOrPasswordError;

    public LoginPage() {
        super("login.aspx");
    }


    public void loginWithInvalidCredentials() {
        fillLoginField("invalidLogin");
        fillPasswordField("invalidPassword");
        clickOnLoginButton();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void fillLoginField(String login) {
        fillField(loginField,login);
    }

    public void fillPasswordField(String password) {
        fillField(passwordField,password);
    }

    public boolean isLoginErrorExist() {
        return isElementExist(invalidLoginOrPasswordError);
    }


    public boolean isLoginFieldExist() {
        return isElementExist(loginField);
    }

    public boolean isPasswordFieldExist() {
        return isElementExist(passwordField);
    }


    public boolean isStaySignedInCheckBoxExist() {
        return isElementExist(staySignedInCheckBox);
    }

    public boolean isLoginButtonExist() {
        return isElementExist(loginButton);
    }

    public boolean isEmptyFieldErrorExist() {
        return isElementExist(emptyLoginOrPasswordError);
    }


    public boolean isLoginErrorTextCorrect(String expectedError) {
        return invalidLoginOrPasswordError.getText().equals(expectedError);
    }

    public boolean isEmptyFieldErrorTextCorrect(String expectedError) {
        return emptyLoginOrPasswordError.getText().equals(expectedError);
    }

}
