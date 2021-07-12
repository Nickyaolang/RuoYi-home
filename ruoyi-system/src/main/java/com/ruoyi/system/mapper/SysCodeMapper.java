/*
 * 文件名: SysCodeDao.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年07月01日 15时32分
 * 描述: 系统代码 - 数据层
 */
package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysCodeList;

import java.util.List;

/**
 * description:
 *
 * @Author: aolang
 * @Date: 2020/10/23 0023
 */
public interface SysCodeMapper {


    /**
     * 查询代码列表
     *
     * @param typeList 类型组
     * @return 集合
     */
    List<SysCodeList> selectCodeList(List<Integer> typeList);

}
