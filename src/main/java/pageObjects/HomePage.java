package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "[id = 'user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id = 'name']")
    private WebElement login;

    @FindBy(css = "[id = 'password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    public void open(String s){
        driver.navigate().to(s);
    }

    public void login(String name, String passvord){
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passvord);
        submit.click();
    }
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }}
