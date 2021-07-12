/*
 * 文件名: SysCodeList.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年07月01日 16时03分
 * 描述: 系统代码列表 - 对象
 */
package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * description:
 *
 * @Author: aolang
 * @Date: 2020/10/23 0023
 */
public class SysCodeList extends BaseEntity {

    /**
     * 类型ID
     */
    private Integer typeId;
    private String typeIdStr;

    /**
     * 代码标签
     */
    private String codeLabel;

    /**
     * 代码键值
     */
    private String codeValue;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeIdStr() {
        return typeIdStr;
    }

    public void setTypeIdStr(String typeIdStr) {
        this.typeIdStr = typeIdStr;
    }

    public String getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(String codeLabel) {
        this.codeLabel = codeLabel;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
}
