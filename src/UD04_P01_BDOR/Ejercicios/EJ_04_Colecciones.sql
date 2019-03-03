---------COLECCIONES: TIPO VARRAY-------

/*Las bases de datos relacionales y orientadas a objetos permiten el almacenamiento 
de colecciones de elementos en una columna. En oracle, esta operaci�n se lleva a 
cabo mediante una estructura de datos denominada VARRAY, similar a los arrays de 
otros lenguajes de programaci�n; elementos del mismo tipo, identificados por su 
posici�n u otro �ndice. Anexo a este concepto se introduce el de las tablas 
anidadas, que facilitan almacenar una tabla en una columna de otra tabla.*/

-- Tipo VARRAY

--Mediante la sentencia del ejemplo se crea un varray de 3 elementos de nombre 
--TELEFONO compuesto de varchar2 de 9 posiciones.
CREATE TYPE TELEFONO AS VARRAY(3) OF VARCHAR2(9)

--Para acceder a la informaci�n del VARRAY se utiliza la orden DESC (DESC TELEFONO).
--Por supuesto es posible crear tablas con columnas de tipo VARRAY:
CREATE TABLE AGENDA (
  NOMBRE VARCHAR2(25),
  TLF TELEFONO --Columna de tipo VARRAY
);
  
INSERT INTO AGENDA VALUES (
  'JUAN', TELEFONO('600123456', '987654321', '912345678'));
  
INSERT INTO AGENDA VALUES ('FRANCISCO', TELEFONO('678543210'));

--No es posible establecer condiciones sobre los elementos almacenados en el VARRAY.
--Adem�s, los valores que contiene, solo pueden ser accedidos o recuperados como 
--bloque, no de forma individualizada (en PL/SQL s� se puede).
SELECT TLF FROM AGENDA;

--Es conveniente usar alias
SELECT A.TLF FROM AGENDA A;

--Actualizaci�n de los datos del VARRAY
UPDATE AGENDA SET TLF = TELEFONO('689123456', '675123489') WHERE NOMBRE = 'FRANCISCO';

--Ejemplo de recorrido de VARRAY mediante PL/SQL:
DECLARE
  CURSOR C1 IS SELECT * FROM AGENDA;
  CAD VARCHAR2(50);
BEGIN
  FOR I IN C1 LOOP
    DBMS_OUTPUT.PUT_LINE(I.NOMBRE || ', N�mero de tel�fonos del contacto: ' ||
    I.TLF.COUNT);
    CAD := '*';
    
  --Recorrido del VARRAY
  FOR J IN 1 .. I.TLF.COUNT LOOP
    CAD := CAD || I.TLF(J) || '*';
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(CAD);
  END LOOP;
END;

--SALIDA
--JUAN, N�mero de tel�fonos del contacto: 3
--*600123456*987654321*912345678*
--FRANCISCO, , N�mero de tel�fonos del contacto: 2
--*689123456*675123489*

--Ejemplo de procedimiento para insertar datos en la AGENDA:
CREATE OR REPLACE PROCEDURE INSERTAR_AGENDA (N VARCHAR2, T TELEFONO) AS
BEGIN
  INSERT INTO AGENDA VALUES(N, T);
END;

--LLAMADA AL PROCEDIMIENTO
BEGIN
  INSERTAR_AGENDA('LUIS', TELEFONO('967654321'));
  INSERTAR_AGENDA('MARIANO', TELEFONO('984654321', '987600321'));
  COMMIT;
END;

--Funciones sobre m�todos de colecciones:

--Argumento               Resultado
--COUNT           Devuelve el n�mero de elementos de la colecci�n.
--EXISTS TRUE     Si existe la fila, false en caso contrario..
--FIRST/LAST      �ndice del primer y �ltimo elementos, respectivamente.
--NEXT/PRIOR      Elemento siguiente/posterior.
--LIMIT           N�mero m�ximo de elementos que puede contener la colecci�n.
--DELETE          Elimina TODOS los elementos de la colecci�n.
--EXTEND          A�ade un elemento (Nulo) a la colecci�n, si se le pasa un n�mero,
--                a�ade tantos nulos como indique el n�mero.
--TRIM            Elimina el �ltimo elemento de la colecci�n, o si se le pasa un n�mero,
--                tantos elementos como indique el n�mero

DECLARE
  TLF TELEFONO := TELEFONO(NULL, NULL, NULL);
BEGIN
  SELECT TLF INTO TLF FROM AGENDA WHERE NOMBRE = 'MARIANO';
  
  DBMS_OUTPUT.PUT_LINE('N�mero de tel�fonos actuales: ' || TLF.COUNT);
  DBMS_OUTPUT.PUT_LINE('�ndice del primer tel�fono: ' || TLF.FIRST);
  DBMS_OUTPUT.PUT_LINE('�ndice del �ltimo tel�fono: ' || TLF.LAST);
  DBMS_OUTPUT.PUT_LINE('M�ximo n�mero de tel�fonos admitidos: ' || TLF.LIMIT);

  --A�ADIR UN TEL�FONO AL VARRAY
  TLF.EXTEND;
  TLF(TLF.COUNT) := '123456789';
  UPDATE AGENDA A SET A.TLF = TLF WHERE NOMBRE = 'MARIANO';

  --ELIMINAR
  SELECT TLF INTO TLF FROM AGENDA WHERE NOMBRE = 'LUIS';
  TLF.TRIM; --Borra el �ltimo
  TLF.DELETE; --Borra todos
  
  UPDATE AGENDA A SET A.TLF = TLF WHERE NOMBRE = 'LUIS';
END;


SELECT * FROM AGENDA;