INSERT INTO arbitro (created_at, delete_at, estado, updated_at, apellido, contrasenia, correo, nombre, usuario_nombre, categoria, direccion, fecha_nacimiento, nacionalidad, partidos) VALUES
('2022-03-10 10:15:00', NULL, 'A', null, 'Garc�a', 'contrasenia1', 'garcia1@gmail.com', 'Juan', 'juangarcia', 'f�tbol', 'Calle 1, Ciudad 1', '1980-01-01', 'M�xico', 10),
('2022-03-09 12:30:00', NULL, 'A', null, 'G�mez', 'contrasenia2', 'gomez2@gmail.com', 'Pedro', 'pedrogomez', 'f�tbol', 'Calle 2, Ciudad 1', '1985-05-15', 'Argentina', 15),
('2022-03-08 15:45:00', NULL, 'A', null,'Fern�ndez', 'contrasenia3', 'fernandez3@gmail.com', 'Mar�a', 'mariafernandez', 'f�tbol', 'Calle 3, Ciudad 2', '1990-03-20', 'Colombia', 20),
('2022-03-07 09:00:00', NULL, 'A', null, 'Gonz�lez', 'contrasenia4', 'gonzalez4@gmail.com', 'Laura', 'lauragonzalez', 'f�tbol', 'Calle 4, Ciudad 2', '1982-08-01', 'M�xico', 12),
('2022-03-06 11:30:00', NULL, 'A', null, 'Rodr�guez', 'contrasenia5', 'rodriguez5@gmail.com', 'Carlos', 'carlosrodriguez', 'f�tbol', 'Calle 5, Ciudad 3', '1988-06-10', 'Argentina', 18),
('2022-03-05 16:15:00', NULL, 'A', null, 'L�pez', 'contrasenia6', 'lopez6@gmail.com', 'Ana', 'anilopez', 'f�tbol', 'Calle 6, Ciudad 3', '1983-12-05', 'Colombia', 25),
('2023-03-11', NULL, 'A', '2023-03-11', 'P�rez', 'contrase�a1', 'perez@gmail.com', 'Juan', 'juanp', 'FIFA', 'Calle Falsa 123', '1980-05-15', 'Argentina', 100),
('2023-03-11', NULL, 'A', '2023-03-11', 'Garc�a', 'contrase�a2', 'garcia@gmail.com', 'Ana', 'anag', 'CONMEBOL', 'Avenida Siempreviva 456', '1985-10-10', 'Uruguay', 80),
('2023-03-11', NULL, 'A', '2023-03-11', 'S�nchez', 'contrase�a3', 'sanchez@gmail.com', 'Pedro', 'pedros', 'FIFA', 'Calle Falsa 789', '1978-03-20', 'Espa�a', 120),
('2023-03-11', NULL, 'A', '2023-03-11', 'Rodr�guez', 'contrase�a4', 'rodriguez@gmail.com', 'Carla', 'carlar', 'CONMEBOL', 'Calle Desconocida 987', '1988-01-01', 'Argentina', 90),
('2023-03-11', NULL, 'A', '2023-03-11', 'G�mez', 'contrase�a5', 'gomez@gmail.com', 'Diego', 'diegog', 'FIFA', 'Avenida Principal 456', '1982-07-02', 'Uruguay', 110),
('2023-03-11', NULL, 'A', '2023-03-11', 'Fern�ndez', 'contrase�a6', 'fernandez@gmail.com', 'Mar�a', 'mariam', 'CONMEBOL', 'Avenida Norte 789', '1976-12-12', 'Argentina', 95),
('2023-03-11', NULL, 'A', '2023-03-11', 'L�pez', 'contrase�a7', 'lopez@gmail.com', 'Gabriel', 'gabriell', 'FIFA', 'Calle Central 123', '1981-06-22', 'Espa�a', 85),
('2023-03-11', NULL, 'A', '2023-03-11', 'D�az', 'contrase�a8', 'diaz@gmail.com', 'Marta', 'martad', 'CONMEBOL', 'Calle Principal 456', '1990-03-01', 'Uruguay', 75),
('2023-03-11', NULL, 'A', '2023-03-11', 'Mart�nez', 'contrase�a9', 'martinez@gmail.com', 'Javier', 'javierm', 'FIFA', 'Avenida Este 789', '1983-08-12', 'Argentina', 105)

insert into role (created_at, delete_at, estado,updated_at,nombre_rol)
  values (GETDATE(), null, 'A', null, 'ADMINISTRADOR');

insert into usuario (created_at, delete_at, estado, updated_at, apellido, contrasenia, correo, nombre, usuario_nombre,rol_id ) values
(GETDATE(), null, 'A', null, 'administrador','123', 'adm@gmail.com', 'Administrador', 'admin', 1);