# pjt002 :Spring Boot 게시판 만들기
* 관련 URL : https://congsong.tistory.com/12
#### 
### 개발환경 ---------------------------
- 개발 언어 : JAVA
- 개발 도구 : intelliJ
- 프레임워크 : Spring Boot(Tomcat Server 내장), MyBatis(DB 통신)
- 데이타베이스 : mariaDB
- 빌드 도구 : Gradle
- 화면 처리 : Thymeleaf, jQuery(Ajax 비동기 처리)
- 화면 디자인 : 아인커뮤니케이션
  https://congsong.tistory.com/16 

            6. CSS 적용하기 --> 6-1) 압축 해제 및 폴더 추가하기 --> static.zip

- 기타 라이브러리 : lombok
###
### Spring Boot ---------------------------
#### 1. Anotation 문법 
   - 과거 : @RequestMapping(value = "...", method = RequestMethod.XXX)
   - 현재 : @xxxMapping("...")
###
### MyBatis ---------------------------
#### 1. Mapper
   - Mapper(Java 인터페이스)와 XML Mapper(실제로 DB에 접근해서 호출할 SQL 쿼리를 작성(선언)하는 파일)를 통해 DB와 통신한다.
   - 즉, XML Mapper에 SQL 쿼리를 선언해 두고 Mapper를 통해 SQL 쿼리를 호출한다. 
   - Mapper는 XML Mapper에 선언된 SQL 중에서 메서드명과 동일한 id를 가진 SQL 쿼리를 찾아 실행한다.
   - Mapper에는 @Mapper 어노테이션을 필수적으로 선언해 주어야 하며, Mapper와 XML Mapper는 XML Mapper의 namespace라는 속성을 통해 연결된다.
#### 2. 명명 규칙
   - DB에서 테이블의 칼럼명은 언더스코어(_)로 연결된 "스네이크 케이스" 사용 
   - 자바에서 변수명은 소문자로 시작하고, 구분되는 단어의 앞 글자만 대문자로 처리하는 "카멜 케이스" 사용
###
### Themeleaf ---------------------------
#### 1. Themeleaf vs JSP
   - JSP : Servlet 이라는 형태로 변환되어 실행, Servlet이 자바 소스이다 보니 HTML 코드에서 JAVA 코드를 넣어 동적 웹페이지를 구성
   - Thymeleaf : HTML, JS, CSS 등을 처리할 수 있는 웹 및 독립형 환경에서 사용이 가능한 java 템플릿 엔진.
     > 서블릿으로 변환되지 않기 때문에 비즈니스 로직이 완전히 분리된다.
     
     > Thymeleaf 템플릿 엔진의 장점은 페이지를 생성하는데 필요한 정보를 태그의 속성으로 넣을 수 있어 유지보수가 간단하다.
#### 2. javascript 구현 방식
   - '<', '>' 태그를 엄격하게 검사하기 때문에 자바스크립트 코드는 꼭 CDATA로 묶어줘야 함.
   - CDATA는 특수문자를 전부 문자열로 치환(replace)할 때 사용.
#### 3. parameter 연결 방식 
   - 일반적인 GET 파라미터 연결 방식 -▶ /post/view.do?idx=${idx}&page=${page}
   - 타임리프 GET 파라미터 연결 방식 -▶ /post/view.do( idx=${idx}, page=${page} )
####
## 용어 정리 -----------------------------
### 1. 쿼리 스트링 (Query String)
   - 브라우저 상단의 주소창(URL)에서 ("/post/view.do?id=1") 이와 같이 ' ? ' 뒤에 id(게시글 번호)가 파라미터로 연결되어 있는데 여기서 parameter가 "key=value" 형태(구조)의 문자열로 이루어진 것.
   - 첫 번째 파라미터는 ' ? '로 시작하고, 두 번째 파라미터부터는 ' & '로 구분
   - 쿼리 스트링으로 연결된 URI는 HTTP 요청 메서드 중 GET 방식임을 의미.
### 2. AOP(Aspect Oriented Programming)
   - 관점 지향 프로그래밍
   - 객체 지향 프로그래밍(OOP)을 더욱 OOP답게 사용할 수 있도록 도와주는 역할을 함.
      ##### 1) Around
      > @Around("execution(....)")
      ###### -> @Around : Advice 중 하나. Target 메서드 이전과 이후 모두 호출 제어.
      ###### -> execuution() : 포인트컷을 지정하는 문법.
### 3. REST(Representational State Transfer)
   - 하나의 URI는 하나의 고유한 Resource를 대표하도록 설계됨.
   - 디바이스 종류에 상관없이 공통으로 데이터를 처리할 수 있도록 하는 방식.
   - REST API 참고자료 : https://meetup.nhncloud.com/posts/92
      #### 1) REST API 전송 방식
      ##### - HTML form
      ###### : @Getter, @Setter 이용, 요청 클래스의 각 멤버 변수는 HTML form 태그에 선언된 name 값을 기준으로 파라매터 전송.
      ##### - REST API
      ###### : JSON 형태(key-value 구조)로 데이터를 처리하므로 @Setter는 필요없음. 
      #### 2) REST API 테스트 
      ##### - 페이지가 필요할때 
      ###### : @Controller, @ResponseBody 사용, HTML이 아닌 리턴 타입에 해당하는 데이터 자체 리턴
      ##### - 페이지가 필요없을때(예:댓글)
      ###### : @RestController 사용, 클래스 레벨에서 선언, 자동으로 @ResponseBody가 적용됨.
      ##### - @PathVariable : URI에서 템플릿 형태로 parameter를 받을 수 있음. 
      ##### - @RequestBody : 데이터 생성 or 수정하는 경우 사용, 저장할 데이터를 <font color='green'>JSON 포맷형태로 서버에 요청</font> 보내면, key-value 구조로 이루어진 각각의 데이터가 Java 객체와 mapping 됨.

      #### 3) 동기와 비동기
      ##### - 동기 처리 : 컨트롤러에서 데이터와 화면 두가지를 동시에 처리 
      ##### - 비동기 처리 : 화면 내에서 데이터의 처리(CRUD 등)를 실시간으로 서버에 요청. 페이지를 로딩하지 않고, <font color='orange'>Ajax를 이용해 실시간으로 서버와 데이터 주고 받음.</font>
