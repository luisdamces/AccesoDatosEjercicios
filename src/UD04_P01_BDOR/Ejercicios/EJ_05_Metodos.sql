---------M�TODOS-------

/* De forma habitual, en programaci�n orientada a objetos, cuando se define una 
clase tambi�n se establecen los m�todos que modelan su comportamiento. En el 
contexto que nos ocupa, los m�todos son procedimientos y funciones que se 
especifican despu�s de los atributos del objeto. Pueden ser de varios tipos: 
MEMBER, CONSTRUCTOR Y STATIC.*/

--Primero se crea el tipo de objeto.
CREATE OR REPLACE TYPE RECTANGULO AS OBJECT(
  BASE NUMBER,
  ALTURA NUMBER,
  AREA NUMBER,
  STATIC PROCEDURE PROC1 (ANCHO INTEGER, ALTO INTEGER),
  MEMBER PROCEDURE PROC2 (ANCHO INTEGER, ALTO INTEGER),
  CONSTRUCTOR FUNCTION RECTANGULO (BASE NUMBER, ALTURA NUMBER)
        RETURN SELF AS RESULT
);

--Una vez que se ha creado el tipo con la especificaci�n de atributos y m�todos, 
--se puede establecer el cuerpo del tipo mediante CREATE OR REPLACE TYPE BODY.

--Estructura PROCEDIMIENTO:
/*CREATE OR REPLACE TYPE BODY nombre_tipo AS
  [STATIC | MEMBER] PROCEDURE nombreProcedure [(parametro1, parametro2,...)]
IS
  --Declaraciones;
BEGIN
  --Instrucciones;
END;*/

--Estructura FUNCI�N:
/*CREATE OR REPLACE TYPE BODY nombre_tipo AS
  [STATIC | MEMBER | CONSTRUCTOR] FUNCTION nombrefuncion [(parametro1,
  parametro2,...)] RETURN tipo_valor_retorno
IS
  --Declaraciones;
BEGIN
  --Instrucciones;
END;*/

--MEMBER
--Son los m�todos m�s habituales, propios de cada objeto. Pueden ser 
--Procedimientos o Funciones.

--CONSTRUCTOR
--Su cometido es inicializar los objetos. Sus argumentos son los atributos del 
--objeto y devuelve el objeto inicializado. Oracle define un constructor por 
--defecto para cada objeto, si bien, este constructor se puede sobreescribir o 
--definir constructores adicionales que incorporen otras funcionalidades 
--(restricciones, valores por defecto, etc.). En la cl�usula RETURN deben 
--establecer la expresi�n RETURN SELF AS RESULT.

--STATIC
--Al igual que los m�todos de clase de la POO, estos m�todos son independientes 
--de las instancias de un objeto. Engloban las operaciones que no pertenecen a 
--un objeto concreto sino al tipo.

CREATE OR REPLACE TYPE BODY RECTANGULO AS

  --Constructor
  CONSTRUCTOR FUNCTION RECTANGULO(BASE NUMBER, ALTURA NUMBER) RETURN SELF AS RESULT IS  
  BEGIN
    SELF.BASE := BASE;
    SELF.ALTURA := ALTURA;
    SELF.AREA := BASE * ALTURA;
    RETURN;
  END;
  
  --Procedimiento Static
  STATIC PROCEDURE PROC1 (ANCHO INTEGER, ALTO INTEGER) IS
  BEGIN
    INSERT INTO TABLAREC VALUES(ANCHO*ALTO);
    --ALTURA := ALTO; --ERROR NO SE PUEDE ACCEDER A LOS ATRIBUTOS DEL TIPO
    DBMS_OUTPUT.PUT_LINE('FILA INSERTADA');
    COMMIT;
  END;
  
  --Procedimiento Member
  MEMBER PROCEDURE PROC2 (ANCHO INTEGER, ALTO INTEGER) IS
  BEGIN    
    SELF.ALTURA := ALTO; --SE PUEDE ACCEDER A LOS ATRIBUTOS DEL TIPO
    SELF.BASE := ANCHO;
    AREA := ALTURA*BASE;
    INSERT INTO TABLAREC VALUES(AREA);
    DBMS_OUTPUT.PUT_LINE('FILA INSERTADA');
    COMMIT;
  END;
END;

/*----Sobrecarga-------
Como ya se ha comentado, mediante el mecanismo de herencia se da la posibilidad
de extender objetos a partir de objetos ya existentes. As� pues, los objetos 
hijos pueden definir sus propios m�todos o modificar los de sus objetos padres.
La cl�usula OVERRIDING permite redefinir m�todos. Hay que situarla antes del 
tipo de m�todo (STATIC, MEMBER, CONSTRUCTOR). De forma similar a otros lenguajes
que soportan POO, es posible utilizar el mismo nombre para m�todos distintos;
variando sus par�metros formales en tipo, orden o cantidad.*/