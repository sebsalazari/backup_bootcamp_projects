/* Segunda Parte - Consultas */
USE movies_db;

# Query 1
SELECT se.title, ge.name 
FROM series se
INNER JOIN genres ge
ON se.genre_id = ge.id;

# Query 2
SELECT epi.title, act.first_name, act.last_name
FROM actor_episode act_epi
INNER JOIN episodes epi
ON act_epi.episode_id = epi.id
INNER JOIN actors act 
ON act_epi.actor_id = act.id;

# Query 3
SELECT ser.title, COUNT(*) AS tot_temporadas
FROM seasons sea
INNER JOIN series ser
ON sea.serie_id = ser.id
GROUP BY ser.id;

# Query 4
SELECT gen.name, COUNT(*) AS tot_movies
FROM movies mo
INNER JOIN genres gen
ON mo.genre_id = gen.id
GROUP BY gen.id
HAVING tot_movies >= 3;

# Query 5
SELECT DISTINCT act.first_name, act.last_name
FROM actor_movie act_mov
INNER JOIN actors act
ON act_mov.actor_id = act.id
INNER JOIN movies mov
ON act_mov.movie_id = mov.id
WHERE mov.title LIKE "%guerra de las galaxias%";


/* Primera Parte - Preguntas Teoricas 

1) A que se demonina JOIN en una base de datos?
	RTA/: Basicamente sentencia JOIN consiste en unir dos tablas que comparten una o varias 
    condiciones pueden ser tablas que comparte ID's es decir llaves foraneas, un ejemplo 
    rapido seria el hacer el JOIN de la tabla veterinaria con la tabla animal, en donde
    podriamos mostrar una nueva tabla donde se muestre lo animales que estan asignados a la 
    veterinaria. 

2) Tipos de JOIN
   RTA/: UNION JOIN -> No es tan usual pero lo que hace es unir todos los registros de cada tabla
   en una sola, obteniendo toda la info de las tablas en una sola.
   
   LEFT JOIN -> Representa la diferencia entre tablas, si tenemos una tabla A y una tabla B, un 
   LEFT JOIN de A con B nos permitirá obtener los registros de la diferencia de (A - B) más la 
   intersección de A y B.

3) Utilizacion del GROUP BY 
	RTA/: El GROUP BY como su nombre lo indica se utiliza para agrupar el resultado de una query
    por una columna indicada, de esta manera simplifica la respuesta al unir registros iguales
    de la columna indicada y responder un solo registro resumiendo la informacion.
    
4) Utilizacion del HAVING
	RTA/: Es similar al WHERE pues se usa para filtar una query, pero con diferencia que este solo
    se aplica a el resultado de un GROUP BY.
    
5) DIAGRAMA 1 -> Corresponde a un INNER JOIN el mas comun
   DIAGRAMA 2 -> Corresponde a un LEFT JOIN.
   
&) Consultas para cada diagrama
	DIAGRAMA 1:
    SELECT * FROM tabla_A AS shop
    RIGHT JOIN tabla_B AS candy
    ON shop.key = candy.key;
    
    DIAGRAMA 2:
    SELECT * FROM tabla_A AS shop
    FULL OUTER JOIN tabla_B AS candy
    ON shop.key = candy.key;

*/