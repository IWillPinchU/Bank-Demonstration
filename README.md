# 💼 BigBank – Cloud-Native Banking Microservices

A production-ready, fault-tolerant **banking backend system** built on **Spring Boot**, deployed using **Kubernetes**, and enhanced with **Helm, Kafka, Keycloak, Grafana, Prometheus, Loki, Tempo**, and **Resilience4j**.

It features **Accounts**, **Cards**, and **Loans** microservices, secured by **OAuth2**, monitored with full observability tooling, and designed for modern cloud-native infrastructure.

---

## 📁 Project Structure

```
bigbank/
├── accounts/                     # Legacy or base microservice
├── cards/
├── configserver/
├── gatewayserver/
│
├── bigbank-services/            # Core services (Spring Boot)
│   ├── accounts/
│   ├── cards/
│   ├── configserver/
│   ├── gatewayserver/
│   ├── loans/
│   └── message/                 # Kafka-based messaging
│
├── environments/                # Helm values for each environment
│   ├── dev-env/
│   ├── prod-env/
│   └── qa-env/
│
├── helm/                        # Helm charts for infra
│   ├── bigbank-common/
│   ├── grafana/
│   ├── grafana-loki/
│   ├── grafana-tempo/
│   ├── kafka/
│   ├── keycloak/
│   └── kube-prometheus/
│
├── kubernetes/
│   └── kubernetes-discoveryserver.yml
│
├── fix-tempo.ps1                # Helper script for Tempo config
└── README.md
```

---

## ✅ Key Features

| Category              | Details                                             |
| --------------------- |-----------------------------------------------------|
| **Language**          | Java 17, Spring Boot                                |
| **Security**          | Keycloak (OAuth2, OpenID Connect), RBAC             |
| **Service Discovery** | Spring Cloud Kubernetes                             |
| **API Gateway**       | Spring Cloud Gateway                                |
| **Config Server**     | Centralized using Spring Config                     |
| **Communication**     | REST + Kafka for async messaging                    |
| **Observability**     | Prometheus, Grafana, Loki, Tempo                    |
| **Resilience**        | ✅ **Resilience4j** Circuit Breaker + Retry support  |
| **Deployment**        | Kubernetes via Helm charts                          |
| **Multi-env Support** | dev, qa, prod                                       |

---

## 💪 Built-in Resilience

All microservices are enhanced with:

* **Circuit Breakers**: Prevent cascading failures (via Resilience4j)
* **Retry Policies**: Automatically retry transient failures (e.g., network glitches)
* **Fallbacks**: Optional degraded behavior if downstream services fail

Configurable in `application.yml` per service:

```yaml
resilience4j:
  circuitbreaker:
    instances:
      someService:
        registerHealthIndicator: true
        slidingWindowSize: 10
        failureRateThreshold: 50
  retry:
    instances:
      someService:
        maxAttempts: 3
        waitDuration: 500ms
```

---

## 🔐 Authentication Flow

* Uses **Keycloak** for authentication and token generation
* JWT tokens are validated at the **API Gateway**
* Role-based access is enforced using Spring Security

---

## 📊 Observability Stack

| Tool           | Purpose                 |
| -------------- | ----------------------- |
| **Prometheus** | Metrics scraping        |
| **Grafana**    | Dashboard visualization |
| **Loki**       | Log aggregation         |
| **Tempo**      | Distributed tracing     |

Includes JVM metrics, HTTP latency, Kafka lag, and resilience events.

---

## 🧪 Setup Summary

```bash
# Clone
git clone https://github.com/IWillPinchU/Bank-Demonstration.git
cd bigbank

# Install Helm dependencies (in ./helm)
helm install kafka ./helm/kafka
helm install keycloak ./helm/keycloak
helm install prometheus ./helm/kube-prometheus
helm install grafana ./helm/grafana
helm install loki ./helm/grafana-loki
helm install tempo ./helm/grafana-tempo

# Deploy discovery server
kubectl apply -f kubernetes/kubernetes-discoveryserver.yml

# Deploy services (example for dev)
helm install bigbank prod-env

```

---

## 🌐 API Summary

| Service   | Endpoint                                  | Description            |
| --------- | ----------------------------------------- | ---------------------- |
| Accounts  | `/api/accounts/{id}`                      | Get account details    |
| Cards     | `/api/cards/account/{accountId}`          | Get all cards          |
| Loans     | `/api/loans`                              | Apply for loan         |
| Messaging | Kafka: `account-created`, `loan-approved` | Internal communication |

---

## 📌 Environment-Specific Config

All Helm overrides and environment files are in:

```
environments/
├── dev-env/
├── qa-env/
└── prod-env/
```

Each contains values for:

* image version
* replica count
* DB URIs
* Kafka topics
* Resilience4j configuration

---

## 🧠 Future Plans

* Add Swagger/OpenAPI spec generation
* CI/CD with GitHub Actions + Helm upgrade
* JWT token refresh
* Real-time audit logging via Kafka sink
* PostgreSQL support for production-grade DB

---

## 🤝 Contributing

```bash
# Fork the repo
# Create your branch: git checkout -b feature/xyz
# Commit your changes
# Push and open a PR
```

---

## 📬 Contact

Maintained by [@IWillPinchU](https://github.com/IWillPinchU)
Issues, feedback, and contributions welcome!

---
