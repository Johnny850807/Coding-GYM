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
    public void onUpdate(String name) {
        try {
            String idsResult = serviceProxy.getIds(name);
            String[] results = idsResult.split(",");
            for (String id : results) {
                System.out.println(serviceProxy.getProductDetails(id));
            }
        } catch (WebException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


