package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;
import com.campushelpdesk.model.SupportTopic;

public class TriageHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        SupportTopic topic = SupportTopic.fromMessage(req.getMessage());
        req.setTopic(topic);
        System.out.println("[Triage] topic: " + topic.getDisplayName());
        return true;
    }
}
