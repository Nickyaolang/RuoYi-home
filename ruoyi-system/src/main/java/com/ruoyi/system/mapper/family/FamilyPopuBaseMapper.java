package com.ruoyi.system.mapper.family;

import com.ruoyi.system.domain.family.FamilyPopuBase;
import com.ruoyi.system.mapper.base.Basedao;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * description:
 *
 * @Author: aolang
 * @Date: 2020/10/23 0023
 */
@Repository
public interface FamilyPopuBaseMapper extends Basedao<FamilyPopuBase> {
    Map<String,String> queryBirthday();


    @Select("select count(1) from family_popu_base where phone = #{phone}")
    int totalCount(String phone);

    @Select("select count(1) from family_popu_base where name = #{name}")
    int totalCountByName(String name);
}
