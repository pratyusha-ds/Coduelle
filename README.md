# Coduelle - Real-Time Competitive Coding Arena

![Next.js](https://img.shields.io/badge/Next.js-15.x-000000?style=for-the-badge&logo=nextdotjs&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4_/_Java_21-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-7.x-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-4.x-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-27.x-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

**Coduelle** is a mobile-first, full-stack real-time competitive coding application. Designed to transition standard asynchronous coding practice into a high-intensity 1v1 duel arena, it pairs an elastic mobile web client with an isolated, multi-tier asynchronous evaluation engine.

**[Live Demo]()** | **[API Documentation]()**

---

## Project Overview

### The Challenge

Safely executing user-submitted programming code in real time presents critical systems and infrastructure vulnerabilities:

- An unconstrained submission containing infinite loops or excessive memory allocation can choke host machine resources, freezing the server for all active users and leading to resource starvation.
- Untrusted execution parameters open vectors for file-system manipulation or network attacks if run directly inside native app threads.
- Pulling execution updates continuously through REST polling forces massive system overhead, ruining fast-paced matchmaking elements.

### Project Vision

Our goal is to build a bulletproof competitive arena by:

1. **Quarantine Isolation:** Offloading code processing entirely into programmatic, network-muted, resource-capped Docker sandboxes managed via Java background workers.
2. **Decoupled Architecture:** Buffering peak traffic spikes safely through an intermediate RabbitMQ message broker to keep web response latency flat.
3. **Bi-Directional Streaming:** Utilizing full-duplex WebSockets (STOMP) to push real-time test verification progress between competing duelist views instantly.

---

## Key Features

- A fluid mobile web layout featuring fixed problem definitions on top and a responsive monospace editor input filling the lower touchscreen canvas.
- Instant acknowledgment response on submission clicks while the code executes in safe back-end processing layers.
- Dual progress bars detailing exactly how many hidden test checks your opponent has passed in real time.
- Live ranking profiles structured via high-speed memory caches to enable immediate score changes with sub-millisecond lookups.

---

## Tech Stack

| Layer                   | Technology                   | Key Features                                                                              |
| :---------------------- | :--------------------------- | :---------------------------------------------------------------------------------------- |
| **Frontend**            | **Next.js 15 (TypeScript)**  | Mobile-first viewport optimization, Tailwind CSS, Framer Motion transitions               |
| **Real-Time Gateway**   | **Spring Boot & WebSockets** | Java 21 Virtual Threads (Project Loom), STOMP event distribution protocols                |
| **Asynchronous Broker** | **RabbitMQ**                 | Decoupled task exchange topologies routing user code to validation targets                |
| **Sandbox Engine**      | **Java Worker + Docker API** | Programmatic runtime management using strict CPU and Memory boundaries (`--network none`) |
| **Database**            | **PostgreSQL 17**            | Relational data persistence mappings for problem datasets and historical matches          |
| **Caching & Scoring**   | **Redis**                    | High-performance user tracking utilizing memory-efficient Redis Sorted Sets (ZSET)        |

---

## Quick Start

Ensure you have **Docker 27** and **Docker Compose** installed.

1.  **Clone & Enter:**

    ```bash
    git clone [https://github.com/your-username/coduelle](https://github.com/your-username/coduelle) && cd coduelle
    ```

2.  **Environment Setup:** Create a `.env` file in the root directory:

    ```env
    POSTGRES_PASSWORD=your_secure_db_password
    JWT_SECRET=your_jwt_signing_token
    RABBITMQ_DEFAULT_PASS=your_queue_password
    ```

3.  **Spin up the Stack:**

    ```bash
    docker-compose up --build
    ```

    - Mobile Web Frontend: `http://localhost:3000`
    - Gateway Service API: `http://localhost:8080`
    - RabbitMQ Dashboard: `http://localhost:15672`

---

## System Architecture

```mermaid
%%{init: {'theme': 'base', 'themeVariables': { 'primaryColor': '#F8FAFC', 'primaryBorderColor': '#475569', 'primaryTextColor': '#0F172A', 'lineColor': '#64748b'}}}%%
flowchart LR
    Browser[Next.js App] -- Code Submission --> API[Spring Boot Gateway]

    subgraph SubGraph [Asynchronous Core]
    API -- 1. Queue Job --> Queue[RabbitMQ]
    Queue -- 2. Process --> Worker[Java Judge]
    Worker -- 3. Quarantine --> Docker[Docker Sandbox]
    end

    Docker -- 4. Live Update WebSockets --> Browser

    style Browser fill:#EEF2F6,stroke:#475569
    style Docker fill:#F0FDF4,stroke:#166534,stroke-width:2px
```

---

## Developed By

| Name                  | Role          | Links                                                                                                |
| :-------------------- | :------------ | :--------------------------------------------------------------------------------------------------- |
| **Pratyusha Dasari**  | Web Developer | [GitHub](https://github.com/pratyusha-ds) / [LinkedIn](https://www.linkedin.com/in/pratyusha-ds/)    |
| **Banto-Laczi Klára** | Web Developer | [GitHub](https://github.com/bantoklara) / [LinkedIn](https://www.linkedin.com/in/banto-laczi-klara/) |

## License

This project is licensed under the MIT License - see the [LICENSE](https://opensource.org/license/mit/) file for details.
