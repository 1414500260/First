package com.ruoyi.project.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.TMaterialMapper;
import com.ruoyi.project.domain.TMaterial;
import com.ruoyi.project.service.ITMaterialService;

import javax.annotation.Resource;

/**
 * 素材内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
@Service
public class TMaterialServiceImpl implements ITMaterialService 
{
    @Resource
    private TMaterialMapper tMaterialMapper;

    /**
     * 查询素材内容
     * 
     * @param id 素材内容ID
     * @return 素材内容
     */
    @Override
    public TMaterial selectTMaterialById(Long id)
    {
        return tMaterialMapper.selectTMaterialById(id);
    }

    /**
     * 查询素材内容列表
     * 
     * @param tMaterial 素材内容
     * @return 素材内容
     */
    @Override
    public List<TMaterial> selectTMaterialList(TMaterial tMaterial)
    {
        return tMaterialMapper.selectTMaterialList(tMaterial);
    }

    /**
     * 新增素材内容
     * 
     * @param tMaterial 素材内容
     * @return 结果
     */
    @Override
    public int insertTMaterial(TMaterial tMaterial)
    {
        tMaterial.setCreateTime(DateUtils.getNowDate());
        return tMaterialMapper.insertTMaterial(tMaterial);
    }

    /**
     * 修改素材内容
     * 
     * @param tMaterial 素材内容
     * @return 结果
     */
    @Override
    public int updateTMaterial(TMaterial tMaterial)
    {
        tMaterial.setUpdateTime(DateUtils.getNowDate());
        return tMaterialMapper.updateTMaterial(tMaterial);
    }

    /**
     * 批量删除素材内容
     * 
     * @param ids 需要删除的素材内容ID
     * @return 结果
     */
    @Override
    public int deleteTMaterialByIds(Long[] ids)
    {
        return tMaterialMapper.deleteTMaterialByIds(ids);
    }

    /**
     * 删除素材内容信息
     * 
     * @param id 素材内容ID
     * @return 结果
     */
    @Override
    public int deleteTMaterialById(Long id)
    {
        return tMaterialMapper.deleteTMaterialById(id);
    }
}
