## Seleccionar filas cuya *Ciudad* sea HUESCA

```sql
SELECT * FROM ALUMNOS A WHERE A.DIREC.CIUDAD = 'HUESCA';
```

### Consulta columnas individuales
Si la columna es un objeto, es necesario definir un *alias* para la tabla; La recomendación es utilizar alias siempre. Por ejemplo, para el CODIGO y la DIRECCION de los alumnos:

```sql
SELECT CODIGO, A.DIREC FROM ALUMNOS A;
```

### Consultas sobre métodos
Se invocan mediante su nombre y los argumentos que reciban entre paréntesis, o los paréntesis vacíos en caso de no haber argumentos. 

```sql
SELECT NOMBRE, A.DIREC.GET_CALLE() FROM ALUMNOS A;
```

