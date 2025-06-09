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


import com.dao.YiyangbaogaoDao;
import com.entity.YiyangbaogaoEntity;
import com.service.YiyangbaogaoService;
import com.entity.vo.YiyangbaogaoVO;
import com.entity.view.YiyangbaogaoView;

@Service("yiyangbaogaoService")
public class YiyangbaogaoServiceImpl extends ServiceImpl<YiyangbaogaoDao, YiyangbaogaoEntity> implements YiyangbaogaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiyangbaogaoEntity> page = this.selectPage(
                new Query<YiyangbaogaoEntity>(params).getPage(),
                new EntityWrapper<YiyangbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiyangbaogaoEntity> wrapper) {
		  Page<YiyangbaogaoView> page =new Query<YiyangbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiyangbaogaoVO> selectListVO(Wrapper<YiyangbaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiyangbaogaoVO selectVO(Wrapper<YiyangbaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiyangbaogaoView> selectListView(Wrapper<YiyangbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiyangbaogaoView selectView(Wrapper<YiyangbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
