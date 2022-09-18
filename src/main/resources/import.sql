insert into user (first_name, last_name, phone_number, role, email) values ("John", "Smith", "+1231231212", 0, "bskokic@outlook.com");
insert into user (first_name, last_name, phone_number, role, email) values ("Cristian", "Sulz", "+1111231212", 0, "bskokic@outlook.com");
insert into user (first_name, last_name, phone_number, role, email) values ("James", "Patrick", "+1234567891", 1, "bskokic@outlook.com");

insert into patient (user_id) values (1);
insert into patient (user_id) values (2);

insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 11:00:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 11:30:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 12:00:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 12:30:00', 0 , 2, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 13:00:00', 0 , 2, false);

insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (1, '2022-9-19 11:00:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (1, '2022-9-19 12:00:00', 0 , 2, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (1, '2022-9-19 13:00:00', 0 , 1, false);