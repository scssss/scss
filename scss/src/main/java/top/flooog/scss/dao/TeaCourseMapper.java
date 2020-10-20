package top.flooog.scss.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flooog.scss.entity.TeaCourse;

import java.util.List;

/**
 * @author 方立清
 */
@Mapper
public interface TeaCourseMapper {
    //插入教授课程
    int insertTeaCourse(TeaCourse teaCourse);
    //老师查询自己所教授的课程
    List<TeaCourse> findMyCourse(String tid);
    // 通过课程号查询课程
    List<TeaCourse> findCourse(String cid);
}
