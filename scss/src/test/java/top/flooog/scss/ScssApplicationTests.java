package top.flooog.scss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.flooog.scss.dao.SelectCourseMapper;
import top.flooog.scss.dao.SysUserMapper;
import top.flooog.scss.service.SysMenuService;

import javax.sql.DataSource;

@SpringBootTest
class ScssApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    private SysMenuService sysMenuServiceImpl;
    @Autowired
    SysUserMapper sysUserMapper ;
    @Autowired
    private SelectCourseMapper selectCourseMapper;
    @Test
    void contextLoads() {
        System.out.println(selectCourseMapper.delCourse("29"));
    }

}
