package proxycache.proxy;

import proxycache.exception.WebException;

/**
 * @author i19
 */
public interface Service {
     String getName(String name) throws WebException, InterruptedException;
     String getId(String id) throws WebException, InterruptedException;
}


