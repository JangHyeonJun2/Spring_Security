package io.security.basicSecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
                .formLogin()
//                .loginPage("/loginPage")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("userId")
                .passwordParameter("passwd")
                .loginProcessingUrl("/login_proc")
                .successHandler((request, response, authentication) -> {
                    System.out.println("authentication" + authentication.getName());
                    response.sendRedirect("/");
                })
                .failureHandler((request, response, exception) -> {
                    System.out.println("exception" + exception.getMessage());
                    response.sendRedirect("/login");
                })
                .permitAll();
        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .addLogoutHandler((request, response, authentication) -> {
                    HttpSession session = request.getSession();
                    session.invalidate();
                })
                .logoutSuccessHandler((request, response, authentication) -> response.sendRedirect("/login"))
                .deleteCookies("remember-me");
    }
}
