package com.sys.controller;

import com.sys.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class jumpController {
    @Autowired
    private LogService logService;
    @RequestMapping("/Jumpto")
    public String Jumpto(@RequestParam("url") String url){
        return url;
    }
    @RequestMapping("/resetpassword")
    public String resetpassword()
    {return  "table/xgmm";}
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        setLog.setlod(httpServletRequest, "安全退出",logService);
        httpSession.invalidate();
        return "logout";
    }
}
