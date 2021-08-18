/* 
	Practica 2 - SQL 1 - TT
    Sebastian Salazar
*/

USE movies_db;

# Query 2
SELECT * FROM movies;

# Query 3
SELECT first_name, last_name, rating FROM actors;

# Query 4
SELECT title "Titulo" FROM series AS Series;

# Query 5
SELECT title "Titulo" FROM series AS Series 
WHERE release_date < "20160101";

# Query 6
SELECT first_name, last_name FROM actors 
WHERE rating > 7.5;

# Query 7
SELECT title, rating , awards FROM movies 
WHERE rating > 7.5 AND awards >= 2;

# Query 8
SELECT title, rating FROM movies 
ORDER BY rating ASC;

# Query 9
SELECT title FROM movies 
LIMIT 3;

# Query 10
SELECT title, rating FROM movies 
ORDER BY rating DESC 
LIMIT 5;

# Query 11
SELECT title, rating FROM movies 
ORDER BY rating DESC 
LIMIT 5 OFFSET 5;

# Query 12
SELECT * FROM actors 
LIMIT 10;

# Query 13
SELECT * FROM actors 
LIMIT 10 OFFSET 20;

# Query 14
SELECT * FROM actors 
LIMIT 10 OFFSET 40;

# Query 15
SELECT title, rating FROM movies 
WHERE title LIKE "%Toy Story%";

# Query 16
SELECT * FROM actors 
WHERE first_name LIKE "Sam%";

# Query 17
SELECT title FROM movies 
WHERE release_date BETWEEN "20040101" AND "20081231";

# Query 18
SELECT title FROM movies 
WHERE rating > 3 AND awards >= 1 AND YEAR(release_date) BETWEEN 1998 AND 2009 
ORDER BY rating DESC;

# Query 19
SELECT title FROM movies 
WHERE rating > 3 AND awards >= 1 AND YEAR(release_date) BETWEEN 1998 AND 2009 
ORDER BY rating DESC 
LIMIT 3 OFFSET 10;
