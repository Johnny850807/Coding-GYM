package adapter;

import WebServer.WebServer;

public class WebAdapter implements WebService {
    private WebServer webServer;

    public WebAdapter() {
        webServer = WebServer.WebServerFactory.create();
    }

    @Override
    public String request(String url) throws InterruptedException {
        return webServer.request(url);
    }
}