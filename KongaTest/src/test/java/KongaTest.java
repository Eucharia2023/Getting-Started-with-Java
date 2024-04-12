import com.google.inject.spi.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class KongaTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your chrome driver
        driver = new ChromeDriver();
        //2. Input your Konga Url (https://www.konga.com);
        driver.get("https://www.konga.com");
        Thread.sleep(10000);

        //Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void logInAndNavigateToCategory() throws InterruptedException {
        //3. Click on login/signup button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(2000);
        //4. Locate the username field and Input username
        driver.findElement(By.id("username")).sendKeys("aria@mailinator.com");
        Thread.sleep(2000);
        //5. Locate the password field and input password
        driver.findElement(By.id("password")).sendKeys("ariaaria");
        Thread.sleep(2000);
        //6. Click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void SelectComputerandAccessories() throws InterruptedException {
        // Select Computer and Accessories Category
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        // Create an instance of Action Class
        Actions actions = new Actions(driver);
        //Hover over the Element
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(10000);
    }

    @Test (priority = 2)
    public void SelectMacBook() throws InterruptedException {
        //Select MacBook
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div/div[1]/a[6]")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 3)
    public void AddToCart() throws InterruptedException {
        //Choose the Apple MacBook to buy
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[1]/a[1]/picture/img")).click();
        Thread.sleep(10000);
        // Click on 'Add to cart button'
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void Checkout() throws InterruptedException {
        //Click on continue to Checkout
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[4]/div/div[6]/div/a")).click();
        Thread.sleep(10000);
        //Select the 'Pay now' option
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(20000);
        //Continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(15000);
        //Switch iFrame
        WebElement paymentMethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(20000);
        //Select card method
        WebElement cardPayment = driver.findElement(By.className("Card"));
        cardPayment.click();
        Thread.sleep(15000);
    }

    @Test (priority = 5)
    public void EnterCardDetails() throws InterruptedException {
        //Input Card Number in the Card Number Field
        driver.findElement(By.id("card-number")).sendKeys("9807 2309 1687 9890");
        //Input Date in the Date field
        driver.findElement(By.id("expiry")).sendKeys("06/24");
        //Input CVV in the CVV field
        driver.findElement(By.id("cvv")).sendKeys("285");
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void ErrorMessage() {
         // print out the error message: Invalid Card Number
         WebElement message = driver.findElement(By.id("card-number_unhappy"));
         System.out.println(message.getText());
    }

    @Test (priority = 7)
    public void CloseIframe() {
        //Close the iFrame that displays the input card modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
    }

    @AfterTest
    public void CloseBrowser() {
        //Quit the browser
        driver.quit();
    }
}
