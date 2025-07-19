# Práctica Spring Boot - User API

Este es un repositorio para recordar y practicar conocimientos de **Spring Boot**. El proyecto implementa una API REST para la gestión de usuarios con operaciones CRUD completas.

## 🚀 Características

- **Spring Boot 3.x** - Framework principal
- **Spring Security** - Autenticación y autorización
- **Spring Data JPA** - Persistencia de datos
- **BCrypt** - Encriptación de contraseñas
- **Swagger/OpenAPI** - Documentación automática de la API
- **Flyway** - Migraciones de base de datos
- **Lombok** - Reducción de código boilerplate
- **Maven** - Gestión de dependencias

## 📋 Funcionalidades

- ✅ Crear usuarios
- ✅ Listar todos los usuarios
- ✅ Obtener usuario por ID
- ✅ Actualizar información de usuario
- ✅ Eliminar usuarios
- ✅ Encriptación de contraseñas
- ✅ Manejo global de excepciones
- ✅ Validación de datos

## 🛠️ Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database** (desarrollo)
- **Flyway Migration**
- **Maven**
- **Swagger UI**

## 📚 Documentación de la API

La API está completamente documentada con Swagger UI. Una vez que el servidor esté ejecutándose, puedes acceder a la documentación en:

🔗 **[http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui)**

## 🚀 Cómo ejecutar

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/Danie0822/practica-spring-boot.git
   ```

2. **Ejecutar la aplicación**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acceder a la documentación**
   - Swagger UI: `http://localhost:8080/swagger-ui`

##  Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/userapi/
│   │   ├── config/          # Configuraciones
│   │   ├── controller/      # Controladores REST
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── entity/         # Entidades JPA
│   │   ├── exception/      # Manejo de excepciones
│   │   ├── repository/     # Repositorios JPA
│   │   ├── service/        # Lógica de negocio
│   │   └── response/       # Objetos de respuesta
│   └── resources/
│       ├── application.properties
│       └── db/migration/   # Scripts de migración
└── test/                   # Pruebas unitarias
```

## 🔄 Próximas Mejoras

Este proyecto se irá actualizando con nuevas funcionalidades y mejoras:

- [ ] Implementar autenticación JWT
- [ ] Añadir paginación en listados
- [ ] Dockerizar la aplicación
- [ ] Eliminación suave
- [ ] Añadir pruebas unitarias e integración
- [ ] Implementar roles y permisos
- [ ] Añadir cache con Redis
- [ ] Añadir logging con Logback
- [ ] Implementar CI/CD con GitHub Actions
- [ ] Añadir métricas con Actuator
