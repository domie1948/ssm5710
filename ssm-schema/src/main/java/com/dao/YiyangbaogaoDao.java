package com.dao;

import com.entity.YiyangbaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiyangbaogaoVO;
import com.entity.view.YiyangbaogaoView;


/**
 * 异样报告
 * 
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface YiyangbaogaoDao extends BaseMapper<YiyangbaogaoEntity> {
	
	List<YiyangbaogaoVO> selectListVO(@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);
	
	YiyangbaogaoVO selectVO(@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);
	
	List<YiyangbaogaoView> selectListView(@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);

	List<YiyangbaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);
	
	YiyangbaogaoView selectView(@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);
	
}
