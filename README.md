# Simple Bulletin Board CRUD Application

### 🎉 <span style="color:orange">1. 설정</span>
1. **새 프로젝트 생성**
    - **File** -> **New** -> **Spring Legacy Project** -> **MVC templates**
2. **환경**
    - **IDE**: Spring Tool Suite 3 (STS3)
    - **서버**: Apache Tomcat 9.0
    - **데이터베이스**: H2 (인메모리 데이터베이스)


---
### 📚 <span style="color:orange">2. 주제</span>
- 간단한 게시판 CRUD 애플리케이션 만들기
- `User` 테이블을 포함한 사용자 관리 기능 추가
---
### 🚀 <span style="color:orange">3. 단계</span>


##### ${\textsf{\color{green}💦Step 1: Model1}}$
- Bean = Model
- jsp = Controller + View 

##### ${\textsf{\color{green}💦Step 2: Model2}}$
- Bean = Model
- jsp =  View 
- DispatcherServlet = Controller

##### ${\textsf{\color{green}💦Step 3-1: Spring MVC 패턴}}$
- 기존에는 DispatcherServlet에 모든 Controller로직(비즈니스)이 들어가 있음
- 그러나, 이 방법은 유지보수 등의 문제가 있으므로 각 로직별로 분리
- DispatcherServlet: 유일한 서블릿 클래스 & 모든 클라이언트의 요청을 가장 먼저 처리하는 Front Controller
- HandlerMapping: 클라이언트의 요청을 처리할 Controller를 매핑
- Controller: 실.질.적인 클라이언트의 요청 처리(비즈니스 로직 in)
- ViewResolver: Controller가 리턴한 View이름으로 실행될 JSP경로 완성
- Controller -> DispatcherServlet에 return값은 String

##### ${\textsf{\color{green}💦Step 3-2: Spring MVC 패턴2}}$
- Step3-1에서는 com.springbook.view.controller에 아래와 같은 클래스들을 수.동으로 만들어주었다
    - Controller, DispatcherServlet.java, HandlerMapping, ViewResolver.java
- 그러나, 이것은 이해를 돕기 위해서 만든 것이지, 실제로는 Spring에서 제공해주는 객체들을 바로 사용하면 된다!
- 0.기존에 사용했던 view.controller에 있는 파일들 모두 삭제
- 1.WEB-INF/config/presentation-layer.xml파일에 
    - (1)HandlerMapping 등록
    - (2)Controller를 bean 등록 - (위에서 만든 handler와 연결하기 위해!)
    - (3)ViewResolver 등록
- 2.WEB-INF/web.xml파일에
    - (1)spring에서 제공해주는 DispatcherServlet클래스 등록
    - (2)인코딩도 여기서 처리! - (filer태그로 mapping)