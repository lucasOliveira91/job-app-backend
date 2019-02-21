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

INSERT INTO job values(null,'Job Test Jedi', null, null);
INSERT INTO task values(null,'Task Test Jedi', 1, null);

INSERT INTO job values(null,'Job Test Sith', null, null);
INSERT INTO task values(null,'Task Test Sith', 2, null);

INSERT INTO job values(null,'Job Test Leia', null, null);
INSERT INTO task values(null,'Task Test Leia', 3, null);

INSERT INTO job values(null,'Job Test Ben', null, null);
INSERT INTO task values(null,'Task Test Ben', 4, null);

INSERT INTO job values(null,'Job Test Luky', null, null);
INSERT INTO task values(null,'Task Test Luky', 5, null);

INSERT INTO job values(null,'Job Test Jango Fett', null, null);
INSERT INTO task values(null,'Task Test Fett', 6, null);

INSERT INTO job values(null,'Job Test Rey', null, null);
INSERT INTO task values(null,'Task Test Rey', 7, null);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(1000) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user values(null,'admin', 'admin@gmail.com', '$2a$10$d1X6lgJ/fBEV.4TwS4Zhr.MNAfOLDjJjRE2HcAMHwblsfcxGKLwtq');


