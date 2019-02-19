CREATE TABLE job (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  parent_job_id bigint(20),
  active boolean DEFAULT true,
  PRIMARY KEY (id),
  FOREIGN KEY (parent_job_id) REFERENCES job(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE task (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  job_id bigint(20),
  active boolean DEFAULT true,
  PRIMARY KEY (id),
  FOREIGN KEY (job_id) REFERENCES job(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO job values(null,'Job Test One', null, null);
INSERT INTO task values(null,'Task Test One', 1, null);


CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(1000) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user values(null,'admin', 'admin@gmail.com', '$2a$10$d1X6lgJ/fBEV.4TwS4Zhr.MNAfOLDjJjRE2HcAMHwblsfcxGKLwtq');


