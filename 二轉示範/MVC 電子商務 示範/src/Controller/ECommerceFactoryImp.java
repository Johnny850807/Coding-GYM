package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Product;
import Model.UserRepository;
import Model.UserRepositoryImp;
import Model.XmlUserBuilder;

//Abstract factory
public class ECommerceFactoryImp implements ECommerceFactory{

	@Override
	public UserRepository createUserRepository() {
		return new UserRepositoryImp(new XmlUserBuilder());
	}

	@Override
	public List<Product> createProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product("���y", 600));
		products.add(new Product("��K", 40));
		products.add(new Product("�c�l", 2100));
		products.add(new Product("UML�о�", 300));
		products.add(new Product("JAVA�о�", 400));
		products.add(new Product("�K", 3000));
		return products;
	}


}
