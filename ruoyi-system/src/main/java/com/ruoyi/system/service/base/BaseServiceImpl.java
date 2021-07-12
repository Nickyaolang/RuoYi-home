package com.ruoyi.system.service.base;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.mapper.base.Basedao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther al
 * Date 2020/10/23 0023
 */
public class BaseServiceImpl<T, O extends Basedao<T>> implements IBaseService<T> {

    @Autowired
    protected O dao;

    @Override
    public AjaxResult list(T param) {
        return AjaxResult.success(dao.list(param));
    }

    @Override
    public AjaxResult getDetail(Long id) {
        if (id == null) {
            return AjaxResult.error("ID不能为空！");
        }
        return AjaxResult.success(dao.getDetail(id));
    }

    @Override
    public AjaxResult insert(T param) {
        if (dao.insert(param) > 0) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("新增失败！请联系管理员");
    }

    @Override
    public AjaxResult updateById(T param) {
        if (dao.updateById(param) > 0) {
            return AjaxResult.success("修改成功！");
        }
        return AjaxResult.error("修改失败！请联系管理员");
    }

    @Override
    public AjaxResult deleteById(Long id) {
        if (dao.deleteById(id) > 0) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("删除失败！请联系管理员");
    }
}
