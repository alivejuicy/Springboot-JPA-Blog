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
로그인 회원가입 서비스 구현 해보기
