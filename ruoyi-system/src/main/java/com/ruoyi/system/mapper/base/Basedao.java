package com.ruoyi.system.mapper.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Basedao<T> {

    /**
     * 查询列表
     */
    List<T> list(T param);

    /**
     * 获取详情
     */
    T getDetail(@Param("id") Long id);

    /**
     * 新增
     */
    int insert(T param);

    /**
     * 修改
     */
    int updateById(T param);

    /**
     * 删除
     */
    int deleteById(@Param("id") Long id);

}
