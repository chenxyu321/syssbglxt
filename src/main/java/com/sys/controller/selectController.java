package com.sys.controller;
import com.alibaba.fastjson.JSONObject;
import com.sys.model.*;
import com.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

@RestController
public class selectController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private LogService logService;
    @Autowired
    private GroupinfoService groupinfoService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ZyglService zyglService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private SyslxService syslxService;
    @Autowired
    private XxtgService xxtgService;
    @Autowired
    private SysbglService sysbglService;
    @Autowired
    private SysglService sysglService;
    @Autowired
    private JydjService jydjService;
    @Autowired
    private SyxxbService syxxbService;
    @Autowired
    private SbshdjService sbshdjService;
    @Autowired
    private SbwxdjService sbwxdjService;

    @RequestMapping("/selectcdgl")
    public JSONObject selectcdgl(HttpServletRequest httpServletRequest) {
        List<Menu> menus = menuService.getmenuList();
        List<Map<String, Object>> list = new ArrayList<>();
        if (menus != null) {
            for (Menu menu : menus) {
                int id = menu.getId();
                String fdm = null;
                if(menu.getFdm()!=null&&menu.getFdm()!="") {
                    fdm = menuService.selectByPrimaryKey(Integer.parseInt(menu.getFdm())).getMenuname();
                }
                String menulink = menu.getMenulink();
                String menuname = menu.getMenuname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("fdm", fdm);
                map.put("menulink", menulink);
                map.put("menuname", menuname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了全部菜单信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectjsxxgl")
    public JSONObject selectjsxxgl(@RequestParam(required = false)String tname,@RequestParam(required = false) String idcard, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (tname!=null&&!tname.equals(""))
        requestparamMap.put("tname","%"+tname+"%");
        if (idcard!=null&&!idcard.equals(""))
        requestparamMap.put("idcard","%"+idcard+"%");
        List<Teacher> teachers = teacherService.getTeacherList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                int id = teacher.getId();
                String tnamestr = teacher.getTname();
                String sex = teacher.getSex();
                Date date = teacher.getBirth();
                String birth = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日";
                String zyzc = teacher.getZyzc();
                int zyid = teacher.getZyid();
                String zystr = zyglService.getZyglById(zyid).getZname();
                String tel = teacher.getTel();
                String jl = teacher.getJl();
                String idcardstr = String.valueOf(teacher.getIdcard());
                Map map = new HashMap();
                map.put("id", id);
                map.put("tname", tnamestr);
                map.put("sex", sex);
                map.put("birth", birth);
                map.put("zyzc", zyzc);
                map.put("zystr", zystr);
                map.put("tel", tel);
                map.put("jl", jl);
                map.put("idcard", idcardstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了教师信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsysbgl")
    public JSONObject selectsysbgl(@RequestParam(required = false)String sbname,@RequestParam(required = false) String bh, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (sbname!=null&&!sbname.equals(""))
            requestparamMap.put("sbname","%"+sbname+"%");
        if (bh!=null&&!bh.equals(""))
            requestparamMap.put("bh","%"+bh+"%");
        List<Sysbgl> sysbgls = sysbglService.getSysbglList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysbgls != null) {
            for (Sysbgl sysbgl : sysbgls) {
                int id = sysbgl.getId();
                String sbnamestr = sysbgl.getSbname();
                String bhstr = sysbgl.getBh();
                String sysid = sysglService.getSysglById(sysbgl.getSysid()).getSysname();
                Date date = sysbgl.getCgsj();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String cgsj =  String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日";
                int price = sysbgl.getPrice();
                int ztid = sysbgl.getZtid();
                String ztstr="未使用";
                if (ztid==1)
                    ztstr = "正在使用";
                if (ztid==2)
                    ztstr = "待审核";
                if (ztid==3)
                    ztstr = "维修中";
                String sfbxstr = "未报修";
                int sfbx = sysbgl.getSfbx();
                if (sfbx==1)
                    sfbxstr="已报修";
                String info = sysbgl.getInfo();
                String img = sysbgl.getImg();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sbname", sbnamestr);
                map.put("bh", bhstr);
                map.put("sysid", sysid);
                map.put("cgsj", cgsj);
                map.put("price", price);
                map.put("ztid", ztstr);
                map.put("sfbx", sfbxstr);
                map.put("info", info);
                map.put("img", img);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了设备信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsysbll")
    public JSONObject selectsysbll(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        List<Map<String, Object>> list = new ArrayList<>();
        if (users.getGroupid()==3){
            Student student = studentService.getStudentByIdcard(Integer.parseInt(users.getUsername()));
            List<Syxxb> syxxbList = syxxbService.getSyxxbByCid(student.getCid());
            if (syxxbList!=null)
            for (Syxxb syxxb : syxxbList){
                int sysid = syxxb.getSysid();
                List<Sysbgl> sysbgls = sysbglService.getSysbglBySysid(sysid);
                for (Sysbgl sysbgl:sysbgls){
                    int id = sysbgl.getId();
                    String sbnamestr = sysbgl.getSbname();
                    String bhstr = sysbgl.getBh();
                    String sysidstr = sysglService.getSysglById(sysid).getSysname();
                    Date date = sysbgl.getCgsj();
                    String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                    String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                    String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                    String cgsj =  String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日";
                    int price = sysbgl.getPrice();
                    int ztid = sysbgl.getZtid();
                    String ztstr="未使用";
                    if (ztid==1)
                        ztstr = "正在使用";
                    if (ztid==2)
                        ztstr = "待审核";
                    if (ztid==3)
                        ztstr = "维修中";
                    String sfbxstr = "未报修";
                    int sfbx = sysbgl.getSfbx();
                    if (sfbx==1)
                        sfbxstr="已报修";
                    String info = sysbgl.getInfo();
                    String img = sysbgl.getImg();
                    Map map = new HashMap();
                    map.put("id", id);
                    map.put("sbname", sbnamestr);
                    map.put("bh", bhstr);
                    map.put("sysid", sysidstr);
                    map.put("cgsj", cgsj);
                    map.put("price", price);
                    map.put("ztid", ztstr);
                    map.put("sfbx", sfbxstr);
                    map.put("info", info);
                    map.put("img", img);
                    list.add(map);
                }
            }
            Map<String, Object> map1 = new HashMap<>();
            map1.put("code", 0);
            map1.put("msg", "ok");
            map1.put("count", list.size());
            map1.put("data", list);
            setLog.setlod(httpServletRequest, "查询了设备信息数据",logService);
            JSONObject json = new JSONObject(map1);
            return json;
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了设备信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectxsxxgl")
    public JSONObject selectxsxxgl(@RequestParam(required = false)String sname,@RequestParam(required = false) String idcard, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (sname!=null&&!sname.equals(""))
            requestparamMap.put("sname","%"+sname+"%");
        if (idcard!=null&&!idcard.equals(""))
            requestparamMap.put("idcard","%"+idcard+"%");
        List<Student> students = studentService.getStudentList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (students != null) {
            for (Student student : students) {
                int id = student.getId();
                String snamestr = student.getSname();
                String sex = student.getSex();
                Date date = student.getBirth();
                String birth = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日";
                int zyid = student.getZid();
                int cid = student.getCid();
                String cstr = classesService.getClassesById(cid).getBname();
                String zystr = zyglService.getZyglById(zyid).getZname();
                String tel = String.valueOf(student.getTel());
                String jl = student.getJl();
                String idcardstr = String.valueOf(student.getIdcard());
                Map map = new HashMap();
                map.put("id", id);
                map.put("sname", snamestr);
                map.put("sex", sex);
                map.put("birth", birth);
                map.put("zystr", zystr);
                map.put("cstr", cstr);
                map.put("tel", tel);
                map.put("jl", jl);
                map.put("idcard", idcardstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了学生信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectzyxxgl")
    public JSONObject selectzyxxgl(@RequestParam(required = false)String zname, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (zname!=null&&!zname.equals(""))
            requestparamMap.put("zname","%"+zname+"%");
        List<Zygl> zygls = zyglService.getZyglList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (zygls != null) {
            for (Zygl zygl : zygls) {
                int id = zygl.getId();
                String znamestr = zygl.getZname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("zname", znamestr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了专业信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsylxgl")//实验室类型管理
    public JSONObject selectsylxgl(@RequestParam(required = false)String lx, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (lx!=null&&!lx.equals(""))
            requestparamMap.put("lx","%"+lx+"%");
        List<Syslx> syslxes = syslxService.getSyslxList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (syslxes != null) {
            for (Syslx syslx : syslxes) {
                int id = syslx.getId();
                String lxstr = syslx.getLx();
                Map map = new HashMap();
                map.put("id", id);
                map.put("lx", lxstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室类型信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectyhzhgl")//用户组管理
    public JSONObject selectyhzhgl(@RequestParam(required = false)String username,HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (username!=null&&!username.equals(""))
            requestparamMap.put("username","%"+username+"%");
        List<Users> userss = usersService.getuserList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (userss != null) {
            for (Users users : userss) {
                int id = users.getId();
                String usernamestr = users.getUsername();
                int gid = users.getGroupid();
                String groupstr = groupinfoService.selectByPrimaryKey(gid).getGroupname();
                Date date = users.getRegtime();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String regtime = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Map map = new HashMap();
                map.put("id", id);
                map.put("username", usernamestr);
                map.put("groupstr", groupstr);
                map.put("regtime", regtime);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了用户信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectbjxxgl")//班级信息管理
    public JSONObject selectbjxxgl(@RequestParam(required = false)String bname,HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (bname!=null&&!bname.equals(""))
            requestparamMap.put("bname","%"+bname+"%");
        List<Classes> classess = classesService.getClassesList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (classess != null) {
            for (Classes classes : classess) {
                int id = classes.getId();
                String bnamestr = classes.getBname();
                int tid = classes.getTid();
                String tidstr = teacherService.getTeacherById(tid).getTname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("bname", bnamestr);
                map.put("tid", tidstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了班级信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectxxtggl")
    public JSONObject selectxxtggl(HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        List<Xxtg> xxtgs = xxtgService.getXxtgList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (xxtgs != null) {
            for (Xxtg xxtg : xxtgs) {
                int id = xxtg.getId();
                String fbrstr = usersService.selectByPrimaryKey(xxtg.getFbrid()).getUsername();
                String info = xxtg.getInfo();
                Date date = xxtg.getFbtime();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String fbtime = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Map map = new HashMap();
                map.put("id", id);
                map.put("fbrid", fbrstr);
                map.put("info", info);
                map.put("fbtime", fbtime);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了信息通告数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsyssysp")
    public JSONObject selectsyssysp(HttpServletRequest httpServletRequest) {
        List<Sysgl> sysgls = sysglService.getSysglBySfyy(2);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                int id = sysgl.getId();
                String sysname = sysgl.getSysname();
                String bh = sysgl.getBh();
                String fzrid = sysgl.getFzrid();
                String lc = sysgl.getLc();
                int lxid = sysgl.getLxid();
                int yyrid = sysgl.getYyrid();
                String lx = syslxService.getSyslxById(lxid).getLx();
                String yyr = usersService.selectByPrimaryKey(yyrid).getUsername();

                Map map = new HashMap();
                map.put("id", id);
                map.put("sysname", sysname);
                map.put("bh", bh);
                map.put("fzrid", fzrid);
                map.put("lc", lc);
                map.put("lx", lx);
                map.put("yyr", yyr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "打开了实验室使用审批",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsbsysp")
    public JSONObject selectsbsysp(HttpServletRequest httpServletRequest) {
        List<Jydj> jydjs = jydjService.getJydjByZtid(2);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jydjs != null) {
            for (Jydj jydj : jydjs) {
                int id = jydj.getId();
                String info = jydj.getInfo();
                Date date = jydj.getJysj();
                int sbid = jydj.getSbid();
                int uid = jydj.getUid();
                String sbstr = sysbglService.getSysbglById(sbid).getSbname();
                String ustr = usersService.selectByPrimaryKey(uid).getUsername();
                String sbbh = sysbglService.getSysbglById(sbid).getBh();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String fbtime = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Map map = new HashMap();
                map.put("id", id);
                map.put("info", info);
                map.put("sbid", sbstr);
                map.put("uid", ustr);
                map.put("sbbh", sbbh);
                map.put("jysj", fbtime);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "打开了设备使用审批",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsysjbxxgl")
    public JSONObject selectsysjbxxgl(@RequestParam(required = false)String sysname,@RequestParam(required = false)String bh,HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (sysname!=null&&!sysname.equals(""))
            requestparamMap.put("sysname","%"+sysname+"%");
        if (bh!=null&&!bh.equals(""))
            requestparamMap.put("bh","%"+bh+"%");
        List<Sysgl> sysgls = sysglService.getSysglList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                String yyridstr = "未预约";
                int id = sysgl.getId();
                String sysnamestr = sysgl.getSysname();
                if (sysgl.getYyrid()!=null&&!sysgl.getYyrid().equals("")) {
                    int yyrid = sysgl.getYyrid();
                  //  yyridstr = usersService.selectByPrimaryKey(yyrid).getUsername();
                    yyridstr = usersService.selectByPrimaryKey(yyrid).getUsername();
                    System.out.println(yyridstr);
                }
                int lxid = sysgl.getLxid();
                String lc = sysgl.getLc();
                String fzrid = sysgl.getFzrid();
                String bhstr = sysgl.getBh();
                int sfyy = sysgl.getSfyy();
                String lxidstr = syslxService.getSyslxById(lxid).getLx();
                String sfyystr = "未预约";
                if (sfyy==1){
                    sfyystr="已预约";
                }
                if (sfyy==2){
                    sfyystr="预约未审核";
                }
                Map map = new HashMap();
                map.put("id", id);
                map.put("yyrid", yyridstr);
                map.put("sysname", sysnamestr);
                map.put("lc", lc);
                map.put("fzrid", fzrid);
                map.put("bh", bhstr);
                map.put("lxid", lxidstr);
                map.put("sfyy", sfyystr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室基本信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectjysysgl")
    public JSONObject selectjysysgl(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int tid = users.getId();
        List<Sysgl> sysgls = sysglService.getSysglByteacher(tid);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                String yyridstr = "未预约";
                int id = sysgl.getId();
                String sysnamestr = sysgl.getSysname();
                if (sysgl.getYyrid()!=null&&!sysgl.getYyrid().equals("")) {
                    int yyrid = sysgl.getYyrid();
                    yyridstr = usersService.selectByPrimaryKey(yyrid).getUsername();
                }
                int lxid = sysgl.getLxid();
                String lc = sysgl.getLc();
                String fzrid = sysgl.getFzrid();
                String bhstr = sysgl.getBh();
                int sfyy = sysgl.getSfyy();
                String lxidstr = syslxService.getSyslxById(lxid).getLx();
                String sfyystr = "未预约";
                if (sfyy==1){
                    sfyystr="已预约";
                }
                if (sfyy==2){
                    sfyystr="预约未审核";
                }
                Map map = new HashMap();
                map.put("id", id);
                map.put("yyrid", yyridstr);
                map.put("sysname", sysnamestr);
                map.put("lc", lc);
                map.put("fzrid", fzrid);
                map.put("bh", bhstr);
                map.put("lxid", lxidstr);
                map.put("sfyy", sfyystr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室基本信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsykcgl")
    public JSONObject selectsykcgl(@RequestParam(required = false)String info,HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (info!=null&&!info.equals(""))
            requestparamMap.put("info","%"+info+"%");
        List<Syxxb> syxxbs = syxxbService.getSyxxbList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (syxxbs != null) {
            for (Syxxb syxxb : syxxbs) {
                int cid = syxxb.getCid();
                Date date = syxxb.getFbtime();
                int id = syxxb.getId();
                String infostr = syxxb.getInfo();
                int sfwc = syxxb.getSfwc();
                int sysid = syxxb.getSysid();
                String cidstr = classesService.getClassesById(cid).getBname();
                String sfwcstr = "未完成";
                if (sfwc==1){
                    sfwcstr="已完成";
                }
                String sysidstr = sysglService.getSysglById(sysid).getSysname();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String fbtime = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Map map = new HashMap();
                map.put("id", id);
                map.put("info", infostr);
                map.put("sysid", sysidstr);
                map.put("cid", cidstr);
                map.put("sfwc", sfwcstr);
                map.put("fbtime", fbtime);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验课程信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsykcll")
    public JSONObject selectsykcll(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        List<Map<String, Object>> list = new ArrayList<>();
        if (users.getGroupid()==3){
            Student student = studentService.getStudentByIdcard(Integer.parseInt(users.getUsername()));
            List<Syxxb> syxxbs = syxxbService.getSyxxbByCid(student.getCid());
            if (syxxbs != null) {
                for (Syxxb syxxb : syxxbs) {
                    Date date = syxxb.getFbtime();
                    int id = syxxb.getId();
                    String infostr = syxxb.getInfo();
                    int sysid = syxxb.getSysid();
                    String bh = sysglService.getSysglById(sysid).getBh();
                    String sysidstr = sysglService.getSysglById(sysid).getSysname();
                    String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                    String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                    String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                    String fbtime = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                    Map map = new HashMap();
                    map.put("id", id);
                    map.put("info", infostr);
                    map.put("bh", bh);
                    map.put("sysid", sysidstr);
                    map.put("fbtime", fbtime);
                    list.add(map);
                }
            }
            Map<String, Object> map1 = new HashMap<>();
            map1.put("code", 0);
            map1.put("msg", "ok");
            map1.put("count", list.size());
            map1.put("data", list);
            setLog.setlod(httpServletRequest, "查询了实验课程信息数据",logService);
            JSONObject json = new JSONObject(map1);
            return json;
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验课程信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectjysbgl")
    public JSONObject selectjysbgl(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int tid = users.getId();
        List<Jydj> jydjs = jydjService.getJydjByUid(tid);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jydjs != null) {
            for (Jydj jydj : jydjs) {
                int id = jydj.getId();
                int sbid = jydj.getSbid();
                Date date = jydj.getJysj();
                String info = jydj.getInfo();
                Date date1 = jydj.getGhsj();
                int ztid = jydj.getZtid();
                Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
                String sbname = sysbgl.getSbname();
                String bh = sysbgl.getBh();
                String ghsj = "未归还";
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String jysj = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                if (date1!=null) {
                    String hour2 = date1.getHours() > 9 ? String.valueOf(date1.getHours()) : 0 + String.valueOf(date1.getHours());
                    String minute2 = date1.getMinutes() > 9 ? String.valueOf(date1.getMinutes()) : 0 + String.valueOf(date1.getMinutes());
                    String second2 = date1.getSeconds() > 9 ? String.valueOf(date1.getSeconds()) : 0 + String.valueOf(date1.getSeconds());
                    ghsj = String.valueOf(date1.getYear() + 1900) + "年" + String.valueOf(date1.getMonth() + 1) + "月" + String.valueOf(date1.getDate()) + "日--" + hour + ":" + minute + ":" + second;
                }
                if(ztid==2)
                    ghsj="管理员审核中";
                if(ztid==3)
                    ghsj="借用被拒绝";
                Map map = new HashMap();
                map.put("id", id);
                map.put("sbname", sbname);
                map.put("bh", bh);
                map.put("jysj", jysj);
                map.put("ghsj", ghsj);
                map.put("info", info);
                map.put("ztid", ztid);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了借用设备记录数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsbshdj")
    public JSONObject selectsbshdj(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int uid = users.getId();
        List<Sbshdj> sbshdjs = sbshdjService.getSbshdjByUid(uid);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sbshdjs != null) {
            for (Sbshdj sbshdj : sbshdjs) {
                int id = sbshdj.getId();
                int sbid = sbshdj.getSbid();
                String info = sbshdj.getInfo();
                int ztid = sbshdj.getZtid();
                String ztidstr = "未损坏";
                if (ztid==1){
                    ztidstr="已损坏";
                }
                Date date = sbshdj.getShsj();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String shsj = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
                String sbname = sysbgl.getSbname();
                String bh = sysbgl.getBh();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sbname", sbname);
                map.put("bh", bh);
                map.put("shsj", shsj);
                map.put("info", info);
                map.put("ztid", ztidstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了设备损坏记录数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsbwxdj")
    public JSONObject selectsbwxdj(@RequestParam(required = false) String info, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (info!=null&&!info.equals(""))
            requestparamMap.put("info","%"+info+"%");
        List<Sbwxdj> sbwxdjs = sbwxdjService.getSbwxdjList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sbwxdjs != null) {
            for (Sbwxdj sbwxdj : sbwxdjs) {
                int id = sbwxdj.getId();
                int sbid = sbwxdj.getSbid();
                String infostr = sbwxdj.getInfo();
                int ztid = sbwxdj.getZtid();
                String wxr = sbwxdj.getWxr();
                int money = sbwxdj.getMoney();
                String ztidstr = "未维修";
                if (ztid==1){
                    ztidstr="已维修";
                }
                if (ztid==2){
                    ztidstr="无法维修";
                }
                Date date = sbwxdj.getWssj();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String wxsj = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
                String sbname = sysbgl.getSbname();
                String bh = sysbgl.getBh();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sbname", sbname);
                map.put("bh", bh);
                map.put("wxsj", wxsj);
                map.put("info", infostr);
                map.put("ztid", ztidstr);
                map.put("wxr", wxr);
                map.put("money", money);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了设备维修记录数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }
    @RequestMapping("/selectxxtgll")
    public JSONObject selectxxtgll(@RequestParam(required = false) String info, HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        if (info!=null&&!info.equals(""))
            requestparamMap.put("info","%"+info+"%");
        List<Xxtg> xxtgs = xxtgService.getXxtgList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (xxtgs != null) {
            for (Xxtg xxtg : xxtgs) {
                int id = xxtg.getId();
                int fbrid = xxtg.getFbrid();
                String infostr = xxtg.getInfo();
                Date date = xxtg.getFbtime();
                String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                String fbsj = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                Users users = usersService.selectByPrimaryKey(fbrid);
                String username = users.getUsername();
                Map map = new HashMap();
                map.put("id", id);
                map.put("fbrid", username);
                map.put("info", infostr);
                map.put("fbtime", fbsj);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查看了信息通告",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectyhzqxgl")
    public JSONObject selectyhzqxgl(HttpServletRequest httpServletRequest) {
        List<Groupinfo> groupinfos = groupinfoService.getgroupinfoList();
        List<Map<String, Object>> list = new ArrayList<>();
        if (groupinfos != null) {
            for (Groupinfo groupinfo : groupinfos) {
                int id = groupinfo.getId();
                String qx = groupinfo.getQx();
                String groupname = groupinfo.getGroupname();
                String qxs[] ={};
                Map map = new HashMap();
                map.put("id", id+"_a");
                map.put("field", id+"_a");
                map.put("title", groupname);
                if (qx!=null)
                    qxs = qx.split(",");
                Map child = selectfcd(httpServletRequest);
                List childdatas = (List) child.get("data");
                List childsmap = new ArrayList();
                for (int i = 0 ;i<childdatas.size();i++){
                    boolean sfxz = false;
                    Map childmap = (Map)childdatas.get(i);
                    int childid = Integer.parseInt(String.valueOf(childmap.get("id")));
                    String aaaa= Arrays.toString(qxs);
                    if (aaaa.length()>2&&qxs!=null) {
                        for (String qxbsstr : qxs) {
                            if (Integer.parseInt(qxbsstr) == childid) {
                                sfxz = true;
                                break;
                            }
                        }
                    }
                    String childmenuname = String.valueOf(childmap.get("menuname"));
                    childmap.put("id",childid+"_b_"+id);
                    childmap.put("title",childmenuname);
                    childmap.put("checked",sfxz);
                    childmap.put("field",childid+"_b_"+id);
                    childsmap.add(childmap);
                }
                map.put("children",childsmap);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了全部权限节点数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }
    @RequestMapping("/selectfcd")
    public Map<String, Object> selectfcd(HttpServletRequest httpServletRequest) {
        List<Menu> menus = menuService.getfdmmenuList();
        List<Map<String, Object>> list = new ArrayList<>();
        if (menus != null) {
            for (Menu menu : menus) {
                int id = menu.getId();
                String menuname = menu.getMenuname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("menuname", menuname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了父菜单信息数据",logService);
        return map1;
    }

    @RequestMapping("/selectfcd2")
    public JSONObject selectfcd2(HttpServletRequest httpServletRequest) {
        List<Menu> menus = menuService.getfdmmenuList();
        List<Map<String, Object>> list = new ArrayList<>();
        if (menus != null) {
            for (Menu menu : menus) {
                int id = menu.getId();
                String menuname = menu.getMenuname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("menuname", menuname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了父菜单信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectzy")
    public JSONObject selectzy(HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        List<Zygl> zygls = zyglService.getZyglList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (zygls != null) {
            for (Zygl zygl : zygls) {
                int id = zygl.getId();
                String zname = zygl.getZname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("zname", zname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了专业信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectbj")
    public JSONObject selectbj(HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        List<Classes> classess = classesService.getClassesList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (classess != null) {
            for (Classes classes : classess) {
                int id = classes.getId();
                String bname = classes.getBname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("bname", bname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了班级信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectjs")
    public JSONObject selectjs(HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        List<Teacher> teachers = teacherService.getTeacherList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                int id = teacher.getId();
                String tname = teacher.getTname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("tname", tname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了教师信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectkysb")
    public JSONObject selectkysb(HttpServletRequest httpServletRequest) {
        List<Sysbgl> sysbgls = sysbglService.getSysbglByky();
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysbgls != null) {
            for (Sysbgl sysbgl : sysbgls) {
                int id = sysbgl.getId();
                String bh = sysbgl.getBh();
                String sbname = sysbgl.getSbname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("bh", bh);
                map.put("sbname", sbname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了可用实验设备列表",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsys")
    public JSONObject selectsys(HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        List<Sysgl> sysgls = sysglService.getSysglList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                int id = sysgl.getId();
                String sysname = sysgl.getSysname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sysname", sysname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }
    @RequestMapping("/selectkysys")
    public JSONObject selectkysys(HttpServletRequest httpServletRequest) {
        List<Sysgl> sysgls = sysglService.getSysglBySfyy(0);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                int id = sysgl.getId();
                String sysname = sysgl.getSysname();
                String bh = sysgl.getBh();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sysname", sysname);
                map.put("bh", bh);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectgrxxwh")
    public JSONObject selectgrxxwh(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        String username = users.getUsername();
        int groupid = users.getGroupid();
        List<Map<String, Object>> list = new ArrayList<>();
        if (groupid==2) {
            Teacher teacher = teacherService.getTeacherByIdcard(Integer.parseInt(username));
        }
        if (groupid==3){
            Student student = studentService.getStudentByIdcard(Integer.parseInt(username));
            if (student!=null){
                int id = student.getId();
                int idcard = student.getIdcard();
                Date date = student.getBirth();
                String birth = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日";
                int cid = student.getCid();
                String cidstr = classesService.getClassesById(cid).getBname();
                String jl = student.getJl();
                String sex = student.getSex();
                String sname = student.getSname();
                String tel = student.getTel();
                int zid = student.getZid();
                String zidstr = zyglService.getZyglById(zid).getZname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("idcard",idcard);
                map.put("birth",birth);
                map.put("cid",cidstr);
                map.put("jl",jl);
                map.put("sex",sex);
                map.put("sname",sname);
                map.put("tel",tel);
                map.put("zid",zidstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了个人信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selecttgkysys")
    public JSONObject selecttgkysys(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int tid = users.getId();
        List<Sysgl> sysgls = sysglService.getSysglByKysys(tid);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                int id = sysgl.getId();
                String sysname = sysgl.getSysname();
                String bh = sysgl.getBh();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sysname", sysname);
                map.put("bh", bh);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selecthavesys")
    public JSONObject selecthavesys(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int tid = users.getId();
        List<Sysgl> sysgls = sysglService.getSysglByteacher(tid);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysgls != null) {
            for (Sysgl sysgl : sysgls) {
                int id = sysgl.getId();
                String sysname = sysgl.getSysname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("sysname", sysname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了教师"+users.getUsername()+"预约成功实验室数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectsyslx")
    public JSONObject selectsyslx(HttpServletRequest httpServletRequest) {
        Map requestparamMap = new HashMap();
        List<Syslx> syslxs = syslxService.getSyslxList(requestparamMap);
        List<Map<String, Object>> list = new ArrayList<>();
        if (syslxs != null) {
            for (Syslx syslx : syslxs) {
                int id = syslx.getId();
                String lx = syslx.getLx();
                Map map = new HashMap();
                map.put("id", id);
                map.put("lx", lx);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了实验室类型数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectyhz")
    public JSONObject selectyhz(HttpServletRequest httpServletRequest) {
        List<Groupinfo> groupinfos = groupinfoService.getgroupinfoList();
        List<Map<String, Object>> list = new ArrayList<>();
        if (groupinfos != null) {
            for (Groupinfo groupinfo : groupinfos) {
                int id = groupinfo.getId();
                String gstr = groupinfo.getGroupname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("gstr", gstr);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了用户组信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }


    @RequestMapping("/selectjslast")
    public JSONObject selectjslast(HttpServletRequest httpServletRequest) {
        Teacher teacher = teacherService.getteacherlast();
        List<Map<String, Object>> list = new ArrayList<>();
                int idcard = teacher.getIdcard();
                Map map = new HashMap();
                map.put("idcard", idcard+1);
                list.add(map);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了最后一条教师数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectxslast")
    public JSONObject selectxslast(HttpServletRequest httpServletRequest) {
        Student student = studentService.getStudentBylast();
        List<Map<String, Object>> list = new ArrayList<>();
        int idcard = student.getIdcard();
        Map map = new HashMap();
        map.put("idcard", idcard+1);
        list.add(map);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了最后一条学生数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectyhzxxgl")
    public JSONObject selectyhzxxgl(@RequestParam(required = false) String name, HttpServletRequest httpServletRequest) {
        List<Groupinfo> groupinfos = groupinfoService.getgroupinfoList();
        List<Map<String, Object>> list = new ArrayList<>();
        if (groupinfos != null) {
            for (Groupinfo groupinfo : groupinfos) {
                int id = groupinfo.getId();
                String qx = groupinfo.getQx();
                String groupname = groupinfo.getGroupname();
                Map map = new HashMap();
                map.put("id", id);
                map.put("qx", qx);
                map.put("groupname", groupname);
                list.add(map);
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", list.size());
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了全部用户组信息数据",logService);
        JSONObject json = new JSONObject(map1);
        return json;
    }

    @RequestMapping("/selectxtrzgl")
    public Map<String, Object> selectxtrzgl(HttpServletRequest httpServletRequest, @RequestParam(value = "page") int page,@RequestParam(value = "limit") int limit) {
        page = page-1;
        int start = page*limit;
        int end = (page+1)*limit-1;
        List<Log> logs = logService.getlogList();
        int datacount = logs.size();
        int i = 0;
        List<Map<String, Object>> list = new ArrayList<>();
        if (logs != null) {
            for (Log log : logs) {
                if (i>=start&&i<=end){
                    int id = log.getId();
                    String cz = log.getCz();
                    int czr = log.getCzr();
                    Date date = log.getTime();
                    String hour = date.getHours()>9?String.valueOf(date.getHours()):0+String.valueOf(date.getHours());
                    String minute = date.getMinutes()>9?String.valueOf(date.getMinutes()):0+String.valueOf(date.getMinutes());
                    String second = date.getSeconds()>9?String.valueOf(date.getSeconds()):0+String.valueOf(date.getSeconds());
                    String timestr = String.valueOf(date.getYear()+1900)+"年"+String.valueOf(date.getMonth()+1)+"月"+String.valueOf(date.getDate())+"日--"+hour+":"+minute+":"+second;
                    String czrstr=usersService.selectByPrimaryKey(czr).getUsername();
                    Map map = new HashMap();
                    map.put("id", id);
                    map.put("cz", cz);
                    map.put("czr", czrstr);
                    map.put("time", timestr);
                    list.add(map);
                }
                i++;
            }
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("msg", "ok");
        map1.put("count", datacount);
        map1.put("data", list);
        setLog.setlod(httpServletRequest, "查询了全部系统日志信息数据",logService);
        return map1;
    }

}