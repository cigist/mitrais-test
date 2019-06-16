CREATE DATABASE mitrais;

CREATE TABLE `tbl_register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(13) DEFAULT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
