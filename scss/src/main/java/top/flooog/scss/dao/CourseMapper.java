package top.flooog.scss.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flooog.scss.entity.Course;

import java.util.List;

/**
 * @author liqing
 */
@Mapper
public interface CourseMapper {
    //增加课程
    int courseInsert(Course course);
    //查询所有课程
    List<Course>  findAllCourse();
    //通过课程号查询课程
    List<Course> findCourse(String cid);
}
