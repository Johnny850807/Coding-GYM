package view;

import controller.EcommerceController;
import view.status.EcommerceState;
import view.status.LoginState;
import view.status.State;

public class StandardView implements View {
    private EcommerceController ecommerceController;
    private State state;

    public StandardView(EcommerceController ecommerceController) {
        this.ecommerceController = ecommerceController;
        state = new LoginState(this);
    }

    @Override
    public void launch() {
        while (true) {
            state.launch();
        }
    }

    @Override
    public void onUpdate(String content) {
        System.out.println(content);
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void onError(Exception err) {
        System.out.println(err.getMessage());
    }

    @Override
    public void loginSuccessful() {
        System.out.println("登入成功");
        setState(new EcommerceState(this));
    }

    @Override
    public EcommerceController getEcommerceController() {
        return ecommerceController;
    }

}
