package top.flooog.scss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.flooog.scss.core.HttpResult;
import top.flooog.scss.core.MybaitsPageHelper;
import top.flooog.scss.core.PageRequest;
import top.flooog.scss.core.PageResult;
import top.flooog.scss.dao.CourseMapper;
import top.flooog.scss.dao.SelectCourseMapper;
import top.flooog.scss.entity.SelectCourse;
import top.flooog.scss.service.StuService;

import java.util.List;

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
    public String selectCourse(SelectCourse selectCourse) {
        List<SelectCourse> list = selectCourseMapper.findMyCourse(selectCourse.getUserId());
        // 判断课程是否已经选择
        for (SelectCourse s: list) {
           if (selectCourse.getcId().equals(s.getcId())){
               return "课程已经选择";
           }
        }
        selectCourse.settName(selectCourseMapper.findTeaName(selectCourse.getcId()));
        int i = selectCourseMapper.selectCourse(selectCourse);
        if (i > 0){
            return "选课成功！";
        }
        return "选课失败！";
    }

    /**
     * 查询已选课程
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult findHasCourse(PageRequest pageRequest) {
        String sid = (String)pageRequest.getParam("sid");
        return MybaitsPageHelper.findPage(pageRequest,selectCourseMapper,"findMyCourse",sid);
    }
    /**
     *学生选课退选
     */
    @Override
    public HttpResult delCourse(String id) {
        int i = selectCourseMapper.delCourse(id);
        if(i == 0){
            return HttpResult.error(201,"课程退选失败！");
        }
        return HttpResult.error(200,"课程退选成功！");
    }


}