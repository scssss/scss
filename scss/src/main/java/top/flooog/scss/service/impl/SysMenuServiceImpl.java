package top.flooog.scss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.flooog.scss.dao.SysMenuMapper;
import top.flooog.scss.entity.SysMenu;
import top.flooog.scss.service.SysMenuService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysMenuService")
public class SysMenuServiceImpl  implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenu;

    @Override
    public List<SysMenu> findMenu(Integer role) {
        List<SysMenu> menulist = sysMenu.findAllmenu(role);
        List<SysMenu> menu = new ArrayList<>(10);
        int[] menuid = new int[10];
        int i = 0;
        //遍历所有的根节点节点
        for ( SysMenu list: menulist){
            if (list.getParentId() == 0){
                menu.add(list);
                menuid[i] = list.getMenuId();
                i++;
            }
        }
        ArrayList[] arrayLists = new ArrayList[4];
        //把二级加在一级列表上
        for (int k = 0;k < menuid.length ;k++){
            if (menuid[k] != 0){
                arrayLists[k] = new ArrayList<SysMenu>();
                for ( SysMenu list: menulist){
                 if (menuid[k] == list.getParentId()){
                     arrayLists[k].add(list);
                }
                }
            menu.get(k).setChildren(arrayLists[k]);
            }
        }
        return menu;
    }

    @Override
    public List<SysMenu> findByUser(String userName) {
        return sysMenu.findByUser(userName);
    }
}
