package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;
import com.campushelpdesk.util.TicketGenerator;

public class AssignmentHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        String office;
        switch (req.getType()) {
            case "IT": office = "IT Helpdesk"; break;
            case "FACILITIES": office = "Facilities Office"; break;
            case "REGISTRAR": office = "Registrar's Office"; break;
            case "FINANCE": office = "Finance Office"; break;
            default: office = "Campus Helpdesk"; break;
        }
        req.setAssignedOffice(office);
        req.setTicketId(TicketGenerator.next(req.getType()));
        System.out.println("[Assignment] office: " + office + " | ticket: " + req.getTicketId());

        // Notify observers
        if (req.getNotifier() != null) {
            req.getNotifier().notifyAllObservers(req);
        }
        return true;
    }
}
