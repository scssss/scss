package top.flooog.scss.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flooog.scss.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author liqing
 */
@Mapper
public interface SysUserMapper {
    // 插入数据
    int sysUserInsert(SysUser sysUser);
    // 删除数据
    int deletedUpdate(Integer sid);
    // 登录查看信息
    Map<String,Integer> login(Map<String,String> map);
    // 通过学号查询部分信息
    List<SysUser> stuFindAll(String sid);

    SysUser findByName(String userid);

    List<SysUser> findAll();
}
