# eldarPaula
 Para levantar la aplicación se necesita seguir los siguientes pasos:
 
1- Configurar una base de datos en el archivo src/main/resources/application.properties utilizando el siguiente template:

*****************************************************************
spring.datasource.url=[URL DE LA BASE DE DATOS]
spring.datasource.username=[USERNAME]
spring.datasource.password=[CONTRASEÑA]
spring.datasource.driver-class-name=[DATASOURCE DRIVER]
******************************************************************

2- Correr el archivo src/main/resources/sql/create_table en dicha base de datos

3- Correr el comando mvn spring-boot:run

API REST

path: localhost:8080/creditCard
Se debe enviar como datos los parámetros siguientes:
Amount
brandName
cardNumber
cardholder
dueDate
