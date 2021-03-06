package base.jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import org.openqa.selenium.support.FindBy;
import com.epam.jdi.light.ui.html.common.TextField;

public class LoginForm extends Form {

    @FindBy(css = "#name")
    private TextField login;
    @FindBy(css = "#password")
    private TextField password;
    @FindBy(css = "#login-button")
    private Button submit;

}
