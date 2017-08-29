package com.zhejiang.zhixin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhejiang.zhixin.entity.Student;
import com.zhejiang.zhixin.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @RestController:在spring4.0以上版本可以使用，可以响应普通的post和get请求，也可以响应ajax请求，不需要添加ResponseBody
 */
@RestController
public class StudentController {
    @Resource
    private StudentService s;
//#############################################返回跳转的页面#######################################

    /**
     * 添加学生
     *
     * @return
     */
    @RequestMapping("addStudent.do")
    public String addStudent() {
        Student stu = new Student();
        stu.setAge(22);
        stu.setStuname("小红");
        int i = s.addStudentS(stu);
        if (i > 0) {
            return "success";
        } else {
            return "error";
        }
    }
//#############################################返回跳转的页面#######################################
// #############################################返回JSON数据#######################################

    /**
     * 修改学生
     *
     * @return
     */
    @RequestMapping("updateStudent.do")
    public void updateStudent(HttpServletResponse response) {
        List list = s.queryStudentS();
        for (Object stu : list) {
            Student student = (Student) stu;
            student.setStuname("mzd");
            s.updateStudentS(student);
        }
        //返回修改后所有学生的集合
        List list1 = s.queryStudentS();
        try {
            response.getWriter().write(JSON.toJSONString(list1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    /**
     * 查询学生
     *
     * @return
     */
    @RequestMapping("queryStudent.do")
    public void queryStudent(HttpServletResponse response) {
        List list = s.queryStudentS();
        try {
            response.getWriter().write(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除学生
     *
     * @return
     */
    @RequestMapping("deleteStudent.do")
    public void deleteStudent(HttpServletResponse response) {
        String id = "402890f35df4a779015df4a79ce00000";
        int i = s.deleteStudentS(id);
        try {
            if (i > 0) {
                List list = s.queryStudentS();
                response.getWriter().write(JSON.toJSONString(list));
            } else {
                response.getWriter().write("删除学生失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// #############################################返回JSON数据#######################################
}
