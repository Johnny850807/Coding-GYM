package View;

import java.util.List;

import Controller.ECommerce;
import Model.Product;
import Model.User;

public class ViewImp implements View{
	private ECommerce ecommerce;
	private State state;
	
	
	public ViewImp(ECommerce ecommerce) {
		this.ecommerce = ecommerce;
		state = new SigningState(this);
	}
	
	@Override
	public void onStart() {
		state.showUi();
	}
	
	@Override
	public void onSignInSuccessfully(User user) {
		state = new EcommerceState(user, this);
		state.showUi();
	}
	
	@Override
	public void onGetProducts(List<Product> products) {
		for (int i = 0 ; i < products.size() ; i ++ )
		{
			Product product = products.get(i);
			System.out.println("("+i+") "+product.getName() + " - " + product.getPrice());
		}
	}
	
	@Override
	public void onMoneyNotEnough() {
		System.out.println("金錢不足。");
	}

	@Override
	public void onAccountDuplicated() {
		System.out.println("帳號重複已存在");
		state.showUi();
	}

	@Override
	public void onUserNotFound() {
		System.out.println("帳號或密碼錯誤");
		state.showUi();
	}

	@Override
	public void onProductCreatedFinsih(User user) {
		state.showUi();
		
	}

	@Override
	public void onError(Exception err) {
		err.printStackTrace();
		System.exit(0);
	}

	@Override
	public State getState() {
		return state;
	}
	
	@Override
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public ECommerce getEcommerce() {
		return ecommerce;
	}


}
