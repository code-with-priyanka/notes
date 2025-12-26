1. JDBC (Java Database Connectivity) – Introduction

JDBC is a standard Java API used to connect Java applications with databases.

Key Points (MCQ Focus)

JDBC is part of java.sql and javax.sql packages

It allows Java programs to:

Connect to a database

Execute SQL queries

Retrieve and process results

JDBC is database-independent

JDBC uses drivers to communicate with databases

✅ JDBC = Java API + SQL + Driver
===========================================================================
2. JDBC Architecture
JDBC Architecture has two layers

JDBC API

Used by Java applications

JDBC Driver API

Implemented by database vendors
----------------------------------------
Flow:
Java Application
        ↓
JDBC API
        ↓
JDBC Driver
        ↓
Database
----------------------------------
MCQ Facts
----------------------------------
JDBC follows client-server architecture

Driver acts as a translator between Java calls and DB calls
========================================================================
3. JDBC Drivers
Types of JDBC Drivers (VERY IMPORTANT)
Type	Name	Description	Status
Type 1	JDBC-ODBC Bridge	Uses ODBC driver	❌ Deprecated
Type 2	Native API Driver	Uses DB native libraries	❌ Platform dependent
Type 3	Network Protocol Driver	Middleware based	⚠ Rare
Type 4	Thin Driver	Pure Java, talks directly to DB	✅ Most used
-------------------------------------------------
MCQ Highlights

Type 4 driver is fastest and portable

Type 1 driver removed after Java 8

Type 2 needs native libraries

Type 3 uses middleware server
==========================================================
4. JDBC Classes & Interfaces
4.1 Driver Interface

Located in java.sql

Implemented by DB vendors

Registers itself with DriverManager

Class.forName("com.mysql.cj.jdbc.Driver");


📌 MCQ: Driver loads automatically from Java 6 onward
==================================================================
4.2 Connection Interface

Represents a connection to database

Created using DriverManager.getConnection()

Connection con = DriverManager.getConnection(url, user, pass);

MCQ Points

Used to:

Create Statement objects

Control transactions

One Connection = One DB session
======================================================
4.3 Statement Interface

Used to execute static SQL queries

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM emp");

Limitations (MCQ)

Not precompiled

Prone to SQL Injection

Slower than PreparedStatement
=====================================================
4.4 PreparedStatement Interface

Used for parameterized queries

Precompiled by DB

PreparedStatement ps =
con.prepareStatement("SELECT * FROM emp WHERE id=?");
ps.setInt(1, 101);

Advantages (VERY IMPORTANT)

Faster execution

Prevents SQL Injection

Better performance
==========================================================
4.5 ResultSet Interface

Holds data returned by SELECT query

Cursor based

rs.next();
rs.getInt(1);

ResultSet Types (MCQ)

TYPE_FORWARD_ONLY (default)

TYPE_SCROLL_INSENSITIVE

TYPE_SCROLL_SENSITIVE
===========================================================
5. Relationship between JDBC Interfaces & Provider Implementations
Concept

JDBC provides interfaces

Database vendors provide implementations

Interface	Implemented By
Driver	DB Vendor
Connection	Driver
Statement	Driver
ResultSet	Driver

📌 This supports loose coupling
=================================================
6. Stored Procedures & Functions Invocation
What are Stored Procedures?

Precompiled SQL programs stored in DB

CallableStatement Interface
CallableStatement cs =
con.prepareCall("{call getEmp(?)}");

Differences (MCQ)
Stored Procedure	Function
May return multiple values	Returns single value
Can have OUT params	Must return 
===========================================================
7. SQL Injection – Overview & Prevention
SQL Injection

A security attack where SQL code is injected via input

SELECT * FROM users WHERE name='admin' OR '1'='1'

Prevention (VERY IMPORTANT)

Use PreparedStatement

Validate input

Avoid dynamic SQL

📌 MCQ: PreparedStatement is best defense
=======================================================
8. Transaction Management in JDBC
Transaction

A group of SQL statements executed as a unit

ACID Properties

Atomicity

Consistency

Isolation

Durability
------------------------------------------
Auto-Commit

Default is true

Each SQL executes as separate transaction

con.setAutoCommit(false);
-----------------------------------
Commit & Rollback
con.commit();
con.rollback();

-------------------------------------
📌 MCQ:

commit() saves changes

rollback() undoes changes
=====================================================
9. Data Access Object (DAO) Design Pattern
DAO Pattern

Separates business logic from data access logic

Structure
Service Layer
     ↓
DAO Interface
     ↓
DAO Implementation
     ↓
Database
----------------------------------------
Advantages (MCQ)

Loose coupling

Easy maintenance

DB independent

Better testing

📌 DAO uses JDBC internally
==============================================
10. Exam-Oriented Summary

✔ JDBC is API, not a language
✔ Type 4 Driver is best
✔ PreparedStatement > Statement
✔ SQL Injection prevented by PreparedStatement
✔ DAO separates persistence logic
✔ Default auto-commit = true
================================================================