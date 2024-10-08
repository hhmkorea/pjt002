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
# tb_comment
# tb_post


-- 테이블 조회
select count(*) from tb_comment;
select * from tb_comment;
delete from tb_comment where  id = 3;
-- 데이터 삭제
-- truncate tb_comment;
-- 테이블 구조확인
show full columns from tb_comment;
desc tb_comment;
-- 제약 조건 조회
SELECT * FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'tb_comment'
;
SELECT COUNT(*) FROM tb_comment WHERE delete_yn = 0 AND post_id = '18343';

-- 데이터 자가 복제(PostServiceTest.java 에서 1000건 추가 후 saveByForeach() 실행하면 2000건)
# INSERT INTO tb_post (title, content, writer, view_cnt, notice_yn, delete_yn)
#     (SELECT title, content, writer, view_cnt, notice_yn, delete_yn FROM tb_post WHERE delete_yn = 0);

-- 테이블 생성(tb_comment)
/*
create table tb_comment (
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

-- 테이블 생성(tb_post)
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

