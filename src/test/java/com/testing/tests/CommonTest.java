package com.testing.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testing.utils.fillPageElement;
import com.testing.utils.getPageElement;

public class CommonTest {
	  protected static WebDriver driver = new FirefoxDriver();	 
      protected static WebDriverWait wait = new WebDriverWait(driver, 40);

	  @BeforeSuite(alwaysRun=true)
	  //@Parameters({"baseUrl", "ContentType", "Accept", "userName", "password"})
	    public void setUp () throws Exception {
		  String baseUrl = "http://finance.yahoo.com";
		  
		  driver.get(baseUrl);
		  
		  fillPageElement.fillPage("login.json", "loginData.json");
		  driver.findElement(getPageElement.getElement("login.json", "loginSubmit")).submit();
		  wait.until(ExpectedConditions.elementToBeClickable(getPageElement.getElement("createNewCoursePage.json", "createNewCourse"))); 
		  Set<org.openqa.selenium.Cookie> allCookies = driver.manage().getCookies();
			for (org.openqa.selenium.Cookie loadedCookie : allCookies) {
				if (loadedCookie.getName().equalsIgnoreCase("APOLLOASSERTION")){
					String cookie = "APOLLOASSERTION="+ loadedCookie.getValue();
				}
			} 
	    }
	  @AfterSuite(alwaysRun=true)
	  public void shutDown(){
		  driver.quit();
	  }
	
}
