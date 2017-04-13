--DROP TABLE users IF EXISTS;
CREATE TABLE Planet (
  node varchar(255) NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (node)
);