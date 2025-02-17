import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instahyre {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        
        // Open Instahyre homepage
            driver.get("https://www.instahyre.com/");
            // Maximize the browser window
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(2000);
            
            // instahyre linkedin signin button
            WebElement signInButton = driver.findElement(By.xpath("//a[@id='linkedin-signup-link']"));
           signInButton.click();
           Thread.sleep(2000);
           
           // redirection of linkedin page
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jlokesh985@gmail.com");
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Loke@1995");	       
	        driver.findElement(By.xpath("//button[@class='btn__primary--large from__button--floating']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//*[@id=\"job-search-section\"]/div[1]/h6")).click();
	        //navigated to the instahyre page
	     WebElement searchBoxSkills = driver.findElement(By.xpath("//input[@type='text' and @id='skills-selectized']"));
	      searchBoxSkills.sendKeys("Automation Testing, Java, SDET, Selenium, REST Assured, Quality Assurance, Database Testing, SQL, API testing, MySQL"); //Manual Testing, API testing, 
	      searchBoxSkills.sendKeys(Keys.ENTER);
	      Thread.sleep(1000); 
	      
	      WebElement searchBoxLocations = driver.findElement(By.xpath("//input[@type='text' and @id='locations-selectized']"));
	      searchBoxLocations.sendKeys("Anywhere in India");
	      searchBoxLocations.sendKeys(Keys.ENTER);
	      Thread.sleep(1000);
	      
	      
	   // Wait for "Show Results" Button to be Clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement showResultsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("show-results")));

	        // Scroll to Button
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showResultsButton);
	        Thread.sleep(500);

	        // Click Using JavaScript
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showResultsButton);

	     
	        Thread.sleep(3000);
	        //driver.quit();
	        
	        driver.findElement(By.xpath("//button[contains(text(), 'View »')]")).click();
	        Thread.sleep(1000);
	      
	        Thread.sleep(1000);
	       
	       while (true) {
	            try {
	                WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-lg btn-primary new-btn']")));

	                applyButton.click();
	                Thread.sleep(500); 

	            } catch (Exception e) {
	                System.out.println("No more applications to apply.");
	                Thread.sleep(1000);
	                break;
	                
	            }
	            
	        }
	      }

}
