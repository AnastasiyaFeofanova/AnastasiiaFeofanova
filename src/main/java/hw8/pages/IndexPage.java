package hw8.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import hw8.entities.HeaderMenuNavigation;
import hw8.entities.User;
import hw8.Sections.Header;
import hw8.forms.LoginForm;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IndexPage extends WebPage {

    LoginForm loginForm;
    MetalsAndColorsPage metalsAndColorsPage;
    Header header;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;
    @FindBy(id = "user-name")
    private UIElement userName;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void checkUserName(User user){
        Assert.assertEquals(userName.getText(), user.userName);
    }

    public void linkMetalsAndColors(HeaderMenuNavigation s){
        header.menuNavigation.select(s.value);
        metalsAndColorsPage.shouldBeOpened();
    }
}