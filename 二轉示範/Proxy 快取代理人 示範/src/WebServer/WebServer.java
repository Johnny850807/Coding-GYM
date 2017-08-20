package WebServer;

import java.util.ArrayList;
import java.util.List;

import Exception.WebException;
import Product.Product;

public final class WebServer {
	private List<Product> products = new ArrayList<>();
	private final static String BASEURI = "https://server.api";
	private final static String RESOURCE = "/product";
	
	public String request(String url) throws WebException, InterruptedException{
		Thread.sleep(3000);
		if (checkUrlValid(url))
			return parseParameter(url);
		
		throw new WebException("Error 500, ���A�����~�C");
	}
	
	private boolean checkUrlValid(String url) throws WebException{
		url = url.trim();
		if (!url.startsWith(BASEURI+RESOURCE))
			throw new WebException("Error 400, �L�k�ѪRURL�r��C");
		if (url.contains("?"))
		{
			if (!url.contains("name=") && !url.contains("id="))
				throw new WebException("Error 400, �ݸ��᭱�����򱵵۰ѼơC");
			if (url.split("=").length == 1)
				throw new WebException("Error 400, ������J�ѼƦb����᭱");
		}
		return true;
	}
	
	private String parseParameter(String url){
		if (url.contains("="))
		{
			if (url.contains("name"))
				return seachByname(url.split("=")[1]);
			if (url.contains("id"))
				return seachById(url.split("=")[1]);
		}

		
		return parseList(products);
	}
	
	private String seachByname(String name){
		List<Product> search = new ArrayList<>();
		for (Product product : products)
			if (product.getName().contains(name))
				search.add(product);
		return parseList(search);
	}
	
	private String seachById(String uuid){
		List<Product> search = new ArrayList<>();
		for (Product product : products)
			if (product.getUuid().contains(uuid))
				search.add(product);
		return search.get(0).toString();
	}
	
	private String parseList(List<Product> result){
		StringBuffer sb = new StringBuffer();
		if (result.size() == 0)
			return "";
		
		for (Product product : result)
			sb.append(product.getUuid()).append(",");
		
		String text = sb.toString();
		text = text.substring(0, text.length()-1);
		
		return text;
	}
	
	public static class WebServerFactory {
		private static WebServer server;
		
		public static WebServer create(){
			if (server == null)
			{
				server = new WebServer();
				server.products.add(new Product("�Ψm", 100, 10.7, 15.5));
				server.products.add(new Product("�c�l", 170, 27.7, 2.5));
				server.products.add(new Product("�O�I�M", 40, 1.7, 0.5));
				server.products.add(new Product("�O�R�s", 50, 1.7, 4.6));
				server.products.add(new Product("�O�@��", 80, 20.7, 0.6));
				server.products.add(new Product("�j�K�O�I", 400, 18.7, 4.45));
				server.products.add(new Product("�Ϊo", 500, 17.7, 3.65));
				server.products.add(new Product("��", 190, 20.7, 2.58));
				server.products.add(new Product("���Y", 100, 16.7, 2.3));
				server.products.add(new Product("��K", 20, 14.7, 1.524));
				server.products.add(new Product("����", 70, 13.7, 7.5));
				server.products.add(new Product("���}��", 500, 37.7, 12.7));
			}
			
			return server;
		}
	}
	/*
	public static void main(String[] argv){
		WebServer server = WebServerFactory.create();
		try {
			String result = server.request("https://server.api/product?name=�O");
			System.out.println(result);
			String[] uuids = result.split(",");
			for (String id : uuids)
				System.out.println(server.request("https://server.api/product?id="+id) + "\n");
		} catch (WebException | InterruptedException e) {
			e.printStackTrace();
		}
	}*/
}
