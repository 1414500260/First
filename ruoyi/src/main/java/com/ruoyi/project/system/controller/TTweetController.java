package com.ruoyi.project.system.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ruoyi.project.controller.TMaterialController;
import com.ruoyi.project.domain.TMaterial;
import com.ruoyi.project.service.ITMaterialService;
import com.ruoyi.project.utils.HttpUtil;
import com.ruoyi.project.utils.WeChatUtils;
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
import com.ruoyi.project.system.domain.TTweet;
import com.ruoyi.project.system.service.ITTweetService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 推文Controller
 * 
 * @author ruoyi
 * @date 2020-05-29
 */
@RestController
@RequestMapping("/system/tweet")
public class TTweetController extends BaseController
{
    @Autowired
    private ITTweetService tTweetService;
    @Autowired
    private ITMaterialService itMaterialService;

    /**
     * 根据审核人ID查询推文列表
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:list')")
    @GetMapping("/list")
    public TableDataInfo list(TTweet tTweet)
    {
        startPage();
        List<TTweet> list = tTweetService.selectTTweetList(tTweet);
        return getDataTable(list);
    }

    /**
     * 导出推文列表
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:export')")
    @Log(title = "推文", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TTweet tTweet)
    {
        List<TTweet> list = tTweetService.selectTTweetList(tTweet);
        ExcelUtil<TTweet> util = new ExcelUtil<TTweet>(TTweet.class);
        return util.exportExcel(list, "tweet");
    }

    /**
     * 获取推文详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tTweetService.selectTTweetById(id));
    }

    /**
     * 新增推文
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:add')")
    @Log(title = "推文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TTweet tTweet)
    {
        return toAjax(tTweetService.insertTTweet(tTweet));
    }

    /**
     * 修改推文
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:edit')")
    @Log(title = "推文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TTweet tTweet)
    {
        return toAjax(tTweetService.updateTTweet(tTweet));
    }
    /**
     * 审核并且推文
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:edit')")
    @Log(title = "审核并且推文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult Ttweet(@RequestBody TTweet tTweet) throws IOException {
        String appid = "wxfd24f8f4d829e5a0";
        String secret = "53893cd95261bc5ca24891d9073a02dd";
        //根据公众号appid和secret获取到令牌
        String access_token = HttpUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid + "&secret=" + secret);
        //根据令牌得到openid
        String s = HttpUtil.sendGet("https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + access_token + "&next_openid=");

        Long media=null;

        // //素材状态
        // //推文审核状态
        TTweet tTweet1 = tTweetService.selectTTweetById(tTweet.getId());
        tTweet1.setStatus(1);
        tTweet1.setUpdateId(tTweet.getUid());
        tTweet1.setUpdateTime(new Date());
        tTweetService.updateTTweet(tTweet);
        WeChatUtils weChatUtils = new WeChatUtils();
        TMaterial tMaterial = itMaterialService.selectTMaterialById(tTweet1.getMid());
        media=tMaterial.getId();
        String sendutil = weChatUtils.sendutil(access_token,s,media);

        return toAjax(tTweetService.updateTTweet(tTweet));
    }

    /**
     * 删除推文
     */
    @PreAuthorize("@ss.hasPermi('system:tweet:remove')")
    @Log(title = "推文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tTweetService.deleteTTweetByIds(ids));
    }
}
