//package com.magellans.cardtrading.sercurity;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Getter
//@Setter
//public class JWTUser {
//    private String username;
//    private String userId;
//    private String email;
//    private Long timeNumberRequest;
//    private Date dateRequest;
//    private List<String> roles;
//
//    public JWTUser() {
//        super();
//    }
//
//    public JWTUser(JSONObject json) {
//        super();
//        try {
//            this.username = json.getString("custodyID");
//            this.userId = json.getString("sub");
//            this.email = json.getString("email");
//            if (json.getJSONArray("roles") == null) {
//                this.roles = null;
//            } else {
//                List<String> list = new ArrayList<>();
//                JSONArray arr = json.getJSONArray("roles");
//                for (int i = 0; i < arr.length(); i++) {
//                    list.add(arr.get(i).toString());
//                }
//                this.roles = list;
//            }
//        } catch (Exception e) {
//            this.username = "";
//            this.userId = "";
//            this.email = "";
//        }
//    }
//
//}
