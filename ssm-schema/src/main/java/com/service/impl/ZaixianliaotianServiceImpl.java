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


import com.dao.ZaixianliaotianDao;
import com.entity.ZaixianliaotianEntity;
import com.service.ZaixianliaotianService;
import com.entity.vo.ZaixianliaotianVO;
import com.entity.view.ZaixianliaotianView;

@Service("zaixianliaotianService")
public class ZaixianliaotianServiceImpl extends ServiceImpl<ZaixianliaotianDao, ZaixianliaotianEntity> implements ZaixianliaotianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianliaotianEntity> page = this.selectPage(
                new Query<ZaixianliaotianEntity>(params).getPage(),
                new EntityWrapper<ZaixianliaotianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianliaotianEntity> wrapper) {
		  Page<ZaixianliaotianView> page =new Query<ZaixianliaotianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianliaotianVO> selectListVO(Wrapper<ZaixianliaotianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianliaotianVO selectVO(Wrapper<ZaixianliaotianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianliaotianView> selectListView(Wrapper<ZaixianliaotianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianliaotianView selectView(Wrapper<ZaixianliaotianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
