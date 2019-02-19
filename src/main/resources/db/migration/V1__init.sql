CREATE TABLE job (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  parent_job_id bigint(20),
  active boolean DEFAULT false,
  PRIMARY KEY (id),
  FOREIGN KEY (parent_job_id) REFERENCES job(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE task (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  job_id bigint(20),
  active boolean DEFAULT false,
  PRIMARY KEY (id),
  FOREIGN KEY (job_id) REFERENCES job(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(1000) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user values(null,'admin', 'admin@gmail.com',  STRINGTOUTF8('adminPass'));


