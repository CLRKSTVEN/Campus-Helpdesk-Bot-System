package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;
import com.campushelpdesk.model.SupportTopic;
import com.campushelpdesk.util.TicketGenerator;

public class AssignmentHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        SupportTopic topic = req.getTopic() == null ? SupportTopic.GENERAL : req.getTopic();
        req.setAssignedOffice(topic.getAssignedOffice());
        req.setTicketId(TicketGenerator.next(topic.getCode()));
        System.out.println("[Assignment] office: " + topic.getAssignedOffice() + " | ticket: " + req.getTicketId());

        // Notify observers
        if (req.getNotifier() != null) {
            req.getNotifier().notifyAllObservers(req);
        }
        return true;
    }
}
