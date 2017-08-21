package Proxy;

import Exception.WebException;

public interface Server {
	String searchByName(String name) throws WebException, InterruptedException;
	String searchById(String id) throws WebException, InterruptedException;
}
