package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;
import java.util.Arrays;
import java.util.List;

public class PriorityHandler extends Handler {
    private static final List<String> HIGH_PRIORITY_KEYWORDS = Arrays.asList(
            "urgent",
            "cannot login",
            "can't login",
            "wifi down",
            "power outage",
            "system down",
            "emergency",
            "immediately",
            "asap",
            "critical"
    );

    @Override
    protected boolean process(SupportRequest req) {
        String msg = req.getMessage().toLowerCase();
        // Naive heuristics for demo
        if (HIGH_PRIORITY_KEYWORDS.stream().anyMatch(msg::contains)) {
            req.setPriority("HIGH");
        } else {
            req.setPriority("NORMAL");
        }
        System.out.println("[Priority] set to: " + req.getPriority());
        return true;
    }
}
