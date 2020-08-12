package model;

import model.login.LoginSystem;
import model.login.dao.User;
import model.market.Market;

public abstract class AbstractEcommerceSystem implements EcommerceSystem {
    protected LoginSystem loginSystem;
    protected Market market;
    protected User user;

    public AbstractEcommerceSystem(LoginSystem loginSystem, Market market) {
        this.loginSystem = loginSystem;
        this.market = market;
    }

    public LoginSystem getLoginSystem() {
        return loginSystem;
    }

    public void setLoginSystem(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
