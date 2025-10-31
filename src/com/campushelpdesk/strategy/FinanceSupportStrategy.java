package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public class FinanceSupportStrategy implements SupportStrategy {
    @Override
    public String respond(SupportRequest req) {
        return "Finance request noted (Priority: " + req.getPriority() + "). "
                + "If this is about payment posting, please provide your OR and transaction reference. "
                + "Assigned: " + req.getAssignedOffice() + ". Ticket: " + req.getTicketId() + ".";
    }
}
