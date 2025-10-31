package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public class GeneralSupportStrategy implements SupportStrategy {
    @Override
    public String respond(SupportRequest req) {
        return "Thanks for reaching out! We have logged your request"
                + formatPriority(req)
                + ". Our campus helpdesk team will review the details and route it to the correct department. "
                + followUp(req);
    }

    private String formatPriority(SupportRequest req) {
        String priority = req.getPriority();
        return priority == null ? "" : " (priority: " + priority + ")";
    }

    private String followUp(SupportRequest req) {
        return "Ticket: " + req.getTicketId() + ".";
    }
}
