package com.sys.controller;

import com.sys.model.*;
import com.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class insertController {
    @Autowired
    private GroupinfoService groupinfoService;
    @Autowired
    private LogService logService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private ZyglService zyglService;
    @Autowired
    private SyslxService syslxService;
    @Autowired
    private XxtgService xxtgService;
    @Autowired
    private SysbglService sysbglService;
    @Autowired
    private SysglService sysglService;
    @Autowired
    private SyxxbService syxxbService;
    @Autowired
    private JydjService jydjService;
    @Autowired
    private SbshdjService sbshdjService;
    @Autowired
    private SbwxdjService sbwxdjService;

    @RequestMapping("Insertyhzxxgl")
    public boolean Insertyhzxxgl(@RequestParam(value = "title") String title,
                                 HttpServletRequest httpServletRequest) {
        Groupinfo groupinfo = new Groupinfo();
        groupinfo.setGroupname(title);
        if (groupinfoService.insertSelective(groupinfo) != 0) {
            setLog.setlod(httpServletRequest, "添加名字为" + title + "的用户组", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertcdgl")
    public boolean Insertcdgl(@RequestParam(value = "menuname") String menuname,
                              @RequestParam(value = "menulink") String menulink,
                              @RequestParam(value = "fdm") String fdm,
                              HttpServletRequest httpServletRequest) {
        Menu menu = new Menu();
        if (menuname != "")
            menu.setMenulink(menulink);
        menu.setMenuname(menuname);
        if (fdm != "")
            menu.setFdm(fdm);
        if (menuService.insertSelective(menu) != 0) {
            setLog.setlod(httpServletRequest, "添加名字为" + menuname + "的菜单", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertjsxxgl")
    public boolean Insertjsxxgl(@RequestParam String tname,
                                @RequestParam String birth,
                                @RequestParam String zyzc,
                                @RequestParam String tel,
                                @RequestParam String jl,
                                @RequestParam String idcard,
                                @RequestParam String xb,
                                @RequestParam String zyid,
                                HttpServletRequest httpServletRequest) throws ParseException {
        if (teacherService.getTeacherByIdcard(Integer.parseInt(idcard)) != null)
            return false;
        Teacher teacher = new Teacher();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date birthtime = sdf.parse(birth);
        teacher.setTname(tname);
        teacher.setBirth(birthtime);
        teacher.setZyzc(zyzc);
        teacher.setTel(tel);
        teacher.setJl(jl);
        teacher.setIdcard(Integer.parseInt(idcard));
        teacher.setSex(xb);
        teacher.setZyid(Integer.parseInt(zyid));
        if (teacherService.insertTeacher(teacher) != 0) {
            Users users = new Users();
            users.setUsername(idcard);
            users.setGroupid(2);
            users.setRegtime(new Date(new Date().getTime()));
            users.setUpassword(UtilPacket.Md5MD5String("123456"));
            if (usersService.insertSelective(users) != 0)
                setLog.setlod(httpServletRequest, "成功为工号" + idcard + "创建账户", logService);
            setLog.setlod(httpServletRequest, "添加工号为" + idcard + "的教师", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertxsxxgl")
    public boolean Insertxsxxgl(@RequestParam String sname,
                                @RequestParam String birth,
                                @RequestParam String cid,
                                @RequestParam String tel,
                                @RequestParam String jl,
                                @RequestParam String idcard,
                                @RequestParam String xb,
                                @RequestParam String zyid,
                                HttpServletRequest httpServletRequest) throws ParseException {
        if(studentService.getStudentByIdcard(Integer.parseInt(idcard)) != null)
            return false;
        Student student = new Student();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date birthtime = sdf.parse(birth);
        student.setSname(sname);
        student.setBirth(birthtime);
        student.setCid(Integer.parseInt(cid));
        student.setTel(tel);
        student.setJl(jl);
        student.setIdcard(Integer.parseInt(idcard));
        student.setSex(xb);
        student.setZid(Integer.parseInt(zyid));
        if (studentService.insertStudent(student) != 0) {
            Users users = new Users();
            users.setUsername(idcard);
            users.setGroupid(3);
            users.setRegtime(new Date(new Date().getTime()));
            users.setUpassword(UtilPacket.Md5MD5String("123456"));
            if (usersService.insertSelective(users) != 0)
                setLog.setlod(httpServletRequest, "成功为学号" + idcard + "创建账户", logService);
            setLog.setlod(httpServletRequest, "添加学号为" + idcard + "的学生", logService);
            return true;
        } else
            return false;
    }

   /* @RequestMapping("Insertyhzhgl")
    public boolean Insertyhzhgl(@RequestParam String username,
                                @RequestParam String yhzid,
                                HttpServletRequest httpServletRequest) {
        if (usersService.getusersByusername(username) != null)
            return false;
        Users users = new Users();
        users.setUsername(username);
        users.setGroupid(Integer.parseInt(yhzid));
        users.setRegtime(new Date(new Date().getTime()));
        users.setUpassword(UtilPacket.Md5MD5String("123456"));
        if (usersService.insertSelective(users) != 0) {
            setLog.setlod(httpServletRequest, "成功创建账户为" + username + "的账号", logService);
            return true;
        } else
            return false;
    }
*/
    @RequestMapping("Insertbjxxgl")
    public boolean Insertbjxxgl(@RequestParam String bname,
                                @RequestParam String tid,
                                HttpServletRequest httpServletRequest) {
        Classes classes = new Classes();
        classes.setBname(bname);
        classes.setTid(Integer.parseInt(tid));

        if (classesService.insertClasses(classes) != 0) {
            setLog.setlod(httpServletRequest, "成功创建班级名为" + bname + "的班级", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertzyxxgl")
    public boolean Insertzyxxgl(@RequestParam String zname,
                                HttpServletRequest httpServletRequest) {
        Zygl zygl = new Zygl();
        zygl.setZname(zname);
        if (zyglService.insertZygl(zygl) != 0) {
            setLog.setlod(httpServletRequest, "成功创建专业名为" + zname + "的专业", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertsylxgl")
    public boolean Insertsylxgl(@RequestParam String lx,
                                HttpServletRequest httpServletRequest) {
        Syslx syslx = new Syslx();
        syslx.setLx(lx);
        if (syslxService.insertSyslx(syslx) != 0) {
            setLog.setlod(httpServletRequest, "成功创建实验室类型名为" + lx + "的类型", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("/Insertjysbgl")
    public boolean Insertjysbgl(HttpServletRequest httpServletRequest, @RequestParam int sbid,@RequestParam String info){
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int uid = users.getId();
        Jydj jydj  = new Jydj();
        jydj.setZtid(2);
        jydj.setInfo(info);
        jydj.setJysj(new Date(new Date().getTime()));
        jydj.setSbid(sbid);
        jydj.setUid(uid);
        Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
        sysbgl.setZtid(2);
        if (jydjService.insertJydj(jydj)!=0&&sysbglService.upSysbgl(sysbgl)!=0) {
            setLog.setlod(httpServletRequest, "提交设备编号为" + sysbgl.getBh() + "的实验设备借用请求", logService);
            return true;
        }
        return false;
    }

    @RequestMapping("Insertxxtggl")
    public boolean Insertxxtggl(@RequestParam String info,
                                HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        Users users = (Users) httpSession.getAttribute("islogin");
        int uid = users.getId();
        Xxtg xxtg = new Xxtg();
        xxtg.setInfo(info);
        xxtg.setFbrid(uid);
        xxtg.setFbtime(new Date(new Date().getTime()));
        if (xxtgService.insertxxtg(xxtg) != 0) {
            setLog.setlod(httpServletRequest, "成功创建通告", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertsbshdj")
    public boolean Insertsbshdj(@RequestParam int sbid,
                                @RequestParam String info,
                                HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        Users users = (Users) httpSession.getAttribute("islogin");
        Sbshdj sbshdj = new Sbshdj();
        sbshdj.setZtid(1);
        sbshdj.setInfo(info);
        sbshdj.setSbid(sbid);
        sbshdj.setShsj(new Date(new Date().getTime()));
        sbshdj.setUid(users.getId());
        Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
        sysbgl.setSfbx(1);
        sysbgl.setZtid(3);
        if (sysbglService.upSysbgl(sysbgl) != 0&&sbshdjService.InsertSbshdj(sbshdj)!=0) {
            setLog.setlod(httpServletRequest, "设备"+sysbgl.getSbname()+"---"+sysbgl.getBh()+"损坏", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertsysbgl")
    public boolean Insertsysbgl(@RequestParam String sbname,
                                @RequestParam String bh,
                                @RequestParam String cgsj,
                                @RequestParam String sysid,
                                @RequestParam String price,
                                @RequestParam String info,
                                @RequestParam String img,
                                HttpServletRequest httpServletRequest) throws ParseException {
        Sysbgl sysbgl = new Sysbgl();
        sysbgl.setSbname(sbname);
        sysbgl.setBh(bh);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date cgsjtime = sdf.parse(cgsj);
        sysbgl.setCgsj(cgsjtime);
        sysbgl.setSysid(Integer.parseInt(sysid));
        sysbgl.setPrice(Integer.parseInt(price));
        sysbgl.setInfo(info);
        sysbgl.setImg(img);
        sysbgl.setZtid(0);
        sysbgl.setSfbx(0);
        if (sysbglService.insertSysbgl(sysbgl) != 0) {
            setLog.setlod(httpServletRequest, "成功创建编号为" + bh + "的实验设备", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertsbwxdj")
    public boolean Insertsbwxdj(@RequestParam int sbid,
                                @RequestParam String info,
                                @RequestParam int ztid,
                                @RequestParam String wxr,
                                @RequestParam int money,
                                HttpServletRequest httpServletRequest) throws ParseException {
        Sbwxdj sbwxdj = new Sbwxdj();
        sbwxdj.setInfo(info);
        sbwxdj.setMoney(money);
        sbwxdj.setSbid(sbid);
        sbwxdj.setWssj(new Date(new Date().getTime()));
        sbwxdj.setWxr(wxr);
        sbwxdj.setZtid(ztid);
        Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
        sysbgl.setSfbx(1);
        if (sbwxdjService.insertSbwxdj(sbwxdj) != 0&&sysbglService.upSysbgl(sysbgl)!=0) {
            setLog.setlod(httpServletRequest, "设备"+sysbgl.getSbname()+"---"+sysbgl.getBh()+"维修", logService);
            return true;
        } else
            return false;
    }

    @RequestMapping("Insertjysysgl")
    public boolean Insertjysysgl(@RequestParam int sysid,
                                @RequestParam String img,
                                HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        Users users = (Users) session.getAttribute("islogin");
        int uid = users.getId();
        Sysgl sysgl = sysglService.getSysglById(sysid);
        sysgl.setYyrid(uid);
        sysgl.setSfyy(2);
        sysgl.setFzrid(img);
        if (sysglService.UpSysgl(sysgl) != 0) {
            setLog.setlod(httpServletRequest, "申请编号为"+sysgl.getBh()+"的实验室", logService);
            return true;
        } else
            return false;
    }


    @RequestMapping("Insertsysjbxxgl")
    public boolean Insertsysjbxxgl(@RequestParam String sysname,
                                   @RequestParam String bh,
                                   @RequestParam String lc,
                                   @RequestParam String lxid,
                                   HttpServletRequest httpServletRequest){
        if (sysglService.getSysglByBh(bh)==null){
        Sysgl sysgl = new Sysgl();
            sysgl.setLc(lc);
            sysgl.setBh(bh);
            sysgl.setSysname(sysname);
            sysgl.setSfyy(0);
            sysgl.setLxid(Integer.parseInt(lxid));
        if (sysglService.insertSysgl(sysgl) != 0) {
            setLog.setlod(httpServletRequest, "成功创建编号为" + bh + "的实验室", logService);
            return true;
        } else
            return false;
    }
        return false;
    }

    @RequestMapping("Insertsykcgl")
    public boolean Insertsykcgl(@RequestParam String info,
                                   @RequestParam String sysid,
                                   @RequestParam String cid,
                                   HttpServletRequest httpServletRequest){
            HttpSession session = httpServletRequest.getSession();
            Users users = (Users) session.getAttribute("islogin");
            int tid = users.getId();
            Syxxb syxxb = new Syxxb();
            syxxb.setSfwc(0);
            syxxb.setInfo(info);
            syxxb.setCid(Integer.parseInt(cid));
            syxxb.setFbtime(new Date(new Date().getTime()));
            syxxb.setSysid(Integer.parseInt(sysid));
            syxxb.setTid(tid);
            if (syxxbService.insertSyxxb(syxxb) != 0) {
                setLog.setlod(httpServletRequest, "成功创建实验课程", logService);
                return true;
            } else
                return false;
    }

}
