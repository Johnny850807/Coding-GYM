package proxycache.observer;


import proxycache.exception.WebException;
import proxycache.proxy.Service;
import proxycache.proxy.ServiceProxyImpl;

/**
 * @author i19
 */
public class ProductDetail implements Display {
    private final Service serviceProxy = new ServiceProxyImpl();
    @Override
    public void update(String productIds){
        String[] results = productIds.split(",");
        for (String id : results) {
            try {
                System.out.println(serviceProxy.getId(id));
            } catch (WebException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


