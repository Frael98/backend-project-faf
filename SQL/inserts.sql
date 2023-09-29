--- ROL
insert into role (created_at, delete_at, estado,updated_at,nombre_rol)
   (GETDATE(), null, 'A', null, 'ADMINISTRADOR');

---- USUARIO
insert into usuario (created_at, delete_at, estado, updated_at, apellido, contrasenia, correo, nombre, usuario_nombre,rol_id ) 
(GETDATE(), null, 'A', null, 'administrador','123', 'adm@gmail.com', 'Administrador', 'admin', 1);

--- ARBIRO
INSERT INTO arbitro (created_at, delete_at, estado, updated_at, apellido, contrasenia, correo, nombre, usuario_nombre, categoria, direccion, fecha_nacimiento, nacionalidad, partidos) 
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

---- EQUIPO
INSERT INTO equipo (created_at, delete_at, estado, updated_at, director, nombre)
    ('2023-03-18 10:00:00', null, 'A', NULL, 'Juan P�rez', 'Real Madrid'),
    ('2023-03-18 10:00:01', null, 'A', NULL, 'Mar�a Gonz�lez', 'Barcelona'),
    ('2023-03-18 10:00:02', null, 'A', NULL, 'Pedro S�nchez', 'Manchester United'),
    ('2023-03-18 10:00:03', null, 'A', NULL, 'Ana Mart�nez', 'Bayern Munich'),
    ('2023-03-18 10:00:04', null, 'A', NULL, 'David Garc�a', 'PSG'),
    ('2023-03-18 10:00:05', null, 'A', NULL, 'Laura Rodr�guez', 'Liverpool'),
    ('2023-03-18 10:00:06', null, 'A', NULL, 'Juan Gonz�lez', 'Juventus'),
    ('2023-03-18 10:00:07', null, 'A', NULL, 'Sara Mart�nez', 'Real Betis'),
    ('2023-03-18 10:00:08', null, 'A', NULL, 'Luis Hern�ndez', 'Borussia Dortmund'),
    ('2023-03-18 10:00:09', null, 'A', NULL, 'Carlos P�rez', 'River Plate');

-- Insercion de 8 clubs
set identity_insert equipo on

IF NOT EXISTS ( SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='equipo' AND COLUMN_NAME='ESTADO')
BEGIN
  ALTER TABLE equipo ADD ESTADO CHAR(1) NULL
END

INSERT INTO equipo
        (id_equipo, nombre, director, created_at, delete_at, updated_at, estado)
    VALUES
        (404, 'Osazuna FC', 'Ximenez', GETDATE(), null, NULL, 'A'),
        (405, 'Barcelona FC', 'Hurtado', GETDATE(), null, NULL, 'A'),
        (406, 'Villarancho FC', 'Santillan', GETDATE(), null, NULL, 'A'),
        (407, 'Valencia FC', 'Hidalgo', GETDATE(), null, NULL, 'A'),
        (408, 'Catalunia FC', 'Guevara', GETDATE(), null, NULL, 'A'),
        (409, 'Elche FC', 'Gomez', GETDATE(), null, NULL, 'A'),
        (410, 'Mallorca FC', 'Intriago', GETDATE(), null, NULL, 'A'),
        (411, 'Andorra FC', 'Winstrong', GETDATE(), null, NULL, 'A');
        
set identity_insert equipo off

  
---- PARTIDO ------
IF NOT EXISTS ( SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='PARTIDO' AND COLUMN_NAME='ESTADO')
BEGIN
  ALTER TABLE PARTIDO ADD ESTADO CHAR(1) NULL
END
IF NOT EXISTS ( SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='PARTIDO' AND COLUMN_NAME='PARTIDO_DESCRIPCION')
BEGIN
  ALTER TABLE PARTIDO ADD PARTIDO_DESCRIPCION VARCHAR(200) NULL
END

set identity_insert partido on

INSERT INTO partido (id_partido, equipo_local_id, equipo_rival_id, ESTADO, partido_descripcion)
    VALUES (501, 404, 411, 'A', concat('Osazuna FC' , ' VS ' , 'Andorra FC')),
     (509, 409, 405, 'A', concat('Elche FC' , ' VS ' , 'Barcelona FC')),
     (510, 406, 407, 'A', concat('Villarancho FC' , ' VS ' , 'Valencia FC')),
     (511, 408, 409, 'A', concat('Catalunia FC' , ' VS ' , 'Elche FC')),
     (512, 410, 411, 'A', concat('Mallorca FC' , ' VS ' , 'Andorra FC')),
     (513, 404, 408, 'A', concat('Osazuna FC' , ' VS ' , 'Catalunia FC')),
     (514, 411, 408, 'A', concat('Andorra FC' , ' VS ' , 'Catalunia FC')),
     (515, 409, 411, 'A', concat('Elche FC' , ' VS ' , 'Andorra FC'));
