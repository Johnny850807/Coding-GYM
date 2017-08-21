package Model;

import javax.imageio.spi.RegisterableService;

public interface UserRepository {
	public User register(String name, String account, String password) throws Exception;
	public User signIn(String account, String password) throws Exception;
	public User buyProduct(Product product) throws Exception;
}
