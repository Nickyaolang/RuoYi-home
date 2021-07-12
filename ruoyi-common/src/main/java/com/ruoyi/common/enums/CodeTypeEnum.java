/*
 * 文件名: CodeTypeEnum.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年07月02日 11时40分
 * 描述: 代码类型枚举
 */
package com.ruoyi.common.enums;

/**
 * 代码类型枚举
 *
 * @author liuhongliang
 * @version V1.0, 2019/7/2
 */
public enum CodeTypeEnum {

    ADDRESS(1,"籍贯","无"),
    SEX(2,"性别","无"),
    NOTICE_TYPE(3,"通知类型","无");

    private int typeId;
    private String typeName;
    private String typeLabel;

    CodeTypeEnum(int typeId, String typeName, String typeLabel) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeLabel = typeLabel;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTypeLabel() {
        return typeLabel;
    }
}
