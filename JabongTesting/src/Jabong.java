import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jabong {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jabong.com/customer/account/login/");
		driver.findElement(By.id("login-email")).sendKeys("akash@oovy.org");
		driver.findElement(By.id("login-pwd")).sendKeys("qwerty123");
		WebElement signin = driver.findElement(By.id("btn-login"));
		signin.click();
		driver.get("https://www.jabong.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/header/div[1]/div[2]/div/div/input")).sendKeys("Mens Shirt");
		WebElement search = driver.findElement(By.xpath("/html/body/div[2]/div[3]/header/div[1]/div[2]/div/div/div[1]/span"));
		search.click();
		WebElement details = driver.findElement(By.xpath("/html/body/section[1]/div/section/div/section/section[2]/div[1]/a/figure/img"));	
		details.click();
		WebElement addToBag = driver.findElement(By.xpath("/html/body/section/section/div[2]/div[1]/div[2]/div/div[3]/div/div/form/button"));
		WebElement size = driver.findElement(By.xpath("/html/body/section/section/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/ul/li[1]/button"));
		size.click();
		addToBag.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement viewCart = driver.findElement(By.xpath("/html/body/section/section/div[1]/div[1]/section/section/div[3]/div/div[3]/a"));
		viewCart.click();
		WebElement placeOrder = driver.findElement(By.xpath("/html/body/section[1]/section/div/section[2]/div/div[2]/div[2]/a"));
		placeOrder.click();
		driver.findElement(By.id("login-email")).sendKeys("akash@oovy.org");
		driver.findElement(By.id("login-pwd")).sendKeys("qwerty123");
		WebElement checkout = driver.findElement(By.id("btn-login-checkout"));
		checkout.click();
		WebElement deliver = driver.findElement(By.xpath("/html/body/section/section/div/section[1]/div/section[2]/div[2]/section/div[2]/button"));
		deliver.click();
	}
}
