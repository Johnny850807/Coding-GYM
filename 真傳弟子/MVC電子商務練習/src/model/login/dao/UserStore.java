package model.login.dao;

import model.market.Product;
import model.market.StandardProduct;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserStore {
    private final String path = "./User.json";
    private File file = new File(path);
    private List<User> users = new ArrayList<>();

    public UserStore() {
        init();
        loadAllUsers();
    }

    public void init() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAllUsers() {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }
            ObjectMapper mapper = new ObjectMapper();

            if (stringBuilder.length() != 0) {
                JsonNode rootNode = mapper.readTree(stringBuilder.toString());

                for (JsonNode jsonNode : rootNode) {
                    User user = new NormalUser(jsonNode.path("account").getTextValue(),
                            jsonNode.path("password").getTextValue());
                    for (JsonNode heldProduct : jsonNode.path("heldProducts")) {
                        Product product = new StandardProduct(heldProduct.path("name").getTextValue(),
                                heldProduct.path("money").getIntValue());
                        user.addHeldProduct(product);
                    }
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(users);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpNewUser(User user) {
        users.add(user);
    }

    public User findSameAccount(String account) {
        for (User user : users) {
            if (user.getAccount().equals(account)) {
                return user;
            }
        }
        return null;
    }
}
