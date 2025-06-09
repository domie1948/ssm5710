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


import com.dao.XingdongguijiDao;
import com.entity.XingdongguijiEntity;
import com.service.XingdongguijiService;
import com.entity.vo.XingdongguijiVO;
import com.entity.view.XingdongguijiView;

@Service("xingdongguijiService")
public class XingdongguijiServiceImpl extends ServiceImpl<XingdongguijiDao, XingdongguijiEntity> implements XingdongguijiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XingdongguijiEntity> page = this.selectPage(
                new Query<XingdongguijiEntity>(params).getPage(),
                new EntityWrapper<XingdongguijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XingdongguijiEntity> wrapper) {
		  Page<XingdongguijiView> page =new Query<XingdongguijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XingdongguijiVO> selectListVO(Wrapper<XingdongguijiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XingdongguijiVO selectVO(Wrapper<XingdongguijiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XingdongguijiView> selectListView(Wrapper<XingdongguijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XingdongguijiView selectView(Wrapper<XingdongguijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
