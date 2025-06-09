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


import com.dao.DiscussyishengDao;
import com.entity.DiscussyishengEntity;
import com.service.DiscussyishengService;
import com.entity.vo.DiscussyishengVO;
import com.entity.view.DiscussyishengView;

@Service("discussyishengService")
public class DiscussyishengServiceImpl extends ServiceImpl<DiscussyishengDao, DiscussyishengEntity> implements DiscussyishengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyishengEntity> page = this.selectPage(
                new Query<DiscussyishengEntity>(params).getPage(),
                new EntityWrapper<DiscussyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyishengEntity> wrapper) {
		  Page<DiscussyishengView> page =new Query<DiscussyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyishengVO> selectListVO(Wrapper<DiscussyishengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyishengVO selectVO(Wrapper<DiscussyishengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyishengView> selectListView(Wrapper<DiscussyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyishengView selectView(Wrapper<DiscussyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
