package top.flooog.scss.service;

import top.flooog.scss.entity.SysMenu;

import java.util.List;

public interface SysMenuService {
    List<SysMenu> findMenu(Integer role);

    List<SysMenu> findByUser(String userName);
}
