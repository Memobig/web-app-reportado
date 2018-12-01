/*usuarios*/
INSERT INTO usuarios (nombre, apellido, email, password, enabled) VALUES("Juan", "Lopez", "j@gm.com", "pass", 1);

/*authorities*/
INSERT INTO authorities (usuario_id, authority) VALUES(1, "ROLE_ADMIN");
INSERT INTO authorities (usuario_id, authority) VALUES(1, "ROLE_USER");

/* inserta categorias */
INSERT INTO categorias (nombre) VALUES("Celulares");
INSERT INTO categorias (nombre) VALUES("Automoviles");
INSERT INTO categorias (nombre) VALUES("Motocicleta");
INSERT INTO categorias (nombre) VALUES("Bicicleta");
INSERT INTO categorias (nombre) VALUES("Laptops");
INSERT INTO categorias (nombre) VALUES("Otros");
INSERT INTO categorias (nombre) VALUES("Televisor");

/*caracteristicas*/
INSERT INTO caracteristicas(categoria_id, nombre) VALUES(2, "NIV");
INSERT INTO caracteristicas(categoria_id, nombre) VALUES(2, "Placas");
INSERT INTO caracteristicas(categoria_id, nombre) VALUES(2, "Serial");
INSERT INTO caracteristicas(categoria_id, nombre) VALUES(2, "No. Motor");
INSERT INTO caracteristicas(categoria_id, nombre) VALUES(1, "IMEI");

/*estados*/
INSERT INTO estados (nombre) VALUES("Estado de México");
INSERT INTO estados (nombre) VALUES("Ciudad de México");

/*municipios*/
INSERT INTO municipios (nombre) VALUES("Chalco");
INSERT INTO municipios (nombre) VALUES("Ixtapaluca");
INSERT INTO municipios (nombre) VALUES("Iztacalco");

/*asentamientos*/
INSERT INTO asentamientos (nombre) VALUES("Tlapacoya");
INSERT INTO asentamientos (nombre) VALUES("La venta");
INSERT INTO asentamientos (nombre) VALUES("Agricola Oriental");
INSERT INTO asentamientos (nombre) VALUES("Pueblo Nuevo");

/*ubicaciones*/
INSERT INTO ubicacion (estado_id, municipio_id, asentamiento_id) VALUES(1, 1, 4);
INSERT INTO ubicacion (estado_id, municipio_id, asentamiento_id) VALUES(1, 2, 1);

/*publicaciones*/
INSERT INTO publicaciones (usuario_id, ubicacion_id, titulo, detalles, created_at) VALUES(1, 1, "Aveo 2018", "El automovil fue robado en chalco", NOW());
INSERT INTO publicaciones (usuario_id, ubicacion_id, titulo, detalles, created_at) VALUES(1, 2, "Chevrolet Spark 2017","El automovil fue robado en Tlapacoya", NOW());

/*caracteristicas de la publicacion*/
INSERT INTO publicacion_caracteristica (publicacion_id, caracteristica_id, valor) VALUES(1, 2, "KW2548");
INSERT INTO publicacion_caracteristica (publicacion_id, caracteristica_id, valor) VALUES(2, 2, "KW1550");


