package proxy;

import exception.WebException;

/**
 * @author i19
 */
public interface Service {
    String getIds(String name) throws WebException, InterruptedException;

    String getProductDetails(String id) throws WebException, InterruptedException;
}


