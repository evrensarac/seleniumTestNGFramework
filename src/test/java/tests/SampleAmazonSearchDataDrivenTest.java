package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class SampleAmazonSearchDataDrivenTest {
	
	AmazonHomePage amazonHP;
	BrowserUtils utils = new BrowserUtils();
	
  @Test(dataProvider = "myDataBucket")
  public void test(String input) {
	  System.out.println(input);
  }
  
  @DataProvider
  public String [] myDataBucket() {
	  String[] myData = new String[5];
	  myData[0] = "coffee mug";
	  myData[1] = "pretty coffee mug";
	  myData[2] = "cool coffee mug";
	  myData[3] = "cute coffee mug";
	  myData[4] = "ugly coffee mug";
	  
	  return myData;
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
