package Controller;

import java.util.List;

import Model.Product;
import Model.UserRepository;

public interface ECommerceFactory {
	UserRepository createUserRepository();
	List<Product> createProducts();
}
