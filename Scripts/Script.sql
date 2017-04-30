CREATE TABLE if not exists title (
	title_no    CHAR(5)     not NULL,	
	title_name  VARCHAR(20) not null,
	isexist boolean not null,
	PRIMARY KEY (title_no)
);

CREATE TABLE if not exists department (
	dept_no    CHAR(5)     not NULL,	
	dept_name  VARCHAR(20) not null,
	floor integer,
	isexist boolean not null,
	PRIMARY KEY (dept_no)
);


CREATE TABLE if not exists employee (
	emp_no     CHAR(5)     not NULL,	
	emp_name   VARCHAR(20) not null,
	title  CHAR(5) not null,
	salary integer ,
	gender boolean     not null,
	hobbys varchar(20),
	department CHAR(5),
	joinDate Date,
	isexist boolean not null,
	PRIMARY KEY (emp_no),
	FOREIGN KEY (title) REFERENCES title(title_no),
	FOREIGN KEY (department) REFERENCES department(dept_no)
);
insert into title(title_no,title_name) values('T001','과장',true);
insert into title values('T001','과장',true);
insert into department values('D001','관리',1,true);
insert into employee values ('E001','이승우','T001',5000,true,"게임 음악",'D001',now(),true);

select title_no,title_name,isexist from title;
select dept_no,dept_name,floor,isexist from department;
select *  from employee e join department d on d.dept_no=e.department join title t on e.title=t.title_no;
