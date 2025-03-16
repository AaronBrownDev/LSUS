# Personal Finance Application

A Java-based personal finance management system built as a final project for CSC 285 (Object-Oriented Programming) at Louisiana State University in Shreveport. This academic project demonstrates the implementation of object-oriented programming principles and design patterns.

## Overview

This application was developed as a conceptual demonstration of personal finance management, including tracking various account types, categorizing transactions, and monitoring financial activities. It is an academic exercise focused on applying OOP concepts rather than a completed, production-ready application. The primary purpose of this project was to showcase advanced OOP concepts and software design principles learned throughout the course.

## Features

- **Multi-account management**: Track cash, credit cards, and debit accounts in a unified system
- **Transaction categorization**: Organize income and expenses into customizable categories
- **Transaction history**: Record and retrieve transactions with detailed information
- **Validation systems**: Ensure data integrity through robust validation mechanisms

## Architecture & Design Patterns

This project implements several object-oriented design patterns and principles as part of the academic requirements:

### Design Patterns
- **Facade Pattern**: `PersonalFinanceApp` provides a simplified interface to the complex subsystem
- **Repository Pattern**: Used for data access abstraction (e.g., `NameableRepository`, `CategoryRepository`)  
- **Singleton Pattern**: Implemented in `TransactionRepository` and `PersonalFinanceApp` to ensure single instances
- **Chain of Responsibility**: Used in the transaction validation system

### OOP Principles
- **Encapsulation**: Data and behavior are encapsulated within appropriate classes
- **Inheritance**: Class hierarchies are used for code reuse and specialization
- **Polymorphism**: Interfaces (e.g., `IAccount`, `INameable`) enable polymorphic behavior
- **Abstraction**: Complex implementations are hidden behind clean interfaces

### Key Components

The project is structured around several key components that demonstrate OOP concepts:

- **Interfaces**: `IAccount`, `ICategory`, `INameable`, `ITransaction`, `ISetValuePolicy`, etc.
- **Core Classes**: `Account`, `Category`, `Transaction`, `Budget`
- **Repositories**: `NameableRepository`, `CategoryRepository`, `TransactionRepository`, `AllAccountsRepository`
- **Validation**: `TransactionDateValidator`, `ITransactionValidator`
- **Facade**: `PersonalFinanceApp` - the main entry point for the application

## Project Status

This is an academic project created specifically for demonstrating object-oriented programming concepts. It is not intended for actual use as a personal finance tool and lacks certain components that would be necessary in a production application, such as:

- Persistent data storage
- Complete error handling
- User interface implementation
- Comprehensive testing

The focus of this project was on demonstrating OOP principles and design patterns rather than creating a fully functional application.

## Educational Purpose

This project demonstrates understanding and application of:
- Object-oriented programming fundamentals
- Design patterns implementation
- Interface-based design
- Software architecture principles
- Code organization and structure

## Academic Context

This project was completed as the final assignment for CSC 285 (Object-Oriented Programming) at Louisiana State University in Shreveport. It represents the culmination of course learning objectives related to OOP principles and software design.

## Acknowledgments

- Louisiana State University in Shreveport Computer Science Department
- Course instructor for guidance on OOP principles and design patterns
