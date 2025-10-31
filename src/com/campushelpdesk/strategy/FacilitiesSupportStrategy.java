package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public class FacilitiesSupportStrategy implements SupportStrategy {
    @Override
    public String respond(SupportRequest req) {
        return "Facilities request received (Priority: " + req.getPriority() + "). "
                + "A technician will inspect the reported area. "
                + "Assigned: " + req.getAssignedOffice() + ". Ticket: " + req.getTicketId() + ".";
    }
}
