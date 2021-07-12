package com.ruoyi.system.service.base;

import com.ruoyi.common.core.domain.AjaxResult;
import org.apache.ibatis.annotations.Param;

public interface IBaseService<T> {

    /**
     * 列表
     */
    AjaxResult list(T param);

    /**
     * 获取详情
     */
    AjaxResult getDetail(@Param("id") Long id);

    /**
     * 新增
     */
    AjaxResult insert(T param);

    /**
     * 修改
     */
    AjaxResult updateById(T param);

    /**
     * 删除
     */
    AjaxResult deleteById(@Param("id") Long id);


}
