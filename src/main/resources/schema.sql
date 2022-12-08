CREATE TABLE IF NOT EXISTS teacher (
      id  INTEGER NOT NULL AUTO_INCREMENT,
      name VARCHAR(128) NOT NULL,
      PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS student (
     id  INTEGER NOT NULL AUTO_INCREMENT,
     name VARCHAR(128) NOT NULL,
     PRIMARY KEY (id),
     teacher_id int,
     FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);