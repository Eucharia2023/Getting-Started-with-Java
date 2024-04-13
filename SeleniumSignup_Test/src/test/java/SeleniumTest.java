import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open your chromedriver
        driver = new ChromeDriver();
        //input your selenium page url
        driver.get("https://selenium-blog.herokuapp.com");
        //Test 1: Verify that user is on the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");

        Thread.sleep(5000);

        //Maximize page
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void Siginup() throws InterruptedException {
        //Click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test 2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //True
            System.out.println("Correct Signuppage");
        else
            //Fail
            System.out.println("Wrong Signuppage");

        Thread.sleep(5000);

        //Input username in the username field
        driver.findElement(By.id("user_username")).sendKeys("amaha123");
        //Input email address in the email address field
        driver.findElement(By.id("user_email")).sendKeys("amaha123@mailinator.com");
        //Input password in the password field
        driver.findElement(By.id("user_password")).sendKeys("amin");
        //Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 1)
    public void ClickUser1() throws InterruptedException {
        //9. Click on User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test 3. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Signup page");
        else
            //Fail
            System.out.println("Wrong Signup page");

        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1page");
        else
            //Fail
            System.out.println("Wrong User1page");

        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void LogOutSuccessful() throws InterruptedException {
        //Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Verify that when the user logout, he/she is directed back to the homepage
        String expectedTitle = "Selenium Blog";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle))
            // Pass
            System.out.println("Logout Successful");
        else
            // Fail
            System.out.println("Logout Successful");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void NegativeSignup1() throws InterruptedException {
        //Click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Input username less than three characters
        driver.findElement(By.id("user_username")).sendKeys("an");
        //Input valid email address in the email address field
        driver.findElement(By.id("user_email")).sendKeys("ukeria145@mailinator.com");
        //Input password in the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }


    @Test(priority = 5)
    public void NegativeSignup2() throws InterruptedException {
        //Input username in the username field
        driver.findElement(By.id("user_username")).sendKeys("shina12");
        //Input an invalid email address in the email address field
        driver.findElement(By.id("user_email")).sendKeys("ukeria4mailinator.com");
        //Input password in the password field
        driver.findElement(By.id("user_password")).sendKeys("faith");
        //Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @AfterTest
    public void QuitBrowser() {
        //Quit browser
        driver.quit();
    }
}
