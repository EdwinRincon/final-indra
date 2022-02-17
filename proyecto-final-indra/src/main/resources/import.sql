-- clientes
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ("Jose","Garcia","hombre","642775959");
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ("Maria","Perez","mujer","642775958");
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ("David","Orue","hombre","642775957");
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ("Sergio","Gomez","hombre","642775956");
INSERT INTO clientes(nombre,apellidos,sexo,telefono) VALUES ("Antonio","Cardona","mujer","642775955");


-- productos
insert into productos (nombre, descripcion, p_unitario, existencias) values ("Televisión", "Una tele", 250, 20);
insert into productos (nombre, descripcion, p_unitario, existencias) values ("Portatil", "Un ordenador", 890, 25);
insert into productos (nombre, descripcion, p_unitario, existencias) values ("Altavoces", "Un par de altavoces", 200, 40);
insert into productos (nombre, descripcion, p_unitario, existencias) values ("Disco duro", "Un disco duro", 150, 10);


-- ventas
insert into ventas(producto_id, cliente_id, cantidad, subtotal, iva, total) values (1, 1, 2, 200, 50, 250);
insert into ventas(producto_id, cliente_id, cantidad, subtotal, iva, total) values (1, 2, 2, 200, 50, 250);
insert into ventas(producto_id, cliente_id, cantidad, subtotal, iva, total) values (2, 3, 3, 200, 50, 250);
insert into ventas(producto_id, cliente_id, cantidad, subtotal, iva, total) values (3, 2, 2, 200, 50, 250);