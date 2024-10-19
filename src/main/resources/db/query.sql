
#################### Table 데이타 조회 및 관리 ####################

-- 테이블 조회
SELECT * FROM tb_post;
SELECT * FROM tb_member;
SELECT * FROM tb_comment;
SELECT * FROM tb_file;
-- 테이블 구조확인
DESC tb_file;
SHOW full columns FROM tb_file;
-- 제약 조건(PK, FK) 조회
SELECT * FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'tb_file';

SELECT count(*) FROM tb_member;
SELECT count(*) FROM tb_comment WHERE delete_yn = 0 AND post_id = '18343';




#################### DB, Table 생성 및 관리 ####################

-- 테이블 삭제
# delete from tb_comment where  id = 3;
-- 데이터 삭제
# truncate tb_comment;
-- 사용자 추가 : 유저이름@아이피주소
-- create user 'cos'@'%' identified by 'cos1234';
-- ON DB이름.테이블명
-- 권한 설정 : TO 유저이름@아이피주소
-- GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
-- 데이터베이스 생성
# CREATE DATABASE board CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
-- 데이터베이스 사용
USE board;
-- 사용자 조회
SELECT * FROM mysql.user;
-- 한글설정 확인
SHOW variables LIKE 'c%';
SHOW databases ;
SHOW tables;

-- 테이블 생성(tb_post)
/*CREATE TABLE `tb_post` (
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

-- 테이블 생성(tb_member)
/*CREATE TABLE `tb_member` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 번호 (PK)',
                             `login_id` varchar(20) NOT NULL COMMENT '로그인 ID',
                             `password` varchar(60) NOT NULL COMMENT '비밀번호',
                             `name` varchar(20) NOT NULL COMMENT '이름',
                             `gender` enum('M','F') NOT NULL COMMENT '성별',
                             `birthday` date NOT NULL comment '생년월일',
                             `delete_yn` tinyint(1) NOT NULL COMMENT '삭제 여부',
                             `created_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
                             `modified_date` datetime DEFAULT NULL COMMENT '최종 수정일시',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY uix_member_login_id (`login_id`)
) COMMENT '회원';*/

-- 데이터 자가 복제(PostServiceTest.java 에서 1000건 추가 후 saveByForeach() 실행하면 2000건)
# INSERT INTO tb_post (title, content, writer, view_cnt, notice_yn, delete_yn)
#     (SELECT title, content, writer, view_cnt, notice_yn, delete_yn FROM tb_post WHERE delete_yn = 0);

-- 테이블 생성(tb_comment)
/*create table tb_comment (
                            id bigint not null auto_increment comment '댓글 번호 (PK)'
                            , post_id bigint not null comment '게시글 번호 (FK)'
                            , content varchar(1000) not null comment '내용'
                            , writer varchar(20) not null comment '작성자'
                            , delete_yn tinyint(1) not null comment '삭제 여부'
                            , created_date datetime not null default CURRENT_TIMESTAMP comment '생성일시'
                            , modified_date datetime comment '최종 수정일시'
                            , primary key(id)
) comment '댓글';
*/
-- 제약조건 추가(tb_comment)
-- alter table tb_comment add constraint fk_post_comment foreign key(post_id) references tb_post(id);
-- FK 추가 : 게시글과 댓글 1:N관계로 게시글 id에 딸린 여려개 댓글 관리하는 주요키.

-- 테이블 생성(tb_file)
/*CREATE TABLE `tb_file` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '파일 번호 (PK)',
                           `post_id` bigint(20) NOT NULL COMMENT '게시글 번호 (FK)',
                           `original_name` varchar(255) NOT NULL COMMENT '원본 파일명',
                           `save_name` varchar(40) NOT NULL COMMENT '저장 파일명',
                           `size` int(11) NOT NULL COMMENT '파일 크기',
                           `delete_yn` tinyint(1) NOT NULL COMMENT '삭제 여부',
                           `created_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
                           `deleted_date` datetime DEFAULT NULL COMMENT '삭제일시',
                           PRIMARY KEY (`id`),
                           KEY `fk_post_file` (`post_id`),  -- FK 추가 : 게시글과 파일 1:N관계로 게시글 id에 딸린 여려개 파일 관리하는 주요키.
                           CONSTRAINT `fk_post_file` FOREIGN KEY (`post_id`) REFERENCES `tb_post` (`id`)
) COMMENT '파일';
*/

