package mobile;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GiveIndiaExample {

	public static void main(String[] args){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP India\\Desktop\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//step 1
	driver.get("https://en.wikipedia.org/wiki/Selenium");
	driver.manage().window().maximize();
	//step 2
	List<WebElement> Links = driver.findElements(By.xpath("//*[@id='mw-content-text']/div/ul[2]/child::li"));
	System.out.println(Links.size());
	for(int i=0;i<Links.size();i++){
		if(Links.get(i).getAttribute("href")!=null){
			System.out.println(i+"." + Links.get(i).getText());
		}
	}
	
	//step 3
	driver.findElement(By.xpath("(//a[@title='Oxygen'])[2]")).click();;
	//step 4
	String VerifyArticle = driver.findElement(By.xpath("//a[text()='Article']")).getText();
	if(VerifyArticle.equals("Article")){
		System.out.println("Displayed Page is Featured Article");
	}
	else{
		System.out.println("Displayed page is not Featrured Article");
	}
	//step 5
	File Shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Shot, new File("C:\\Dummy\\First\\Screenshot.png"));
	
	//step 6
	List<WebElement> PdfList = driver.findElements(By.xpath("//span[@class='cs1-format']")); 
	System.out.println("Total Number of PDF are: "+ PdfList.size());
	
	//step 7
	WebElement SearchBar = driver.findElement(By.xpath("//input[@id='searchInput']"));
	SearchBar.sendKeys("pluto");
	SearchBar.sendKeys(Keys.ARROW_DOWN);
	SearchBar.sendKeys(Keys.ARROW_DOWN);
	}
}
