package com.zhejiang.zhixin.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zhejiang.zhixin.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {
    @Resource
    private SessionFactory sessionF;

    /**
     * 获取session
     *
     * @return
     */
    public Session getsession() {
        Session session;
        if (null == sessionF.getCurrentSession()) {
            session = sessionF.openSession();
        } else {
            session = sessionF.getCurrentSession();
        }
        return session;
    }

    /**
     * 添加学生
     *
     * @param stu
     * @return
     */
    public int addStudentD(Student stu) {
        Session session = getsession();
        try {
            session.save(stu);
            return 1;
        } catch (Exception e) {
            System.out.println("添加学生失败");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询学生
     *
     * @return
     */
    public List queryStudentD() {
        Session session = getsession();
        List list = new ArrayList();
        try {
            /**
             *idea中会对sql和hql报错，禁止对它的检查即可，因为sql和hql没错
             */
            //需要注意的是：使用hql的时候，from后面是对象而不是表名
//            String hql = "from  Student";
//            Query q = session.createQuery(hql);
            //使用普通的sql------addEntity()建议写上，不然有可能会报错
            Query q = session.createSQLQuery("select * from  idea_student").addEntity(Student.class);
            list = q.list();
        } catch (Exception e) {
            System.out.println("查询学生集合失败");
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 修改学生
     *
     * @param student
     * @return
     */
    public int updateStudentD(Student student) {
        Session session = getsession();
        try {
            session.update(student);
            return 1;
        } catch (Exception e) {
            System.out.println("修改学生失败");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    public int deleteStudentD(String id) {
        Session session = getsession();
        try {
            //hibernate不能直接通过id删除对象，需要先把对象加载进来，然后再删除
            Student student = session.get(Student.class, id);
            session.delete(student);
            return 1;
        } catch (Exception e) {
            System.out.println("删除学生失败");
            e.printStackTrace();
            return 0;
        }
    }
}
