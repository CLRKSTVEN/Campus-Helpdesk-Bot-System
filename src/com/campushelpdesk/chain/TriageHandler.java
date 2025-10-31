package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;

public class TriageHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        String msg = req.getMessage().toLowerCase();
        String type = null;

        // IT keywords
        if (msg.contains("lms") || msg.contains("wifi") || msg.contains("network") || msg.contains("account")
            || msg.contains("login") || msg.contains("email") || msg.contains("printer") || msg.contains("software")) {
            type = "IT";
        }
        // Facilities keywords
        if (type == null && (msg.contains("room") || msg.contains("classroom") || msg.contains("projector")
            || msg.contains("aircon") || msg.contains("chair") || msg.contains("light") || msg.contains("power")
            || msg.contains("leak") || msg.contains("repair"))) {
            type = "FACILITIES";
        }
        // Registrar keywords
        if (type == null && (msg.contains("enroll") || msg.contains("enrollment") || msg.contains("grade")
            || msg.contains("transcript") || msg.contains("tor") || msg.contains("certificate") || msg.contains("record"))) {
            type = "REGISTRAR";
        }
        // Finance keywords
        if (type == null && (msg.contains("payment") || msg.contains("tuition") || msg.contains("soa")
            || msg.contains("receipt") || msg.contains("refund") || msg.contains("posting") || msg.contains("or"))) {
            type = "FINANCE";
        }

        // Fallback
        if (type == null) type = "GENERAL";

        req.setType(type);
        System.out.println("[Triage] type: " + type);
        return true;
    }
}
