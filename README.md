#CS 320: Software Test, Automation, and Quality Assurance
Project Overview
This repository contains the back-end services developed for Grand Strand Systems. The project involved creating a mobile application backend with three core services: Contact, Task, and Appointment. The primary focus was on Unit Testing and Requirement Traceability using JUnit 4 to ensure 100% code coverage and strict adherence to business constraints.

Reflection
How can I ensure that my code, program, or software is functional and secure?
I ensure functionality and security through Defensive Programming and Automated Unit Testing. By implementing strict validation logic in the class constructors—such as verifying that a phone number is exactly 10 digits or that an appointment date is not in the past—I prevent the application from entering an insecure or invalid state. Using JUnit, I verify these constraints with both positive and negative test cases. This ensures that every "if" statement (the defensive guards) is executed and confirmed, which I validated by achieving 100% code coverage on all model classes.

How do I interpret user needs and incorporate them into a program?
Interpreting user needs involves breaking down high-level business requirements into specific, testable technical constraints. For this project, I translated requirements (like "the contact ID shall not be updatable") into final variable declarations and setter-less architectures in Java. I used Boundary Value Analysis to ensure that my tests pushed the limits of the requirements, such as testing a name at 10 characters (valid) versus 11 characters (invalid).

How do I approach designing software?
My approach to design is centered on Modularity and Exception Handling. I design services to be independent, using in-memory HashMaps to manage data without the overhead of a database in the early stages. I utilize a "Fail-Fast" design, where IllegalArgumentException is thrown the moment invalid data is detected. This prevents Technical Debt and ensures that small bugs do not cascade into system-wide failures, a principle that is vital when handling life-critical or financial data.
