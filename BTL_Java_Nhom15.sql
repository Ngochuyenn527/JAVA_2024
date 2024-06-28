create database qlspdt_yp;

use qlspdt_yp;

create table user(
	uid int NOT NULL AUTO_INCREMENT,
    uname varchar(20),
    uemail varchar(100),
    upassword varchar(20),
    uphone varchar(15),
    PRIMARY KEY (uid)
);

SELECT * FROM qlspdt_yp.user;

