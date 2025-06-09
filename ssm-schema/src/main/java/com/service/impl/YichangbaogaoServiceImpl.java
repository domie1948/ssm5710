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


import com.dao.YichangbaogaoDao;
import com.entity.YichangbaogaoEntity;
import com.service.YichangbaogaoService;
import com.entity.vo.YichangbaogaoVO;
import com.entity.view.YichangbaogaoView;

@Service("yichangbaogaoService")
public class YichangbaogaoServiceImpl extends ServiceImpl<YichangbaogaoDao, YichangbaogaoEntity> implements YichangbaogaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YichangbaogaoEntity> page = this.selectPage(
                new Query<YichangbaogaoEntity>(params).getPage(),
                new EntityWrapper<YichangbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YichangbaogaoEntity> wrapper) {
		  Page<YichangbaogaoView> page =new Query<YichangbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YichangbaogaoVO> selectListVO(Wrapper<YichangbaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YichangbaogaoVO selectVO(Wrapper<YichangbaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YichangbaogaoView> selectListView(Wrapper<YichangbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YichangbaogaoView selectView(Wrapper<YichangbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
