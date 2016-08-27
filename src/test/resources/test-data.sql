INSERT INTO users(id, name, email, phone, created_at, modified_at, deleted_at, is_deleted) VALUES (1, 'Obi-wan Kenobi', 'ben@jedi.org', '1111111111', '2016-08-18 14:56:55', null, null, 0);
INSERT INTO users(id, name, email, phone, created_at, modified_at, deleted_at, is_deleted) VALUES (2, 'Anakin Skywalker', 'vader@sith.net', '1233211236', '2016-08-18 14:56:55', null, null, 0);
INSERT INTO users(id, name, email, phone, created_at, modified_at, deleted_at, is_deleted) VALUES (3, 'Rey', 'clone@anakin.com', '1234554321', '2016-08-18 14:56:55', null, null, 0);

INSERT INTO vehicles(id, user_id, capacity, model, number_plate, created_at, modified_at, deleted_at, is_deleted) VALUES(1, 1, 4, 'X-Wing', 'OB1KOB', '2016-08-18 14:56:55', null, null, 0);
INSERT INTO vehicles(id, user_id, capacity, model, number_plate, created_at, modified_at, deleted_at, is_deleted) VALUES(2, 2, 3, 'TIE', 'DVADER', '2016-08-18 14:56:55', null, null, 0);
INSERT INTO vehicles(id, user_id, capacity, model, number_plate, created_at, modified_at, deleted_at, is_deleted) VALUES(3, 1, 1, 'Y-Wing', 'BENKOB', '2016-08-18 14:56:55', null, null, 0);

INSERT INTO addresses(id, latitude, longitude, formatted_address, created_at, modified_at, deleted_at, is_deleted) VALUES(1, 1.11, 2.22, 'Jedi Temple, Coruscant', '2016-08-18 14:56:55', null, null, 0);
INSERT INTO addresses(id, latitude, longitude, formatted_address, created_at, modified_at, deleted_at, is_deleted) VALUES(2, 11.11, 22.22, 'Podracing Arena, Tatooine', '2016-08-18 14:56:55', null, null, 0);
INSERT INTO addresses(id, latitude, longitude, formatted_address, created_at, modified_at, deleted_at, is_deleted) VALUES(3, -1.11, -2.22, 'Rebel Base, Yavin 4', '2016-08-18 14:56:55', null, null, 0);

INSERT INTO sources(id, name, address_id, created_at, modified_at, deleted_at, is_deleted) VALUES(1, 'Coruscant', 1, '2016-08-18 14:56:55', null, null, 0);
INSERT INTO sources(id, name, address_id, created_at, modified_at, deleted_at, is_deleted) VALUES(2, 'Tatooine', 2, '2016-08-18 14:56:55', null, null, 0);
INSERT INTO sources(id, name, address_id, created_at, modified_at, deleted_at, is_deleted) VALUES(3, 'Yavin 4', 3, '2016-08-18 14:56:55', null, null, 0);

INSERT INTO listings(id, user_id, vehicle_id, departure_time, source_id, destination_address_id, seats_available, created_at, modified_at, deleted_at, is_deleted) VALUES(1, 1, 1, '2016-08-18 14:56:55', 1, 2, 1, '2016-08-18 14:56:55', null, null, 0);
INSERT INTO listings(id, user_id, vehicle_id, departure_time, source_id, destination_address_id, seats_available, created_at, modified_at, deleted_at, is_deleted) VALUES(2, 2, 2, '2016-08-18 14:56:55', 2, 1, 2, '2016-08-18 14:56:55', null, null, 0);
INSERT INTO listings(id, user_id, vehicle_id, departure_time, source_id, destination_address_id, seats_available, created_at, modified_at, deleted_at, is_deleted) VALUES(3, 3, 3, '2016-08-18 14:56:55', 3, 1, 1, '2016-08-18 14:56:55', null, null, 0);

INSERT INTO bookings(id, user_id, listing_id, created_at, modified_at, deleted_at, is_deleted) VALUES(1, 1, 1, '2016-08-18 14:56:55', null, null, 0);
INSERT INTO bookings(id, user_id, listing_id, created_at, modified_at, deleted_at, is_deleted) VALUES(2, 2, 1, '2016-08-18 14:56:55', null, null, 0);
INSERT INTO bookings(id, user_id, listing_id, created_at, modified_at, deleted_at, is_deleted) VALUES(3, 1, 2, '2016-08-18 14:56:55', null, null, 0);
