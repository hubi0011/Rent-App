package com.RentCar.RentCar.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;




public class SecurityUtils {

    public static User getCurrentUser() {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principle instanceof User) {
            return (User) principle;
        }
        return null;
    }
//    public static String getRole(){
//        User user = getCurrentUser();
//        Collection<GrantedAuthority> authorities = user.getAuthorities();
//        for(GrantedAuthority authority: authorities){
//            return authority.getAuthority();
//        }
//        return null;
//    }
}
