package top.flooog.scss.service;

import top.flooog.scss.core.PageRequest;
import top.flooog.scss.core.PageResult;
import top.flooog.scss.entity.SelectCourse;

public interface StuService{
    //查询所有可选课程
    PageResult findCourse(PageRequest pageRequest);
    //学生选课
    String selectCourse(SelectCourse selectCourse);
    //查询学生已选课程
    PageResult findHasCourse(PageRequest pageRequest);
}