insert into user (first_name, last_name, phone_number, role, email) values ("John", "Smith", "+381 60 342 12 12", 0, "bskokic@outlook.com");
insert into user (first_name, last_name, phone_number, role) values ("James", "Patrick", "+123 456 78 91", 1);

insert into patient (user_id) values (1);

insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 11:00:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 11:30:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (0, '2022-9-18 12:00:00', 0 , 1, false);

insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (1, '2022-9-19 11:00:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (1, '2022-9-19 12:00:00', 0 , 1, false);
insert into appoitment (duration, start_date_time, type, patient_id, canceled) values (1, '2022-9-19 13:00:00', 0 , 1, false);