# Campus Helpdesk Bot System (Console, Java 17+)

A console-based assistant that triages campus support tickets, demonstrates behavioural design patterns, and produces tailored responses for each office. The bot now centralises topic knowledge, includes library support, and offers an inline help command so users can discover keywords quickly.

## Project Overview

- Accepts free-text requests from students or staff and turns them into routed tickets.
- Filters spam, infers urgency, classifies the topic, assigns the owning office, and generates a contextual reply.
- Notifies subscribed offices (Observer pattern) whenever a valid ticket is created.
- Provides `help` and `exit` commands directly in the console for faster onboarding.

## Architecture at a Glance

- **Chain of Responsibility (`src/com/campushelpdesk/chain`)**  
  `SpamFilterHandler` -> `PriorityHandler` -> `TriageHandler` -> `AssignmentHandler` -> `SupportHandler`. Each handler performs one responsibility and can short-circuit the flow.
- **Support Catalogue (`SupportTopic`)**  
  Holds the topic code, display name, owning office, reply strategy, and keywords. `TriageHandler` calls `SupportTopic.fromMessage` to classify requests in a single step.
- **Strategy Pattern (`src/com/campushelpdesk/strategy`)**  
  Each topic has its own `SupportStrategy` implementation that renders customised guidance. General requests fall back to `GeneralSupportStrategy`.
- **Observer Pattern (`src/com/campushelpdesk/observer`)**  
  `Notifier` broadcasts ticket updates to subscribed `OfficeObserver` instances. In the demo this is console output, but it could call email, SMS, or chat APIs.
- **Utilities (`src/com/campushelpdesk/util/TicketGenerator.java`)**  
  Generates date-based ticket identifiers with topic-specific prefixes.

## Code Walkthrough

1. `Main.java` prints the banner, registers observers (IT, Facilities, Registrar, Finance, Library), builds the handler chain, and loops on user input. Typing `help` displays the latest topic keywords.
2. `SpamFilterHandler` rejects obviously irrelevant text.
3. `PriorityHandler` uses a curated keyword list to upgrade critical incidents to `HIGH` priority.
4. `TriageHandler` calls `SupportTopic.fromMessage` to map text to the proper topic (IT, Facilities, Registrar, Finance, Library, or General).
5. `AssignmentHandler` stamps the owning office, issues a ticket number via `TicketGenerator`, and notifies observers.
6. `SupportHandler` delegates to the topic-specific `SupportStrategy` and stores the generated response.

## Running the Bot

```bash
cd src
javac com/campushelpdesk/**/*.java
java com.campushelpdesk.Main
```

While the program runs:

- Type any request, for example `Wifi is down in the library` or `Need help requesting a transcript`.
- Type `help` to see recognised keywords per topic.
- Type `exit` to close the session.

## Extending the System

- Add a new topic by creating a strategy class and adding an entry to `SupportTopic`.
- Plug the notifier into your preferred communication channel (email/SMS/Slack) by replacing the console printout in `OfficeObserver`.
- Integrate persistence by storing `SupportRequest` snapshots after `SupportHandler` finishes.

---
