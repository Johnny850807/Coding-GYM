import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class GithubAPI {
	public static final String BASE_URL = "https://api.github.com/";
	public static final String REPO_API = "users/%s/repos" ;
	
	public void getRepositoryList(String userId , OnResponseListener listener) throws Throwable{
		String link = BASE_URL + String.format(REPO_API, userId);
		URL url = new URL(link);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		
		try {
			connection.connect();
			Scanner scanner = new Scanner(connection.getInputStream(),"UTF-8");
			String jsonResult = scanner.nextLine();
			listener.onSuccess(jsonResult);
		} catch (Exception e) {
			listener.onFailed(e);
		} finally{
			connection.disconnect();
		}
		
	}
	
	public static interface OnResponseListener{
		public void onSuccess(String jsonResult);
		public void onFailed(Throwable e) throws Throwable;
	}
}
