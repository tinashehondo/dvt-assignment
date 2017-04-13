CREATE TABLE Route (
  routeId INT NOT NULL ,
  origin varchar(255) NOT NULL,
  destination varchar(255) DEFAULT NULL,
  distance DOUBLE DEFAULT NULL ,
  PRIMARY KEY (node)
);

/*
CREATE TABLE Route (
 routeId int(11) NOT NULL,
  distance decimal(19,2) DEFAULT NULL,
  destination_node varchar(255) DEFAULT NULL,
  origin_node varchar(255) DEFAULT NULL,
  PRIMARY KEY (routeId),
);*/
