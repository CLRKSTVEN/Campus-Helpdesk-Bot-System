package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;

public class SpamFilterHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        String msg = req.getMessage().toLowerCase();
        boolean looksSpam = msg.trim().isEmpty()
                || msg.contains("buy now")
                || msg.contains("free money")
                || msg.contains("visit my channel");
        if (looksSpam) {
            req.setSpam(true);
            System.out.println("[SpamFilter] rejected as spam.");
            return false; // stop chain
        }
        System.out.println("[SpamFilter] ok");
        return true;
    }
}
