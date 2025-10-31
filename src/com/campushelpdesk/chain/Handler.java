package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;

public abstract class Handler {
    private Handler next;

    public Handler setNext(Handler next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
        return this;
    }

    public void handle(SupportRequest req) {
        if (process(req) && next != null) {
            next.handle(req);
        }
    }

    protected abstract boolean process(SupportRequest req);
}
