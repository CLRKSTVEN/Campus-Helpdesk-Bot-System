package com.campushelpdesk.util;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketGenerator {
    private static final AtomicInteger SEQ = new AtomicInteger(1);

    public static String next(String type) {
        String prefix = "GEN";
        if (type != null) {
            switch (type) {
                case "IT": prefix = "IT"; break;
                case "FACILITIES": prefix = "FAC"; break;
                case "REGISTRAR": prefix = "REG"; break;
                case "FINANCE": prefix = "FIN"; break;
                case "LIBRARY": prefix = "LIB"; break;
                default: prefix = "GEN";
            }
        }
        int n = SEQ.getAndIncrement();
        return prefix + "-" + LocalDate.now() + "-" + String.format("%04d", n);
    }
}
