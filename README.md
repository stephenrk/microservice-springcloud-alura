# Microservices E-commerce Platform

A robust microservices-based e-commerce platform built with Spring Boot and Spring Cloud, demonstrating modern distributed system architecture and best practices.

## 🏗️ Architecture

The platform consists of the following microservices:

### Core Services
- **Store Service (`loja`)**: Handles customer orders and orchestrates the purchase flow
- **Supplier Service (`fornecedor`)**: Manages product inventory and order fulfillment
- **Eureka Server**: Service discovery and registration
- **Config Server**: Centralized configuration management

## 🚀 Features

### Store Service
- Order processing and management
- Integration with supplier service for product availability
- Address validation and order tracking
- Distributed tracing with Spring Cloud Sleuth

### Supplier Service
- Product catalog management
- Inventory tracking by state/region
- Order processing and status management
- Real-time order status updates

## 🛠️ Technology Stack

- **Framework**: Spring Boot 2.1.13
- **Service Discovery**: Netflix Eureka
- **Configuration Management**: Spring Cloud Config
- **API Communication**: 
  - OpenFeign for declarative REST clients
  - RestTemplate with load balancing
- **Distributed Tracing**: Spring Cloud Sleuth
- **Logging**: 
  - Logback
  - Papertrail integration for centralized logging
- **Database**: JPA/Hibernate with relational database
- **Build Tool**: Maven

## 📋 Prerequisites

- Java 8
- Maven 3.x
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.)
- Git

## 🚀 Getting Started

1. Clone the repository:
```bash
git clone https://github.com/sknupfer/microservice-springcloud-alura.git
cd microservice-springcloud-alura
```

2. Start the services in the following order:
   - Config Server (port 8888)
   - Eureka Server (port 8761)
   - Supplier Service (port 8081)
   - Store Service (port 8080)

3. Build and run each service:
```bash
mvn clean install
mvn spring-boot:run
```

## 🔄 Service Communication

The services communicate through REST APIs and use Eureka for service discovery:

1. Store Service → Supplier Service:
   - Product information retrieval
   - Order placement
   - Order status updates

2. All services register with Eureka Server for service discovery

## 📝 API Documentation

### Store Service Endpoints
- `POST /compra`: Create a new order
  - Request body: `CompraDTO` with items and delivery address
  - Response: Order details with status and preparation time

### Supplier Service Endpoints
- `GET /info/{estado}`: Get supplier information by state
- `GET /produto/{estado}`: Get products available in a state
- `POST /pedido`: Create a new order
- `GET /pedido/{id}`: Get order status by ID

## 🔍 Monitoring and Logging

- Distributed tracing with Spring Cloud Sleuth
- Centralized logging with Papertrail
- Service health monitoring through Eureka dashboard

## 🏗️ Project Structure

```
microservice-springcloud-alura/
├── config-server/          # Configuration server
├── eureka-server/         # Service discovery server
├── fornecedor/            # Supplier service
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── br/com/alura/microservice/fornecedor/
│   │   │   │       ├── controller/    # REST endpoints
│   │   │   │       ├── model/         # Domain entities
│   │   │   │       ├── repository/    # Data access
│   │   │   │       ├── service/       # Business logic
│   │   │   │       └── dto/           # Data transfer objects
│   │   │   └── resources/
│   │   └── test/
└── loja/                  # Store service
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── br/com/alura/microservice/loja/
    │   │   │       ├── controller/    # REST endpoints
    │   │   │       ├── model/         # Domain entities
    │   │   │       ├── service/       # Business logic
    │   │   │       ├── client/        # Feign clients
    │   │   │       └── dto/           # Data transfer objects
    │   │   └── resources/
    │   └── test/
```

## 🔒 Security Considerations

- Service-to-service communication is internal and secured
- External endpoints should be protected with appropriate authentication
- Sensitive configuration is managed through the config server

## 🎯 Future Improvements

- Add API Gateway for unified access point
- Implement Circuit Breaker pattern with Resilience4j
- Add authentication and authorization
- Implement event-driven architecture with message queues
- Add containerization with Docker
- Implement CI/CD pipeline

## 📚 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Microservices Patterns](https://microservices.io/patterns/index.html)


## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details. 