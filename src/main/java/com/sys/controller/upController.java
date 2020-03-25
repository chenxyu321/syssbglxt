package com.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.sys.model.*;
import com.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class upController {
    @Autowired
    private LogService logService;
    @Autowired
    private GroupinfoService groupinfoService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private ZyglService zyglService;
    @Autowired
    private SyslxService syslxService;
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
    @RequestMapping("/upyhzxxgl")
    public boolean upyhzxxgl(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue,
                             HttpServletRequest httpServletRequest) {
        Groupinfo groupinfo = groupinfoService.selectByPrimaryKey(id);
        if (groupinfo != null) {
            groupinfo.setGroupname(updateValue);
            if (groupinfoService.updateByPrimaryKeySelective(groupinfo) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "组信息的名称为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    //权限中心
    @RequestMapping("/upyhzqxgl")
    public boolean upyhzqxgl(@RequestParam(value = "id") String id,
                             @RequestParam(value = "checked") String checked,
                             HttpServletRequest httpServletRequest) {
        String ids[] = id.split("_");
        int fcdid=Integer.parseInt(ids[0]);
        int zid = Integer.parseInt(ids[2]);
        String info="增加";
        Groupinfo groupinfo = groupinfoService.selectByPrimaryKey(zid);
        if (groupinfo != null) {
            String qx = groupinfo.getQx();
            String qxs[] = {};
            if (qx!=null) {
                qxs = qx.split(",");
            }
            if (checked.equals("true"))
            //增加
            {  info="增加";
                String aaaa= Arrays.toString(qxs);
                if (aaaa.length()>2)
                    qx+=","+fcdid;
                else
                    qx+=fcdid;
            }
            if (checked.equals("false"))
            //减少
            {
                qx="";
                info="减少";
                int tem = 0;
                int i;
                for(i = 0; i<qxs.length; i++){
                    if(Integer.parseInt(qxs[i])==fcdid){
                        tem = i;
                    }
                }
                for (i = 0;i<qxs.length;i++)
                {
                    if (i==tem)
                        continue;
                    qx+=qxs[i]+",";
                }
                if (qx.length()>1)
                    qx = qx.substring(0, qx.length() -1);
            }
            groupinfo.setQx(qx);
            if (groupinfoService.updateByPrimaryKeySelective(groupinfo) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + zid + "用户组的权限," + info + "权限id" + fcdid,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upcdgl")
    public boolean upcdgl(@RequestParam(value = "id") int id,
                          @RequestParam(value = "field") String field,
                          @RequestParam(value = "updateValue") String updateValue,
                          HttpServletRequest httpServletRequest) {
        Menu menu = menuService.selectByPrimaryKey(id);
        if (menu != null) {
            if (field.equals("menuname"))
                menu.setMenuname(updateValue);
            if (field.equals("menulink"))
                menu.setMenulink(updateValue);
            if (menuService.updateByPrimaryKeySelective(menu) != 0) {
                setLog.setlod(httpServletRequest, "修改了" + id + "菜单的" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upjsxxgl")
    public boolean upjsxxgl(@RequestParam(value = "id") int id,
                          @RequestParam(value = "field") String field,
                          @RequestParam(value = "updateValue") String updateValue,
                          HttpServletRequest httpServletRequest) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            if (field.equals("tname"))
                teacher.setTname(updateValue);
            if (field.equals("sex"))
                teacher.setSex(updateValue);
            if (field.equals("zyzc"))
                teacher.setZyzc(updateValue);
            if (field.equals("tel"))
                teacher.setTel(updateValue);
            if (field.equals("jl"))
                teacher.setJl(updateValue);
            if (teacherService.upTeacher(teacher) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的教师" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upxsxxgl")
    public boolean upxsxxgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            if (field.equals("sname"))
                student.setSname(updateValue);
            if (field.equals("tel"))
                student.setTel(updateValue);
            if (field.equals("jl"))
                student.setJl(updateValue);
            if (studentService.upStudent(student) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的学生" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upbjxxgl")
    public boolean upbjxxgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest) {
        Classes classes = classesService.getClassesById(id);
        if (classes != null) {
            if (field.equals("bname"))
                classes.setBname(updateValue);
            if (classesService.upClasses(classes) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的班级" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upzyxxgl")
    public boolean upzyxxgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest) {
        Zygl zygl = zyglService.getZyglById(id);
        if (zygl != null) {
            if (field.equals("zname"))
                zygl.setZname(updateValue);
            if (zyglService.upZygl(zygl) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的专业" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upsylxgl")
    public boolean upsylxgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest) {
        Syslx syslx = syslxService.getSyslxById(id);
        if (syslx != null) {
            if (field.equals("lx"))
                syslx.setLx(updateValue);
            if (syslxService.upSyslx(syslx) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的实验室类型" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upsysbgl")
    public boolean upsysbgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest) {
        Sysbgl sysbgl = sysbglService.getSysbglById(id);
        if (sysbgl != null) {
            if (field.equals("sbname"))
                sysbgl.setSbname(updateValue);
            if (field.equals("bh"))
                sysbgl.setBh(updateValue);
            if (field.equals("info"))
                sysbgl.setInfo(updateValue);
            if (sysbglService.upSysbgl(sysbgl) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的实验设备" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upsysjbxxgl")
    public boolean upsysjbxxgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest) {
        Sysgl sysgl = sysglService.getSysglById(id);
        if (sysgl != null) {
            if (field.equals("sysname"))
                sysgl.setSysname(updateValue);
            if (field.equals("bh"))
                sysgl.setBh(updateValue);
            if (field.equals("lc"))
                sysgl.setLc(updateValue);
            if (sysglService.UpSysgl(sysgl) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的实验室" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/upgrxxwh")
    public boolean upgrxxwh(@RequestParam(value = "id") int id,
                               @RequestParam(value = "field") String field,
                               @RequestParam(value = "updateValue") String updateValue,
                               HttpServletRequest httpServletRequest) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            if (field.equals("tel"))
                student.setTel(updateValue);
            if (field.equals("jl"))
                student.setJl(updateValue);
            if (studentService.upStudent(student) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的学生" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/inituser")
    public boolean inituser(@RequestParam int id, HttpServletRequest httpServletRequest) {
        Users users = usersService.selectByPrimaryKey(id);
        if (users != null) {
            users.setUpassword(UtilPacket.Md5MD5String("123456"));
            if (usersService.updateByPrimaryKeySelective(users) != 0) {
                setLog.setlod(httpServletRequest, "重置了" + id + "用户的密码",logService);
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/syssyspty")
    public boolean syssyspty(HttpServletRequest httpServletRequest, @RequestParam int id){
        Sysgl sysgl = sysglService.getSysglById(id);
        if (sysgl!=null) {
            sysgl.setSfyy(1);
            if (sysglService.UpSysgl(sysgl)!=0) {
                setLog.setlod(httpServletRequest, "同意实验室名为" + sysgl.getSysname() + "的预约申请", logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/syssysptybty")
    public boolean syssysptybty(HttpServletRequest httpServletRequest, @RequestParam int id){
        Sysgl sysgl = sysglService.getSysglById(id);
        if (sysgl!=null) {
            sysgl.setSfyy(0);
            if (sysglService.UpSysgl(sysgl)!=0) {
                setLog.setlod(httpServletRequest, "拒绝实验室名为" + sysgl.getSysname() + "的预约申请", logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/sbsyspty")
    public boolean sbsyspty(HttpServletRequest httpServletRequest, @RequestParam int id){
        Jydj jydj  = jydjService.getJydjById(id);
        int sbid = jydj.getSbid();
        jydj.setZtid(1);
        Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
        if (sysbgl!=null) {
            sysbgl.setZtid(1);
            if (sysbglService.upSysbgl(sysbgl)!=0&&jydjService.upJydj(jydj)!=0) {
                setLog.setlod(httpServletRequest, "同意实验设备编号为" + sysbgl.getBh() + "的借用申请", logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/sbsyspbty")
    public boolean sbsysptybty(HttpServletRequest httpServletRequest, @RequestParam int id){
        Jydj jydj  = jydjService.getJydjById(id);
        int sbid = jydj.getSbid();
        jydj.setZtid(3);
        Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
        if (sysbgl!=null) {
            sysbgl.setZtid(0);
            if (sysbglService.upSysbgl(sysbgl)!=0&&jydjService.upJydj(jydj)!=0) {
                setLog.setlod(httpServletRequest, "拒绝实验设备编号为" + sysbgl.getBh() + "的借用申请", logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/sbwxdjwxwb")
    public boolean sbshdjwxwb(HttpServletRequest httpServletRequest, @RequestParam int id){
        Sbshdj sbshdj  = sbshdjService.getSbshdjById(id);
        int sbid = sbshdj.getSbid();
        sbshdj.setZtid(1);
        Sysbgl sysbgl = sysbglService.getSysbglById(sbid);
        if (sysbgl!=null) {
            sysbgl.setZtid(0);
            sysbgl.setSfbx(0);
            if (sysbglService.upSysbgl(sysbgl)!=0&&sbshdjService.upSbshdj(sbshdj)!=0) {
                setLog.setlod(httpServletRequest, "设备编号为" + sysbgl.getBh() + "的设备维修完毕", logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/ghsys")
    public boolean ghsys(HttpServletRequest httpServletRequest, @RequestParam int id){
        Sysgl sysgl  = sysglService.getSysglById(id);
        sysgl.setSfyy(0);
        sysgl.setYyrid(1);
            if (sysglService.UpSysgl(sysgl)!=0) {
                setLog.setlod(httpServletRequest, "归还编号为" + sysgl.getBh() + "的实验室", logService);
                return true;
            }
            return false;
    }

    @RequestMapping("/upsykcgl")
    public boolean upsykcgl(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue,
                            HttpServletRequest httpServletRequest){
        Syxxb syxxb  = syxxbService.getSyxxbById(id);
        if (syxxb != null) {
            if (field.equals("info"))
                syxxb.setInfo(updateValue);
            if (syxxbService.upSyxxb(syxxb) != 0) {
                setLog.setlod(httpServletRequest, "修改了id为" + id + "的实验课程" + field + "为" + updateValue,logService);
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/sykcglwc")
    public boolean sykcglwc(HttpServletRequest httpServletRequest, @RequestParam int id){
        Syxxb syxxb  = syxxbService.getSyxxbById(id);
        syxxb.setSfwc(1);
            if (syxxbService.upSyxxb(syxxb)!=0) {
                setLog.setlod(httpServletRequest, "实验id为" + syxxb.getId() + "的实验已完成", logService);
                return true;
            }
            return false;
    }

    @RequestMapping("/ghjysb")
    public boolean ghjysb(HttpServletRequest httpServletRequest, @RequestParam int id,@RequestParam String bh){
        Jydj jydj  = jydjService.getJydjById(id);
        Sysbgl sysbgl = sysbglService.getSysbglByBh(bh);
        jydj.setZtid(0);
        jydj.setGhsj(new Date(new Date().getTime()));
        sysbgl.setZtid(0);
        if (jydjService.upJydj(jydj)!=0&&sysbglService.upSysbgl(sysbgl)!=0) {
            setLog.setlod(httpServletRequest, "实验设备编号为" + bh + "的实验设备已归还", logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/layupload")
    public JSONObject upload(MultipartFile file, HttpServletRequest request) {
        try {
//            String path = request.getSession().getServletContext().getRealPath("/upload/");
//            String path = request.getServletContext().getRealPath("/uploadFile");
            String path = "D:/JAVA/upload";
            String image = UtilPacket.uploadImage(file, path);
            if (image != null) {
                Map map = new HashMap();
                map.put("filenamed",image);
                map.put("path",path);
                map.put("code",0);
                map.put("msg","ok");
                setLog.setlod(request, "上传了文件名为:" + image + "的图片，路径为:" + path + "，完整路径为:" + path+"/"+image,logService);
                JSONObject json = new JSONObject(map);
                return json;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
