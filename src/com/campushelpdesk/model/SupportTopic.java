package com.campushelpdesk.model;

import com.campushelpdesk.strategy.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Central catalogue of supported helpdesk topics.
 * Each entry knows how to identify itself from raw text, which office owns it,
 * and which response strategy to use.
 */
public enum SupportTopic {
    IT(
            "IT",
            "IT Support",
            "IT Helpdesk",
            new ITSupportStrategy(),
            Arrays.asList("lms", "wifi", "network", "account", "login", "email", "printer", "software", "password")
    ),
    FACILITIES(
            "FACILITIES",
            "Facilities",
            "Facilities Office",
            new FacilitiesSupportStrategy(),
            Arrays.asList("room", "classroom", "projector", "aircon", "chair", "light", "maintenance", "power", "leak", "repair", "clean")
    ),
    REGISTRAR(
            "REGISTRAR",
            "Registrar",
            "Registrar's Office",
            new RegistrarSupportStrategy(),
            Arrays.asList("enroll", "enrollment", "grade", "transcript", "tor", "certificate", "record", "evaluation", "dropping", "adding")
    ),
    FINANCE(
            "FINANCE",
            "Finance",
            "Finance Office",
            new FinanceSupportStrategy(),
            Arrays.asList("payment", "tuition", "soa", "receipt", "refund", "posting", "or", "billing", "scholarship", "cashier")
    ),
    LIBRARY(
            "LIBRARY",
            "Library Services",
            "Library Services Office",
            new LibrarySupportStrategy(),
            Arrays.asList("library", "book", "borrow", "return", "overdue", "fine", "catalog", "database", "reference", "journal")
    ),
    GENERAL(
            "GENERAL",
            "General Support",
            "Campus Helpdesk",
            new GeneralSupportStrategy(),
            Collections.emptyList()
    );

    private final String code;
    private final String displayName;
    private final String assignedOffice;
    private final SupportStrategy strategy;
    private final List<String> keywords;

    SupportTopic(String code, String displayName, String assignedOffice, SupportStrategy strategy, List<String> keywords) {
        this.code = code;
        this.displayName = displayName;
        this.assignedOffice = assignedOffice;
        this.strategy = strategy;
        this.keywords = keywords;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAssignedOffice() {
        return assignedOffice;
    }

    public SupportStrategy getStrategy() {
        return strategy;
    }

    public List<String> getKeywords() {
        return Collections.unmodifiableList(keywords);
    }

    /**
     * Attempts to match a request message to a known topic based on keyword presence.
     * Returns GENERAL when nothing matches.
     */
    public static SupportTopic fromMessage(String message) {
        if (message == null || message.isBlank()) {
            return GENERAL;
        }
        String normalized = message.toLowerCase();
        for (SupportTopic topic : values()) {
            if (topic == GENERAL) {
                continue;
            }
            if (topic.keywords.stream().anyMatch(normalized::contains)) {
                return topic;
            }
        }
        return GENERAL;
    }

    public static SupportTopic fromCode(String code) {
        if (code == null) {
            return null;
        }
        return Arrays.stream(values())
                .filter(topic -> topic.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(GENERAL);
    }
}
