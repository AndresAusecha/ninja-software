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
* poner host, puerto y esquema en application.properties
* poner usuario y contraseña
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

### Empleado
#### Crear
```
curl -X POST \
  http://localhost:8080/logica-negocio/empleado/crear \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 7d96fee0-6f99-4738-ba7d-5f77cfb9f25c' \
  -H 'cache-control: no-cache' \
  -d '{
    "numeroIdentificacion": "1017181249",
    "nombre": "Ana sofia",
    "apellido": "Pardo Hernandez"
}'
```

#### Actualizar
```
curl -X PUT \
  http://localhost:8080/logica-negocio/empleado/actualizar/3 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 62a73363-c2e5-4589-be9e-dc83df0171e7' \
  -H 'cache-control: no-cache' \
  -d '{
    "numeroIdentificacion": "1017181249",
    "nombre": "Sofia",
    "apellido": "Pardo"
}'
```

#### Leer
```
curl -X GET \
  http://localhost:8080/logica-negocio/empleado/leer/1 \
  -H 'Postman-Token: e22b1b27-59fa-47b4-8ae2-eff1784a21f3' \
  -H 'cache-control: no-cache'
```

### Eliminar
```
curl -X DELETE \
  http://localhost:8080/logica-negocio/empleado/eliminar/1 \
  -H 'Postman-Token: dc35c3e3-4b62-452e-8ae7-6cf04cb7ac18' \
  -H 'cache-control: no-cache'
```
 
 