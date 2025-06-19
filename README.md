# Ecommerce Spring Boot Backend
A robust backend for an ecommerce platform, built with Spring Boot, providing RESTful APIs for user management, product catalog, order processing, authentication, and more.

---

## Features

- **User Authentication & Authorization**:  
  - JWT-based login and registration  
  - Role-based access control (Admin, User)

- **Product Management**:  
  - CRUD operations for products  
  - Product image upload (AWS S3 integration)  
  - Search and filter products  
  - Category management

- **Order Management**:  
  - Place orders with multiple items  
  - Order status tracking (Pending, Confirmed, Shipped, Delivered, Cancelled, Returned)  
  - Filter orders by status, date, and item

- **User Profile & Address**:  
  - Manage user profile and address  
  - View order history

- **Security**:  
  - Spring Security integration  
  - Password encryption (BCrypt)  
  - CORS configuration

- **Exception Handling**:  
  - Global exception handler for consistent API error responses

- **Testing**:  
  - Comprehensive unit and integration tests for controllers, services, and entities

---

## Technologies Used

- **Java 21**
- **Spring Boot 3.3.1**
- **Spring Data JPA**
- **Spring Security**
- **JWT (io.jsonwebtoken)**
- **MySQL**
- **Lombok**
- **AWS S3 SDK** (for image storage)
- **JUnit** (for testing)
- **Maven** (build tool)

---

## Prerequisites

- **Java 21** or higher
- **Maven** (for building the project)
- **MySQL** (running locally or accessible remotely)
- **AWS S3 Account** (for product image uploads, or use mock profile)
- (Optional) **Postman** or similar tool for API testing

---

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/MahmoudOsama-007/Ecommerce.git
   cd Ecommerce
   ```

2. **Configure the database:**
   - Update `src/main/resources/application.properties` with your MySQL credentials and database URL.
   - Example:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/dbtest
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     ```

3. **Configure AWS S3 (optional):**
   - Add your AWS S3 access and secret keys in `application.properties` if you want to enable image uploads.
   - remove mock profile

4. **Build the project:**
   ```bash
   mvn clean install
   ```

5. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication
- `POST /auth/register` — Register a new user
- `POST /auth/login` — Login and receive JWT token

### User
- `GET /user/get-all` — List all users (Admin only)
- `GET /user/my-info` — Get current user info and order history

### Product
- `POST /product/create` — Create product (Admin only)
- `PUT /product/update` — Update product (Admin only)
- `DELETE /product/delete/{productId}` — Delete product (Admin only)
- `GET /product/get-all` — List all products
- `GET /product/get-by-product-id/{productId}` — Get product by ID
- `GET /product/get-by-category-id/{categoryId}` — List products by category
- `GET /product/search?searchValue=...` — Search products

### Category
- `POST /category/create` — Create category (Admin only)
- `PUT /category/update/{categoryId}` — Update category (Admin only)
- `DELETE /category/delete/{categoryId}` — Delete category (Admin only)
- `GET /category/get-all` — List all categories
- `GET /category/get-category-by-id/{categoryId}` — Get category by ID

### Order
- `POST /order/create` — Place an order
- `PUT /order/update-item-status/{orderItemId}` — Update order item status (Admin only)
- `GET /order/filter` — Filter order items (Admin only)

### Address
- `POST /address/save` — Save or update user address

---

## Usage Examples

### Register a User

```http
POST /auth/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "phoneNumber": "1234567890"
}
```

### Login

```http
POST /auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```
_Response will include a JWT token for authenticated requests._

### Create a Product (Admin)

```http
POST /product/create
Headers:
  Authorization: Bearer <JWT_TOKEN>
Content-Type: multipart/form-data

Fields:
  categoryId: 1
  image: (file)
  name: "Laptop"
  description: "High performance laptop"
  price: 1200.00
```

### Place an Order

```http
POST /order/create
Headers:
  Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ]
}
```

---
