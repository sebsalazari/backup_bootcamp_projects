/* Practica Tarde - SQL 2 */

/* 1 - Normalización - Concepto
		El proceso de normalización permite estandarizar los datos en nuestras bases de datos. Elimina redundancias e 
		inconsistencias, disminuye problemas de actualización de los datos en las tablas y facilita la gestión de la 
		base de datos. 
 */
 
 # 2 - Insert new movie
 INSERT INTO movies (title, rating, awards, release_date, length, genre_id) 
 VALUES ("Inception", 9.9, 7, "2012-03-11", 120, 5);
 
 # 3 - Insert new genre
 INSERT INTO genres (created_at, name, ranking, active) 
 VALUES ("2021-08-19", "Anime" , 15, 1);
 
 # 4 - Update movie with genre created
 UPDATE movies 
 SET genre_id = 13
 WHERE id = 22;

# 5 - Update actor with new movie
 UPDATE actors
 SET favorite_movie_id = 22
 WHERE id = 4;

# 6 - New table temp
 CREATE TEMPORARY TABLE movies_temp
 SELECT * FROM movies;
 
# 7 - Delete movies with less 5 awards
 SET SQL_SAFE_UPDATES = 0;
 DELETE FROM movies_temp 
 WHERE awards < 5;
 
 # 8 - Get list genres with minimun one movie
 SELECT DISTINCT gen.*
 FROM genres gen
 INNER JOIN movies mov
 ON mov.genre_id = gen.id;
 
 # 9 - Get list of movies favorites of actors
 SELECT act.*
 FROM actors act
 INNER JOIN movies mov
 ON act.favorite_movie_id = mov.id
 WHERE mov.awards >= 3;
 
 # 10 - Analyze with explain plane the queries 6 and 7
 
 /* 11 - Explicacion Indices
	Los indices por lo que entendi sirven para hacer mas veloces las consultas a base de datos con una gran cantidad
    de datos, los indices almacena consultas muy frecuentes en memoria, lo que hace que los procesos de consultas
    generales sean muy rapidas y mas eficientes, pero es recomendable que los indices creados sean de tablas las cuales
    sus columnas no cambiaran sus datos de manera frecuente.
 */
 
 # 12 - Create a new index from movies
 CREATE INDEX title_index ON movies (title);
 
 # 13 - Check a new index created
 SHOW INDEX FROM movies;
