package com.sys.controller;
import com.sys.model.Log;
import com.sys.model.Users;
import com.sys.service.LogService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
public class setLog {
    static public boolean setlod(HttpServletRequest httpServletRequest, String caozuo,LogService logService){
        HttpSession httpSession = httpServletRequest.getSession();
        if (httpSession.getAttribute("islogin")!=null)
        {
            Users users = (Users) httpSession.getAttribute("islogin");
            int username = users.getId();
            Date date = new Date(System.currentTimeMillis());
//            Date date = new Date(System.currentTimeMillis());
            Log log = new Log();
            log.setCz(caozuo);
            log.setCzr(username);
            log.setTime(date);
            logService.insertSelective(log);
            return true;
        }
        return false;
    }
}
