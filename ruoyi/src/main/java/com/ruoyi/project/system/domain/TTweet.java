package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 推文对象 t_tweet
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
public class TTweet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 素材id */
    @Excel(name = "素材id")
    private Long mid;

    /** 用户id */
    @Excel(name = "用户id")
    private Long uid;

    /** 0:发布   1:启用  2:禁用 */
    @Excel(name = "0:发布   1:启用  2:禁用")
    private Integer status;

    /** 可见用户id */
    @Excel(name = "可见用户id")
    private Long tUid;

    /** 推送标题 */
    @Excel(name = "推送标题")
    private String title;

    /** 审核人员id */
    @Excel(name = "审核人员id")
    private Long aUid;

    /** 创建人员ID */
    @Excel(name = "创建人员ID")
    private Long createId;

    /** $column.columnComment */
    @Excel(name = "创建人员ID")
    private Long updateId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMid(Long mid) 
    {
        this.mid = mid;
    }

    public Long getMid() 
    {
        return mid;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void settUid(Long tUid) 
    {
        this.tUid = tUid;
    }

    public Long gettUid() 
    {
        return tUid;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setaUid(Long aUid) 
    {
        this.aUid = aUid;
    }

    public Long getaUid() 
    {
        return aUid;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setUpdateId(Long updateId) 
    {
        this.updateId = updateId;
    }

    public Long getUpdateId() 
    {
        return updateId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mid", getMid())
            .append("uid", getUid())
            .append("status", getStatus())
            .append("tUid", gettUid())
            .append("title", getTitle())
            .append("createTime", getCreateTime())
            .append("aUid", getaUid())
            .append("createId", getCreateId())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
