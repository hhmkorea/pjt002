# pjt002
:Spring Boot 게시판 만들기

### < 개발환경 >
- 개발 언어 : JAVA
- 개발 도구 : intelliJ
- 프레임워크 : Spring Boot(Tomcat Server 내장), MyBatis(DB 통신)
- 데이타베이스 : mariaDB
- 빌드 도구 : Gradle
- 화면 처리 : Thymeleaf
- 화면 디자인 : bootstrap
- 기타 라이브러리 : lombok

### < 참고자료 >
> https://congsong.tistory.com/12

### < MyBatis >
- Mapper(Java 인터페이스)와 XML Mapper(실제로 DB에 접근해서 호출할 SQL 쿼리를 작성(선언)하는 파일)를 통해 DB와 통신한다.
- 즉, XML Mapper에 SQL 쿼리를 선언해 두고 Mapper를 통해 SQL 쿼리를 호출한다. 
- Mapper는 XML Mapper에 선언된 SQL 중에서 메서드명과 동일한 id를 가진 SQL 쿼리를 찾아 실행한다.
- Mapper에는 @Mapper 어노테이션을 필수적으로 선언해 주어야 하며, Mapper와 XML Mapper는 XML Mapper의 namespace라는 속성을 통해 연결된다.

> DB에서 테이블의 칼럼명은 언더스코어(_)로 연결된 "스네이크 케이스" 사용 

> 자바에서 변수명은 소문자로 시작하고, 구분되는 단어의 앞 글자만 대문자로 처리하는 "카멜 케이스" 사용
