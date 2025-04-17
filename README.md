# Secure E-Coupon System using Blockchain

This Java-based web application implements a secure blockchain-integrated e-coupon system using J2EE technologies.

## 🧰 Tech Stack
- Java (JDK 11)
- J2EE (Servlets, JSP)
- Tomcat 9.0
- MySQL 8
- Blockchain (Custom logic)

## 🚀 Setup Instructions

### 1. Database
- Install MySQL 8
- Run the SQL script in `database.sql` to create the `secure_coupon` DB

### 2. Backend
- Import project into Eclipse or IntelliJ
- Configure Apache Tomcat 9
- Deploy the web application

### 3. Application Usage
- Go to `http://localhost:8080/SecureECouponSystem`
- Create a new coupon
- View existing coupons with their blockchain hash

## 🛡️ Features
- Coupons are stored with unique blockchain hash
- Blockchain chain is verifiable and immutable
- Servlet + DAO + JDBC layered architecture