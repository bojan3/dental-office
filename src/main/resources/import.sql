insert into user (first_name, last_name, phone_number, role, email) values ("John", "Smith", "+381 60 342 12 12", 0, "bskokic@outlook.com");
insert into user (first_name, last_name, phone_number, role) values ("James", "Patrick", "+123 456 78 91", 1);

insert into patient (user_id) values (1);

--insert into appoitment (patient_id, start_date_time, duration ) values (1, "2022-09-14T08:57:36.977Z", 0);