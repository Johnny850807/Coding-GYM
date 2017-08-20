package Factory;

import Proxy.Server;
import Proxy.ServerProxy;
import Proxy.WebServerRepository;

public class ServerFactoryImp implements ServerFactory{

	@Override
	public Server createServer() {
		return new ServerProxy(new WebServerRepository());
	}
	
}
