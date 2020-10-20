package top.flooog.scss.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flooog.scss.entity.SysMenu;

import java.util.List;

@Mapper
public interface SysMenuMapper {

    //根据角色查出相应角色的菜单
    List<SysMenu> findAllmenu(Integer role);

    List<SysMenu> findByUser(String userName);
}
