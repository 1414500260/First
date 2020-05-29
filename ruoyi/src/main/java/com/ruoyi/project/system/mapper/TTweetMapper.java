package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.TTweet;

/**
 * 推文Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
public interface TTweetMapper 
{
    /**
     * 查询推文
     * 
     * @param id 推文ID
     * @return 推文
     */
    public TTweet selectTTweetById(Long id);

    /**
     * 查询推文列表
     * 
     * @param tTweet 推文
     * @return 推文集合
     */
    public List<TTweet> selectTTweetList(TTweet tTweet);

    /**
     * 新增推文
     * 
     * @param tTweet 推文
     * @return 结果
     */
    public int insertTTweet(TTweet tTweet);

    /**
     * 修改推文
     * 
     * @param tTweet 推文
     * @return 结果
     */
    public int updateTTweet(TTweet tTweet);

    /**
     * 删除推文
     * 
     * @param id 推文ID
     * @return 结果
     */
    public int deleteTTweetById(Long id);

    /**
     * 批量删除推文
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTweetByIds(Long[] ids);
}
