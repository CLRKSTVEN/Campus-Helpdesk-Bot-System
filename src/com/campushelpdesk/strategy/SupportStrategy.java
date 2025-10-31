package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public interface SupportStrategy {
    String respond(SupportRequest req);
}
