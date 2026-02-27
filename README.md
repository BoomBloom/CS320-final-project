# **Grand Strand Systems: Software Test & Automation Portfolio**

## **Project Overview**
This repository showcases a suite of back-end services developed for a mobile application project at **Grand Strand Systems**. The project consists of three core modules: **Contact Service**, **Task Service**, and **Appointment Service**. The primary objective was to demonstrate mastery in **Unit Testing**, **Defensive Programming**, and **Requirement Traceability** using Java and JUnit 4.

---

## **Reflection**

### **1. Ensuring Functionality and Security**
To ensure that software is both functional and secure, I utilize a "Fail-Fast" design pattern coupled with rigorous unit testing. By implementing **Defensive Programming** within class constructors, I ensure that invalid data—such as null values or strings that exceed character limits—is rejected immediately with an `IllegalArgumentException`. 

In this project, I achieved **100% code coverage** on all model classes. This metric is vital for security because it proves that every guardrail (validation check) I wrote was actually executed and verified during testing, leaving no untested logic where bugs could hide.



### **2. Interpreting User Needs**
I interpret user needs by translating high-level business requirements into specific, testable technical constraints. For example, when the customer required that a phone number must be "exactly 10 digits," I implemented a regular expression check (`\\d{10}`) to enforce this requirement.

I apply **Boundary Value Analysis (BVA)** to incorporate these needs into the code. This means testing the extreme edges of requirements (e.g., testing a name at 10 characters to ensure it passes, and at 11 characters to ensure it fails). This level of precision ensures the final program aligns perfectly with the client’s specifications.

### **3. Software Design Approach**
My approach to software design is centered on **Modularity** and **Maintainability**. By decoupling the services (e.g., separating `Contact.java` from `ContactService.java`), I created a system where components can be updated or tested in isolation.

I prioritize avoiding **Technical Debt** by writing clean, self-validating code. By catching errors at the unit level, I prevent defects from cascading into the integration phase, where they become significantly more expensive and difficult to fix.



---

## **Included Artifacts**

### **Project One: Back-End Services**
* **Contact Service:** Manages contact information with strict validation for names, 10-digit phone numbers, and addresses.
* **Task Service:** Handles task creation with unique IDs and length-restricted names and descriptions.
* **Appointment Service:** Manages schedules while ensuring appointment dates are never set in the past.

### **Project Two: Quality Assurance Report**
* **Summary & Reflections:** A deep-dive report (CS320 Project Two.docx) analyzing testing strategies, JUnit efficiency, and the adversarial mindset adopted during development.

---

## **Technical Skills Demonstrated**
* **Languages:** Java
* **Testing Frameworks:** JUnit 4
* **Methodologies:** Test-Driven Development (TDD), Boundary Value Analysis, Negative Testing
* **Tools:** Maven, Git, GitHub

***
