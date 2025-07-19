# User API - Spring Boot Practice Repository

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

## 🚀 Cómo ejecutar el proyecto

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+

### Pasos para ejecutar

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/Danie0822/user-api.git
   cd user-api
   ```

2. **Configurar variables de entorno** (opcional)
   ```bash
   cp .env.example .env
   # Edita el archivo .env con tus configuraciones
   ```

3. **Ejecutar la aplicación**
   ```bash
   # Usando Maven
   ./mvnw spring-boot:run
   
   # O en Windows
   mvnw.cmd spring-boot:run
   ```

4. **Acceder a la aplicación**
   - API Base URL: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui`

## 📋 Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/users` | Obtener todos los usuarios |
| GET | `/api/users/{id}` | Obtener usuario por ID |
| POST | `/api/users` | Crear nuevo usuario |
| PUT | `/api/users/{id}` | Actualizar usuario |
| DELETE | `/api/users/{id}` | Eliminar usuario |

## 📁 Estructura del Proyecto

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

## 🤝 Contribuciones

Este es un proyecto de práctica, pero las contribuciones son bienvenidas:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**Daniel Morales** - [Danie0822](https://github.com/Danie0822)

---

⭐ Si este proyecto te ayuda a recordar o aprender Spring Boot, ¡no olvides darle una estrella!
