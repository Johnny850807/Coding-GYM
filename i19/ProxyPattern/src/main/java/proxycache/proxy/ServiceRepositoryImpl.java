package proxycache.proxy;

import proxycache.exception.WebException;
import proxycache.webServer.WebServer;

/**
 * @author i19
 */
public class ServiceRepositoryImpl implements Service {
    private final WebServer webServer;

    public ServiceRepositoryImpl() {
        webServer = WebServer.WebServerFactory.create();
    }

    @Override
    public String getName(String name) throws WebException, InterruptedException {
        return webServer.request("https://server.api/product?name=" + name);
    }

    @Override
    public String getId(String id) throws WebException, InterruptedException {
        return webServer.request("https://server.api/product?id=" + id);
    }
}