set identity_insert partido off


set identity_insert sorteo on

INSERT INTO sorteo
        (id_sorteo, fecha_sorteo, created_at, delete_at, update_at, estado, arbitro_id, partido_id, arbitro_sustituto_id)
    VALUES
        (602, '2023-02-27', GETDATE(), NULL, NULL, 'A', 302, 501, 303),
        (603, '2023-01-12', GETDATE(), NULL, NULL, 'A', 303, 509, 303),
        (604, '2023-02-02', GETDATE(), NULL, NULL, 'A', 304, 510, 306),
        (605, '2023-02-17', GETDATE(), NULL, NULL, 'A', 307, 512, 304),
        (606, '2023-01-20', GETDATE(), NULL, NULL, 'A', 309, 511, 303),
        (607, '2023-02-22', GETDATE(), NULL, NULL, 'A', 304, 513, 305),
        (608, '2023-02-27', GETDATE(), NULL, NULL, 'A', 302, 514, 308),
        (609, '2023-01-24', GETDATE(), NULL, NULL, 'A', 302, 515, 307);	

set identity_insert sorteo off


-- Insercion de 8 agendas
set identity_insert agenda on

INSERT INTO agenda
        (id_agenda, fecha_partido, lugar_partido, hora_partido, created_at, delete_at, updated_at, estado, partido_id)
    VALUES
        (702, '2023-02-27', 'Madrid', '10:00:00', GETDATE(), NULL, NULL, 'A', 501),
        (703, '2023-01-12', 'Barcelona', '09:00:00', GETDATE(), NULL, NULL, 'A', 509),
        (704, '2023-02-02', 'Valencia', '12:00:00', GETDATE(), NULL, NULL, 'A', 510),
        (705, '2023-01-20', 'Elche', '13:00:00', GETDATE(), NULL, NULL, 'A', 511),
        (706, '2023-02-17', 'Andorra', '18:00:00', GETDATE(), NULL, NULL, 'A', 512),
        (707, '2023-02-22', 'Catalunia', '21:00:00', GETDATE(), NULL, NULL, 'A', 513),
        (708, '2023-02-27', 'Andorra', '09:00:00', GETDATE(), NULL, NULL, 'A', 514),
        (709, '2023-01-24', 'Elche', '19:00:00', GETDATE(), NULL, NULL, 'A', 515);
        

set identity_insert agenda off


-- Insercion de 8 actas de partidos
set identity_insert acta_partido on

-- 1
INSERT INTO acta_partido
        (id_acta, codigo_acta, fecha_emision, hora_inicio, hora_fin, equipo_local, equipo_rival, duracion_partido,
        num_gol_equipo_local, num_gol_equipo_rival, total_amarillas, total_rojas, equipo_ganador, create_at, delete_at, update_at, estado, partido_id_partido)
    VALUES
        (802, 2, '2023-02-16', '10:00:00', '11:34:00', 'Osazuna FC', 'club_Alemania', '01:34:00',
            2, 1, 1, 1, 'Osazuna FC', GETDATE(), NULL, NULL, 'A', 501),

        (803, 3, '2023-01-12', '09:00:00', '10:30:00', 'club_Argentina', 'Barcelona FC', '01:30:00',
            0, 1, 2, 1, 'Barcelona FC', GETDATE(), NULL, NULL, 'A', 509),
            
        (804, 4, '2023-02-02', '12:00:00', '13:34:00', 'Villarancho FC', 'Valencia FC', '01:34:00',
            1, 0, 4, 1, 'Villarancho FC', GETDATE(), NULL, NULL, 'A', 510),
            
        (805, 5, '2023-01-20', '13:00:00', '14:34:00', 'Catalunia FC', ' Elche FC', '01:34:00',
            2, 2, 3, 1, 'Empate', GETDATE(), NULL, NULL, 'A', 511),
            
        (806, 6, '2023-02-17', '18:00:00', '19:34:00', 'Mallorca FC', 'Andorra FC', '01:34:00',
            2, 0, 1, 2, 'Andorra FC', GETDATE(), NULL, NULL, 'A', 512),
            
        (807 ,7, '2023-02-22', '21:00:00', '22:30:00', 'Osazuna FC', 'Catalunia FC', '01:30:00',
            1, 3, 2, 1, 'Catalunia FC', GETDATE(), NULL, NULL, 'A', 513),
            
        (808 ,8, '2023-02-27', '09:00:00', '10:30:00', 'Andorra FC', 'Catalunia FC', '01:30:00',
            2, 3, 3, 1,'Catalunia FC', GETDATE(), NULL, NULL, 'A', 514),
            
        (809, 9, '2023-01-24', '19:00:00', '20:34:00', 'Elche FC ', 'club_Alemania', '01:34:00',
            2, 0, 1, 1, 'Elche FC', GETDATE(), NULL, NULL, 'A', 515);
            
set identity_insert acta_partido off

