package com.zhejiang.zhixin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhejiang.zhixin.dao.StudentDao;
import com.zhejiang.zhixin.entity.Student;

import java.util.List;

@Service("s")
public class StudentService {
    @Resource
    private StudentDao studao;

    public int addStudentS(Student stu) {
        return studao.addStudentD(stu);
    }

    public List queryStudentS() {
        return studao.queryStudentD();
    }

    public int updateStudentS(Student student) {
        return studao.updateStudentD(student);
    }

    public int deleteStudentS(String id) {
        return studao.deleteStudentD(id);
    }
}
