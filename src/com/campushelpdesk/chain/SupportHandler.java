package com.campushelpdesk.chain;

import com.campushelpdesk.model.SupportRequest;
import com.campushelpdesk.strategy.*;

public class SupportHandler extends Handler {
    @Override
    protected boolean process(SupportRequest req) {
        SupportStrategy strategy;
        switch (req.getType()) {
            case "IT": strategy = new ITSupportStrategy(); break;
            case "FACILITIES": strategy = new FacilitiesSupportStrategy(); break;
            case "REGISTRAR": strategy = new RegistrarSupportStrategy(); break;
            case "FINANCE": strategy = new FinanceSupportStrategy(); break;
            default: strategy = (r) -> "Your request has been received. An agent will follow up shortly."; // lambda impl
        }
        String resp = strategy.respond(req);
        req.setResponse(resp);
        System.out.println("[Support] response generated.");
        return true;
    }
}
