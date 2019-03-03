-----ACTIVIDADES: TIPOS DE OBJETOS-----

--Crea un tipo *ALUMNO* con 4 atributos, uno de tipo *Persona* y tres que indican
--las notas de las evaluaciones: primera, segunda y tercera. 

CREATE OR REPLACE TYPE ALUMNO AS OBJECT (
  CODIGO NUMBER,
  PER PERSONA,
  EVA1 NUMBER,
  EVA2 NUMBER,
  EVA3 NUMBER
);


--Inicializa el objeto creado mediante un bloque de c�digo PL/SQL.
DECLARE
  Dire DIRECCION;  -- SE INICIA CON NEW
  Per PERSONA;      -- SE INICIA CON NEW
  Alu ALUMNO;      -- SE INICIA CON NEW
BEGIN  
  Dire := NEW DIRECCION ('C/Tudela 7','Tarazona',50500);
  Per:= NEW PERSONA(7,'Jorge', Dire, SYSDATE);
  Alu:= NEW ALUMNO(1, Per, 10, 9, 10);
  DBMS_OUTPUT.PUT_LINE('Alumno: NOMBRE: ' ||Alu.PER.NOMBRE || 
     ' CALLE: '  ||Per.DIREC.CALLE || ' Evaluaci�n1: '|| Alu.EVA1 || 
     ' Evaluaci�n2: ' || Alu.EVA2 ||' Evaluaci�n3: ' || Alu.EVA2);  
END;