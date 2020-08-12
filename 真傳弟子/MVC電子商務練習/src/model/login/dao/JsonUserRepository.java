package model.login.dao;

public class JsonUserRepository implements UserRepository {
    UserStore userStore;

    public JsonUserRepository() {
        userStore = new UserStore();
    }

    @Override
    public void setUpNewUser(User user) {
        userStore.setUpNewUser(user);
        save();
    }

    @Override
    public void save() {
        userStore.save();
    }

    @Override
    public User getUser(String account) {
        return userStore.findSameAccount(account);
    }

}
