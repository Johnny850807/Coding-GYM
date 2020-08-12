package proxypatten;

public class ServerSubject extends Observable {
    private Server server;

    public ServerSubject(Server server) {
        this.server = server;
    }

    public void request(String thingName) {
        new Thread(() -> {
            response(server.request(thingName));
        }).start();

    }
}
