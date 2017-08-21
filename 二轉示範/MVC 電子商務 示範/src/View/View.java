package View;

import java.util.List;

import Controller.ECommerce;
import Model.Product;
import Model.User;

public interface View {
	public void onStart();
	public void onSignInSuccessfully(User user);
	public void onAccountDuplicated();
	public void onUserNotFound();
	public void onGetProducts(List<Product> products);
	public void onProductCreatedFinsih(User user);
	public void onError(Exception err);
	public void onMoneyNotEnough();
	public State getState();
	public void setState(State state);
	public ECommerce getEcommerce();
}
