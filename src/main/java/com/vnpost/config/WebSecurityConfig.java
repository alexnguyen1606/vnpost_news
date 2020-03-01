package com.vnpost.config;

import com.vnpost.security.CustomSuccessHandler;
import com.vnpost.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return customSuccessHandler;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //cho tất cả truy cập
        //http.authorizeRequests().antMatchers("/ckfinder/*").permitAll();
        http.authorizeRequests().antMatchers("/admin").access("hasAuthority('USER') or hasAuthority('ADMIN')");
        http.authorizeRequests().antMatchers("/admin/user").access("hasAuthority('ADMIN')");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accessDenied");
        http.authorizeRequests().antMatchers("/admin/user/changeinfo").authenticated();
        //cấu hình trang login
        http.authorizeRequests()

                .and().formLogin()
                .loginPage("/login")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .loginProcessingUrl("/j_spring_security_check")
                .successHandler(customSuccessHandler)

                .failureUrl("/login?accessDenied=true").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .invalidateHttpSession(true);

                //.and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true);
        http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/images/**","/ckeditor/**","/ckfinder/**","/media/**");
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }

}
