package com.campushelpdesk.model;

import com.campushelpdesk.observer.Notifier;

public class SupportRequest {
    private final String message;
    private boolean spam = false;
    private String priority;
    private SupportTopic topic;
    private String assignedOffice;
    private String response;
    private String ticketId;
    private Notifier notifier;

    public SupportRequest(String message) {
        this.message = message == null ? "" : message;
    }

    public String getMessage() { return message; }
    public boolean isSpam() { return spam; }
    public void setSpam(boolean spam) { this.spam = spam; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getType() { return topic == null ? null : topic.getCode(); }
    public SupportTopic getTopic() { return topic; }
    public void setTopic(SupportTopic topic) { this.topic = topic; }
    public void setType(String type) { this.topic = SupportTopic.fromCode(type); }
    public String getAssignedOffice() { return assignedOffice; }
    public void setAssignedOffice(String assignedOffice) { this.assignedOffice = assignedOffice; }
    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public Notifier getNotifier() { return notifier; }
    public void setNotifier(Notifier notifier) { this.notifier = notifier; }
}
