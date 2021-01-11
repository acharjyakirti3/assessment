package testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pageobject.AddtoCartPO;
import pageobject.AmazonSearchResultPO;

public class TestAddtoCart extends BaseTest{
	@Test
	public void addtocart() {
		try {
			Actions actions=new Actions(driver);
			WebElement mousemovetosignin= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			actions.moveToElement(mousemovetosignin).build().perform();
			mousemovetosignin.click();
			Thread.sleep(4000);
			
			AmazonSearchResultPO asr=new AmazonSearchResultPO(driver);
			
			asr.username().click();
			asr.username().sendKeys(username);
			Thread.sleep(4000);
			
			asr.ContinueButton().click();
			Thread.sleep(4000);
			
			asr.Password().clear();
			asr.Password().sendKeys(pwd);
			Thread.sleep(4000);
			
			asr.LogInButton().click();
			
			AddtoCartPO atc= new AddtoCartPO(driver);
			atc.Searchbar().clear();
			atc.Searchbar().click();
			atc.Searchbar().sendKeys(search);
			atc.Searchbar().sendKeys(Keys.ENTER);
			atc.EarPhone().click();
			ArrayList<String> secondtab = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(secondtab.get(1));
		    driver.navigate();
		    WebElement cart = driver.findElement(By.id("a-autoid-0-announce"));
		    cart.click();
		    Thread.sleep(10000);
		    Reporter.log("item added to cart successfully",true);		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}