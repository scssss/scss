package top.flooog.scss.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.flooog.scss.core.HttpResult;
import top.flooog.scss.core.PageRequest;
import top.flooog.scss.entity.SelectCourse;
import top.flooog.scss.service.StuService;
import top.flooog.scss.service.SysMenuService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询所有可选课程
     * @param pageRequest
     * @return
     */
    @PreAuthorize("hasAnyAuthority('sys:stu:find')")
    @GetMapping(value = "/findCourse")
    public HttpResult finCourse( PageRequest pageRequest){
        return HttpResult.ok(stuService.findCourse(pageRequest));
    }

    /**
     * 查询学生功能菜单
     * @return
     */
    @PreAuthorize("hasAnyAuthority('sys:stu:menu')")
    @GetMapping(value = "/menu")
    public HttpResult findmenu(){
        return HttpResult.ok(sysMenuService.findMenu(1));
    }

    /**
     * 学生选课
     */
    @PreAuthorize("hasAnyAuthority('sys:stu:selectcourse')")
    @PostMapping(value="/selectcourse")
    public HttpResult selectCourse(@RequestBody SelectCourse selectCourse){

            return HttpResult.ok(stuService.selectCourse(selectCourse));
    }

    /**
     * 查询已选课程
     */
    @PreAuthorize("hasAnyAuthority('sys:stu:hasselect')")
    @PostMapping(value = "/hasselect")
    public HttpResult hasselect(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(stuService.findHasCourse(pageRequest));
    }
    /**
     * 学生退选课程
     */
    @PreAuthorize("hasAnyAuthority('sys:stu:delcourse')")
    @PostMapping(value = "/delcourse")
    public HttpResult delcourse(@RequestBody Map<String,String> id){
        String id1 = id.get("id");
        return stuService.delCourse(id1);
    }
}
