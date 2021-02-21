package proxy;

import exception.WebException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author i19
 */
public class ServiceProxyImpl implements Service {
    private final Service service;
    private final Map<String, String> cache = new HashMap<>();

    public ServiceProxyImpl(Service service) {
        this.service = service;
    }

    @Override
    public String getIds(String name) throws WebException, InterruptedException {
        if (cache.containsKey(name)) {
            return cache.get(name);
        }
        String id = service.getIds(name);
        cache.put(name, id);
        return id;
    }

    @Override
    public String getProductDetails(String id) throws WebException, InterruptedException {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        String productDetails = service.getProductDetails(id);
        cache.put(id, productDetails);
        return productDetails;
    }
}


