//package com.magellans.cardtrading.sercurity;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//
//    public JWTAuthorizationFilter(AuthenticationManager authManager) {
//        super(authManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req,
//									HttpServletResponse res,
//									FilterChain chain) throws IOException, ServletException {
//        String token = req.getHeader(SecurityConstants.HEADER_STRING);
//        String tokenXAPIKey = req.getHeader(SecurityConstants.HEADER_STRING_XAPIKEY);
//
//        if (token != null) {
//            UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            chain.doFilter(req, res);
//        } else if (tokenXAPIKey != null) {
//            UsernamePasswordAuthenticationToken authentication = getAuthentication(tokenXAPIKey);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            chain.doFilter(req, res);
//        } else {
//            chain.doFilter(req, res);
//            return;
//        }
//    }
//
//    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
//        if (token != null) {
//            // parse the token.
//            JWTUser user = JWTUtil.getAuthorizationBody(token);
//
//            if (user != null) {
//                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//                if (user.getRoles() != null) {
//                    for (String role : user.getRoles()) {
//                        grantedAuthorities.add(new SimpleGrantedAuthority(role));
//                    }
//                }
//                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//            }
//            return null;
//        }
//        return null;
//    }
//}