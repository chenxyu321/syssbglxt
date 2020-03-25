package com.sys.controller;

import com.sys.model.Groupinfo;

import com.sys.model.Users;
import com.sys.service.GroupinfoService;
import com.sys.service.LogService;
import com.sys.service.MenuService;
import com.sys.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private GroupinfoService groupinfoService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private LogService logService;
    @RequestMapping("/Index")
    public String index(Model model, HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        Users users = (Users) httpSession.getAttribute("islogin");
        if (users!=null) {
            int groupid = users.getGroupid();
            String username = users.getUsername();
            String password = users.getUpassword();
            Users users1 = usersService.getusersByusername(username);
            if (users1.getUpassword().equals(password)){
//                此处封装需要带到前端的数据
                model.addAttribute("users",users1);
                Groupinfo groupinfo = groupinfoService.selectByPrimaryKey(users1.getGroupid());
             if (groupinfo!=null){
                 /*start权限中心*/
                 String quanxian = groupinfo.getQx();
                 String qx[] = {};
                 qx = quanxian.split(",");
                 Map map = new HashMap();
                 for (String qxcache : qx) {
                     int qxid = Integer.parseInt(qxcache);
                     Map map1 = new HashMap();
                     map1.put("pmenu", menuService.selectByPrimaryKey(qxid));
                     map1.put("cmenu", menuService.getmenubyfdm(qxid));
                     map.put(String.valueOf(qxid) + "menus", map1);
                 }
                 model.addAttribute("parentmenus", map);
                 /*end权限中心*/
                 return "index";
             }
             else {
                 model.addAttribute("errmsg","用户组信息错误！");
                 return "login";
             }
            }
            else {
                model.addAttribute("errmsg","您以更改密码请重新输入");
                return "login";
            }
        }
        return "login";
    }
    @RequestMapping("/Login")//登录模块
    public String Login(@RequestParam String username,@RequestParam String password, Model model, HttpServletRequest httpServletRequest){
        //管理员
        HttpSession session = httpServletRequest.getSession();
        password = UtilPacket.Md5MD5String(password);
        if (username.equals("admin")&&password.equals(UtilPacket.Md5MD5String("admin"))){
            Groupinfo groupinfo = groupinfoService.selectByPrimaryKey(1);
            if (groupinfo!=null) {
                /*start权限中心*/
                String quanxian = groupinfo.getQx();
                String qx[] = {};
                qx = quanxian.split(",");
                Map map = new HashMap();
                for (String qxcache : qx) {
                    int qxid = Integer.parseInt(qxcache);
                    Map map1 = new HashMap();
                    map1.put("pmenu", menuService.selectByPrimaryKey(qxid));
                    map1.put("cmenu", menuService.getmenubyfdm(qxid));
                    map.put(String.valueOf(qxid) + "menus", map1);
                }
                model.addAttribute("parentmenus", map);
                /*end权限中心*/
            }
            Users users = new Users();
            users.setUsername("admin");
            model.addAttribute("users",users);
            setLog.setlod(httpServletRequest,"admin登录",logService);
            return "index";
        }
        //教师，学生
        else if(usersService.getusersByusername(username)!=null){
            if (usersService.getusersByusername(username).getUpassword().equals(password))
            {
                Users users = usersService.getusersByusername(username);
                model.addAttribute("users",users);
                session.setAttribute("islogin",users);
                int groupid = users.getGroupid();
                Groupinfo groupinfo = groupinfoService.selectByPrimaryKey(groupid);
                if (groupinfo!=null){
                    /*start权限中心*/
                    String quanxian = groupinfo.getQx();
                    String qx[] = {};
                    qx = quanxian.split(",");
                    Map map = new HashMap();
                    for (String qxcache : qx) {
                        int qxid = Integer.parseInt(qxcache);
                        Map map1 = new HashMap();
                        map1.put("pmenu", menuService.selectByPrimaryKey(qxid));
                        map1.put("cmenu", menuService.getmenubyfdm(qxid));
                        map.put(String.valueOf(qxid) + "menus", map1);
                    }
                    model.addAttribute("parentmenus", map);
                    /*end权限中心*/
                    session.setAttribute("islogin",users);
                    setLog.setlod(httpServletRequest,"id为"+users.getId()+"的用户登录",logService);
                    return "index";
                }
                model.addAttribute("errmsg","用户组信息错误！");
                return "login";
            }
            else {
                model.addAttribute("errmsg","密码错误！");
                return "login";
            }
        }
        else {
            model.addAttribute("errmsg","用户名不存在！");
            return "login";
        }
    }
}
