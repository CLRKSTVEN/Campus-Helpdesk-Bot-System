# Campus Helpdesk Bot System (Console, Java 17+)

A Java-based automated helpdesk assistant for a school/university using Behavioral Design Patterns.

# System Overview

The Campus Helpdesk Bot System simulates an automated student and staff support assistant for a university.
Requesters choose their help topic—such as IT concerns, facilities issues, enrollment/records questions, or finance queries—and the system automatically routes, classifies, assigns, and responds.

The system demonstrates three Behavioral Design Patterns working together:

# Chain of Responsibility

Requests flow through a pipeline of handlers:

SpamFilterHandler – screens out spam/irrelevant inputs

PriorityHandler – classifies urgency (e.g., urgent, normal)

TriageHandler – identifies request type (IT, Facilities, Registrar/Enrollment, Finance)

AssignmentHandler – assigns to the right campus office/team

SupportHandler – generates an appropriate reply using the selected strategy

# Strategy Pattern

The bot dynamically selects a support strategy based on the determined issue type:

ITSupportStrategy – accounts, LMS, network, lab computers

FacilitiesSupportStrategy – classroom repairs, power, cleanliness, equipment

RegistrarSupportStrategy – enrollment, grades, academic records, certifications

FinanceSupportStrategy – tuition/fees, payment posting, SOA, refunds

You can extend this with additional strategies (e.g., LibrarySupportStrategy, GuidanceSupportStrategy) without changing the pipeline.

# Observer Pattern

The system notifies office observers whenever a valid request arrives or changes state.
Observers can represent IT Helpdesk, Facilities Office, Registrar, Finance Office, or specific staff/technicians.
This simulates email/Slack notifications (console output in this demo).

# Typical Flow

User submits a request (free-text + optional category/priority).

Pipeline filters spam → sets priority → triages type → assigns office/team.

The appropriate Strategy builds a tailored response/action plan.

Observers (subscribed offices) are notified of the new/updated request.

Request Types (Examples)

IT: “I can’t log in to LMS” / “Wi-Fi is down in the library”

Facilities: “Broken chair in Room 203” / “Aircon not working in Lab 2”

Registrar: “How to request a transcript?” / “Grade not appearing”

Finance: “Payment not reflected” / “Request Statement of Account”

## Run (VS Code or IntelliJ)

- Open this folder as a project.
- Ensure JDK 17+.
- Run `Main.java`.

## Run (Command Line)

```bash
cd src
javac com/campushelpdesk/**/*.java
java com.campushelpdesk.Main
```
