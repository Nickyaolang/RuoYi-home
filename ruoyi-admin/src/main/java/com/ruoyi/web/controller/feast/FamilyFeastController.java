package com.ruoyi.web.controller.feast;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.feast.FamilyFeast;
import com.ruoyi.system.mapper.feast.FamilyFeastMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 【酒席控制层】Controller
 *
 * @author ruoyi
 * @date 2020-10-28
 */
@Controller
@RequestMapping("/family/feast")
public class FamilyFeastController extends BaseController {
    private String prefix = "family/feast";

    @Autowired
    private FamilyFeastMapper mapper;

    @RequiresPermissions("system:feast:view")
    @GetMapping()
    public String feast() {
        return prefix + "/feast";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:feast:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyFeast familyFeast,ModelMap modelMap) {
        startPage();
        List<FamilyFeast> list = mapper.list(familyFeast);
        int count = 0;
        for(int i=0;i<list.size(); i++){
            count += list.get(i).getMoneyTotal();
        }
        modelMap.put("count",count);
        return getDataTable(list);
    }

    /**
     * 统计求和
     */
    @ResponseBody
    @PostMapping("countAll")
    public Integer countAll(String  ids){
        String[] split = ids.split(",");
        int count = 0;
        for(int i = 0;i<split.length;i++){
            FamilyFeast detail = mapper.getDetail(Long.parseLong(split[i]));
            if(detail != null)
            count+= detail.getMoneyTotal();
        }
        return count;
    }

    /**
     * 导出【请填写功能名称】列表
     */
  /*  @RequiresPermissions("system:feast:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyFeast familyFeast) {
        List<FamilyFeast> list = mapper.list(familyFeast);
        ExcelUtil<FamilyFeast> util = new ExcelUtil<FamilyFeast>(FamilyFeast.class);
        return util.exportExcel(list, "feast");
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:feast:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyFeast familyFeast) {
        return toAjax(mapper.insert(familyFeast));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        FamilyFeast familyFeast = mapper.getDetail(id);
        mmap.put("familyFeast", familyFeast);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:feast:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyFeast familyFeast) {
        return toAjax(mapper.updateById(familyFeast));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:feast:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mapper.deleteById(Long.parseLong(ids)));
    }
}
