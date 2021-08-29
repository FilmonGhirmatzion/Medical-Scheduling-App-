--CREATE DATABASE EMPLOYEE;
 DROP TABLE IF EXISTS employee;
 DROP TABLE IF EXISTS department;
 DROP TABLE IF EXISTS office;
DROP TABLE IF EXISTS appointment;

create table office(
office_id serial,
office_name varchar (256) not null,
office_street_address varchar (256) not null,
office_city varchar (256) not null,
office_state varchar (256) not null,
office_zip varchar (256) not null,
office_phone varchar (256) not null,
office_email varchar (256) not null,
office_hours varchar (256) not null,
office_parking varchar (256),
office_additional_info varchar (256),
office_url varchar (256),
constraint pk_office primary key(office_id) 
);


create table appointment(
appointment_id serial,
office_id serial,
firstName varchar (256) not null,
lastName varchar (256) not null,
gender varchar (256) not null,
dateOfBirth date  not null,
patient_street_address varchar (256) not null,
patient_city varchar (256) not null,
patient_state varchar (256) not null,
patient_zip varchar (256) not null,
patient_phone varchar (256) not null,
patient_email varchar (256) not null,
newPatient boolean not null,
appointment_type varchar (256) not null,
appointment_date date  not null,
appointment_time time  not null,
constraint pk_appointment primary key(appointment_id),
constraint fk_appointment_office foreign key(office_id) references office(office_id)
);


create table department(
dept_id serial ,
department_name varchar (256) not null,
constraint pk_department primary key(dept_id)
);


create table employee(
employee_id serial,
job_title varchar (256) not null,
first_name varchar(256) not null,
last_name varchar(256) not null,
gender varchar (256) not null,
dept_id int not null,
office_id int not null,
constraint pk_employee primary key(employee_id),
constraint fk_employee_dept foreign key (dept_id)references department(dept_id),
constraint fk_employee_employee foreign key (office_id)references office(office_id)
);






 select * from office;
 --'office_id serial','office_name','office_street_address', 'office_city', 'office_state', 'office_zip', 'office_phone', 'office_email', 'office_hours', 'office_parking', 'office_additional_info', 'office_url'
insert into office values('1','Primary One Health','1905 Parsons Ave','Columbus', 'OH', '43207', '(614) 645-5500', 'office@primaryone.com', '8AM-5PM', 'Parking is Free', 'No Additional Info','https://www.primaryone.com' );
insert into office values('2','Canyon Medical Center','5969 E Broad','Columbus', 'OH', '43213', '(614) 864-6010', 'office@canyonmedical.com', '8AM-5PM', 'Parking is Free', 'No Additional Info','https://www.canyonmedical.com');
insert into office values('3','Buckeye Family Medicine','2575 W Broad St','Columbus', 'OH', '43204', '(614) 278-9666', 'office@buckeyefamilymedicine.com', '8AM-5PM', 'Parking is Free', 'No Additional Info','https://www.buckeyefamilymedicine.com');




select * from appointment;
insert into appointment values('1','2','Adam', 'Smith', 'male', '1995-12-22','1212 Knollwood Ave','Columbus', 'OH', '43207','(614) 555-5555', 'adamsmith@example.com', 'true', 'Family Medicine', '2021-08-10', '8:00');
insert into appointment values('2','3','Tom', 'Jerry', 'male', '1985-04-15','32 Baskin Robins Ave','Columbus', 'OH', '43207','(614) 445-5444', 'tomjerry@example.com', 'true', 'Family Medicine', '2021-08-11', '9:00');
insert into appointment values('3','1','Jessica', 'Perry', 'female', '1989-11-27','2 Panera Ave','Columbus', 'OH', '43207','(614) 435-3434', 'jessicaperry@example.com', 'true', 'Family Medicine', '2021-08-11', '10:00');
insert into appointment values('4','1','Tom', 'Claus', 'male', '1999-11-27','2 Brook Ave','Columbus', 'OH', '43207','(614) 435-3434', 'jessicaperry@example.com', 'true', 'Family Medicine', '2021-08-11', '11:00');
insert into appointment values('5','1','Tim', 'Cook', 'male', '1979-11-27','52 Delaware Ave','Columbus', 'OH', '43207','(614) 435-3434', 'jessicaperry@example.com', 'true', 'Family Medicine', '2021-08-11', '12:00');




select * from department;
insert into department values('1','Family Medicine');
insert into department values('2','Cardiology department');
insert into department values('3','Pathology/Laboratory');
insert into department values('4','Nephrology');


select * from employee;
--insert into employee values('employee_id','job_title', 'first_name', 'last_name', 'gender', 'dept_id','office_id');
insert into employee values('1','Dr', 'Tracie', 'Bolden', 'female',  1, 1 );
insert into employee values('2','Dr', 'Mike', 'Duke', 'male',  4, 1);
insert into employee values('3','Nr', 'Jessica', 'Golden', 'female',  2, 1);


select * from appointment;
select * from office;

select office.office_name, *  from appointment Join office ON appointment.office_id = office.office_id Where office.office_id = 1 ;
select office_id, office_name from office ;


select *  from office Join appointment ON appointment.office_id = office.office_id Where appointment.appointment_date = 2021-08-11;







