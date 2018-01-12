/* progress_soft database*/

/* iso_currency_code*/
CREATE TABLE `iso_currency_code`(
  `id` bigint NOT NULL auto_increment ,
  `country_name` varchar(250) NOT NULL,
  `currency_code` varchar(250) NOT NULL,
  
  PRIMARY KEY (`id`)
);
INSERT INTO iso_currency_code(country_name,currency_code) values('Afghanistan','AFN');
INSERT INTO iso_currency_code(country_name,currency_code) values('MYR','MYR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Armenia','AMD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Albania','ALL');
INSERT INTO iso_currency_code(country_name,currency_code) values('Australia','AUD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Aruba','AWG');
INSERT INTO iso_currency_code(country_name,currency_code) values('Barbados','BBD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Bangladesh','BDT');
INSERT INTO iso_currency_code(country_name,currency_code) values('Bahrain','BHD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Bermuda','BMD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Brazil','BRL');
INSERT INTO iso_currency_code(country_name,currency_code) values('Bhutan','BTN');
INSERT INTO iso_currency_code(country_name,currency_code) values('Canada','CAD');
INSERT INTO iso_currency_code(country_name,currency_code) values('China','CNY');
INSERT INTO iso_currency_code(country_name,currency_code) values('Cuba','CUC');
INSERT INTO iso_currency_code(country_name,currency_code) values('Egypt','EGP');
INSERT INTO iso_currency_code(country_name,currency_code) values('EUR','EUR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Hong Kong','HKD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Israel','ILS');
INSERT INTO iso_currency_code(country_name,currency_code) values('India','INR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Japan','JPY');
INSERT INTO iso_currency_code(country_name,currency_code) values('Korea','KRD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Kuwait','KWD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Sri Lanka','LKR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Morocco','MAD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Maldives','MVR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Mexico','MXN');
INSERT INTO iso_currency_code(country_name,currency_code) values('Qatar','QAR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Jordan','JOD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Russia','RUB');
INSERT INTO iso_currency_code(country_name,currency_code) values('Saudi Arabia','SAR');
INSERT INTO iso_currency_code(country_name,currency_code) values('Singapore','SGD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Swaziland','SZL');
INSERT INTO iso_currency_code(country_name,currency_code) values('United States','USD');
INSERT INTO iso_currency_code(country_name,currency_code) values('Zimbabwe','ZWD');

/* file_info*/
CREATE TABLE `file_info`(
  `id` bigint NOT NULL auto_increment ,
  `file_name` varchar(250) NOT NULL,
  
  PRIMARY KEY (`id`),
  UNIQUE (`file_name`)
);

/* valid_deal*/
CREATE TABLE `valid_deal`(
  `id` bigint NOT NULL auto_increment ,
  `from_currency` bigint(250) NOT NULL,
  `to_currency` bigint(250) NOT NULL,
  `amount` float NOT NULL,
  `file_name` bigint(250) NOT NULL,
  `date` datetime NOT NULL,
  
  PRIMARY KEY (`id`),
  FOREIGN KEY (`from_currency`) REFERENCES  iso_currency_code (id),
  FOREIGN KEY (`to_currency`) REFERENCES  iso_currency_code (id),
  FOREIGN KEY (`file_name`) REFERENCES  file_info (id)
);

/* valid_deal*/
CREATE TABLE `invalid_deal`(
  `id` bigint NOT NULL auto_increment,
  `from_currency` varchar(250),
  `to_currency` varchar(250),
  `amount` varchar(250),
  `file_id` bigint,
  `date` varchar(250),
  `reason` varchar(1000),
  
  PRIMARY KEY (`id`),
  FOREIGN KEY (`file_id`) REFERENCES  file_info (id)
);

/* accumulative_count*/
CREATE TABLE `accumulative_count`(
  `id` bigint NOT NULL auto_increment ,
  `iso_currency_code` bigint NOT NULL,
  `count` int NOT NULL,
  
  PRIMARY KEY (`id`),
  FOREIGN KEY (`iso_currency_code`) REFERENCES  iso_currency_code (id)
);
