package com.ruoyi.project.service;

import java.util.List;
import com.ruoyi.project.domain.TMaterial;

/**
 * 素材内容Service接口
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
public interface ITMaterialService 
{
    /**
     * 查询素材内容
     * 
     * @param id 素材内容ID
     * @return 素材内容
     */
    public TMaterial selectTMaterialById(Long id);

    /**
     * 查询素材内容列表
     * 
     * @param tMaterial 素材内容
     * @return 素材内容集合
     */
    public List<TMaterial> selectTMaterialList(TMaterial tMaterial);

    /**
     * 新增素材内容
     * 
     * @param tMaterial 素材内容
     * @return 结果
     */
    public int insertTMaterial(TMaterial tMaterial);

    /**
     * 修改素材内容
     * 
     * @param tMaterial 素材内容
     * @return 结果
     */
    public int updateTMaterial(TMaterial tMaterial);

    /**
     * 批量删除素材内容
     * 
     * @param ids 需要删除的素材内容ID
     * @return 结果
     */
    public int deleteTMaterialByIds(Long[] ids);

    /**
     * 删除素材内容信息
     * 
     * @param id 素材内容ID
     * @return 结果
     */
    public int deleteTMaterialById(Long id);
}
