package proxycache.webServer;


import proxycache.exception.WebException;
import proxycache.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author i19
 */
public class WebServer {
    private List<Product> products = new ArrayList<>();
    private final static String BASEURI = "https://server.api";
    private final static String RESOURCE = "/product";

    public String request(String url) throws WebException, InterruptedException{
        Thread.sleep(1500);
        if (checkUrlValid(url)) {
            return parseParameter(url);
        }
        throw new WebException("Error 500, 伺服器錯誤。");
    }

    private boolean checkUrlValid(String url) throws WebException{
        url = url.trim();
        if (!url.startsWith(BASEURI+RESOURCE)) {
            throw new WebException("Error 400, 無法解析URL字串。");
        }
        if (url.contains("?"))
        {
            if (!url.contains("name=") && !url.contains("id=")) {
                throw new WebException("Error 400, 問號後面必須緊接著參數。");
            }
            if (url.split("=").length == 1) {
                throw new WebException("Error 400, 必須輸入參數在等於後面");
            }
        }
        return true;
    }

    private String parseParameter(String url){
        if (url.contains("=")) {
            if (url.contains("name")) {
                return seachByname(url.split("=")[1]);
            }
            if (url.contains("id")) {
                return seachById(url.split("=")[1]);
            }
        }


        return parseList(products);
    }

    private String seachByname(String name){
        List<Product> search = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                search.add(product);
            }
        }
        return parseList(search);
    }

    private String seachById(String uuid){
        List<Product> search = new ArrayList<>();
        for (Product product : products) {
            if (product.getUuid().contains(uuid)) {
                search.add(product);
            }
        }
        return search.get(0).toString();
    }

    private String parseList(List<Product> result){
        StringBuffer sb = new StringBuffer();
        if (result.size() == 0) {
            return "";
        }

        for (Product product : result) {
            sb.append(product.getUuid()).append(",");
        }

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
                server.products.add(new Product("肥皂", 100, 10.7, 15.5));
                server.products.add(new Product("鞋子", 170, 27.7, 2.5));
                server.products.add(new Product("保險套", 40, 1.7, 0.5));
                server.products.add(new Product("保麗龍", 50, 1.7, 4.6));
                server.products.add(new Product("保護膜", 80, 20.7, 0.6));
                server.products.add(new Product("槍枝保險", 400, 18.7, 4.45));
                server.products.add(new Product("肥油", 500, 17.7, 3.65));
                server.products.add(new Product("魚", 190, 20.7, 2.58));
                server.products.add(new Product("罐頭", 100, 16.7, 2.3));
                server.products.add(new Product("樹枝", 20, 14.7, 1.524));
                server.products.add(new Product("釣竿", 70, 13.7, 7.5));
                server.products.add(new Product("牛飼料", 500, 37.7, 12.7));
            }

            return server;
        }
    }
	/*
	public static void main(String[] argv){
		WebServer server = WebServerFactory.create();
		try {
			String result = server.request("https://server.api/product?name=保");
			System.out.println(result);
			String[] uuids = result.split(",");
			for (String id : uuids)
				System.out.println(server.request("https://server.api/product?id="+id) + "\n");
		} catch (WebException | InterruptedException e) {
			e.printStackTrace();
		}
	}*/
}





