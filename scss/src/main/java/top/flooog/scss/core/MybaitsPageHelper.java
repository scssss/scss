package top.flooog.scss.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.flooog.scss.util.ReflectionUtil;

import java.util.List;

public class MybaitsPageHelper {

    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        //利用反射的方法进行查询
        Object result = ReflectionUtil.invoke(mapper, queryMethodName, args);
        if (result == null){
            System.out.println("result 为空");
            return  null;
        }
        return getPageResult(pageRequest, new PageInfo((List) result));
    }

    /**
     * 将分页信息封装在PageRequest中
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
