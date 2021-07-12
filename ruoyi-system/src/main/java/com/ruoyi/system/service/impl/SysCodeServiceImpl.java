/*
 * 文件名: SysCodeServiceImpl.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年07月02日 14时24分
 * 描述: 系统代码 - 服务层实现类
 */
package com.ruoyi.system.service.impl;

import com.ruoyi.common.enums.CodeTypeEnum;
import com.ruoyi.system.domain.SysCodeList;
import com.ruoyi.system.domain.common.KeyCode;
import com.ruoyi.system.mapper.SysCodeMapper;
import com.ruoyi.system.service.ISysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @Author: aolang
 * @Date: 2020/10/23 0023
 */
@Service
public class SysCodeServiceImpl implements ISysCodeService {

    @Autowired
    private SysCodeMapper codeDao;


    @Override
    public Map<String, List<KeyCode>> selectGroupCodeList(CodeTypeEnum... enums) {
        List<Integer> typeList = extractCodeTypeList(enums);
        if (typeList.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, List<KeyCode>> result = new HashMap<>();

        List<SysCodeList> list = codeDao.selectCodeList(typeList);
        for (SysCodeList code : list) {
            String key = code.getTypeIdStr();
            List<KeyCode> value = result.computeIfAbsent(key, k -> new ArrayList<>());
            value.add(new KeyCode<>(code.getId(), code.getCodeLabel()));
        }
        return result;
    }

    /**
     * 提取代码类型列表
     */
    private List<Integer> extractCodeTypeList(CodeTypeEnum... enums) {
        List<Integer> typeList = new ArrayList<>(enums.length);
        for (CodeTypeEnum e : enums) {
            typeList.add(e.getTypeId());
        }
        return typeList;
    }

}
