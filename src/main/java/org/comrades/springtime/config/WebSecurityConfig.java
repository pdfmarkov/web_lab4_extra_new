package org.comrades.springtime.config;

import org.comrades.springtime.security.jwt.TokenHandler;
import org.comrades.springtime.security.jwt.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String LOGIN_ENDPOINT = "/api/aunt/**";
    private final String REFRESH_ENDPOINT = "/api/refresh/**";
    private final String CONTENT = "/dist/**";

    private final TokenHandler jwtTokenHandler;

    @Autowired
    public WebSecurityConfig(TokenHandler jwtTokenHandler) {
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers(LOGIN_ENDPOINT).permitAll()
                    .antMatchers(REFRESH_ENDPOINT).permitAll()
                    .antMatchers(CONTENT).permitAll()
                    .anyRequest().authenticated()
                .and()
                    .addFilterBefore(new JwtFilter(jwtTokenHandler), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web){
        web
                .ignoring()
                .antMatchers("/api/refresh/**");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}