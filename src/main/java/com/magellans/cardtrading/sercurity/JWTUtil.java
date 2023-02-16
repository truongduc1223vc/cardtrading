//package com.magellans.cardtrading.sercurity;
//
//import com.magellans.cardtrading.controller.old.RoleType;
//import org.json.JSONObject;
//import org.springframework.security.core.Authentication;
//
//import java.util.Base64;
//
//public class JWTUtil {
//    public static JWTUser getAuthorizationBody(String token) {
//        try {
//            String[] split_string = token.split("\\.");
//            String base64EncodedBody = split_string[1];
//            String body = new String(Base64.getDecoder().decode(base64EncodedBody));
//            JSONObject jsonObj = new JSONObject(body);
//            return new JWTUser(jsonObj);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static boolean hasRoleRm(JWTUser token) {
//        if (token == null || token.getRoles() == null) {
//            return false;
//        }
//        return token.getRoles().contains(RoleType.rm.name());
//    }
//
//    public static JWTUser getPrincipal(Authentication authentication) {
//        return (JWTUser) authentication.getPrincipal();
//    }
//}
