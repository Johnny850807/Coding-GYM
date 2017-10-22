import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
	private static final String API = "https://api.github.com/users/johnny850807/repos";
	private static Gson gson = new Gson();
	
	public static void main(String[] args) {
		try{
			String result = sendHttpRequest();
			System.out.println(result);
			List<Response> response = parse(result);
			System.out.println(response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String sendHttpRequest() throws Exception{
        URL obj = new URL(API);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

		return response.toString();
	}
	
	private static List<Response> parse(String result){
		Type listType = new TypeToken<ArrayList<Response>>(){}.getType();
		return gson.fromJson(result, listType);
	}

	
	private static class Response{
		private int id;
		private String name;
		private String description;
		
		public Response(){}

		@Override
		public String toString() {
			return String.format("±M®×:  %d\n--¦WºÙ: %s\n--´y­z: %s\n", id, name, description);
		}
	}
}