package com.ruoyi.web.controller.family;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.CodeTypeEnum;
import com.ruoyi.system.domain.family.FamilyPopuBase;
import com.ruoyi.system.mapper.family.FamilyPopuBaseMapper;
import com.ruoyi.system.service.ISysCodeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-10-23
 */
@Controller
@RequestMapping("/popu/base")
public class FamilyPopuBaseController extends BaseController {
    private String prefix = "popu/base";

    @Autowired
    private FamilyPopuBaseMapper mapper;
    @Autowired
    private ISysCodeService codeService;

    @RequiresPermissions("system:base:view")
    @GetMapping()
    public String base() {
        return prefix + "/base";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:base:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyPopuBase familyPopuBase) {
        startPage();
        List<FamilyPopuBase> list = mapper.list(familyPopuBase);
        return getDataTable(list);
    }
    /*
     *//**
     * 导出【请填写功能名称】列表
     *//*
    @RequiresPermissions("system:base:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyPopuBase familyPopuBase)
    {
        List<FamilyPopuBase> list = mapper.list(familyPopuBase);
        ExcelUtil<FamilyPopuBase> util = new ExcelUtil<FamilyPopuBase>(FamilyPopuBase.class);
        return util.exportExcel(list, "base");
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {

        addOrEditSelectData(modelMap);
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:base:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Valid FamilyPopuBase familyPopuBase) {
        if (mapper.totalCount(familyPopuBase.getPhone().trim()) > 0) {
            return AjaxResult.error("手机号码已存在！");
        }
        if (mapper.totalCountByName(familyPopuBase.getName().trim()) > 0) {
            return AjaxResult.error("姓名已存在！");
        }
        return toAjax(mapper.insert(familyPopuBase));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        FamilyPopuBase familyPopuBase = mapper.getDetail(id);
        mmap.put("familyPopuBase", familyPopuBase);
        addOrEditSelectData(mmap);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:base:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyPopuBase familyPopuBase) {
        return toAjax(mapper.updateById(familyPopuBase));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:base:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mapper.deleteById(Long.parseLong(ids)));
    }


    private void addOrEditSelectData(ModelMap modelMap) {
        CodeTypeEnum[] enums = {
                CodeTypeEnum.ADDRESS,
                CodeTypeEnum.NOTICE_TYPE
        };
        modelMap.put("selects", codeService.selectGroupCodeList(enums));

    }
}
