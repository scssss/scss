package top.flooog.scss.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.flooog.scss.dao.SysUserMapper;
import top.flooog.scss.entity.SysMenu;
import top.flooog.scss.entity.SysUser;
import top.flooog.scss.service.SysMenuService;
import top.flooog.scss.service.SysUserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysMenuService sysMenuServiceImpl;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> findAll() {

       return sysUserMapper.findAll();
    }

    @Override
    public SysUser findByName(String userid) {
        return sysUserMapper.findByName(userid);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuServiceImpl.findByUser(userName);
        for(SysMenu sysMenu:sysMenus) {
            if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
                System.out.println(sysMenu.getPerms());
            }
        }
        return perms;
    }
}
