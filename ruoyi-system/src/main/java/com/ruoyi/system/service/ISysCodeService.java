/*
 * 文件名: ISysCodeService.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年07月02日 14时17分
 * 描述: 系统代码 - 服务层
 */
package com.ruoyi.system.service;

import com.ruoyi.common.enums.CodeTypeEnum;
import com.ruoyi.system.domain.common.KeyCode;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @Author: aolang
 * @Date: 2020/10/23 0023
 */
public interface ISysCodeService {

    /**
     * 根据类型分组查询代码列表
     *
     * @param enums 类型数组
     * @return <keys, list>
     */
    Map<String, List<KeyCode>> selectGroupCodeList(CodeTypeEnum... enums);

}
