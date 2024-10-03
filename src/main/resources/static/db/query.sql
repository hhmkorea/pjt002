-- 사용자 추가 : 유저이름@아이피주소
create user 'cos'@'%' identified by 'cos1234';
-- ON DB이름.테이블명
-- 권한 설정 : TO 유저이름@아이피주소
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
-- 데이터베이스 생성
CREATE DATABASE board CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
-- 데이터베이스 사용
use board;
-- 사용자 조회
select * from mysql.user;
-- 한글설정 확인
show variables like 'c%';

show databases ;
show tables;
