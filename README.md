# Springboot-JPA-Blog
스프링 부트 블로그 프로젝트

## STS로 Spring boot 연동하기
`Spring Framework` 를 지원하는 IDE 개발 툴중 하나로 Java 기반의 웹 서비스 어플리케이션 구축을 쉽게 할 수 있도록 도와주는 개발 도구이다. `(Eclipse)`

@RestController는 문자 그 자체를 return 하는 반면,
@Controller는 해당 경로 이하에 있는 파일을 리턴하므로 슬러시(/)를 붙여야 한다.

스프링부트는 기본적으로 jsp 지원을 하지 않는다.
jsp파일을 리턴해줘도 정상적으로 동작하지 않는다.
스프링부트에서 jsp를 인식하기 위한 사전설정은 다음과 같다.

    1. pom.xml에 JSP 템플릿 엔진 dependency 추가
    		<!-- JSP 템플릿 엔진 -->
		<dependency>
		    <groupId>org.apache.tomcat.embed</groupId>
		    <artifactId>tomcat-embed-jasper</artifactId>
		</dependency>

    2. application.yml에 다음 코드를 추가한다.
        spring:
          mvc:
            view:
              prefix: /WEB-INF/views/
              suffix: .jsp

       src/main/webapp/WEB-INF/views 디렉토리를 직접 만들어야 한다.
       이때 뒤에 확장자명이 이미 설정파일에 추가되어 있으므로 파일이름만을 return한다. EX) return "temp";

JSP파일은 정적 파일이 아니므로 웹서버인 아파치가 처리하지 못한다. 톰캣이 대신 컴파일해서 웹 브라우저에게 전달한다.

`MySQL - user table` 생성

<img src="https://user-images.githubusercontent.com/80264449/159158235-22ea7c3a-cc83-41a4-acc6-6a9d35ebd0af.png" width="100%" height="70%">

메인화면 부트스트랩(BootStrap) - jsp 파일로 관리

## 로그인 회원가입 서비스 구현 해보기

트랜잭션 : 일이 처리되기 위한 가장 작은 단위이다.

여러 개의 트랜잭션이 묶여서 하나의 트랜잭션으로 구현되는 구현체를 Service로 둔다.

DB 격리 수준 
예시 - 어떤 트랜잭션 시작 후 UPDATE 문으로 수정한 데이터를, 다른 트랜잭션이 
READ(SELECT) 하려는 경우 COMMIT이 되지 않았기 때문에 수정 전 
데이터를 읽어오게 된다(UNDO 영역 내에서). READ COMMIT이 이뤄진 이후에
SELECT해야 이후 트랜잭션이 올바른 데이터를 읽어올 수 있다.
PHANTOM READ를 막기 위해 REPEATABLE READ를 사용해야한다.

여기서 REPEATABLE READ는 수정된 데이터를 처리해서 정합성을 유지할 수 있다.
하지만 추가되는 데이터, 즉 INSERT는 처리하지 못한다. 이것을 막으려면
DB를 완전히 격리시켜줘야 한다. 이 때 SERIALIZABLE 방식을 사용할 수 있다.
하지만 SERIALIZABLE 방식은 DB 가용성이 떨어진다. (동시 처리가 안 되기 때문에)

REPEATABLE READ를 사용하면서 하나의 트랜잭션에서 여러 번의 READ를 해야 할 때는
부정합 현상을 막기 위해선 TABLE을 복제해서 READ하는 방식을 사용할 수 있다.

