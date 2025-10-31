package com.campushelpdesk.strategy;

import com.campushelpdesk.model.SupportRequest;

public class RegistrarSupportStrategy implements SupportStrategy {
    @Override
    public String respond(SupportRequest req) {
        return "Registrar request recorded (Priority: " + req.getPriority() + "). "
                + "For records, TOR, or certification requests, please ensure all forms are complete. "
                + "Assigned: " + req.getAssignedOffice() + ". Ticket: " + req.getTicketId() + ".";
    }
}
