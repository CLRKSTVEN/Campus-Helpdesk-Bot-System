package com.campushelpdesk.observer;

import com.campushelpdesk.model.SupportRequest;

public interface HelpdeskObserver {
    void onRequestUpdate(SupportRequest req);
}
