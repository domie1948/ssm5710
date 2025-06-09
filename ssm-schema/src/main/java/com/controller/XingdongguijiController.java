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

import com.entity.XingdongguijiEntity;
import com.entity.view.XingdongguijiView;

import com.service.XingdongguijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 行动轨迹
 * 后端接口
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@RestController
@RequestMapping("/xingdongguiji")
public class XingdongguijiController {
    @Autowired
    private XingdongguijiService xingdongguijiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XingdongguijiEntity xingdongguiji, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xingdongguiji.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XingdongguijiEntity> ew = new EntityWrapper<XingdongguijiEntity>();
		PageUtils page = xingdongguijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xingdongguiji), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XingdongguijiEntity xingdongguiji, HttpServletRequest request){
        EntityWrapper<XingdongguijiEntity> ew = new EntityWrapper<XingdongguijiEntity>();
		PageUtils page = xingdongguijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xingdongguiji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XingdongguijiEntity xingdongguiji){
       	EntityWrapper<XingdongguijiEntity> ew = new EntityWrapper<XingdongguijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xingdongguiji, "xingdongguiji")); 
        return R.ok().put("data", xingdongguijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XingdongguijiEntity xingdongguiji){
        EntityWrapper< XingdongguijiEntity> ew = new EntityWrapper< XingdongguijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xingdongguiji, "xingdongguiji")); 
		XingdongguijiView xingdongguijiView =  xingdongguijiService.selectView(ew);
		return R.ok("查询行动轨迹成功").put("data", xingdongguijiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        XingdongguijiEntity xingdongguiji = xingdongguijiService.selectById(id);
        return R.ok().put("data", xingdongguiji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        XingdongguijiEntity xingdongguiji = xingdongguijiService.selectById(id);
        return R.ok().put("data", xingdongguiji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XingdongguijiEntity xingdongguiji, HttpServletRequest request){
    	xingdongguiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xingdongguiji);

        xingdongguijiService.insert(xingdongguiji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XingdongguijiEntity xingdongguiji, HttpServletRequest request){
    	xingdongguiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xingdongguiji);

        xingdongguijiService.insert(xingdongguiji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XingdongguijiEntity xingdongguiji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xingdongguiji);
        xingdongguijiService.updateById(xingdongguiji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xingdongguijiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XingdongguijiEntity> wrapper = new EntityWrapper<XingdongguijiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = xingdongguijiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
