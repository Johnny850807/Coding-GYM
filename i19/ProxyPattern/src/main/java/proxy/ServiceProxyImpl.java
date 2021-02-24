package proxy;

import exception.WebException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author i19
 */
public class ServiceProxyImpl implements Service {
    private final Service service;
    private final Map<String, String> cacheIds = new HashMap<>();
    private final Map<String, String> cacheProductDetails = new HashMap<>();


    public ServiceProxyImpl(Service service) {
        this.service = service;
    }

    @Override
    public String getIds(String name) throws WebException, InterruptedException {
        if (cacheIds.containsKey(name)) {
            return cacheIds.get(name);
        }
        String id = service.getIds(name);
        cacheIds.put(name, id);
        return id;
    }

    @Override
    public String getProductDetails(String id) throws WebException, InterruptedException {
        if (cacheProductDetails.containsKey(id)) {
            return cacheProductDetails.get(id);
        }
        String productDetails = service.getProductDetails(id);
        cacheProductDetails.put(id, productDetails);
        return productDetails;
    }
}


