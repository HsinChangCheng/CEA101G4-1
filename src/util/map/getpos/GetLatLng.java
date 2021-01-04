package util.map.getpos;

import com.google.gson.*;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetLatLng {
	public static String GOOGLE_URL = "https://maps.googleapis.com/maps/api/geocode/json?"
			+ "language=zh-TW&address=";
	
	public static JsonObject getJsonDataFromGoogle(String address) throws Exception {
		
		String args2 =  address + "&key=" + Util.MAP_KEY;
		URL url = new URL(GOOGLE_URL + args2);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
			
		int statusCode = con.getResponseCode();
		StringBuilder sb = new StringBuilder();

		if (statusCode == 200) {
			InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String data;
			while ((data = br.readLine()) != null) {
				sb.append(data);
			}
			br.close();
			isr.close();
			is.close();
			con.disconnect();
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject jsonObj = gson.fromJson(sb.toString(), JsonObject.class);
		return jsonObj;
	}
	
	public static JsonObject getJsonFromFile(String file) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = null;
        
        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonObj = (JsonObject) obj;

        } catch (IOException e) {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public static JsonObject transAddToPos(String address) throws Exception {
		JsonObject jsonObj = getJsonDataFromGoogle(address);
		JsonObject location = jsonObj.get("results").getAsJsonArray().get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
		return location;
	}
	
	public static void main(String args[]) throws Exception {
		// []就用getAsJsonArray 再用index取, {}就用Object
		JsonObject location = transAddToPos("桃園市桃園區民族路52號");
		
		System.out.println("location = " + location);
		System.out.println("lat = " + location.get("lat").getAsDouble());
		System.out.println("lng = " + location.get("lng").getAsDouble());

		}
}
