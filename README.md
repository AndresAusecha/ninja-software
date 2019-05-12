Gestión De Turnos Ninja Software
================

Tabla of contenidos
----------------

* Arquitectuta empleada
* Casos de uso
* Instrucciones de instalacion
* Instrucciones de uso

## Arquitectura
 Se empleó arquitectura tipo cebolla con el objetivo de desacoplar el código, hacerlo menos dependiente y respetar la 
 separación de tareas, en tres capas; modelo del dominio, servicios del dominio, servicios de aplicación y externa 
 
## Casos de uso

#### CRUD empleados
Operaciones sobre entidad empleados básicas crear, actualizar, eliminar, leer

#### CRUD turnos
Operaciones sobre entidad turnos básicas crear, actualizar, eliminar, leer

#### Listados,busquedas y filtros
* Buscar empleados por numero de identificacion, listar empleados organizados por apellido.
* Buscar turnos por fecha entre día inicio y día fin, hora entre hora inicio y hora fin, hora de inicio específica,
 hora fin específica.
  
## Instrucciones de instalacion
* nota: La implementación se realizó con mysql 8
* crear esquema
```
CREATE SCHEMA `prueba-ninja-software`;
```
* poner ese nombre de esquema en application.properties
* poner usuario y contraseña
* poner host, puerto y esquema en application.properties
* por defecto se eliminan tablas y vuelen a crear, para no borrar datos de prueba se puede reemplazar "drop-create" por "validate"

Ejemplo:
```
spring.output.ansi.enabled=ALWAYS
spring.application.name=Prueba-ninja-software

# Tomcat Server configuration
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/prueba-ninja-software?serverTimezone=America/Bogota
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=drop-create
spring.jpa.show-sql=true
```


## Instrucciones de uso