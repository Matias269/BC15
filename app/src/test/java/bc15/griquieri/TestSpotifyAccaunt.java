package bc15.griquieri;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSpotifyAccaunt {

    private WebDriver driver;

    public void EsperayClick(By locator){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }

    @Test
    public void TC001_CreateAccaunt_Spotify() throws InterruptedException{

        //Manage Waits

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://open.spotify.com/intl-es");

        //Looking for the "Singup button"
        By byBtnRegister = By.xpath("//button[@data-testid='signup-button']");
        WebElement btnRegister = driver.findElement(byBtnRegister);
        btnRegister.click();

        //looking for the "username" Imput
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("userbc150002@gmail.com");

        //Close PopUp
        /*WebElement btnClosePopup = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));
        if(btnClosePopup.isDisplayed()){
            btnClosePopup.click();
        }*/

        By byClosePopup = By.xpath("//button[@aria-label='Cerrar']");
        if (!driver.findElements(byClosePopup).isEmpty()) {
            WebElement btnClosePopup = wait.until(ExpectedConditions.elementToBeClickable(byClosePopup));
            btnClosePopup.click();
        }

        //Send the form
        EsperayClick(By.xpath("//button[@data-testid='submit']"));
        //driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        //complete password
        driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Contraseña123.");

        EsperayClick(By.xpath("//button[@data-testid='submit']"));



    }

    @BeforeEach

    public void preCondiciones(){

        String rutaDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //enlazar el webdriver a traves de property
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //testing
        driver = new ChromeDriver();

        //maximizar el browser
        driver.manage().window().maximize();
    }

    @AfterEach

    public void posCondiciones(){
        //driver.close();
    }

}
