# Spring_Security
스프링 시큐리티 공부

# 인증 API - Spring Security 의존성 추가
#### chapter 1.1
`implementation 'org.springframework.boot:spring-boot-starter-security'`
## 해당 의존성으로 추가 시 일어나는 일들
- 서버가 기동되면 스프링 시큐리티의 초기화 작업 및 보안 설정이 이루어진다.
- 별도의 설정이나 구현을 하지 않아도 기본적인 웹 보안 기능이 현재 시스템에 연동되어 작동됨
    1. 모든 요청은 인증이 되어야 자원에 접근 가능
    2. 인증 방식은 폼 로그인 방식과 httpBasic 로그인 방식을 제공한다.
    3. 기본 로그인 페이지 제공
    4. 기본 계정 한 개 제공 (username: user / password: 랜덤 문자열)

#### Chapter 1.2
- 인증 API - 사용자 정의 보안 기능 구현
<img width="820" alt="image" src="https://user-images.githubusercontent.com/38535971/184591822-eb48b34d-c36d-4c93-a9ae-e61f9654c968.png">


- SecurityConfig 설정
```java
@Configuration  
@EnableWebSecurity  
public class SecurityConfig extends WebSecurityConfigurerAdapter {  
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        //인가 정책  
        http  
                .authorizeRequests()  
                .anyRequest()  
                .authenticated();  
  
        //인증 정책 form 로그인  
        http  
                .formLogin();  
    }  
}
```

### 현재 WebSecurityConfigurerAdapter 클래스가 Deprecated됨 (22.08.15)
- 그렇기 때문에 추후에 상속받지 않고 필요한 클래스에 `@Bean` 을 직접 주입해줘야함...
- [관련블로그 바로가기](https://velog.io/@pjh612/Deprecated%EB%90%9C-WebSecurityConfigurerAdapter-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8C%80%EC%B2%98%ED%95%98%EC%A7%80)

#### chapter 1.3
- 인증 API - Form 인증
[![2022-08-17-01-06-38.png](https://i.postimg.cc/G3T8Fycg/2022-08-17-01-06-38.png)](https://postimg.cc/rzcwczR5)

[![2022-08-17-01-48-18.png](https://i.postimg.cc/6pt8xbCF/2022-08-17-01-48-18.png)](https://postimg.cc/jL3xzXgh)
