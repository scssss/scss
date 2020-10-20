package top.flooog.scss.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.flooog.scss.core.HttpResult;
import top.flooog.scss.core.PageRequest;
import top.flooog.scss.entity.SelectCourse;
import top.flooog.scss.service.StuService;
import top.flooog.scss.service.SysMenuService;

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;
    @Autowired
    private SysMenuService sysMenuService;

    @PreAuthorize("hasAnyAuthority('sys:stu:find')")
    @GetMapping(value = "/findCourse")
    public HttpResult finCourse( PageRequest pageRequest){
        return HttpResult.ok(stuService.findCourse(pageRequest));
    }

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
        if (stuService.selectCourse(selectCourse)){
            return HttpResult.ok("选课成功");
        }
        return HttpResult.error("选课失败");

    }

    /**
     * 查询已选课程
     */
    @PreAuthorize("hasAnyAuthority('sys:stu:hasselect')")
    @PostMapping(value = "/hasselect")
    public HttpResult hasselect(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(stuService.findHasCourse(pageRequest));
    }
}
