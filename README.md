# Campus Helpdesk Bot System (Console, Java 17+)

A fully runnable rewrite of your Support Request Bot as a **Campus Helpdesk** (no shop references).
Demonstrates **Chain of Responsibility + Strategy + Observer** patterns.

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

## Example
```
> My payment last week is not showing in my SOA
[SpamFilter] ok
[Priority] set to: NORMAL
[Triage] type: FINANCE
[Assignment] office: Finance Office | ticket: FIN-2025-10-31-0001
[Observer] Notified: Finance Office | Ticket FIN-2025-10-31-0001
[Support] response generated.
```
