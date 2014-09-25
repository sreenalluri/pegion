package com.testing.utils;

import java.util.List;

public class ObjectData {
	
	private String pageName;
	private String pageUrl;
	private List<ObjectDetails> pageInputObjects;
	private List<ObjectDetails> pageActionObjects;
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public List<ObjectDetails> getPageInputObjects() {
		return pageInputObjects;
	}
	public void setPageInputObjects(List<ObjectDetails> pageInputObjects) {
		this.pageInputObjects = pageInputObjects;
	}
	public List<ObjectDetails> getPageActionObjects() {
		return pageActionObjects;
	}
	public void setPageActionObjects(List<ObjectDetails> pageActionObjects) {
		this.pageActionObjects = pageActionObjects;
	}
	
}