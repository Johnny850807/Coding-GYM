package view;

import controller.EcommerceController;
import view.status.State;

public interface View {
    void launch();

    void onUpdate(String content);

    void setState(State state);

    void onError(Exception err);

    void loginSuccessful();

    EcommerceController getEcommerceController();

}
