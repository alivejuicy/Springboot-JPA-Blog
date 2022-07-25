package com.cos.blog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.configuration.auth.AuthDetailService;

@Configuration
@EnableWebSecurity //Fillter 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthDetailService authDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(authDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests() //요청에 대한 인가가 들어오면
				.antMatchers("/","/auth/**","/js/**","/css/**", "/image/**","/dummy/**") 
				.permitAll() //위 컨텍스트는 모두 접근 가능
				.anyRequest() //그밖에 다른 요청들은 인증이 되어야한다.
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")	//인증이 필요한 요청이라면 로그인 폼으로
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/"); //성공 시 홈 화면으로
				//.failureUrl("/auth/loginForm"); //실패 시 다시 로그인 폼
			
			
	}
	

}
