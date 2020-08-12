package proxypatten;

public class User implements Observers {
    @Override
    public void response(String content) {
        System.out.println(content);
    }
}
