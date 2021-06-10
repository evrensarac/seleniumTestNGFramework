package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SeleniumEasyAlertPage {     //constructor of the class
	
	public SeleniumEasyAlertPage() {
		PageFactory.initElements(Driver.getDriver(), this);  //we are invoking the page of the factory--this means = we are 
		//Initialize of the objects of THIS class
	}
	
	@FindBy(xpath = "//button[@onclick='myAlertFunction()']")  //@FindBy=Annotation 
	public WebElement firstAlertBtn; //method create yaptik ve return type i WebElement 
	//bu methodu cagirdigimizda "//button[@onclick='myAlertFunction()']" buna attached
	
	@FindBy(xpath = "//button[@onclick='myConfirmFunction()']")
	public WebElement secondAlertBtn;
	
	@FindBy(xpath="//button[@onclick='myPromptFunction()']")
	public WebElement thirdAlertBtn;

}
