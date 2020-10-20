package top.flooog.scss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.flooog.scss.core.MybaitsPageHelper;
import top.flooog.scss.core.PageRequest;
import top.flooog.scss.core.PageResult;
import top.flooog.scss.dao.CourseMapper;
import top.flooog.scss.dao.SelectCourseMapper;
import top.flooog.scss.entity.SelectCourse;
import top.flooog.scss.service.StuService;

@Service("stuService")
public class StuServiceImpl implements StuService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SelectCourseMapper selectCourseMapper;
    /**
     * 查找所有可选课程
     * @return
     */
    @Override
    public PageResult findCourse(PageRequest pageRequest) {
        return MybaitsPageHelper.findPage(pageRequest,courseMapper,"findAllCourse");
    }

    /**
     * 学生选课
     * @param selectCourse
     * @return
     */
    @Override
    public boolean selectCourse(SelectCourse selectCourse) {
        int i = selectCourseMapper.selectCourse(selectCourse);
        if (i > 0){
            return true;
        }
        return false;
    }

    /**
     * 查询已选课程
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult findHasCourse(PageRequest pageRequest) {
        return MybaitsPageHelper.findPage(pageRequest,selectCourseMapper,"findMyCourse");
    }
}