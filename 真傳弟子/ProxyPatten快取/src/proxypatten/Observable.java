package proxypatten;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable {
    private List<Observers> observers = new LinkedList<>();

    public Observable() {
    }

    public void add(Observers observer) {
        observers.add(observer);
    }

    public void remove(Observers observer) {
        observers.remove(observer);
    }

    public void response(String content) {
        for (Observers observer : observers) {
            observer.response(content);
        }
    }
}
