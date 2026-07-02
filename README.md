# 💸 Expense Splitter & Debt Tracker Web Application

A web-based expense management system built using **Java, Spring Boot (MVC), MySQL, HTML, and CSS** that helps users:

* Split group expenses based on custom percentages
* Track personal debts (who owes whom)
* Receive automated email reminders for pending payments

This project focuses on applying backend concepts like **MVC architecture, database relationships, business logic handling, and email automation** in a practical financial use case.
## 📑 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Core Functional Logic](#-core-functional-logic)
- [Current Status](#-current-status)
- [Screenshots](#-screenshots)
- [Learning Outcomes](#-learning-outcomes)

## 🚀 Features

### 1️⃣ Group Expense Splitter Mode

* User enters total number of participants
* Inputs:

  * Names of participants
  * Custom percentage share for each person
* System:

  * Validates percentage distribution
  * Calculates individual payable amounts
  * Displays final split result

✔ Handles real-time calculation

✔ Ensures total percentage equals 100%

✔ Prevents invalid inputs


### 2️⃣ Debt Tracking Mode (Who Owes Whom)

* User can:

  * Track how much they owe someone
  * Track how much someone owes them
* Stores:

  * Debtor
  * Creditor
  * Amount
  * Email
  * Due Date
* Displays structured debt records
* Gives an option of delete 

✔ Persistent storage using MySQL

✔ Clean data retrieval using Spring MVC

✔ Structured financial tracking


### 3️⃣ Email Reminder System

* Automated email reminders for:

  * Payment Overdue
  * Payment Due Soon
  * On Day Of Payment 
* Implemented using:

  * Spring Boot Mail API
  * Scheduled background tasks


## 🛠 Tech Stack

| Layer         | Technology Used                   |
| ------------- | --------------------------------- |
| Backend       | Java                              |
| Framework     | Spring Boot (MVC Architecture)    |
| Database      | MySQL                             |
| Frontend      | HTML, CSS                         |
| Email Service | Spring Boot Mail (JavaMailSender) |


## 🧮 Core Functional Logic

### Group Split Calculation

* Validates total percentage
* Converts percentage into monetary distribution
* Returns individual payable values

### Debt Tracking

* Stores creditor-debtor relationship
* Retrieves balance records
* Maintains transaction consistency in database

## 📌 Current Status

✅ Expense split calculation completed

✅ Debt tracking completed, where user can get teh total remaining and total payment done, can dynamically update if the payment is paid or pending, user can also delete any record

✅ Email reminder automation in done

✅ Password Hashing

✅ JWT Authentication

## 📸 Screenshots

### Home Page

<img width="1533" height="807" alt="WhatsApp Image 2026-07-01 at 9 20 48 PM" src="https://github.com/user-attachments/assets/05f50068-cdc8-4964-a1c8-1c7fa3b298f2" />

### Sign Up Page

<img width="1530" height="812" alt="WhatsApp Image 2026-07-01 at 9 20 48 PM" src="https://github.com/user-attachments/assets/56fe3d77-c571-4d50-8d94-452204947f7a" />


### Login Page

<img width="1529" height="802" alt="Login Page" src="https://github.com/user-attachments/assets/96bbc838-8679-4292-8308-e723f23852c8" />

### Option Page

<img width="1529" height="808" alt="Option Page" src="https://github.com/user-attachments/assets/3230698c-b72b-4c40-a32a-c052719b469d" />

### Keep Track Of Your Settlement Page

<img width="1532" height="813" alt="Keep Track Of Your Settlement Page" src="https://github.com/user-attachments/assets/d5c95614-d6c6-48a1-8349-896597e61298" />

### To Pay Page

<img width="1533" height="808" alt="To Pay Page" src="https://github.com/user-attachments/assets/4e352a09-8643-4072-83a5-2f6e80699a4f" />

### Record Settlement Page

<img width="1532" height="801" alt="Record Settlement Page" src="https://github.com/user-attachments/assets/036dda43-80f2-48f1-bf9f-4ddc622932ae" />

### Transaction History Page

<img width="1531" height="801" alt="Transaction History" src="https://github.com/user-attachments/assets/48566e21-c04e-42fe-81a0-bc5814af37ef" />

### To Receive Page

<img width="1533" height="802" alt="To Receive Page" src="https://github.com/user-attachments/assets/91c5930a-0e90-4ef5-997f-fd9e2609b515" />


### Settlement Details Page

<img width="1532" height="815" alt="Settlement Details Page" src="https://github.com/user-attachments/assets/2ac0879d-8fce-42d7-85df-4a6b6b82c395" />

### Receivables Page

<img width="1529" height="809" alt="Receivables Page" src="https://github.com/user-attachments/assets/c30f8683-3e82-4e4b-9159-581afab832fd" />

### Expense Analysis Chart For User

<img width="1522" height="808" alt="chart green" src="https://github.com/user-attachments/assets/c5434a2d-9729-4a80-896f-0918b43b6b45" />
<img width="1522" height="808" alt="chart green" src="https://github.com/user-attachments/assets/70d511c7-8ab0-4c54-8365-f10c7b3e2ec6" />

### Reminder on user's side when the due date is near for a payment

<img width="1191" height="231" alt="Reminder on user&#39;s side when the due date is near for a payment" src="https://github.com/user-attachments/assets/c9830de1-fdda-4a35-8825-fc31e2707ec6" />

### Reminder on user's side when the user's due date for the payment is near

<img width="1212" height="245" alt="due date for the payment is near for user" src="https://github.com/user-attachments/assets/159ef538-f274-4970-8cf5-01f8e0c1826b" />

### Reminder on user's side when his incoming payment is overdue

<img width="912" height="226" alt="Reminder on user&#39;s side when his incoming payment is overdue" src="https://github.com/user-attachments/assets/780e9d9c-7836-48ac-8b86-fa9cad985015" />
<img width="1047" height="228" alt="image" src="https://github.com/user-attachments/assets/79c7dfee-beec-4f37-83e4-7b6768cd001b" />

### Notice from the user if the payment is overdue

<img width="1044" height="260" alt="image" src="https://github.com/user-attachments/assets/308f975d-41b8-4a08-bab1-8e8c664efc88" />

### Group Split Calculator (Unequal Splits using percentage)

<img width="1524" height="811" alt="cal1" src="https://github.com/user-attachments/assets/5715e98b-0d88-46ea-8cb9-b709fa6e250c" />
<img width="1516" height="809" alt="cal2" src="https://github.com/user-attachments/assets/23641107-762d-40e6-a184-d8f4583ed5c4" />

## 💡 Learning Outcomes

This project strengthened understanding of:

* MVC architecture in Spring Boot
* Backend financial logic handling
* MySQL relational database design
* Form handling and validation
* Email automation using Java
* Password Hashing
* JWT Tokens
