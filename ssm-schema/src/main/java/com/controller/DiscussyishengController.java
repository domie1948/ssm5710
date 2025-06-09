package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussyishengEntity;
import com.entity.view.DiscussyishengView;

import com.service.DiscussyishengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 医生评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@RestController
@RequestMapping("/discussyisheng")
public class DiscussyishengController {
    @Autowired
    private DiscussyishengService discussyishengService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyishengEntity discussyisheng, HttpServletRequest request){

        EntityWrapper<DiscussyishengEntity> ew = new EntityWrapper<DiscussyishengEntity>();
		PageUtils page = discussyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyisheng), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyishengEntity discussyisheng, HttpServletRequest request){
        EntityWrapper<DiscussyishengEntity> ew = new EntityWrapper<DiscussyishengEntity>();
		PageUtils page = discussyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyisheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyishengEntity discussyisheng){
       	EntityWrapper<DiscussyishengEntity> ew = new EntityWrapper<DiscussyishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyisheng, "discussyisheng")); 
        return R.ok().put("data", discussyishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyishengEntity discussyisheng){
        EntityWrapper< DiscussyishengEntity> ew = new EntityWrapper< DiscussyishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyisheng, "discussyisheng")); 
		DiscussyishengView discussyishengView =  discussyishengService.selectView(ew);
		return R.ok("查询医生评论表成功").put("data", discussyishengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyishengEntity discussyisheng = discussyishengService.selectById(id);
        return R.ok().put("data", discussyisheng);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyishengEntity discussyisheng = discussyishengService.selectById(id);
        return R.ok().put("data", discussyisheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyishengEntity discussyisheng, HttpServletRequest request){
    	discussyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyisheng);

        discussyishengService.insert(discussyisheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyishengEntity discussyisheng, HttpServletRequest request){
    	discussyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyisheng);

        discussyishengService.insert(discussyisheng);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussyishengEntity discussyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyisheng);
        discussyishengService.updateById(discussyisheng);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussyishengEntity> wrapper = new EntityWrapper<DiscussyishengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussyishengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
