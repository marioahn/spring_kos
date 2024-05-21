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
-  