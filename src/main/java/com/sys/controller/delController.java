package com.sys.controller;

import com.sys.model.Student;
import com.sys.model.Teacher;
import com.sys.model.Users;
import com.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class delController {
    @Autowired
    private LogService logService;
    @Autowired
    private GroupinfoService groupinfoService;
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
    @RequestMapping("/delyhzxxgl")//删除用户组信息
    public boolean delyhzxxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (groupinfoService.deleteByPrimaryKey(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的用户组信息",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delcdgl")//删除菜单信息
    public boolean delcdgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (menuService.deleteByPrimaryKey(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的菜单",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/deljsxxgl")
    public boolean deljsxxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacherService.delTeacher(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的教师",logService);
            Users users = usersService.getusersByusername(String.valueOf(teacher.getIdcard()));
            if (usersService.deleteByPrimaryKey(users.getId())!=0)
                setLog.setlod(httpServletRequest, "删除了主键为"+id+"的教师账号",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delxsxxgl")
    public boolean delxsxxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        Student student = studentService.getStudentById(id);
        if (teacherService.delTeacher(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的学生",logService);
            Users users = usersService.getusersByusername(String.valueOf(student.getIdcard()));
            if (studentService.delStudent(users.getId())!=0)
                setLog.setlod(httpServletRequest, "删除了主键为"+id+"的学生账号",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delyhzhgl")
    public boolean delyhzhgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (usersService.deleteByPrimaryKey(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的用户",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delbjxxgl")
    public boolean delbjxxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (classesService.delClasses(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的班级",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delzyxxgl")
    public boolean delzyxxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (zyglService.delZygl(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的专业",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delsylxgl")
    public boolean delsylxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (syslxService.delSyslx(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的实验室类型",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delxxtggl")
    public boolean delxxtggl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (xxtgService.delxxtg(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的信息通告",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delsysbgl")
    public boolean delsysbgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (sysbglService.delSysbgl(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的实验设备",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delsysjbxxgl")
    public boolean delsysjbxxgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (sysglService.delSysgl(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的实验室",logService);
            return true;
        }
        return false;
    }

    @RequestMapping("/delsykcgl")
    public boolean delsykcgl(HttpServletRequest httpServletRequest, @RequestParam int id){
        if (syxxbService.delSyxxb(id)!=0) {
            setLog.setlod(httpServletRequest, "删除了主键为"+id+"的实验课程",logService);
            return true;
        }
        return false;
    }
}
