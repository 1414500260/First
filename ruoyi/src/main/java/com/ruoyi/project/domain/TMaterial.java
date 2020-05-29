package com.ruoyi.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 素材内容对象 t_material
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
public class TMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 素材分类 */
    @Excel(name = "素材分类")
    private String type;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 附件id */
    @Excel(name = "附件id")
    private String fileIds;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 发布类型（1，原创；2，其他） */
    @Excel(name = "发布类型", readConverterExp = "1=，原创；2，其他")
    private String publishType;

    /** 发布状态（1，待发布；2，审核中；3，已发布） */
    @Excel(name = "发布状态", readConverterExp = "1=，待发布；2，审核中；3，已发布")
    private Integer publishStatus;

    /** 发布人 */
    @Excel(name = "发布人")
    private Long publisher;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long goodNum;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private Long colNum;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createId;

    /** 修改人 */
    @Excel(name = "修改人")
    private Long updateId;

    /** 是否删除(0:否  1:是) */
    @Excel(name = "是否删除(0:否  1:是)")
    private String isDelete;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setFileIds(String fileIds) 
    {
        this.fileIds = fileIds;
    }

    public String getFileIds() 
    {
        return fileIds;
    }
    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }
    public void setPublishType(String publishType) 
    {
        this.publishType = publishType;
    }

    public String getPublishType() 
    {
        return publishType;
    }
    public void setPublishStatus(Integer publishStatus) 
    {
        this.publishStatus = publishStatus;
    }

    public Integer getPublishStatus() 
    {
        return publishStatus;
    }
    public void setPublisher(Long publisher) 
    {
        this.publisher = publisher;
    }

    public Long getPublisher() 
    {
        return publisher;
    }
    public void setGoodNum(Long goodNum) 
    {
        this.goodNum = goodNum;
    }

    public Long getGoodNum() 
    {
        return goodNum;
    }
    public void setColNum(Long colNum) 
    {
        this.colNum = colNum;
    }

    public Long getColNum() 
    {
        return colNum;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
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
    public void setIsDelete(String isDelete) 
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete() 
    {
        return isDelete;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("title", getTitle())
            .append("content", getContent())
            .append("fileIds", getFileIds())
            .append("publishTime", getPublishTime())
            .append("publishType", getPublishType())
            .append("publishStatus", getPublishStatus())
            .append("publisher", getPublisher())
            .append("goodNum", getGoodNum())
            .append("colNum", getColNum())
            .append("memo", getMemo())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
