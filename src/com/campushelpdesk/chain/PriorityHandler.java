package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;

public class PriorityHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        String msg = req.getMessage().toLowerCase();
        // Naive heuristics for demo
        if (msg.contains("urgent") || msg.contains("cannot login") || msg.contains("wifi down") || msg.contains("power outage")) {
            req.setPriority("HIGH");
        } else {
            req.setPriority("NORMAL");
        }
        System.out.println("[Priority] set to: " + req.getPriority());
        return true;
    }
}
