package com.testing.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;

public class RestClient {
	public static final int HTTP_OK = 200;
	public static final String SERVER_URL = "BASE URL OF THE REST SERVER";

	public static HttpResponse doGet(URI uri, List<NameValuePair> headers)
			throws HttpException, IOException, URISyntaxException {
		final HttpClient httpClient = new DefaultHttpClient();
		HttpConnectionParams
				.setConnectionTimeout(httpClient.getParams(), 10000);
		HttpGet httpGet = new HttpGet(uri);
		Iterator<NameValuePair> iterator = headers.iterator();
		Reporter.log("--------------------------------------------");
		Reporter.log("Headers");
		while (iterator.hasNext()) {
			NameValuePair header = iterator.next();
			httpGet.addHeader(header.getName(), header.getValue());
			Reporter.log(header.getName() + "=" + header.getValue());
		}
		Reporter.log("Request URI= GET " + uri + "");
		System.out.println("Request URI= GET " + uri + "");
		// Execute Get request
		HttpResponse response = httpClient.execute(httpGet);
		Reporter.log("Response");
		Reporter.log("---------");
		Reporter.log("Status =" + response.getStatusLine().getStatusCode()
				+ " " + response.getStatusLine().getReasonPhrase() + "");
		Reporter.log("Response Body:");// + getResponseBody(response) );
		return response;
	}

	public static HttpResponse doPost(URI uri, List<NameValuePair> headers,
			HttpEntity stringEntity) throws URISyntaxException, HttpException,
			IOException {
		final HttpClient httpClient = new DefaultHttpClient();

		HttpConnectionParams
				.setConnectionTimeout(httpClient.getParams(), 10000);

		HttpPost httpPost = new HttpPost(uri);
		Iterator<NameValuePair> iterator = headers.iterator();
		Reporter.log("--------------------------------------------");
		Reporter.log("Headers");
		while (iterator.hasNext()) {
			NameValuePair header = iterator.next();
			httpPost.addHeader(header.getName(), header.getValue());
			Reporter.log(header.getName() + "=" + header.getValue());
		}
		Reporter.log("Request URI= POST " + uri + "");

		Reporter.log("Request Body:-<br>"
				+ EntityUtils.toString(stringEntity, "utf-8")
				+ "<br>---------<br>");

		httpPost.setEntity(stringEntity);
		// Execute Post request
		HttpResponse response = httpClient.execute(httpPost);
		Reporter.log("Response");
		Reporter.log("---------");
		Reporter.log("Status =" + response.getStatusLine().getStatusCode()
				+ " " + response.getStatusLine().getReasonPhrase() + "");
		Reporter.log("Response Body:");// + getResponseBody(response) );
		return response;
	}

	public static HttpResponse doPut(URI uri, List<NameValuePair> headers,
			HttpEntity stringEntity) throws URISyntaxException, HttpException,
			IOException {
		final HttpClient httpClient = new DefaultHttpClient();

		HttpConnectionParams
				.setConnectionTimeout(httpClient.getParams(), 10000);
		HttpPut httpPut = new HttpPut(uri);
		Iterator<NameValuePair> iterator = headers.iterator();
		Reporter.log("--------------------------------------------");
		Reporter.log("Headers");
		while (iterator.hasNext()) {
			NameValuePair header = iterator.next();
			httpPut.addHeader(header.getName(), header.getValue());
			Reporter.log(header.getName() + "=" + header.getValue());
		}
		Reporter.log("Request URI= PUT " + uri + "");
		Reporter.log("Request Body:-<br>"
				+ EntityUtils.toString(stringEntity, "utf-8")
				+ "<br>---------<br>");

		httpPut.setEntity(stringEntity);
		// Execute Put request
		HttpResponse response = httpClient.execute(httpPut);
		Reporter.log("Response");
		Reporter.log("---------");
		Reporter.log("Status =" + response.getStatusLine().getStatusCode()
				+ " " + response.getStatusLine().getReasonPhrase() + "");
		Reporter.log("Response Body:");// + getResponseBody(response) );
		return response;
	}

	public static HttpResponse doDelete(URI uri, List<NameValuePair> headers)
			throws ClientProtocolException, IOException {
		final HttpClient httpClient = new DefaultHttpClient();

		HttpConnectionParams
				.setConnectionTimeout(httpClient.getParams(), 10000);

		HttpDelete httpDelete = new HttpDelete(uri);
		Iterator<NameValuePair> iterator = headers.iterator();
		Reporter.log("--------------------------------------------");
		Reporter.log("Headers");
		while (iterator.hasNext()) {
			NameValuePair header = iterator.next();
			httpDelete.addHeader(header.getName(), header.getValue());
			Reporter.log(header.getName() + "=" + header.getValue());
		}
		Reporter.log("Request URI= DELETE " + uri + "");
		// Execute Delete request
		HttpResponse response = httpClient.execute(httpDelete);
		Reporter.log("Response");
		Reporter.log("---------");
		Reporter.log("Status =" + response.getStatusLine().getStatusCode()
				+ " " + response.getStatusLine().getReasonPhrase() + "");
		Reporter.log("Response Body:");// + getResponseBody(response) );

		return response;
	}

}
