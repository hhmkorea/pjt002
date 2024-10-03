-- 사용자 추가 : 유저이름@아이피주소
-- create user 'cos'@'%' identified by 'cos1234';
-- ON DB이름.테이블명
-- 권한 설정 : TO 유저이름@아이피주소
-- GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
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

-- 테이블 조회
select * from tb_post;
delete from tb_post where  id = 3;
desc tb_post;

-- 데이터 삭제
truncate tb_post;

/*
CREATE TABLE `tb_post` (
                           `id`            bigint(20)    NOT NULL AUTO_INCREMENT COMMENT 'PK',
                           `title`         varchar(100)  NOT NULL COMMENT '제목',
                           `content`       varchar(3000) NOT NULL COMMENT '내용',
                           `writer`        varchar(20)   NOT NULL COMMENT '작성자',
                           `view_cnt`      int(11)       NOT NULL COMMENT '조회 수',
                           `notice_yn`     tinyint(1)    NOT NULL COMMENT '공지글 여부',
                           `delete_yn`     tinyint(1)    NOT NULL COMMENT '삭제 여부',
                           `created_date`  datetime      NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
                           `modified_date` datetime               DEFAULT NULL COMMENT '최종 수정일시',
                           PRIMARY KEY (`id`)
) COMMENT '게시글';*/

