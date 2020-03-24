package com.elektrobit;

/**
 * @see<a href="https://docs.postman-echo.com/?version=latest">Postman</a>
 */
public class HttpRequestLoader {

	private HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();

	public HttpRequestBuilder.RequestResponse requestWithAuthorization(String url, String authorization)
			throws Exception {
		HttpRequestBuilder.RequestResponse response = this.httpRequestBuilder.setUrl(url) //
				.setMethod("GET") //
				.initializeConnection() //
				.setAuthorization(authorization) //
				.invoke();

		System.out.println("respose: " + response.body + " status code: " + response.statusCode);
		return response;

	}

	public static void main(String[] args) throws Exception {
		new HttpRequestLoader().requestWithAuthorization("https://postman-echo.com/basic-auth",
				"Basic cG9zdG1hbjpwYXNzd29yZA==");

	}

}
