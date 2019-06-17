package hska.iwi.eShopMaster.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class RequestHelper<REQUEST, RESPONSE> {
	

	public RESPONSE fetchContent(String uri, String reqMessage, REQUEST request) throws IOException {
		
		final int OK = 200;
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(reqMessage);

		int responseCode = connection.getResponseCode();
		if(responseCode == OK) {
			if(request != null) {
				Gson gson = new Gson();
				String json = gson.toJson(request); 
				OutputStream os = connection.getOutputStream();
				os.write(json.getBytes());
				os.flush();
			}
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			return this.parseObject(response.toString());
		}
			
		return null;
	}
	
	private RESPONSE parseObject(String response) {
		GsonBuilder gson = new GsonBuilder();
	    Type collectionType = new TypeToken<RESPONSE>(){}.getType();

	    RESPONSE res = gson.create().fromJson(response, collectionType);
	    return res;
	}

}
