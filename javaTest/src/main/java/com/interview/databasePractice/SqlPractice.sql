
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS Employee;

CREATE TABLE Department(id VARCHAR(10),name VARCHAR(20));
CREATE TABLE Employee(id VARCHAR(10),name VARCHAR(20),dept_id VARCHAR(10), managerId VARCHAR(10));

INSERT INTO Department (id,name) VALUES (1,"HR");
INSERT INTO Department (id,name) VALUES (2,"Science");
INSERT INTO Department (id,name) VALUES (3,"Math");

INSERT INTO Employee (id,name,dept_id) VALUES (1,"Alex"	,1		);
INSERT INTO Employee (id,name,dept_id) VALUES (2,"Sammy",1		);
INSERT INTO Employee (id,name,dept_id,managerId) VALUES (3,"Jad"  	,2   	,1);
INSERT INTO Employee (id,name,dept_id,managerId) VALUES (4,"Prat"	,1		,3);
INSERT INTO Employee (id,name,dept_id,managerId) VALUES (5,"Ben"	,3		,1);
INSERT INTO Employee (id,name,dept_id,managerId) VALUES (6,"Raj"	,3		,3);

select * from Department;
select * from Employee;

--1.
-- Get number of emolpoyee in each depatment;
-- dept_id, count of number of emolyees

select d.id,count(e.id)
from
Department d,
Employee e
where d.id=e.dept_id
group by e.dept_id;
