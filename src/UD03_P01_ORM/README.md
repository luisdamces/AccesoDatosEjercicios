# Links con documentación para la instalación de Hibernate en Eclipse

[Documentación para la instalación de Hibernate](https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/)

# Hibernate ORM

## Contexto
El mapeo objeto-relacional consiste en la conversión de tipos utilizando un lenguaje de programación orientado a objetos y una base de datos relacional como motor de persistencia. 

En el lenguaje que nos ocupa, Java, se desarrolló un sistema de persistencia denominado JPA (API de persistencia Java), una de cuyas implementaciones, de software libre, es Hibernate.


## Preparación del entorno
1. Descarga de [Hibernate](http://hibernate.org/orm/) 
2. Descarga de [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
3. Instalación del plugin de Jboss Tools (solo Hibernate) a través de eclipse Marketplace.
4. Crear proyecto nuevo (Java Project). Crear carpeta lib. Copiar *.jar(s)* del conector y de *hibernate/lib/required* a lib
5. Agregar jar copiados en Java Build Path (Project Properties) --> *Add jar*
6. Añadir a carpeta src del proyecto el fichero de configuración de hibernate (.xml).

### Ejemplo de fichero de configuración de hibernate

Debe estar fuera de todos los packages, en la carpeta raíz del código, src. Contiene la configuración y las clases que se van a mapear.

```xml
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- JDBC Database connection settings -->
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/nba?serverTimezone=UTC</property>
        <property name="connection.username">prueba_hibernate</property>
        <property name="connection.password">prueba_hibernate</property>

        <!-- JDBC connection pool settings ... using built-in test pool -->
        <property name="connection.pool_size">1</property>

        <!-- Select our SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Echo the SQL to stdout -->
        <property name="show_sql">true</property>

		<!-- Set the current session context -->
		<property name="current_session_context_class">thread</property>

		<!-- ¡¡IMPORTANTE!! O se indica resource o se indica class, aquí se ponen los dos como ejemplo --> 
		<mapping resource="hibernate/modelos/entidades/equipos.hbm.xml"/>
	    <mapping class="modelo.entidades.Equipos"/>
 
    </session-factory>

</hibernate-configuration>
```

* El tag raiz del documento xml se llama *<hibernate-configuration>*.
* Dentro de *<hibernate-configuration>* encontramos el tag *<session-factory>* que contiene la configuración de hibernate.
* Las siguientes líneas son las propiedades de configuración mediante el tag *<property>*
	* *name* es el nombre de la propiedad de configuración.
	* Dentro de la etiqueta *property* se indica el valor de la propiedad de configuración.
* El tag *<mapping>* indica a hibernate las clases que queremos usar desde dicho ORM.
* El atributo *resource* contiene el nombre de un fichero .hbm.xml asociado a la clase a persistir.
* El atributo *class* contiene la clase (package incluido) que se va a persistir. Es excluyente con resource y viceversa.


## Mapeo

El proceso de traslación de clases Java a tablas de la base de datos y viceversa se denomina mapeo y puede realizarse mediante la configuración de un XML o Java Annotations (metadatos en el código fuente).

Hay recursos para resolver las relaciones 1:N y M:N entre clases. Además, se provee un mecanismo de relación entre objetos de la misma clase.

### Mapeo de una Entidad

Una entidad es una clase Java que se persiste en la base de datos. Para ello, la clase debe tener las siguientes características:

* Implementar el interfaz [Serializable](https://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html)
* Declarar un constructor público sin ningún tipo de argumentos.
* Tener un método get/set asociado para cada propiedad a persistir.

Una vez hecho esto, hay que indicar la información relativa a la clase a hibernate, o metainformación. Esto incluye indicar como se va a mapear el objeto en la base de datos, indicando a qué tabla de la base de datos se asocia, cuál es la clave primaria, las columnas y otra información que pueda ser relevante dependiendo de la entidad.

#### Mapeo mediante XML (ficheros *.hbm.xml*)
De cada clase que hay que persistir se debe crear un fichero xml con la información que permitá mapear la clase a una base de datos relacional. Este fichero puede estar en el mismo package que la clase java o en otro distinto.

Hay dos tendencias sobre esto y ambas tienen ventajas e inconvenientes:

* En el mismo package:

	* La clase Java y su correspondiente fichero de mapeo juntos facilita algún cambio en la clase Java y el cambio en el fichero de mapeo.

* En un package diferente: 

	* Implica crear un package alternativo para los ficheros *.hbm.xml* que permitirá localizarlos más fácilmente o eliminarlos si se deja de usar hibernate.

Estructura del fichero xml de mapeo:

* Declaración de xml y [DOCTYPE](http://hibernate.org/dtd/hibernate-mapping-3.0.dtd)
* Nodo raíz del documento *<hibernate-mapping>*
* Nodo *class*, indica que se va a mapear una clase
	* El atributo *name* es el nombre de la clase a mapear (incluyendo el package).
	* El atributo table indica el nombre de la tabla a mapear en la clase. Es opcional si la clase Java y la tabla se llaman igual.

* El tag *<id>* indica el atributo de la clase que es la clave primaria.
	* El atributo *name* es el nombre de la propiedad Java que contiene la clave primaria.
	* El atributo *column* contiene el nombre de la columna de la base de datos asociado a la propiedad. Es opcional si la columna y el atributo de la clase se llaman igual.
	* El atributo *type* indica el tipo de la propiedad Java. 

* El tag *<property>* declara más propiedades Java para ser mapeadas en la base de datos. Las que no se declaran, no se mapean.
	* *name* es el nombre de la propiedad Java que se mapea a la base de datos.
	* *column* es el nombre de la columna de la base de datos asociado a la propiedad. Igual que con la tabla y la clave primaria, es opcional si ambos nombres son iguales.
	* *type* es el tipo de la propiedad Java que va a tener el campo.

Hay más opciones, pero por ahora nos quedaremos en las más elementales.

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN" "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping auto-import="true" default-access="property" default-cascade="none" default-lazy="true">
    <class catalog="nba" dynamic-insert="false" dynamic-update="false" mutable="true" name="modelo.entidades.Jugadores" optimistic-lock="version" polymorphism="implicit" select-before-update="false" table="jugadores">
        <id name="codigo" type="int">
            <column name="codigo"/>
            <generator class="assigned"/>
        </id>
        <many-to-one class="modelo.entidades.Equipos" embed-xml="true" fetch="select" insert="true" name="equipos" not-found="exception" optimistic-lock="true" unique="false" update="true">
            <column length="20" name="Nombre_equipo"/>
        </many-to-one>
        <property generated="never" lazy="false" name="nombre" optimistic-lock="true" type="string" unique="false">
            <column length="30" name="Nombre"/>
        </property>
        <property generated="never" lazy="false" name="procedencia" optimistic-lock="true" type="string" unique="false">
            <column length="20" name="Procedencia"/>
        </property>
        <property generated="never" lazy="false" name="altura" optimistic-lock="true" type="string" unique="false">
            <column length="4" name="Altura"/>
        </property>
        <property generated="never" lazy="false" name="peso" optimistic-lock="true" type="java.lang.Integer" unique="false">
            <column name="Peso"/>
        </property>
        <property generated="never" lazy="false" name="posicion" optimistic-lock="true" type="string" unique="false">
            <column length="5" name="Posicion"/>
        </property>
        <set embed-xml="true" fetch="select" inverse="true" lazy="true" mutable="true" name="estadisticases" optimistic-lock="true" sort="unsorted" table="estadisticas">
            <key on-delete="noaction">
                <column name="jugador" not-null="true"/>
            </key>
            <one-to-many class="modelo.entidades.Estadisticas" embed-xml="true" not-found="exception"/>
        </set>
    </class>
</hibernate-mapping>
```

Una cosa a tener en cuenta es que igual que se necesitan los get/set de cada campo para que hibernate pueda acceder a ellos, puede darse el caso de necesitar que no estén (para que el usuario no pueda modificarlos o verlos, por ejemplo). En ese caso, hay que indicar a hibernate que acceda directamente al atributo, mediante *access="field"* dentro de la etiqueta *property* o *id*.

#### Mapeo mediante Java Annotations

Para evitar la marea de ficheros xml se ha extendido el uso de Anotaciones Java en el propio código. Estas anotaciones permiten especificar de una forma más sencilla (y breve) la información de mapeo de las clases Java.

Inicialmente Hibernate creó sus propia anotaciones en el package *org.hibernate.annotations* pero han sido *java.lang.Deprecated* desde la versión 4 y ya no deben usarse. Las anotaciones que deben usarse actualmente son las del estándar de JPA que se encuentran en el package *javax.persistence*. Asimismo hay características propias de Hibernate que  JPA no contempla y hace que aún sea necesario usar alguna anotación del package *org.hibernate.annotations* (éstas aún no son deprecated).

```JAVA
@Entity
@Table(name="equipos")
public class Equipos implements java.io.Serializable {

	@Id
    @Column(name="nombre")
	private String nombre;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="conferencia")
	private String conferencia;
	
	@Column(name="division")
	private String division;
	
	// Las relaciones también se mapean
	private Set jugadoreses = new HashSet(0);
	private Set partidosesForEquipoVisitante = new HashSet(0);
	private Set partidosesForEquipoLocal = new HashSet(0);

	public Equipos() {
	}

	public Equipos(String nombre) {
		this.nombre = nombre;
	}

	public Equipos(String nombre, String ciudad, String conferencia, String division, Set jugadoreses,
			Set partidosesForEquipoVisitante, Set partidosesForEquipoLocal) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.conferencia = conferencia;
		this.division = division;
		this.jugadoreses = jugadoreses;
		this.partidosesForEquipoVisitante = partidosesForEquipoVisitante;
		this.partidosesForEquipoLocal = partidosesForEquipoLocal;
	}
	//Aquí vendría la relación de get/set de cada propiedad
```

* ```@Entity:``` Se aplica a la clase e indica que esta clase Java es una entidad a persistir. Es anotación estándar de JPA.
* ```@Table(name=“equipos”):``` Se aplica a la clase e indica el nombre de la tabla de la base de datos donde se persistirá la clase. Opcional si la clase y la tabla se llaman igual. Es anotación estándar de JPA. 
* ```@Id:``` Se aplica a una propiedad Java e indica que este atributo es la clave primaria. Es anotación estándar de JPA. En nuestro ejemplo estamos indicando que la propiedad Java nombre es la clave primaria.
* ```@Column(name=“nombre”):``` Indica el nombre de la columna de la base de datos en la que se persistirá la propiedad. Es opcional si el nombre de la propiedad Java coincide con el de la columna de la base de datos. Es anotación estándar de JPA. En nuestro ejemplo estamos indicando que la propiedad Java nombre se persistirá en una columna llamada nombre.
* Se hace para cada columna...

El acceso directo a las propiedades sin usar getters o setters es colocar la anotación sobre la propiedad en sí y no sobre el método get.

Una de las diferencias entre ambos mecanismos de mapeo es que hbm exige indicar todas las propiedades que se desea mapear, mientras que las anotaciones no hace falta. Éstas mapean todos los campos que tengan get/set.


## Uso de Hibernate

La clase más utilizada es [```org.hibernate.Session```](https://docs.jboss.org/hibernate/orm/5.3/javadocs/org/hibernate/Session.html). Contiene los métodos necesarios para leer, borrar o guardar entidades sobre la base de datos. Aún así, antes de utilizarla es necesario crear el objeto [SessionFactory](https://docs.jboss.org/hibernate/orm/5.3/javadocs/org/hibernate/SessionFactory.html)

| Elemento       | Descripción                                                                    |
| -------------  |:-------------------------------------------------------------------------------:|
| SessionFactory | Factoría de objetos *session* y cliente del proveedor de *Connection*. Mantiene el segundo nivel de cache de datos.   |
| Session        | Proporciona una interfaz entre la aplicación y los datos almacenados en la BD, encapsula la conexión JDBC. Es una factoría de *Transaction* |
| Transaction    | Este objeto especifica la unidad atómica de trabajo (opcional). |
| ConnectionProvider | Factoría de conexiones JDBC que abstrae la aplicación del Driver o DataSource. (opcional) |
| TransactionFactory | Factoría de *Transaction* (opcional) |

## Hibernate Query Language (HQL)

### Introducción a HQL
El Hibernate Query Languaje (HQL) es el lenguaje de consultas que usa Hibernate para obtener los objetos desde la base de datos. Su principal particularidad es que las consultas se realizan sobre los objetos java que forman nuestro modelo de negocio, es decir, las entidades que se persisten en Hibernate. Ésto hace que HQL tenga las siguientes características:

Los tipos de datos son los de Java.
Las consultas son independientes del modelo de tablas de la base de datos y del lenguaje de SQL específico de la base de datos.
Es posible tratar con las colecciones de Java y navegar entre los distintos objetos en la propia consulta.

En Hibernate las consultas HQL se ejecutan sobre el modelo de entidades definido en Hibernate, esto es, sobre las clases de negocio.
Se podría ver que nuestro modelo de tablas en HQL son las clases Java y NO las tablas de la base de datos. Aunque esto no es técnicamente así. Debe notarse que al hacer ”SELECT columna FROM nombreTabla”, el ”nombreTabla” será una clase Java y ”columna” será una propiedad Java de dicha clase y nunca una tabla de la base de datos ni una columna de una tabla.

### La clase Query
Una característica fundamental de cualquier ORM es la necesidad de leer los objetos de la base de datos.

Hibernate tiene el objeto *Query* que nos da acceso a todas las funcionalidades para poder leer objetos desde la base de datos. Veamos ahora un sencillo ejemplo de cómo funciona y posteriormente explicaremos más funcionalidades de la clase Query.

```java
Query query = session.createQuery("SELECT j FROM Jugadores j");
	List<Jugadores> jugadores = query.list();
	
	for (Jugadores jugador : jugadores) {
	System.out.println(jugador.toString());
	}
```

Lanzar una consulta con Hibernate es bastante simple. Usando la session llamamos al método createQuery(String queryString) con la consulta en formato HQL y nos retorna un objeto *Query*. Después, sobre el objeto *Query* llamamos al método *list()* que nos retorna una lista de los objetos que ha retornado. Finalmente, se muestran por la consola los valores devueltos.

