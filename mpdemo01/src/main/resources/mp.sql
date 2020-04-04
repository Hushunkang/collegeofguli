DROP TABLE IF EXISTS USER;
CREATE TABLE USER
(
id BIGINT(20) NOT NULL COMMENT '用户ID',
NAME VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
age TINYINT(11) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (id)
);

DELETE FROM user;
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
