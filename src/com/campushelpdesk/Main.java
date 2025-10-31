package com.campushelpdesk;

import com.campushelpdesk.chain.*;
import com.campushelpdesk.model.SupportRequest;
import com.campushelpdesk.model.SupportTopic;
import com.campushelpdesk.observer.Notifier;
import com.campushelpdesk.observer.OfficeObserver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Campus Helpdesk Bot ===");
        System.out.println("Type your request (or 'help' for keywords, 'exit' to quit):");

        // Build Observer system (offices subscribe here)
        Notifier notifier = new Notifier();
        notifier.subscribe(new OfficeObserver("IT Helpdesk"));
        notifier.subscribe(new OfficeObserver("Facilities Office"));
        notifier.subscribe(new OfficeObserver("Registrar's Office"));
        notifier.subscribe(new OfficeObserver("Finance Office"));
        notifier.subscribe(new OfficeObserver("Library Services Office"));

        // Build Chain of Responsibility
        Handler chain = new SpamFilterHandler()
                .setNext(new PriorityHandler())
                .setNext(new TriageHandler())
                .setNext(new AssignmentHandler())
                .setNext(new SupportHandler());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            if (!sc.hasNextLine()) break;
            String msg = sc.nextLine();
            if (msg == null) break;
            String trimmed = msg.trim();
            if ("exit".equalsIgnoreCase(trimmed)) break;
            if ("help".equalsIgnoreCase(trimmed)) {
                printHelp();
                continue;
            }

            SupportRequest req = new SupportRequest(msg);
            req.setNotifier(notifier);

            // Pass through chain
            chain.handle(req);

            // Show result (if not spam/filtered out)
            if (!req.isSpam()) {
                System.out.println();
                System.out.println("[RESULT]");
                System.out.println("Ticket: " + (req.getTicketId() == null ? "-" : req.getTicketId()));
                System.out.println("Priority: " + (req.getPriority() == null ? "-" : req.getPriority()));
                SupportTopic topic = req.getTopic();
                System.out.println("Topic: " + (topic == null ? "-" : topic.getDisplayName()));
                System.out.println("Assigned Office: " + (req.getAssignedOffice() == null ? "-" : req.getAssignedOffice()));
                System.out.println("Response: " + (req.getResponse() == null ? "-" : req.getResponse()));
                System.out.println();
            }
        }

        System.out.println("Goodbye!");
        sc.close();
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("Supported topics & sample keywords:");
        for (SupportTopic topic : SupportTopic.values()) {
            if (topic == SupportTopic.GENERAL) {
                continue;
            }
            System.out.println("- " + topic.getDisplayName() + ": " + String.join(", ", topic.getKeywords()));
        }
        System.out.println();
    }
}
