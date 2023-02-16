//package com.magellans.cardtrading.sercurity;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Order(1)
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    // Custom JWT based security filter
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.antMatcher("/api/**")
//                .csrf().disable()
//                .authorizeRequests()
////                .antMatchers("/api/**").permitAll()
//                .antMatchers("/api/v1/product/**").permitAll()
//                .antMatchers("/api/v2/product/**").permitAll()
//                .antMatchers("/api/v2/deal/**").permitAll()
////                .antMatchers("/api/v1/consumer/files/**").permitAll()
////                .antMatchers("/api/v3/consumer/files/**").permitAll()
////                .antMatchers("/api/v3/public/consumer/files/**").permitAll()
////                .antMatchers("/api/v1/authen/login").permitAll()
////                .antMatchers("/api/v1/ecm/document/stream").permitAll()
////                .antMatchers("/api/v1/product/**").authenticated()
//                .antMatchers("/api/**").authenticated()
//                .and()
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
//    }
//
//
//
//}
