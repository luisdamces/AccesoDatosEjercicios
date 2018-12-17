## Links con documentación para la instalación de Hibernate en Eclipse

[Documentación para la instalación de Hibernate](https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/)

# Hibernate ORM

## Contexto
El mapeo objeto-relacional consiste en la conversión de tipos utilizando un lenguaje de programación orientado a objetos y una base de datos relacional como motor de persistencia. 

En el lenguaje que nos ocupa, Java, se desarrolló un sistema de persistencia denominado JPA (API de persistencia Java), una de cuyas implementaciones, de software libre, es Hibernate.


## Mapeo

El proceso de traslación de clases Java a tablas de la base de datos y viceversa se denomina mapeo y puede realizarse mediante la configuración de un XML o Java Annotations (metadatos en el código fuente).

Hay recursos para resolver las relaciones 1:N y M:N entre clases. Además, se provee un mecanismo de relación entre objetos de la misma clase.

## Hibernate Query Language (HQL)


| Elemento       | Descripción                                                                    |
| -------------  |:-------------------------------------------------------------------------------:|
| SessionFactory | Factoría de objetos *session* y cliente del proveedor de *Connection*. Mantiene el segundo nivel de cache de datos.   |
| Session        | Proporciona una interfaz entre la aplicación y los datos almacenados en la BD, encapsula la conexión JDBC. Es una factoría de *Transaction* |
| Transaction    | Este objeto especifica la unidad atómica de trabajo (opcional). |
| ConnectionProvider | Factoría de conexiones JDBC que abstrae la aplicación del Driver o DataSource. (opcional) |
| TransactionFactory | Factoría de *Transaction* (opcional) |



## Preparación del entorno
1. Descarga de Hibernate
2. Descarga de MySQL Connector
3. Instalación del plugin de Jboss Tools (solo Hibernate) a través de eclipse Marketplace.
4. Crear proyecto nuevo (Java Project). Crear carpeta lib. Copiar .jar(s) del conector y de hibernate.
5. Agregar jar copiados en Java Build Path (Project Properties).
6. Añadir a carpeta src del proyecto el fichero de configuración de hibernate (.xml)

