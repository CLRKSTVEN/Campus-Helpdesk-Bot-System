package com.campushelpdesk.observer;

import com.campushelpdesk.model.SupportRequest;

public class OfficeObserver implements HelpdeskObserver {
    private final String office;

    public OfficeObserver(String office) {
        this.office = office;
    }

    @Override
    public void onRequestUpdate(SupportRequest req) {
        // In a real system, send an email/Slack notif here. We just print.
        if (office.equals(req.getAssignedOffice())) {
            System.out.println("[Observer] Notified: " + office + " | Ticket " + req.getTicketId());
        }
    }
}
