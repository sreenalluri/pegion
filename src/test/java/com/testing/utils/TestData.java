package com.testing.utils;

import java.util.List;

public class TestData {
	
	private String pageName;
	private String pageUrl;
	private List<TestDetails> pageInputObjects;
	
	public List<TestDetails> getPageInputObjects() {
		return pageInputObjects;
	}
	public void setPageInputObjects(List<TestDetails> pageInputObjects) {
		this.pageInputObjects = pageInputObjects;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}


}
