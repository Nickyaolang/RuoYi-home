package com.ruoyi.system.domain.feast;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【酒席】对象 family_feast
 *
 * @author ruoyi
 * @date 2020-10-28
 */
public class FamilyFeast extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 酒席id
     */
    private Long id;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private Long money;

    /**
     * 总计
     */
    @Excel(name = "总计")
    private Long moneyTotal;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String address;

    /**
     * 日期
     */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /**
     * 状态：1=有效，2=无效
     */
    @Excel(name = "状态：1=有效，2=无效")
    private Integer dataStatus;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoneyTotal(Long moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public Long getMoneyTotal() {
        return moneyTotal;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
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
                .append("money", getMoney())
                .append("moneyTotal", getMoneyTotal())
                .append("address", getAddress())
                .append("date", getDate())
                .append("dataStatus", getDataStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
