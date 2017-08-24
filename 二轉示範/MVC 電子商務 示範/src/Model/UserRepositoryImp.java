package Model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import static Model.XmlUtils.*;

public class UserRepositoryImp implements UserRepository{
	private User user;
	private UserBuilder<Element> builder;
	
	public UserRepositoryImp(UserBuilder<Element> builder) {
		this.builder = builder;
	}

	@Override
	public User register(String name, String account, String password)  throws Exception{
		Element userElement = builder.register(name, account, password).build();
		return user = parseUserByElement(userElement);
	}

	@Override
	public User signIn(String account, String password)  throws Exception{
		Element userElement = builder.signIn(account, password).build();
		user = XmlUtils.parseUserByElement(userElement);
		return user;
	}

	@Override
	public User buyProduct(Product product) throws Exception {
		if (user.getMoney() < product.getPrice())
			throw new MoneyNotEnoughException();
		Element userElement = builder.buyProduct(product).build();
		int length = parseProductElementsUnderUserElement(userElement).size();
		user = parseUserByElement(userElement);
		return user; 
	}
}
