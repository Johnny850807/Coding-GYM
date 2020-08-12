package proxypatten;


import java.util.HashMap;
import java.util.Map;

public class WebSeverProxy implements Server {
    private WebService webService;
    private Map<String, String> cache = new HashMap<>(); //<Name, content>

    public WebSeverProxy(WebService webSeverTarget) {
        this.webService = webSeverTarget;
    }

    @Override
    public String request(String thingName) {
        if (cache.containsKey(thingName)) {
            return cache.get(thingName);
        }
        String content = null;
        try {
            String id = webService.request("https://server.api/product?name=" + thingName);
            content = webService.request("https://server.api/product?id=" + id);
            cache.put(thingName, content);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return content;
    }
}
