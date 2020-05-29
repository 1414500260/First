package com.ruoyi.project.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.domain.TMaterial;
import com.ruoyi.project.service.ITMaterialService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 素材内容Controller
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
@RestController
@RequestMapping("/views/material")
public class TMaterialController extends BaseController
{
    @Autowired
    private ITMaterialService tMaterialService;

    /**
     * 查询素材内容列表
     */
    @PreAuthorize("@ss.hasPermi('views:material:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMaterial tMaterial)
    {
        startPage();
        List<TMaterial> list = tMaterialService.selectTMaterialList(tMaterial);
        return getDataTable(list);
    }

    /**
     * 导出素材内容列表
     */
    @PreAuthorize("@ss.hasPermi('views:material:export')")
    @Log(title = "素材内容", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMaterial tMaterial)
    {
        List<TMaterial> list = tMaterialService.selectTMaterialList(tMaterial);
        ExcelUtil<TMaterial> util = new ExcelUtil<TMaterial>(TMaterial.class);
        return util.exportExcel(list, "material");
    }

    /**
     * 获取素材内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('views:material:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tMaterialService.selectTMaterialById(id));
    }

    /**
     * 新增素材内容
     */
    @PreAuthorize("@ss.hasPermi('views:material:add')")
    @Log(title = "素材内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMaterial tMaterial)
    {
        return toAjax(tMaterialService.insertTMaterial(tMaterial));
    }

    /**
     * 修改素材内容
     */
    @PreAuthorize("@ss.hasPermi('views:material:edit')")
    @Log(title = "素材内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMaterial tMaterial)
    {
        return toAjax(tMaterialService.updateTMaterial(tMaterial));
    }

    /**
     * 删除素材内容
     */
    @PreAuthorize("@ss.hasPermi('views:material:remove')")
    @Log(title = "素材内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMaterialService.deleteTMaterialByIds(ids));
    }
}
