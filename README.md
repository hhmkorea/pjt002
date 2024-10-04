# pjt002
:Spring Boot 게시판 만들기
### 개발환경 ---------------------------
- 개발 언어 : JAVA
- 개발 도구 : intelliJ
- 프레임워크 : Spring Boot(Tomcat Server 내장), MyBatis(DB 통신)
- 데이타베이스 : mariaDB
- 빌드 도구 : Gradle
- 화면 처리 : Thymeleaf
- 화면 디자인 : bootstrap
- 기타 라이브러리 : lombok
####
### Spring Boot ---------------------------
1. Anotation 
   - 과거 : @RequestMapping(value = "...", method = RequestMethod.XXX)
   - 현재 : @xxxMapping("...")
####
### MyBatis ---------------------------
1. Mapper
   - Mapper(Java 인터페이스)와 XML Mapper(실제로 DB에 접근해서 호출할 SQL 쿼리를 작성(선언)하는 파일)를 통해 DB와 통신한다.
   - 즉, XML Mapper에 SQL 쿼리를 선언해 두고 Mapper를 통해 SQL 쿼리를 호출한다. 
   - Mapper는 XML Mapper에 선언된 SQL 중에서 메서드명과 동일한 id를 가진 SQL 쿼리를 찾아 실행한다.
   - Mapper에는 @Mapper 어노테이션을 필수적으로 선언해 주어야 하며, Mapper와 XML Mapper는 XML Mapper의 namespace라는 속성을 통해 연결된다.
2. 명명 규칙
   - DB에서 테이블의 칼럼명은 언더스코어(_)로 연결된 "스네이크 케이스" 사용 
   - 자바에서 변수명은 소문자로 시작하고, 구분되는 단어의 앞 글자만 대문자로 처리하는 "카멜 케이스" 사용
####
### Themeleaf ---------------------------
1. javascript 구현 방식
   - '<', '>' 태그를 엄격하게 검사하기 때문에 자바스크립트 코드는 꼭 CDATA로 묶어줘야 함.
   - CDATA는 특수문자를 전부 문자열로 치환(replace)할 때 사용.
2. parameter 연결 방식 
   - 일반적인 GET 파라미터 연결 방식 -▶ /post/view.do?idx=${idx}&page=${page}
   - 타임리프 GET 파라미터 연결 방식 -▶ /post/view.do( idx=${idx}, page=${page} )
####
### 용어 정리 -----------------------------
1. 쿼리 스트링 (Query String)
   - 브라우저 상단의 주소창(URL)에서 ("/post/view.do?id=1") 이와 같이 ' ? ' 뒤에 id(게시글 번호)가 파라미터로 연결되어 있는데 여기서 parameter가 "key=value" 형태(구조)의 문자열로 이루어진 것.
   - 첫 번째 파라미터는 ' ? '로 시작하고, 두 번째 파라미터부터는 ' & '로 구분
   - 쿼리 스트링으로 연결된 URI는 HTTP 요청 메서드 중 GET 방식임을 의미.
###
### ※ 소스 출처 및 참고 자료
> https://congsong.tistory.com/12
