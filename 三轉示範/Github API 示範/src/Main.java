import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
	static List<Repository> repoList = new ArrayList<Repository>();
	public static void main(String[] args) {
		GithubAPI github = new GithubAPI();
		try {
			github.getRepositoryList("johnny850807", new GithubAPI.OnResponseListener() {
				@Override
				public void onSuccess(String jsonResult) {
					parseJsonToRepoList(jsonResult);
					printRepoList();
				}
				
				@Override
				public void onFailed(Throwable e) throws Throwable {
					throw e;
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	static void parseJsonToRepoList(String json){
		Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Repository>>() {}.getType();
        repoList = gson.fromJson(json, listType);
	}
	
	static void printRepoList(){
		for (Repository r : repoList )
			System.out.println(r);
	}

}
