package stepDef;

import org.junit.Assert;
import org.junit.runner.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


	public class ValidationSteps {
	
	WebDriver driver;	

	@Given("user is on Ixigo website")
	public void user_is_on_Ixigo_website() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_Workspace I\\Ixigo\\server\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.navigate().refresh();
		 driver.get("https:/www.ixigo.com/");
		
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 
	}

	@When("user enter details for journey")
	public void user_enter_details_for_journey() throws InterruptedException {
		//from
//		System.out.println("-----------" + driver.findElement(By.xpath("//*[@class='orgn u-ib u-v-align-bottom u-text-left']//input")).getText());
//		if(driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input")).getText().equalsIgnoreCase("LKO - Lucknow")) {
//			System.out.println("inside if");
//			driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//*[@class='clear-input ixi-icon-cross']")).click();
//		}
		
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input")).click();
		Thread.sleep(3000);	
		
		//
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input")).sendKeys("del");
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input")).sendKeys(Keys.ENTER);
				
		//to 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dstn u-ib u-v-align-bottom u-text-left']//input")).clear();
		
		driver.findElement(By.xpath("//div[@class='dstn u-ib u-v-align-bottom u-text-left']//input")).sendKeys("blr");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dstn u-ib u-v-align-bottom u-text-left']//input")).sendKeys(Keys.ENTER);
		
		//departure
		List<WebElement> dep = driver.findElements(By.xpath("//*[@class='rd-month'][1]//table[@class='rd-days']//div[@class='day has-info']"))	;	
		for(WebElement e : dep) {
			if(e.getText().equalsIgnoreCase("27")) {
				e.click(); 
				Thread.sleep(3000);
				break;
			}
		}
		
		//no of traveler
		driver.findElement(By.xpath("//*[@class='u-ib items u-v-align-middle']//*[text()='2']")).click();
		Thread.sleep(3000);
		
		
		//return
		driver.findElement(By.xpath("//*[@placeholder='Return']")).click();
		Thread.sleep(3000);
				List<WebElement> ret = driver.findElements(By.xpath("//*[@class='rd-month'][2]//table[@class='rd-days']//div[@class='day has-info']"));
			
				for(WebElement e : ret) {
					if(e.getText().equalsIgnoreCase("4")) {
						e.click();
						Thread.sleep(3000);
						break;
					}
				}
		
		
						
	}

	@When("clicking on search")
	public void clicking_on_search() throws InterruptedException {
	    
		driver.findElement(By.xpath("//*[@class='search u-ib u-v-align-bottom']")).click();
		Thread.sleep(2000);
	}

	@Then("user is on serched result page")
	public void user_is_on_serched_result_page() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getCurrentUrl().contains("from=DEL&to=BLR&date=27062021&returnDate=04072021&adults=2"));
	    
	}

	@Then("validate filters")
	public void validate_filters() throws InterruptedException {
	    
		//adding stop filter
		List<WebElement> nonstop = driver.findElements(By.xpath("//*[@class='fltr-col-1 u-ib']//*[@class='checkbox-list-item ']//div"));
		
		for(WebElement e : nonstop) {
			if(e.getText().equalsIgnoreCase("Non stop")) {
				e.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	@Then("print the list of airlines costing less than {int}")
	public void print_the_list_of_airlines_costing_less_than(Integer int1) throws InterruptedException {
		//*[@class='result-col outr']//*[@class='airline-text']//div
		
		System.out.println("FLIGHTS COSTING LESSER THAN " + int1);
		List<WebElement> AirlineName = driver.findElements(By.xpath("//*[@class='c-flight-listing-split-row  hide-detail']//*[@class='u-text-ellipsis']"));
		List<WebElement> DepartureTime = driver.findElements(By.xpath("//*[@class='result-wrpr']//*[@class='time-group']//*[@class='time'][1]"));
		List<WebElement> fare = driver.findElements(By.xpath("//*[@class='result-wrpr']//*[@class='price']//span[2]"));
		
		Iterator<WebElement> it1 = AirlineName.iterator();
		Iterator<WebElement> it2 = DepartureTime.iterator();
		Iterator<WebElement> it3 = fare.iterator();
		
		while(it1.hasNext()) {
			
			System.out.println("Flight Name: " + it1.next().getText());
			System.out.println("Departure Time: "+ it2.next().getText());
			System.out.println("Fare: Rs."+ it3.next().getText());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}


//			System.out.println();
//			//System.out.println(e.findElement(By.xpath(s+"//*[@class='time-group']//*[@class='time'][1]")).getText());
//		}
//	
//		while(it.hasNext()) {
//		    System.out.println("Dep--"+ driver.findElement(By.xpath(it.next()+"//*[@class='result-wrpr']//*[@class='time-group']//*[@class='time'][1]")).getText());
//		}

	
//		List<WebElement> DepartureTime = driver.findElements(By.xpath("//*[@class='result-wrpr']//*[@class='time-group']//*[@class='time'][1]"));
//		
//		for(WebElement e : DepartureTime) {
//			System.out.println(e.getText());
//		}
//		
//		List<WebElement> Fare = driver.findElements(By.xpath("//*[@class='result-wrpr']//*[@class='c-price-display u-text-ellipsis ']"));
//		
//		for(WebElement e : Fare) {
//			System.out.println(e.getText());
//		}
	    driver.quit();
	}

}
