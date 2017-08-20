package Proxy;

import java.util.HashMap;
import java.util.Map;

import Exception.WebException;

//Cache Proxy
public class ServerProxy implements Server{
	private Server server;
	private Map<String,String> cache = new HashMap<>();	
	
	public ServerProxy(Server server){
		this.server = server;
	}
	
	@Override
	public String searchByName(String name) throws WebException, InterruptedException {
		if (cache.containsKey(name))
			return cache.get(name);
		String result = server.searchByName(name);
		cache.put(name, result);
		return result;
	}

	@Override
	public String searchById(String id) throws WebException, InterruptedException {
		if (cache.containsKey(id))
			return cache.get(id);
		String result = server.searchById(id);
		cache.put(id, result);
		return result;
	}


}
