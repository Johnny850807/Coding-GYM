package observer;


import exception.WebException;
import proxy.Service;
import proxy.ServiceProxyImpl;
import proxy.ServiceRepositoryImpl;

/**
 * @author i19
 */
public class ProductDetail implements Display {
    private final Service serviceProxy = new ServiceProxyImpl(new ServiceRepositoryImpl());

    @Override
    public void update(String productIds) {
        String[] results = productIds.split(",");
        for (String id : results) {
            try {
                System.out.println(serviceProxy.getProductDetails(id));
            } catch (WebException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


