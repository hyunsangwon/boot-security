CREATE TABLE IF NOT EXISTS user
(
	user_no BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	id VARCHAR(20) NOT NULL,
	password VARCHAR(100) NOT NULL,
	name VARCHAR(20)
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS role
(
    role_no INT NOT NULL PRIMARY KEY,
    role_name varchar(20) NOT NULL
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS user_role
(
  user_no BIGINT NOT NULL,
  role_no INT NOT NULL,
  FOREIGN KEY (user_no) REFERENCES user (user_no),
  FOREIGN KEY (role_no) REFERENCES role (role_no)
  
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO role (role_no, role_name) VALUES (1, 'ADMIN');
INSERT INTO role (role_no, role_name) VALUES (2, 'USER');