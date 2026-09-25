# ShopSphere-project
# 🛍️ ShopSphere

> A full-stack e-commerce web application built with Spring Boot, MySQL, JPA/Hibernate, REST APIs, and a responsive HTML, CSS & JavaScript frontend.

ShopSphere is a mini e-commerce platform designed to provide a complete online shopping experience with product browsing, search, categories, authentication, cart management, wishlist functionality, checkout, and order management.

---

## ✨ Features

### 🛒 Shopping Experience
- Browse products
- Product search
- Filter products by category
- Filter products by brand
- Product pagination
- Product details
- Add products to cart
- Update cart quantity
- Remove products from cart
- Wishlist functionality
- Automatic price calculation
- Checkout flow

### 👤 User Features
- User registration
- User login
- User profile information
- Authentication-related API
- User management

### 📦 Order Management
- Create orders
- View order details
- Order status
- Total order amount
- User-specific orders

### 🔐 Backend Features
- RESTful APIs
- Spring Data JPA
- MySQL database integration
- DTO-based product responses
- Entity relationships
- Input validation
- Global exception handling
- Search APIs
- Category APIs
- Brand APIs
- Pagination

### 💳 Checkout
- Cash on Delivery option
- Online payment option
- Payment flow UI
- Order confirmation

---

## 🛠️ Tech Stack

### Frontend
- HTML5
- CSS3
- JavaScript
- Responsive Design

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs
- Jakarta Validation

### Database
- MySQL

### Tools
- Maven
- Postman
- Git
- GitHub
- IntelliJ IDEA / VS Code

---

## 🏗️ Project Architecture

```text
ShopSphere
│
├── src
│   └── main
│       ├── java
│       │   └── com.shopsphere.shop
│       │       │
│       │       ├── controller
│       │       ├── service
│       │       ├── repository
│       │       ├── entity
│       │       ├── dto
│       │       └── exception
│       │
│       └── resources
│           ├── application.properties
│           └── static
│               └── index.html
│
├── pom.xml
└── README.md
