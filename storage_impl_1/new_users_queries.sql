# Visualizar todos los usuarios que hay
SELECT user, host FROM mysql.user;

# Crear un nuevo usuario con contraseña
CREATE USER 'st_admin'@'localhost' IDENTIFIED BY 'st_admin';

# Se le garantizan todos los privilegios al nuevo usuario en la movies_db
GRANT ALL PRIVILEGES ON movies_db.* TO 'st_admin'@'localhost';

# Probando los privilegios del nuevo usuario
SELECT * FROM mini_serie;