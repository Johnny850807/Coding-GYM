package Proxy;

import Exception.WebException;
import WebServer.WebServer;
import WebServer.WebServer.WebServerFactory;

// Adapter 
public class WebServerRepository implements Server{
	private WebServer server;
	
	public WebServerRepository(){
		server = WebServerFactory.create();
	}

	@Override
	public String searchByName(String name) throws WebException, InterruptedException {
		return server.request("https://server.api/product?name="+name);
	}

	@Override
	public String searchById(String id) throws WebException, InterruptedException {
		return server.request("https://server.api/product?id="+id);
	}
	
}
