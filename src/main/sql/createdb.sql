CREATE DATABASE premierPaints;
USE premierPaints;
CREATE TABLE `premierPaints`.`users` (
`username` varchar(255) NOT NULL,
`password` varchar(255) DEFAULT NULL,
`firstname` varchar(255) NOT NULL,
`lastname` varchar(255) NOT NULL,
PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `premierPaints`.`groups` (
`username` varchar(255) DEFAULT NULL,
`groupname` varchar(255) DEFAULT NULL)
ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE INDEX groups_users_FK1 ON groups(username ASC);

INSERT INTO users VALUES('clerk','basic','level','one user');
INSERT INTO users VALUES('manager','intermediate','level','two user');
INSERT INTO users VALUES('ceo','admin','level','three user');
INSERT INTO groups VALUES('ceo','admin');
INSERT INTO groups VALUES('manager','intermediate');
INSERT INTO groups VALUES('clerk','basic');