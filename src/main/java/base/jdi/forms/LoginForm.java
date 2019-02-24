package base.jdi.forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm {

    @FindBy(css = "#name")
    private WebElement loginName;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(css = "#login-button")
    private WebElement submit;

}
