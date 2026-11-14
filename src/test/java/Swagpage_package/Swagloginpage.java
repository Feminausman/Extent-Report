package Swagpage_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swagloginpage {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"user-name\"]")WebElement username;
	@FindBy(xpath = "//*[@id=\"password\"]")WebElement password;
	@FindBy(xpath = "//*[@id=\"login-button\"]")WebElement login;
	
	public Swagloginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
	}
	
	public String urlmthd()
	{
		return driver.getCurrentUrl();
	}
	
	public String title()
	{
		String title=driver.getTitle();
		return title;
	}

}
