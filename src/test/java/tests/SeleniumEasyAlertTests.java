package tests;

import org.testng.annotations.Test;

import pages.SeleniumEasyAlertPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SeleniumEasyAlertTests {
	
	SeleniumEasyAlertPage alertPage = new SeleniumEasyAlertPage();
	//page'deki elementleri cagirmak icin--bu class'in objectlerine ihtiyacimiz var
	BrowserUtils utils = new BrowserUtils(); // utils classin function larini cagiricaz
	
	
  @Test(priority=2, description="This is first Alert accept test.")
  public void firstAlertTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
	  						//calling URL"i 	       // env-variables,properties de ki URL
	  alertPage.firstAlertBtn.click();
	  
	  // calling the swithToAlert function
	  utils.switchToAlert(); //driver focus to the alert
	  utils.waitUntilAlertIsPresent();//burada alertin ekrana gelmesini bekliyoruz
	  String expectedMessage = "I am an alert box!";
	  String actualMessage = utils.alertGetText();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  //iki mejasi karsilastiriyor 
	  Thread.sleep(3000);
	  utils.alertAccept();
  }
  
  @Test(priority=1, description="This is second Alert dismiss test.")
  public void secondAlertTest() throws InterruptedException {
	  String expectedMessage = "Press a button!";
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
	  alertPage.secondAlertBtn.click();
	  utils.switchToAlert();
	  utils.waitUntilAlertIsPresent();
	  String actualMessage = utils.alertGetText();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  Thread.sleep(3000);
	  utils.alertDismiss();
  }
  
  @Test(priority=3, description="This is the Third Alert enter name test.")
  public void thirdAlertTest() throws InterruptedException {
	  String expectedMessage = "Please enter your name";
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
	  alertPage.thirdAlertBtn.click();
	  utils.switchToAlert();
	  String actualMessage = utils.alertGetText();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  
	  utils.sendKeysOnAlert("John");
	  Thread.sleep(3000);
	  utils.alertAccept();
	  Thread.sleep(3000);
	  
  }
  
  @BeforeTest
  public void beforeMethod() {
	  Driver.getDriver();
	  Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //testden once hersey load olmasi icin bekleme veriyoruz
  }

  @AfterTest
  public void afterTest() {
	  Driver.quitDriver();   //invoking the driver
  }

}
