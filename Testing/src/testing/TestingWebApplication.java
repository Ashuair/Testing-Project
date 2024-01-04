package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestingWebApplication {
	
	public static void navigateToURL(){
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/?scenario=1");
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is : " +currentURL);	
	}	
	public static void verifyURL() {
		String expectedURL = "https://demoapps.qspiders.com/?scenario=1"	;
		ChromeDriver driver = new ChromeDriver();
		driver.get(expectedURL);
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains(expectedURL)) {
			System.out.println("Pass : URL is verified");	
		}
		else {
			System.out.println("Fail : URL is not verified");
		}	
	}

	public static void testTextBox() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://demoapps.qspiders.com/?scenario=1");
		WebElement name = driver.findElement(By.name("name"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		
		Actions actions = new Actions(driver);
		actions.sendKeys(name, "Abcdef").sendKeys(email, "xyz@kjk.com").sendKeys(password, "jhbdsh23165").sendKeys(Keys.ENTER).perform();
		

	}
	
public static void clickonSubmitButton() {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/button/buttonSubmitClick?sublist=3");
	driver.findElement(By.id("sat1")).click();
	driver.findElement(By.id("btn40")).click();
	
	
}
    public static void dragandadrop() {
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/dragDrop/dragToCorrect?sublist=1");
		WebElement source = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement target = driver.findElement(By.xpath("//div[@class=\"drop-column min-h-[200px] bg-slate-100\"][1]"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
    }
    public static void main(String[] args) throws InterruptedException {
    	navigateToURL();
    	verifyURL();
    	testTextBox();
    	clickonSubmitButton();
    	dragandadrop();
    	
		
	}
}

