package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;
import com.campushelpdesk.model.SupportTopic;
import com.campushelpdesk.strategy.SupportStrategy;

public class SupportHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        SupportTopic topic = req.getTopic() == null ? SupportTopic.GENERAL : req.getTopic();
        SupportStrategy strategy = topic.getStrategy();
        String resp = strategy.respond(req);
        req.setResponse(resp);
        System.out.println("[Support] response generated with " + topic.getDisplayName() + " strategy.");
        return true;
    }
}
