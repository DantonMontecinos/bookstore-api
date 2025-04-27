Tecnologías:
Backend	Java 21, Spring Boot 3.x (Web, Data JPA, Actuator), Hibernate, Lombok
Base de Datos	MySQL 8 (Dockerizado)
Infraestructura	Docker, Docker Compose
Herramientas	Maven, Git, Postman

✅ CRUD Completo de libros (Crear, Leer, Actualizar, Eliminar)
✅ Validación de datos con Spring Validation (@NotBlank, @Positive)
✅ Conexión a base de datos MySQL en contenedor Docker
✅ Endpoints de monitoreo con Spring Boot Actuator (/health, /info)
✅ Documentación implícita de API (vía Postman/OpenAPI)
✅Clean Code, API RESTful, Containerización, Variables de Entorno

POST	/api/libros	Crear libro nuevo	JSON con titulo, autor, precio
GET	/api/libros/{id}	Obtener libro por ID
GET	/api/libros	Listar todos los libros
GET	/api/libros	Listar todos los libros
DELETE	/api/libros/{id}	Eliminar libro
