package com.dao;

import com.entity.YiqinggonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiqinggonggaoVO;
import com.entity.view.YiqinggonggaoView;


/**
 * 疫情公告
 * 
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface YiqinggonggaoDao extends BaseMapper<YiqinggonggaoEntity> {
	
	List<YiqinggonggaoVO> selectListVO(@Param("ew") Wrapper<YiqinggonggaoEntity> wrapper);
	
	YiqinggonggaoVO selectVO(@Param("ew") Wrapper<YiqinggonggaoEntity> wrapper);
	
	List<YiqinggonggaoView> selectListView(@Param("ew") Wrapper<YiqinggonggaoEntity> wrapper);

	List<YiqinggonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<YiqinggonggaoEntity> wrapper);
	
	YiqinggonggaoView selectView(@Param("ew") Wrapper<YiqinggonggaoEntity> wrapper);
	
}
