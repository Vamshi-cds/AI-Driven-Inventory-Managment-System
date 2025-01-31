inventory-system/
├── backend/                          # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           ├── controller/       # REST Controllers
│   │   │   │           │   ├── ProductController.java
│   │   │   │           │   └── InventoryController.java
│   │   │   │           ├── exception/        # Custom Exceptions
│   │   │   │           │   └── ResourceNotFoundException.java
│   │   │   │           ├── model/            # Entity Classes
│   │   │   │           │   ├── Product.java
│   │   │   │           │   └── Inventory.java
│   │   │   │           ├── repository/       # JPA Repositories
│   │   │   │           │   ├── ProductRepository.java
│   │   │   │           │   └── InventoryRepository.java
│   │   │   │           ├── service/          # Business Logic
│   │   │   │           │   └── DemandForecastService.java
│   │   │   │           └── InventoryApplication.java  # Main Application Class
│   │   │   └── resources/
│   │   │       ├── application.properties    # Configuration
│   │   │       └── static/                   # Static Files (optional)
│   │   └── test/                             # Unit Tests (optional)
│   ├── pom.xml                               # Maven Configuration
│   └── Dockerfile                            # Docker Configuration
│
├── frontend/                         # React Frontend
│   ├── public/
│   │   └── index.html                 # HTML Entry Point
│   ├── src/
│   │   ├── components/                # React Components
│   │   │   ├── Dashboard.js
│   │   │   └── ProductList.js
│   │   ├── App.js                     # Main App Component
│   │   ├── index.js                   # React Entry Point
│   │   └── index.css                  # Global Styles (optional)
│   ├── package.json                   # NPM Configuration
│   ├── package-lock.json              # NPM Lock File
│   └── Dockerfile                     # Docker Configuration
│
├── ai-service/                        # Python AI Service
│   ├── app.py                         # Flask Application
│   ├── requirements.txt               # Python Dependencies
│   └── Dockerfile                     # Docker Configuration
│
├── docker-compose.yml                 # Docker Compose Configuration
└── README.md                          # Project Documentation