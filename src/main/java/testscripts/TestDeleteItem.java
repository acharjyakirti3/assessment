package testscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pageobject.AmazonSearchResultPO;

public class TestDeleteItem extends BaseTest{
	@Test
	public void deleteitem() {
		try {
			Actions actions=new Actions(driver);
			WebElement mousemovetosignin= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			actions.moveToElement(mousemovetosignin).build().perform();
			mousemovetosignin.click();
			Thread.sleep(4000);
			
			AmazonSearchResultPO asr=new AmazonSearchResultPO(driver);
			
			asr.username().click();
			asr.username().sendKeys(username);
			
			asr.ContinueButton().click();
			
			asr.Password().clear();
			asr.Password().sendKeys(pwd);
			
			asr.LogInButton().click();
			
		    WebElement cart2=driver.findElement(By.id("nav-cart-count"));
		    actions.moveToElement(cart2).build().perform();
		    cart2.click();
		    
		    WebElement deletebutton=driver.findElement(By.xpath("(//input[@class='a-color-link'])[1]"));
		    deletebutton.click();
		    
		    Thread.sleep(6000);
		    Reporter.log("item is deleted from cart successfully",true);	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}