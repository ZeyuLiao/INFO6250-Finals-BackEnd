package edu.neu.booking.ticketbooking.utils;


import edu.neu.booking.ticketbooking.entity.vo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils
{

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser()
    {
        return (LoginUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Boolean isAdmin(){
        String username = getLoginUser().getUsername();
        return username != null;
    }

    public static String getUserName() {
        return getLoginUser().getUsername();
    }
}