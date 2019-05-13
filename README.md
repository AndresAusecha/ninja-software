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
 separación de tareas; modelo del dominio, servicios del dominio, servicios de aplicación y externa 
 
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
* por defecto se eliminan tablas y vuelen a crear, para no borrar datos de prueba se puede reemplazar "create-drop" por "validate"

Ejemplo:
```
spring.output.ansi.enabled=ALWAYS
spring.application.name=Prueba-ninja-software

# Tomcat Server configuration
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/prueba-ninja-software?serverTimezone=America/Bogota
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=create-drop
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
  http://localhost:8080/logica-negocio/empleado/actualizar/1 \
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

### Turnos de trabajo
#### Crear
curl -X POST \
```
  http://localhost:8080/logica-negocio/turno/crear \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 10cf6921-02bf-47ec-9c8c-c76404996b59' \
  -H 'cache-control: no-cache' \
  -d '{
	"fechaInicio": "2019-05-13",
	"fechaFin": "2019-05-15",
	"horaInicio": "07:30:00",
	"horaFin": "17:30:00"
}'
```
#### Actualizar
```
curl -X PUT \
  http://localhost:8080/logica-negocio/turno/actualizar/1 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: aa19d2b4-3432-42ab-896a-296cf7942bfd' \
  -H 'cache-control: no-cache' \
  -d '{
	"fechaInicio": "2019-05-20",
	"fechaFin": "2019-05-24",
	"horaInicio": "08:30:30",
	"horaFin": "18:30:30"
}'
```
#### Leer
```
curl -X GET \
  http://localhost:8080/logica-negocio/turno/leer/1 \
  -H 'Postman-Token: 85a70778-7508-47bc-b308-bd63e0ef50d6' \
  -H 'cache-control: no-cache'
```
#### Eliminar
```
curl -X DELETE \
  http://localhost:8080/logica-negocio/turno/eliminar/1 \
  -H 'Postman-Token: 4af1d251-e3cb-43b0-b594-a025d19d5f4a' \
  -H 'cache-control: no-cache'
```

#### Asignar un turno a un empleado
```
curl -X PUT \
  http://localhost:8080/logica-negocio/empleado/asignar-turno-a-empleado/id-empleado/1/id-turno/1 \
  -H 'Postman-Token: 3c72e315-187d-4cf3-857a-f1fb650e6546' \
  -H 'cache-control: no-cache'
```

### Listados,busquedas y filtros
#### Empleados
* por numero de identificacion
```
curl -X GET \
  http://localhost:8080/logica-negocio/empleado/buscar/idEmpleado/1017181249 \
  -H 'Postman-Token: 25105ec9-b7a9-4b1e-9e37-e408d2fd6bcf' \
  -H 'cache-control: no-cache' 
```
* listar ordenando alfabéticamente por apellido
```
curl -X GET \
  http://localhost:8080/logica-negocio/empleado/listar-ordenando-x-apellido \
  -H 'Postman-Token: fe9706bd-723a-4263-b911-6e74a8f81c85' \
  -H 'cache-control: no-cache'
```
#### Turnos
* filtrar por fecha
```
curl -X GET \
  http://localhost:8080/logica-negocio/turno/filtrar/fecha/2019-05-22 \
  -H 'Postman-Token: 1db0e8cc-e42c-44b6-84dd-99acc58f7239' \
  -H 'cache-control: no-cache'
```

* filtrar por hora
```
curl -X GET \
  http://localhost:8080/logica-negocio/turno/filtrar/hora/12:00:00 \
  -H 'Postman-Token: 464c1937-c7c8-4280-89e5-d95783d2ff0b' \
  -H 'cache-control: no-cache'
```

* filtrar turnos con hora inicio cercana a enviada(menos de 60 mins)
```
curl -X GET \
  http://localhost:8080/logica-negocio/turno/filtrar/horaInicio/08:00:00 \
  -H 'Postman-Token: bcac5353-7dc9-4e12-bca0-8ab6b57f06e1' \
  -H 'cache-control: no-cache'
```

* filtrar turnos con hora fin cercana a enviada(menos de 60 mins)
```
curl -X GET \
  http://localhost:8080/logica-negocio/turno/filtrar/horaFin/18:00:00 \
  -H 'Postman-Token: a5a26c6e-c5e1-4c88-bf38-2f522dc3e19e' \
  -H 'cache-control: no-cache'
```

## Consideraciones finales
No se consideró necesario crear un campo para días abarcados en turnos, ya que complicaba el diseño
y se podía sacar con una consulta. Se aplicaron validaciones no expresadas pero obvias como validar fechas 
y horas, campos obligatorios, turnos de trabajo no pueden tener ser fechas pasadas, fecha/hora fin de turno debe ser superior
a fecha/hora inicio.  
