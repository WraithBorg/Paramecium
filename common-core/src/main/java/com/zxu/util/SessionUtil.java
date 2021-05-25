package com.zxu.util;


import com.zxu.constant.SessionConst;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
   
    public static <T> T getCurrentUser(HttpServletRequest request) {
        Object attribute = request.getSession().getAttribute(SessionConst.CURRENT_USER);
        if (attribute == null) {
            return null;
        }
        T currentUser = (T) attribute;
        return currentUser;
    }
}
