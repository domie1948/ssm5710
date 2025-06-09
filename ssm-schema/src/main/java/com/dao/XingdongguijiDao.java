package com.dao;

import com.entity.XingdongguijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XingdongguijiVO;
import com.entity.view.XingdongguijiView;


/**
 * 行动轨迹
 * 
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface XingdongguijiDao extends BaseMapper<XingdongguijiEntity> {
	
	List<XingdongguijiVO> selectListVO(@Param("ew") Wrapper<XingdongguijiEntity> wrapper);
	
	XingdongguijiVO selectVO(@Param("ew") Wrapper<XingdongguijiEntity> wrapper);
	
	List<XingdongguijiView> selectListView(@Param("ew") Wrapper<XingdongguijiEntity> wrapper);

	List<XingdongguijiView> selectListView(Pagination page,@Param("ew") Wrapper<XingdongguijiEntity> wrapper);
	
	XingdongguijiView selectView(@Param("ew") Wrapper<XingdongguijiEntity> wrapper);
	
}
