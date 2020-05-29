package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.TTweetMapper;
import com.ruoyi.project.system.domain.TTweet;
import com.ruoyi.project.system.service.ITTweetService;

import javax.annotation.Resource;

/**
 * 推文Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
@Service
public class TTweetServiceImpl implements ITTweetService 
{
    @Resource
    private TTweetMapper tTweetMapper;

    /**
     * 查询推文
     * 
     * @param id 推文ID
     * @return 推文
     */
    @Override
    public TTweet selectTTweetById(Long id)
    {
        return tTweetMapper.selectTTweetById(id);
    }

    /**
     * 查询推文列表
     * 
     * @param tTweet 推文
     * @return 推文
     */
    @Override
    public List<TTweet> selectTTweetList(TTweet tTweet)
    {
        return tTweetMapper.selectTTweetList(tTweet);
    }

    /**
     * 新增推文
     * 
     * @param tTweet 推文
     * @return 结果
     */
    @Override
    public int insertTTweet(TTweet tTweet)
    {
        tTweet.setCreateTime(DateUtils.getNowDate());
        return tTweetMapper.insertTTweet(tTweet);
    }

    /**
     * 修改推文
     * 
     * @param tTweet 推文
     * @return 结果
     */
    @Override
    public int updateTTweet(TTweet tTweet)
    {
        tTweet.setUpdateTime(DateUtils.getNowDate());
        return tTweetMapper.updateTTweet(tTweet);
    }

    /**
     * 批量删除推文
     * 
     * @param ids 需要删除的推文ID
     * @return 结果
     */
    @Override
    public int deleteTTweetByIds(Long[] ids)
    {
        return tTweetMapper.deleteTTweetByIds(ids);
    }

    /**
     * 删除推文信息
     * 
     * @param id 推文ID
     * @return 结果
     */
    @Override
    public int deleteTTweetById(Long id)
    {
        return tTweetMapper.deleteTTweetById(id);
    }
}
