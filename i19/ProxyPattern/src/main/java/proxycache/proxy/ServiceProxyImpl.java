package proxycache.proxy;

import proxycache.exception.WebException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author i19
 */
public class ServiceProxyImpl implements Service {
    private final ServiceRepositoryImpl service = new ServiceRepositoryImpl();
    private final Map<String, String> cache = new HashMap<>();

    @Override
    public String getName(String name) throws WebException, InterruptedException {
        if (cache.containsKey(name)) {
            return cache.get(name);
        }
        String id = service.getName(name);
        cache.put(name, id);
        return id;
    }

    @Override
    public String getId(String id) throws WebException, InterruptedException {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        String productDetails = service.getId(id);
        cache.put(id, productDetails);
        return productDetails;
    }
}


