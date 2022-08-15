# Spring_Security
스프링 시큐리티 공부

# 인증 API - Spring Security 의존성 추가
`implementation 'org.springframework.boot:spring-boot-starter-security'`
## 해당 의존성으로 추가 시 일어나는 일들
- 서버가 기동되면 스프링 시큐리티의 초기화 작업 및 보안 설정이 이루어진다.
- 별도의 설정이나 구현을 하지 않아도 기본적인 웹 보안 기능이 현재 시스템에 연동되어 작동됨
	1. 모든 요청은 인증이 되어야 자원에 접근 가능
	2. 인증 방식은 폼 로그인 방식과 httpBasic 로그인 방식을 제공한다.
	3. 기본 로그인 페이지 제공
	4. 기본 계정 한 개 제공 (username: user / password: 랜덤 문자열)

