package top.flooog.scss.service;

import top.flooog.scss.entity.SysUser;

import java.util.List;
import java.util.Set;

public interface SysUserService{
/**
 * 查找所有 用户
 */
List<SysUser> findAll();

SysUser findByName(String userid);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);
}
