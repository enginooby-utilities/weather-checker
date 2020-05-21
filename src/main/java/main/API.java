package main;

import java.io.IOException;

import org.json.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class API {
	private String host;
	// Headers for a request
	private String x_rapidapi_host;
	private String api_key;
	private String query;

	public API() {
	}



	public ResponseBody getRapidApiResponseBody() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(host + "?" + query).get()
				.addHeader("x-rapidapi-host", x_rapidapi_host).addHeader("x-rapidapi-key", api_key).build();
		ResponseBody responseBody = client.newCall(request).execute().body();
		return responseBody;
	}

	public JSONObject getGoogleApiObjResponse() throws UnirestException {
		HttpResponse<JsonNode> response = Unirest.get(host + "json" + "?" + query + api_key).asJson();
		return response.getBody().getObject();
	}

	public String getHost() {
		return host;
	}

	public String getX_rapidapi_host() {
		return x_rapidapi_host;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setX_rapidapi_host(String x_rapidapi_host) {
		this.x_rapidapi_host = x_rapidapi_host;
	}

	public void setApi_key(String x_rapiapi_key) {
		this.api_key = x_rapiapi_key;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
