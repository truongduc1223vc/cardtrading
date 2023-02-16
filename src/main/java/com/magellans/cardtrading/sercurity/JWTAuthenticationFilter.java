//package com.magellans.cardtrading.sercurity;
//
//import com.magellans.cardtrading.exception.AuthenticationException;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//												HttpServletResponse res) throws AuthenticationException {
//        JWTUser creds = new JWTUser();
//        return authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        creds.getUsername(),
//                        null,
//                        new ArrayList<>())
//        );
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//											HttpServletResponse res,
//											FilterChain chain,
//											Authentication auth) throws IOException, ServletException {
//
//    }
//}
//
