package com.elektrobit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestBuilder {

	public static class RequestResponse {

		public final String body;
		public final int statusCode;

		public RequestResponse(String body, int statusCode) {
			this.body = body;
			this.statusCode = statusCode;
		}
	}

	private HttpURLConnection connection;
	private String url;
	private String method;

	public HttpRequestBuilder setUrl(String url) {
		this.url = url;
		return this;
	}

	public HttpRequestBuilder setMethod(String method) {
		this.method = method;
		return this;
	}

	public HttpRequestBuilder initializeConnection() throws IOException {
		final URL url = new URL(this.url);
		this.connection = (HttpURLConnection) url.openConnection();
		this.connection.setRequestMethod(this.method);
		return this;
	}

	public HttpRequestBuilder initializeConnection(HttpURLConnection connection) throws IOException {
		this.connection = connection;
		return this;
	}

	public HttpRequestBuilder setTimeout(int timeout) {
		this.connection.setConnectTimeout(timeout);
		this.connection.setReadTimeout(timeout);
		return this;
	}

	public HttpRequestBuilder setAuthorization(String authorization) {
		this.connection.setRequestProperty("Authorization", authorization);
		return this;
	}

	public HttpRequestBuilder addCorsHeader() {
		this.connection.addRequestProperty("Access-Control-Allow-Origin", "*");
		return this;
	}

	public HttpRequestBuilder setJsonTrue() {
		this.connection.addRequestProperty("json", "true");
		return this;
	}

	public HttpRequestBuilder addBody(String body) throws IOException {
		this.connection.setDoOutput(true);
		final OutputStreamWriter out = new OutputStreamWriter(this.connection.getOutputStream());
		out.write(body);
		out.close();
		return this;
	}

	public RequestResponse invoke() throws IOException {
		final StringBuffer response = new StringBuffer();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(this.connection.getInputStream()))) {
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		}
		this.connection.disconnect();

		return new RequestResponse(response.toString(), this.connection.getResponseCode());
	}

	public void cleanFields() {
		this.connection = null;
		this.method = null;
		this.url = null;
	}

}
