package top.flooog.scss;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.flooog.scss.dao.SysUserMapper;
import top.flooog.scss.entity.SysMenu;
import top.flooog.scss.entity.SysUser;
import top.flooog.scss.service.SysMenuService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ScssApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    private SysMenuService sysMenuServiceImpl;
    @Autowired
    SysUserMapper sysUserMapper ;
    @Test
    void contextLoads() {
        List<SysMenu> sysMenus = sysMenuServiceImpl.findByUser("170706038");
        for (SysMenu menu: sysMenus){
            System.out.println(menu.getPerms());
        }
    }

}
