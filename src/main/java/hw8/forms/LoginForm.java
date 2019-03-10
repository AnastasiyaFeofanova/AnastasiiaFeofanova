package hw8.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form {

    @FindBy(css = "#name")
    private TextField login;
    @FindBy(css = "#password")
    private TextField password;
    @FindBy(css = "#login-button")
    private Button submit;

}
