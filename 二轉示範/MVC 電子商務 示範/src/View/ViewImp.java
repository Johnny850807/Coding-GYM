package View;

import java.util.List;

import Controller.ECommerce;
import Model.Product;
import Model.User;
import Util.Input;

public class ViewImp implements View{
	private ECommerce ecommerce;
	private State state;
	private User user;
	
	
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
		state = new EcommerceState(this);
		this.user = user;
		System.out.println(user);		
		state.showUi();
	}
	
	@Override
	public void onGetProducts(List<Product> products) {
		for (int i = 0 ; i < products.size() ; i ++ )
		{
			Product product = products.get(i);
			System.out.println("("+i+") "+product.getName() + " - " + product.getPrice());
		}
		ecommerce.buyProductByIndex(Input.nextInt("現有金錢: " + user.getMoney() + ", 輸入欲購買編號"));
	}
	
	@Override
	public void onMoneyNotEnough() {
		System.out.println("金錢不足。");
		state.showUi();
	}
	
	@Override
	public void onProductIndexError() {
		System.out.println("輸入錯誤");
		state.showUi();
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
		this.user = user;
		System.out.println("購買成功 !!");
		System.out.println(user);
		state.showUi();
	}
	
	@Override
	public void onShowUserProductsFinish() {
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

	@Override
	public User getUser() {
		return user;
	}

}
