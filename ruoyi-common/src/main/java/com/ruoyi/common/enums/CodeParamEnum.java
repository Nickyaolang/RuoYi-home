/*
 * 文件名: CodeParamEnum.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年05月20日 15时42分
 * 描述: 静态字典枚举
 */
package com.ruoyi.common.enums;

/**
 * 静态字典枚举
 *
 * @author liuhongliang
 * @version V1.0, 2019/5/20
 */
public enum CodeParamEnum {

    SEX_CODE(1, "性别"),
    NATION_CODE(2, "民族"),
    MARITAL_CODE(3, "婚姻状况"),
    POLITICS_CODE(4, "政治面貌"),
    EDUCATION_CODE(5, "学历"),
    RELIGION_CODE(6, "宗教信仰"),
    HUSHAI_CONSISTENT_CODE(7, "人户一致标识"),
    SECURITY_PROBLEM_CODE(8, "治安突出问题编码"),
    AREA_TYPE_CODE(9, "涉及区域类型编码"),
    ORGAN_TYPE_CODE(10, "综治机构类型编码"),
    LOCAL_LEVEL_CODE(11, "地方层级编码"),
    PERSON_LEVEL_CODE(12, "人员级别编码"),
    PERSON_DUTY_CODE(13, "人员职务编码"),
    SPECIALTY_CODE(14, "专业特长编码"),
    PRECAUTION_ORGAN_TYPE_CODE(15, "组织类型编码"),
    CERTIFICATE_CODE(16, "证件代码编码"),
    CASE_TYPE_CODE(17, "案（事）件类型编码"),
    CASE_LEVEL_CODE(18, "案（事）件分级编码"),
    POLICY_TYPE_CODE(19, "政策种类编码"),
    EFFECT_APPRAISAL_CODE(20, "效果评估编码"),
    REGISTRATION_TYPE_CODE(21, "登记注册类型编码"),
    HOLDING_SITUATION_CODE(22, "控股情况编码"),
    BUSINESS_SCOPE_CODE(23, "经营范围"),
    COMPANY_TYPE_CODE(24, "企业类型编码"),
    EVENT_SCALE_CODE(25, "事件规模编码"),
    EVENT_TYPE_CODE(26, "事件类别编码"),
    MAIN_PARTY_CODE(27, "主要当事人人员类别编码"),
    SOLVE_WAY_CODE(28, "化解方式编码"),
    HAZARD_RATING_CODE(29, "危害程度编码"),
    CASE_NATURE_CODE(30, "案(事)件性质编码"),
    SCHOOL_TYPE_CODE(31, "学校办学类型编码"),
    INFLOW_REASON_CODE(33, "流入原因编码"),
    THE_CARD_TYPE_CODE(34, "办证类型编码"),
    DOMICILE_TYPE_CODE(35, "住所类型编码"),
    HEALTH_CONDITION_CODE(36, "健康状况编码"),
    REAR_PERSONNEL_TYPE_CODE(37, "留守人员类型"),
    GOAL_IN_CHINA_CODE(38, "来华目的编码"),
    CONSTRUCTION_APPLICATIONS(39, "建筑用途编码"),
    FAMILY_RELATIONSHIP(40, "家庭人员关系"),
    NATIONALITY(41, "国籍（地区）"),
    HAZARD_TYPE(42, "房屋隐患类型"),
    RENTAL_USE_CODE(43, "出租用途"),
    YES_NO(44,"是否表"),
    GRID_SIR(45,"网格长"),
    GRIDSIRDEPUTY(46,"副网格长"),
    GRIDSIRSTADING(47,"常务网格长"),
    GRIDEMP(48,"网格员");



    private int code;
    private String remark;

    CodeParamEnum(int code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public int getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }
}
