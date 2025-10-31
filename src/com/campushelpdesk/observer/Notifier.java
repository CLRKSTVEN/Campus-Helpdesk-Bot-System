package com.campushelpdesk.observer;

import com.campushelpdesk.model.SupportRequest;
import java.util.ArrayList;
import java.util.List;

public class Notifier {
    private final List<HelpdeskObserver> observers = new ArrayList<>();

    public void subscribe(HelpdeskObserver obs) {
        observers.add(obs);
    }

    public void unsubscribe(HelpdeskObserver obs) {
        observers.remove(obs);
    }

    public void notifyAllObservers(SupportRequest req) {
        for (HelpdeskObserver o : observers) {
            o.onRequestUpdate(req);
        }
    }
}
