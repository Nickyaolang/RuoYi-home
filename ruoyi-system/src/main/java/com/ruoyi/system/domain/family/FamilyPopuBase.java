package com.ruoyi.system.domain.family;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Pattern;

/**
 * 【基本人员】对象 family_popu_base
 *
 * @author nicky
 * @date 2020-10-23
 */
public class FamilyPopuBase extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 出生日期
     */
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String birthday;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    @Pattern(regexp = "^[1][3578][0-9]{9}$", message = "手机格式不合理！")
    private String phone;

    /**
     * 职业
     */
    private String job;

    /**
     * 现住地(1:贵州、2:重庆、3:湖北)
     */
    @Excel(name = "现住地(1:贵州、2:重庆、3:湖北)")
    private String nowAddress;
    private String address;

    /**
     * 状态：1=有效，2=无效
     */
    @Excel(name = "状态：1=有效，2=无效")
    private Integer dataStatus;

    /**
     * 是否通知（1:通知|2:不通知）
     */
    private String notice;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("birthday", getBirthday())
                .append("phone", getPhone())
                .append("nowAddress", getNowAddress())
                .append("dataStatus", getDataStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
