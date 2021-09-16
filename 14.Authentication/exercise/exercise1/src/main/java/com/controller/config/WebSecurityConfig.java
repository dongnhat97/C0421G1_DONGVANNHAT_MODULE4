package com.controller.config;

import com.controller.model.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.persistence.PersistenceContext;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encoder...*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    /*Cấu hình security bằng HTTP basic*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                    .loginPage("/block/login")
                    /*Login thanh cong se chuyen huong ve URL man hinh hien tai,
                    neu truy cap truc tiep /login thi login thanh cong se chuyen huong ve /student */
                    .defaultSuccessUrl("/block/list",true).permitAll()
                .and()
                    .authorizeRequests().antMatchers("/block/list").permitAll()
                   .antMatchers("/block/showCreate").hasAnyRole("USER","ADM")
                .antMatchers("/block/view/**").hasAnyRole("USER","ADM")
                .antMatchers("/block/search").hasAnyRole("USER","ADM")
                .antMatchers("/block/showCreate").hasRole("ADM")
                .antMatchers("/block/save").hasRole("ADM")
                .antMatchers("/block/showUpdate/**").hasRole("ADM")
                .antMatchers("/block/update").hasRole("ADM")
                .antMatchers("/block/showDelete/**").hasRole("ADM")
                .antMatchers("/block/delete").hasRole("ADM")
                .anyRequest().authenticated();

//                    Cấu hình remember me
           http.authorizeRequests().and().rememberMe()
                   .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);
    }



    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
}
