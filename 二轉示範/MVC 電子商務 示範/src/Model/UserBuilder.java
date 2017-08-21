package Model;

public interface UserBuilder<Result> {
	UserBuilder<Result> register(String name, String account, String password) throws Exception;
	UserBuilder<Result> signIn(String account, String password) throws Exception;
	UserBuilder<Result> buyProduct(Product product) throws Exception;
	Result build();
}
