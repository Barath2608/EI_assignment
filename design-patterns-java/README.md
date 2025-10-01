# Design Patterns — Java Examples

This project implements six design-pattern demos (two Behavioral, two Creational, two Structural)
with clean, per-class organization, logging, defensive validations, and a config-driven runtime.

Packages:
- `com.example.designpatterns.behavioral`
- `com.example.designpatterns.creational`
- `com.example.designpatterns.structural`
- `com.example.designpatterns.core` (core utilities)

How to run:
1. Build: `mvn clean package`
2. Run: `mvn exec:java -Dexec.mainClass="com.example.designpatterns.Main"` 
   (or run via your IDE)

Config:
- `src/main/resources/config.properties` controls `mode` (interactive|daemon), `iterations`, `intervalMs`.

Notes:
- Each class resides in its own file following standard Java conventions.
- Logging uses SLF4J + Logback.
- The project is ready to be pushed to GitHub. After pushing, share only the GitHub link as requested.
