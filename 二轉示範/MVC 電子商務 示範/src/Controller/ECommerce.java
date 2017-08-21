package Controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.AccountDuplicatedException;
import Model.MoneyNotEnoughException;
import Model.Product;
import Model.User;
import Model.UserNotFoundException;
import Model.UserRepository;
import View.View;

public class ECommerce {
	private View view;
	private User user;
	private UserRepository userRepository;
	private ECommerceFactory eCommerceFactory;
	protected List<Product> products;

	
	private ECommerce(ECommerceFactory eCommerceFactory) {
		this.eCommerceFactory = eCommerceFactory;
		reset();
	}
	
	public void reset() {
		this.userRepository = eCommerceFactory.createUserRepository();
		this.products = eCommerceFactory.createProducts();
	}
	
	public static ECommerce create(ECommerceFactory eCommerceFactory) {
		return new ECommerce(eCommerceFactory);
	}
	
	public static ECommerce create() {
		return new ECommerce(new ECommerceFactoryImp());
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void register(String name, String account, String password) {
		new Thread() {
			@Override
			public void run() {
				try {
					user = userRepository.register(name, account, password);
					view.onSignInSuccessfully(user);
				} catch (AccountDuplicatedException e) {
					view.onAccountDuplicated();
				}catch (Exception e) {
					view.onError(e);
				}
			}
		}.start();
	}
	
	public void signIn(String account, String password) {
		new Thread() {
			@Override
			public void run() {
				try {
					user = userRepository.signIn(account, password);
					view.onSignInSuccessfully(user);
				} catch (UserNotFoundException e) {
					view.onUserNotFound();
				}catch (Exception e) {
					view.onError(e);
				}
				
			}
		}.start();
	}

	public void showProducts() {
		new Thread() {
			@Override
			public void run() {
				view.onGetProducts(products);
			}
		}.start();
	}
	
	public void buyProductByIndex(int index) {
		new Thread() {
			@Override
			public void run() {
				try {
					user = userRepository.buyProduct(products.get(index));
					view.onProductCreatedFinsih(user);
				} catch (MoneyNotEnoughException e) {
					view.onMoneyNotEnough();
				} catch (ArrayIndexOutOfBoundsException e) {
					view.onProductIndexError();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
}
