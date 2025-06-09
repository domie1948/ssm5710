package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YiqinggonggaoDao;
import com.entity.YiqinggonggaoEntity;
import com.service.YiqinggonggaoService;
import com.entity.vo.YiqinggonggaoVO;
import com.entity.view.YiqinggonggaoView;

@Service("yiqinggonggaoService")
public class YiqinggonggaoServiceImpl extends ServiceImpl<YiqinggonggaoDao, YiqinggonggaoEntity> implements YiqinggonggaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiqinggonggaoEntity> page = this.selectPage(
                new Query<YiqinggonggaoEntity>(params).getPage(),
                new EntityWrapper<YiqinggonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiqinggonggaoEntity> wrapper) {
		  Page<YiqinggonggaoView> page =new Query<YiqinggonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiqinggonggaoVO> selectListVO(Wrapper<YiqinggonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiqinggonggaoVO selectVO(Wrapper<YiqinggonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiqinggonggaoView> selectListView(Wrapper<YiqinggonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiqinggonggaoView selectView(Wrapper<YiqinggonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
