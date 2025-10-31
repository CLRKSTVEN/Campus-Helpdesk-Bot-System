package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public class ITSupportStrategy implements SupportStrategy {
    @Override
    public String respond(SupportRequest req) {
        return "We have logged your IT concern (Priority: " + req.getPriority() + "). "
                + "Please try resetting your LMS/email password if this is a login issue. "
                + "If the problem persists, the IT Helpdesk will reach out. "
                + "Assigned: " + req.getAssignedOffice() + ". Ticket: " + req.getTicketId() + ".";
    }
}
