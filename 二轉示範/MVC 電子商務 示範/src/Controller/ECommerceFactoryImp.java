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
		products.add(new Product("水球", 600));
		products.add(new Product("樹枝", 40));
		products.add(new Product("鞋子", 2100));
		products.add(new Product("UML教學", 300));
		products.add(new Product("JAVA教學", 400));
		products.add(new Product("春", 3000));
		return products;
	}


}
