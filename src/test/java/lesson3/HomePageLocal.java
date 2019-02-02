package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageLocal {
    private WebDriver driver;
    public HomePageLocal(WebDriver driver){
        this.driver=driver;
    }

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

    }
