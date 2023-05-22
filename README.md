# Lamda Richo Vanjaya Sumaryadi
# 201524049
# ETS PPLBO 49

## Implementasi Access Token pada Microservices Kafe And Bakery

## Teknologi:
- Java
- Springboot
- MongoDB
- Laragon
- Docker

## Service yang tersedia
 
- Account Service 
- Accounting Service 
- API Gateway
- Consumer Service
- Delivery Service
- Discovery Server
- Gerai Service
- Inventory Service
- Kitchen Service
- Order Service
- Product Service 

## Rest API

List endpoint dan method pada setiap service yang bisa dirun

| Service    | Method | endpoint                              |
| ---------- | ------ | ------------------------------------- |
| Account    | GET    | http://localhost:8080/api/account     |
| Account    | POST   | http://localhost:8080/api/account     |
| Gerai      | GET    | http://localhost:8080/api/gerai       |
| Gerai      | POST   | http://localhost:8080/api/gerai       |
| Inventory  | GET    | http://localhost:8080/api/intenvory   |
| Inventory  | POST   | http://localhost:8080/api/intenvory   |
| Order      | GET    | http://localhost:8081/api/order       |
| Order      | POST   | http://localhost:8081/api/order       |
| Product    | GET    | http://localhost:8080/api/product     |
| Product    | POST   | http://localhost:8080/api/product     |

## How to use

1. Install IntelliJ IDE
2. Install MongoDB
3. Install Laragon
   - After install, start mysql
   - Create database: order_service and inventory_service
4. Install Docker (for access token)
   - Image run : quay.io/keycloak/keycloak:20.0.3 
5. Start server:
   - API Gateway
   - Discovery Service
   - Account Service
   - Gerai Service
   - Product Service
   - Inventory Service
   - Order Service
   
