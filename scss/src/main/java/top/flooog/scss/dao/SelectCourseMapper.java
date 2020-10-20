package top.flooog.scss.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flooog.scss.entity.SelectCourse;

import java.util.List;

@Mapper
public interface SelectCourseMapper {
    //插入选课
    int selectCourse(SelectCourse selectCourse);
    //根据学号查询选课
    List<SelectCourse> findMyCourse(String sid);
    //根据课程号查询选课
    List<SelectCourse> findMyTea(String cid);
}
