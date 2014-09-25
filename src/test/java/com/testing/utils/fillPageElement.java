package com.testing.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.testing.tests.CommonTest;

public class fillPageElement extends CommonTest {
	
	static Gson gson = new Gson();
	
	public static void fillPage (String objectData, String testData ) throws FileNotFoundException {
		final String dir = System.getProperty("user.dir");
		
		FileReader f1 = new FileReader(dir +"/src/test/resources/com/testing/data/objectData/"+ objectData);
		FileReader f2 = new FileReader(dir +"/src/test/resources/com/testing/data/testData/"+ testData);

		BufferedReader b1 = new BufferedReader(f1);
		BufferedReader b2 = new BufferedReader(f2);

		ObjectData ObjectData = gson.fromJson(b1, ObjectData.class);
		TestData TestData = gson.fromJson(b2, TestData.class);
		
		for (int i=0; i < ObjectData.getPageInputObjects().size(); i++){
			for (int j=0; j < TestData.getPageInputObjects().size(); j++){
				if (ObjectData.getPageInputObjects().get(i).getObjectName().toString().equals(TestData.getPageInputObjects().get(j).getObjectName().toString())) {
					  driver.findElement(getPageElement.getElement(objectData, ObjectData.getPageInputObjects().get(i).getObjectName())).sendKeys(TestData.getPageInputObjects().get(j).getObjectValue());;
				}
			}
		}
	}
}
