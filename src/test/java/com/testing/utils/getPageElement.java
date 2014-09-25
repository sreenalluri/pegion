package com.testing.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;

import com.google.gson.Gson;

public class getPageElement {
	static Gson gson = new Gson();
	static By objectLocator;

	
	public static By getElement (String PageName, String ObjectName) {		
		
		try {
			
			final String dir = System.getProperty("user.dir");
			String locatorType = null, locatorValue = null;
			
			FileReader fileReader = new FileReader(dir +"/src/test/resources/edu/apollogrp/data/objectData/"+ PageName);

			BufferedReader buffered = new BufferedReader(fileReader);

			ObjectData ObjectData = gson.fromJson(buffered, ObjectData.class);
			
			for (int i=0; i < ObjectData.getPageInputObjects().size(); i++){
				if (ObjectData.getPageInputObjects().get(i).getObjectName().toString().equals(ObjectName)) {
					locatorValue = ObjectData.getPageInputObjects().get(i).getObjectIdentifier();
					locatorType = ObjectData.getPageInputObjects().get(i).getObjectType();
				}
			}
			if (locatorValue == null) {				
				for (int j=0; j < ObjectData.getPageActionObjects().size(); j++){
					if (ObjectData.getPageActionObjects().get(j).getObjectName().toString().equals(ObjectName)) {
						locatorValue = ObjectData.getPageActionObjects().get(j).getObjectIdentifier();
						locatorType = ObjectData.getPageActionObjects().get(j).getObjectType();
					}
				}
			}
		
			if(locatorType.equalsIgnoreCase("css")) {
				objectLocator = By.cssSelector(locatorValue);
			} 
			else if (locatorType.equalsIgnoreCase("xpath")) {
				objectLocator = By.xpath(locatorValue);
			}
			else if (locatorType.equalsIgnoreCase("id")) {
				objectLocator = By.id(locatorValue);
			}
			else if (locatorType.equalsIgnoreCase("name")) {
				objectLocator = By.name(locatorValue);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectLocator;
	}
}
