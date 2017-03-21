create table account (
	accid int not null primary key,
	owner varchar(50) not null,
	capacity double not null,
	balance double not null
);

create table transaxions (
	txid int not null primary key,
	accountID int not null,
	txDate timestamp not null,
	amount double not null,
	balance double not null,
	description varchar(128) not null,
	foreign key (accountID) references account(accid)
);

insert into account(accid,owner,capacity,balance) values
(1,'maik',0.0,2300.0),
(2,'chris',1500.0,830.0);

insert into transaxions(txid,accountID,txDate,amount,balance,description) values
(1,1,'2017-03-13 10:23:54',300.0,2300.0,'TRANSFER'),
(2,2,'2017-03-19 11:54:54',100.0,1700.0,'DEPOSIT');

insert into transaxions(txid,accountID,txDate,amount,balance,description) values(2,2,'2017-03-19 11:54:54',100.0,1700.0,'DEPOSIT');