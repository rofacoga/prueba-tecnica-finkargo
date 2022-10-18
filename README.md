# Módulo de Gestión de datos de Personas y empresas 
* Repositorio del micro-servicio solicitado como prueba técnica de Finkargo para desarrollador back-end. 

Este proyecto es un micro-servicio el cual permite gestionar los datos de todas las empresas (proveedores, beneficiarios, partners, fiduciarias) donde nos encontramos operando en los distintos países latinoaméricanos, también permite gestionar los tipos de personas que están vinculadas a cada empresa (accionistas, contactos, consultores).

Para dicha solución se tienen las siguientes consideraciones:
### * Entidades del dominio
![Diagrama relacional o diagrama de entidades de dominio](img\diagrama_relacional-drawio.png)
Esta es el diagrama relacional el cual muestra como está constituido el servicio en cuanto a la base de datos, para este micro-servicio se elige como base de datos relacionales PostgreSQL, puesto que permite el manejo optimizado para indices de tipo UUID, el rendimiento es alto al momento de ejecutar consultas en ambitos donde se tienen muchas cantidades de datos.

