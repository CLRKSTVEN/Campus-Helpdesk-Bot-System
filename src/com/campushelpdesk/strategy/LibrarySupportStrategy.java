package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public class LibrarySupportStrategy implements SupportStrategy {
    @Override
    public String respond(SupportRequest req) {
        return "Library request received (Priority: " + req.getPriority() + "). "
                + "Please bring your ID when visiting the library desk. "
                + "If you need database access support, include the resource title for faster assistance. "
                + "Assigned: " + req.getAssignedOffice() + ". Ticket: " + req.getTicketId() + ".";
    }
}
