package proxy;

import exception.WebException;
import webServer.WebServer;

/**
 * @author i19
 */
public class ServiceRepositoryImpl implements Service {
    private final WebServer webServer;

    public ServiceRepositoryImpl() {
        webServer = WebServer.WebServerFactory.create();
    }

    @Override
    public String getIds(String name) throws WebException, InterruptedException {
        return webServer.request("https://server.api/product?name=" + name);
    }

    @Override
    public String getProductDetails(String id) throws WebException, InterruptedException {
        return webServer.request("https://server.api/product?id=" + id);
    }
}


